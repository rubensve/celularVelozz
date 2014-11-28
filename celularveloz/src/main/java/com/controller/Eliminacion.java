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
        String mensaje;
        try {
            String login = request.getParameter("loginB");
            UsuarioDAO usuario = new UsuarioDAO();
            boolean verificar= usuario.delete(login);
            if (verificar) 
            {
                mensaje= "Usuario eliminado Correctamente";
                request.setAttribute("mensaje", mensaje);
             request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            }
            else {
                mensaje= "Nombre de Usuario no existe, intente nuevamente";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            }
        } catch (Exception e) {
            mensaje= "Ha surgido un error al procesar su solicitud, intente nuevamente";
            request.setAttribute("mensaje", mensaje);
           request.getRequestDispatcher("usuarios.jsp").forward(request, response);

        }
       
    }

}
