/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rubens
 */
@WebServlet(name = "Eliminaciones", urlPatterns = {"/Administrador/eliminarc.los"})
public class EliminacionC extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String mensajes;
        try {
            int id = Integer.parseInt(request.getParameter("idA"));
            ClienteDAO cliente = new ClienteDAO();
            boolean rev = cliente.delete(id);
            
            if (rev) 
            {
                mensajes="Cliente Eliminado Correctamente";
                request.setAttribute("mensajes", mensajes);
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
            else {
                mensajes="El id de cliente no existe, intente nuevamente";
                 request.setAttribute("mensajes", mensajes);
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
        } catch (Exception e) {
            mensajes="Se ha producido un error al procesar su solicitud, intente nuevamente";
             request.setAttribute("mensajes", mensajes);
             request.getRequestDispatcher("clientes.jsp").forward(request, response);

        }
    
    }
}
