/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.NotaDAO;
import com.pojo.Nota;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Fechasona", urlPatterns = {"/Administrador/fechas.fe"})
public class Fechas extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje;
        try{
        HttpSession  session = request.getSession(true);
        String inicial= request.getParameter("inicial");
        String finals= request.getParameter("final");
     NotaDAO nota= new NotaDAO();
     ArrayList<Nota> notas= nota.readPorFechaTotales(inicial, finals);
     session.setAttribute("notas", notas);
     response.sendRedirect("totales.jsp");
        }
        catch(Exception e)
        {
            mensaje="Ha ocurrido un error en tu solicitud, intenta nuevamente";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("reportes.jsp").forward(request, response);
        }
    }
}
