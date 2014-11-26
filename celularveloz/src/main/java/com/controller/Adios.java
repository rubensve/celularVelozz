/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author rubens
 */
@WebServlet(name = "Bye", urlPatterns = {"/Administrador/cierre.out"})
public class Adios extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session= request.getSession(false);
        
        if (session!=null) 
        {
        session.invalidate(); 
        }
        
        response.sendRedirect("../");
    
    }
}
