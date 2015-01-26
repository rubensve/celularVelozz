/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ArticuloDAO;
import com.dao.CestatusNotaDAO;
import com.dao.CestatusReparacionDAO;
import com.dao.ClienteDAO;
import com.dao.NotaDAO;
import com.dao.UsuarioDAO;
import com.pojo.Articulo;
import com.pojo.CestatusNota;
import com.pojo.CestatusReparacion;
import com.pojo.Cliente;
import com.pojo.Nota;
import com.pojo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author rubens
 */
public class pruebaclientenombre {
    
    public static void main(String[] args) {
      
        NotaDAO notas= new NotaDAO();
        Nota n= notas.leerultimo();
        UsuarioDAO usuario= new UsuarioDAO();
        Usuario usu= usuario.login(n.getLogin());
        ClienteDAO clientes= new ClienteDAO();
        Cliente cliente= clientes.readi(n.getId_cliente());
        ArticuloDAO art= new ArticuloDAO();
        ArrayList<Articulo> articulos= art.read(n.getFolio());
        CestatusNotaDAO cen= new CestatusNotaDAO();
        CestatusReparacionDAO cer= new CestatusReparacionDAO();
        CestatusNota cenn= cen.busquedas(n.getId_estatusnota());
        CestatusReparacion cerr= cer.busquedas(n.getId_estatusreparacion());
        
        
        System.out.println("Folio: "+ n.getFolio()+1);
        System.out.println("Fecha Recepcion: "+ n.getFecharecepcion());
        //System.out.println("Fecha Entrega: "+ n.getFechaentrega() );
        System.out.println("Vendedor: "+ usu.getNombre() + " " + usu.getApellido());
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " "+ cliente.getTelefono());
        System.out.println("Dispositivo: " + n.getModelo()+ " " + n.getImei());
        System.out.println("Total: " + n.getTotal() + " Anticipo: " + n.getAnticipo());
        System.out.println("Articulos: ");
        for (Articulo a: articulos) 
        {
            System.out.println("Cantidad: " + a.getCantidad() + " Descripcion: " + a.getDescripcion() + " Costo: "+ a.getCosto());   
        }
        System.out.println("Estatus Nota "+ cenn.getDescripcion());
        System.out.println("Estatus Reparacion: " + cerr.getDescripcion());
        System.out.println("Observaciones: " + n.getObservaciones());
        System.out.println("Observacion de la Reparacion: " + n.getObsreparacion());
    }
}
