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
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Notota", urlPatterns = {"/Administrador/nota.not"})
public class Notita extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession(true);
        
        try{
        String criterio = request.getParameter("criterio");
        NotaDAO notas= new NotaDAO();
        Nota nota=null;
        ClienteDAO clientes= new ClienteDAO();
        Cliente cliente= null;
        UsuarioDAO usuarios= new UsuarioDAO();
        Usuario usuario=null;
        ArticuloDAO articulo= new ArticuloDAO();
        ArrayList <Nota> anotas;
        CestatusNotaDAO cen= new CestatusNotaDAO();
        CestatusNota cenn= null;
        CestatusReparacionDAO cer= new CestatusReparacionDAO();
        CestatusReparacion cerr= null;
        
            if (criterio.equalsIgnoreCase("Folio")) 
            {
                int folion= Integer.parseInt(request.getParameter("folion"));
                nota= notas.leerIndividual(folion);
                cliente= clientes.readi(nota.getId_cliente());
                usuario= usuarios.login(nota.getLogin());
                ArrayList<Articulo>articulos= articulo.read(nota.getFolio());
                cenn= cen.busquedas(nota.getId_estatusnota());
                cerr= cer.busquedas(nota.getId_estatusreparacion());
                session.setAttribute("nota",nota);
                session.setAttribute("usuario", usuario);
                session.setAttribute("cliente", cliente);
                session.setAttribute("articulos", articulos);
                session.setAttribute("cenn", cenn);
                session.setAttribute("cerr", cerr);
                response.sendRedirect("resultadon.jsp");
            }else if (criterio.equalsIgnoreCase("nombre del cliente")) 
            {
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                cliente= clientes.readinombre(nombre, apellido);              
                anotas= notas.readPorCliente(cliente.getId());
                ArrayList<ArrayList<Articulo>> articulos= new ArrayList();
                for (Nota a : anotas) 
                {
                    articulos.add(articulo.read(a.getFolio()));
                }
                
                session.setAttribute("anotas", anotas);
                session.setAttribute("cliente", cliente);
                session.setAttribute("articulos", articulos);
                response.sendRedirect("resultadont.jsp");
                
            }
            else if (criterio.equalsIgnoreCase("fecha")) 
            {
                
            }
        }catch(Exception e){
            System.out.println("Aqui anda mal algo");
        }
        
    }
}