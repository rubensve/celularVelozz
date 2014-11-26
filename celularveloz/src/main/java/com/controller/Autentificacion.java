
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

@WebServlet(name = "Resolucion", urlPatterns = {"/autenticar.do"})
public class Autentificacion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       HttpSession session= request.getSession();
       session.setMaxInactiveInterval(30*60);
        try 
        {
            String usuario = request.getParameter("txtUsuario");
            String password = request.getParameter("txtPassword");
            Usuario usu;
            UsuarioDAO u=  new UsuarioDAO();
    
            usu = u.login(usuario);
    
            String real= usu.getPassword();
            String rol =  usu.getRol();
    
           
    
            if (real.equals(password)) 
            {
                if (rol.equalsIgnoreCase("administrador")) 
                {
                   
                    session.setAttribute("usuario", usu);
                    response.sendRedirect("Administrador");
                } 
                else if (rol.equalsIgnoreCase("cajero")) 
                {
                 response.sendRedirect("Cajero");
                }
            }
            else {  
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
        } 
        catch (Exception e) 
        {
        request.getRequestDispatcher("error.jsp").forward(request, response);
        }
 
    }
   
    
    
}

