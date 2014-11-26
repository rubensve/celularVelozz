
package com.controller;

import com.dao.ClienteDAO;
import com.pojo.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ClientesTodos", urlPatterns = {"/Administrador/clientes.cli"})
public class TodosJuntosC extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClienteDAO cli = new ClienteDAO();
        ArrayList<Cliente> clientes = cli.readAll();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("resultadoc.jsp").forward(request, response);
    
    }
}
