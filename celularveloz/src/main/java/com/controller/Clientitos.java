
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
        String mensajes;
        try {
            String nombre= request.getParameter("nomA");
            String apellido = request.getParameter("apeA");
            String direccion= request.getParameter("dirA");
            String telefono= request.getParameter("telA");
            ClienteDAO cliente =new ClienteDAO();
            boolean rev= cliente.create(new Cliente(nombre, apellido, direccion, telefono));
            if (rev) 
            {
                mensajes="Cliente Registrado Correctamente";
                request.setAttribute("mensajes", mensajes);
             request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
            else {
                mensajes= "No se ha podido registrar al cliente, intente nuevamente";
                request.setAttribute("mensajes", mensajes);
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            }
        } catch (Exception e)
        {
            mensajes ="Se ha producido un error al procesar su solicitud, intente nuevamente";
            request.setAttribute("mensajes", mensajes);
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }
    }
}
