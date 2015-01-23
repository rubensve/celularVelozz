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
        String mensaje;
            if (criterio.equalsIgnoreCase("Folio")) 
            {
                try{
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
                }
                catch(Exception e)
                {
                mensaje="El numero de folio no existe, intente nuevamente";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("busquedas.jsp").forward(request, response);
                }
            }else if (criterio.equalsIgnoreCase("nombre del cliente")) 
            {
                try{
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
                catch(Exception e)
                {
                 mensaje= "El cliente ingresado no existe, intente nuevamente";
                 request.setAttribute("mensaje", mensaje);
                 request.getRequestDispatcher("busquedas.jsp").forward(request, response);
                }
            }
            else if (criterio.equalsIgnoreCase("fecha")) 
            {
                try{
                String inicial= request.getParameter("inicial");
                String finals= request.getParameter("final");
                
                anotas= notas.readPorFecha(inicial, finals);
                ArrayList<ArrayList<Articulo>> articulos= new ArrayList();
                
                for (Nota a : anotas) 
                {
                    articulos.add(articulo.read(a.getFolio()));
                }
                
                session.setAttribute("anotas", anotas);
                session.setAttribute("articulos", articulos);
                response.sendRedirect("resultadonta.jsp");
                }
                catch(Exception e)
                {
                 mensaje="La fecha ingresada es incorrecta, intente nuevamente";
                 request.setAttribute("mensaje", mensaje);
                 request.getRequestDispatcher("busquedas.jsp").forward(request, response);
                }
                }
        }catch(Exception e){
            System.out.println("Aqui anda mal algo");
        }
        
    }
}
