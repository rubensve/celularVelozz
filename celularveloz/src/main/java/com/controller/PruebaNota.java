package com.controller;

import com.dao.ClienteDAO;
import com.dao.NotaDAO;
import com.dao.UsuarioDAO;
import com.pojo.Cliente;
import com.pojo.Nota;
import com.pojo.Usuario;


public class PruebaNota {

    public static void main(String[] args) {
        NotaDAO nota = new NotaDAO();
        Nota no = nota.readUltimo();
        ClienteDAO cliente = new ClienteDAO();
        Cliente c = cliente.readi(no.getId_usuario());
        UsuarioDAO usuario= new UsuarioDAO();
        Usuario u = usuario.login(no.getLogin());
        
        System.out.println(no.getFolio());
        System.out.println(no.getFechaentrega());
        System.out.println(no.getFechaentrega());
        System.out.println(no.getImei());
        System.out.println(u.getNombre());
        System.out.println(u.getApellido());
        System.out.println(c.getNombre());
        System.out.println(c.getApellido());
        System.out.println(c.getDireccion());
        System.out.println(c.getTelefono());
        System.out.println(no.getTotal());
        System.out.println(no.getAnticipo());
        System.out.println(no.getResta());
    }
}
