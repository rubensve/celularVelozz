
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "TodosUsuarios", urlPatterns = {"/Administrador/usuarios.usu"})
public class TodosJuntos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        UsuarioDAO usu= new UsuarioDAO();
        ArrayList<Usuario> usuarios = usu.readAll();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
        
    }
}
