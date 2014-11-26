
package com.controller;

import com.dao.ClienteDAO;
import com.pojo.Cliente;
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
@WebServlet(name = "Registreis", urlPatterns = {"/Administrador/regclien.lo"})
public class Clientitos extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nombre= request.getParameter("nomA");
            String apellido = request.getParameter("apeA");
            String direccion= request.getParameter("dirA");
            String telefono= request.getParameter("telA");
            ClienteDAO cliente =new ClienteDAO();
            boolean rev= cliente.create(new Cliente(nombre, apellido, direccion, telefono));
            if (rev) 
            {
             request.getRequestDispatcher("clientecon.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("clientesin.jsp").forward(request, response);
            }
        } catch (Exception e)
        {
            request.getRequestDispatcher("clientesin.jsp").forward(request, response);
        }
    }
}
