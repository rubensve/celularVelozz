package com.controller;

import com.dao.ArticuloDAO;
import com.dao.NotaDAO;
import com.pojo.Articulo;
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
@WebServlet(name = "Notititas", urlPatterns = {"/Administrador/notas.not"})
public class Notototas extends HttpServlet {
    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session= request.getSession(true);
        NotaDAO notas= new NotaDAO();
        ArrayList<Nota> anotas= notas.readTodas();
        ArticuloDAO articulo= new ArticuloDAO();
        ArrayList<ArrayList<Articulo>> articulos= new ArrayList();
        
        for (Nota nota: anotas) 
        {
         articulos.add(articulo.read(nota.getFolio()));
        }
        
        request.setAttribute("anotas", anotas);
        request.setAttribute("articulos", articulos);
        request.getRequestDispatcher("resultadonottodas.jsp").forward(request, response);
    }
}
