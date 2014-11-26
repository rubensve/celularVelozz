package com.controller;

import com.dao.UsuarioDAO;
import com.pojo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Busquet", urlPatterns = {"/Administrador/usuario.usu"})
public class Abusado extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String login = request.getParameter("busA");
        UsuarioDAO usu = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usu.read(login);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);

    }

}
