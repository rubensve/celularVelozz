/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ClienteDAO;
import com.dao.NotaDAO;
import com.pojo.Cliente;
import com.pojo.Nota;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "Ventitas", urlPatterns = {"/Administrador/ventas.ve"})
public class Ventica extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession session= request.getSession(true);
    ArrayList<Cliente> clientes;
    ClienteDAO cliente= new ClienteDAO();
    clientes= cliente.readAll();
    NotaDAO notas = new NotaDAO();
    Nota nota = notas.leerultimo();
    //int cantidad=0;
    session.setAttribute("nota", nota);
    session.setAttribute("clientes", clientes);
    //cantidad.setAttribute("cantidad", cantidad);
    response.sendRedirect("ventas.jsp");
    //request.getRequestDispatcher("ventas.jsp").forward(request, response);
        
        
    
    }
}
