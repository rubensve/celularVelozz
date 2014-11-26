/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UsuarioDAO;
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
@WebServlet(name = "Debil", urlPatterns = {"/Administrador/eliminarc.lo"})
public class Eliminacion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String login = request.getParameter("loginB");
            UsuarioDAO usuario = new UsuarioDAO();
            boolean verificar= usuario.delete(login);
            if (verificar) 
            {
             request.getRequestDispatcher("usuariocon.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("usuariosin.jsp").forward(request, response);
            }
        } catch (Exception e) {
           request.getRequestDispatcher("usuariosin.jsp").forward(request, response);

        }
       
    }

}
