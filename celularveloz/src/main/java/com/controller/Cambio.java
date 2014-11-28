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
      String mensaje;
        try
        {
        UsuarioDAO usuario = new UsuarioDAO();
        String login = request.getParameter("loginC");
        String password =request.getParameter("passwordC");
        String nombre= request.getParameter("nombreC");
        String apellido= request.getParameter("apellidoC");
        String rol= request.getParameter("rolC");
        
        boolean veri = usuario.update(new Usuario(login, password, nombre, apellido, rol));
            if (veri) 
            {
                mensaje= "Usuario actualizado correctamente";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            }
            else {
                mensaje= "El Nombre de usuario no existe, intente nuevamente";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            }
            
            
        }catch(Exception e)
        {
            mensaje= "Ha surgido un error al procesar su solicitud, intente nuevamente";
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }
        
        
        
    }
}
