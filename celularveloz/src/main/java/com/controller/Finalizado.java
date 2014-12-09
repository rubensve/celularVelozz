
package com.controller;

import com.dao.NotaDAO;
import com.pojo.Nota;
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
@WebServlet(name = "Finalizar", urlPatterns = {"/Administrador/fina.fin"})
public class Finalizado extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaj;
        NotaDAO notas= new NotaDAO();
        
        try{
        int folio = Integer.parseInt(request.getParameter("folion"));
        String estatusnota= request.getParameter("estatusnota");
        String estatusreparacion = request.getParameter("reparacion");
        String obsreparacion= request.getParameter("obsreparacion");
        
       
        boolean veri= notas.update(new Nota(folio, estatusnota, estatusreparacion, obsreparacion));
        
        if (veri) 
        {
            mensaj="Nota Finalizada Satisfactoriamente";
            request.setAttribute("mensaj", mensaj);       
            request.getRequestDispatcher("notas.jsp").forward(request, response);
            
        }
        else
        {
           mensaj="Folio de nota no existe, intentar nuevamente";
           request.setAttribute("mensaj", mensaj);
           request.getRequestDispatcher("notas.jsp").forward(request, response);
        }
        }
        catch(Exception e){
            mensaj="Se ha producido un error al procesar su solicitud";
            request.setAttribute("mensaj", mensaj);
            request.getRequestDispatcher("notas.jsp").forward(request, response);
        }
        
        
    }
}
