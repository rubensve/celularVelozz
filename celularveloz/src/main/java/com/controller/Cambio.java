package com.controller;

import com.dao.UsuarioDAO;
import com.pojo.Usuario;
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
@WebServlet(name = "EntraSale", urlPatterns = {"/Administrador/modificarc.lo"})
public class Cambio extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try
        {
        UsuarioDAO usuario = new UsuarioDAO();
        String login = request.getParameter("loginC");
        String password =request.getParameter("passwordC");
        String nombre= request.getParameter("nombreC");
        String apellido= request.getParameter("apellidoC");
        String rol= request.getParameter("rolC");
        
        boolean veri = usuario.update(new Usuario(login, password, nombre, apellido, rol));
            if (veri) {
                request.getRequestDispatcher("usuariocon.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("usuariosin.jsp").forward(request, response);
            }
            
            
        }catch(Exception e)
        {
            request.getRequestDispatcher("usuariosin.jsp").forward(request, response);
        }
        
        
        
    }
}
