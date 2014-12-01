/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ArticuloDAO;
import com.dao.NotaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rubens
 */
@WebServlet(name = "tevas", urlPatterns = {"/Administrador/elim.el"})
public class EliminacionNota extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    String mensaj;
     try{
    int folion= Integer.parseInt(request.getParameter("folion"));
    NotaDAO nota= new NotaDAO();
    ArticuloDAO articulo = new ArticuloDAO();
    
    boolean veri1= articulo.delete(folion);
    boolean veri2= nota.delete(folion);
    
         if ( veri1 && veri2)
         {
          mensaj= "La nota se ha eliminado con exito";
          request.setAttribute("mensaj", mensaj);
          request.getRequestDispatcher("notas.jsp").forward(request, response);
         }
         else{
             mensaj="El folio de nota no existe, introducir nuevamente";
             request.setAttribute("mensaj", mensaj);
             request.getRequestDispatcher("notas.jsp").forward(request, response);
         }
    
    
    
     }catch(Exception e){
             mensaj="El folio de nota no existe, introducir nuevamente";
             request.setAttribute("mensaj", mensaj);
             request.getRequestDispatcher("notas.jsp").forward(request, response);
     }
    
    
    
    }
}
