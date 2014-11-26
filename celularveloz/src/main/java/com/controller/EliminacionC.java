/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ClienteDAO;
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
@WebServlet(name = "Eliminaciones", urlPatterns = {"/Administrador/eliminarc.los"})
public class EliminacionC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try {
            int id = Integer.parseInt(request.getParameter("idA"));
            ClienteDAO cliente = new ClienteDAO();
            boolean rev = cliente.delete(id);
            
            if (rev) 
            {
            request.getRequestDispatcher("clientecon.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("clientesin.jsp").forward(request, response);
            }
        } catch (Exception e) {
                            request.getRequestDispatcher("clientesin.jsp").forward(request, response);

        }
    
    }
}
