/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author rubens
 */
@WebServlet(name = "Individual", urlPatterns = {"/Administrador/cliente.cli"})
public class Individuo extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("busB");
        ClienteDAO usu = new ClienteDAO();
        ArrayList<Cliente> clientes = usu.read(login);
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("resultadoc.jsp").forward(request, response);
    
    }
}
