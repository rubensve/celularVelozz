/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ClienteDAO;
import com.pojo.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rubens
 */
@WebServlet(name = "Dentro", urlPatterns = {"/Administrador/modificarc.los"})
public class Fuera extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nombre= request.getParameter("nomB");
            String apellido = request.getParameter("apeB");
            String direccion= request.getParameter("dirB");
            String telefono= request.getParameter("telB");    
            int id = Integer.parseInt(request.getParameter("idB"));
            ClienteDAO usuario = new ClienteDAO();
            
            boolean ver = usuario.update(new Cliente(id,nombre,apellido,direccion,telefono));
            
            if (ver) 
            {
             request.getRequestDispatcher("clientecon.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("clientesin.jsp").forward(request, response);
            }
        } catch (Exception e) {
                request.getRequestDispatcher("clientesin.jsp").forward(request, response);

        }
    
    }
}