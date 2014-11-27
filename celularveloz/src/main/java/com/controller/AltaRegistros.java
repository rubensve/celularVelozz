/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UsuarioDAO;
import com.pojo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rubens
 */
@WebServlet(name = "Registreishon", urlPatterns = {"/Administrador/registroc.lo"})
public class AltaRegistros extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        int mensaje;
        HttpSession session = request.getSession(true);
        
        try {
                String login = request.getParameter("loginA");
                String password = request.getParameter("passwordA");
                String nombre =request.getParameter("nombreA");
                String apellido =request.getParameter("apellidoA");
                String rol= request.getParameter("rolA");
        
                UsuarioDAO usuario = new UsuarioDAO();
          
                boolean probar=  usuario.create(new Usuario(login, password, nombre, apellido, rol));
          
                  if (probar) 
                 {
                     mensaje=1;
                    request.setAttribute("mensaje", mensaje);
                  request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                 }
                  else {
                      mensaje=2;
                      request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                 }
            
                } catch (Exception e) 
                {
                    mensaje=3;
                    request.setAttribute("mensaje", mensaje);
                 request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                }
    }
}
