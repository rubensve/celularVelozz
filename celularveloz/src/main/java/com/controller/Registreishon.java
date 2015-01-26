/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.dao.ArticuloDAO;
import com.dao.ClienteDAO;
import com.dao.NotaDAO;
import com.itextpdf.text.Chunk;
import static com.itextpdf.text.Chunk.NEWLINE;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pojo.Articulo;
import com.pojo.Cliente;
import com.pojo.Nota;
import com.pojo.Usuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
@WebServlet(name = "Registrar", urlPatterns = {"/Administrador/registro.pdf"})
public class Registreishon extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double total = 0.0;
        String imei;
        String modelo;
        String observacion;
        String mensaje;
        int validar;
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario) sesion.getAttribute("usuario");
        sesion.setAttribute("usuario", u);
        ArrayList<Articulo> detallearticulos;
        NotaDAO nota = new NotaDAO();
        ArticuloDAO articulo = new ArticuloDAO();
        ClienteDAO cliente = new ClienteDAO();
        
        if (sesion.getAttribute("detallearticulos")==null) 
                {
                 detallearticulos = new ArrayList();
                  
                }
                else{
                detallearticulos= (ArrayList<Articulo>) sesion.getAttribute("detallearticulos");
                }

        try
        {
            if (request.getParameter("Agregar")!=null)
            {
                try{
                int folio = Integer.parseInt(request.getParameter("folio"));
                int cantidad= Integer.parseInt(request.getParameter("cantid"));
                String descripcion = request.getParameter("descrip");
                double precio = Double.parseDouble(request.getParameter("prec"));
                imei = request.getParameter("imei");
                int id_cliente= Integer.parseInt(request.getParameter("clientestodos"));
                modelo= request.getParameter("modelo");
                observacion= request.getParameter("observacioni");
                Cliente cl= cliente.readi(id_cliente);
                sesion.setAttribute("imei", imei);
                sesion.setAttribute("modelo", modelo);
                sesion.setAttribute("observacion", observacion);
                sesion.setAttribute("cl", cl);
                detallearticulos.add(new Articulo(new Nota(folio),cantidad, descripcion, precio)); 
                }
                catch(Exception e)
                {
                 response.sendRedirect("ventas.jsp");
                }
            }
            else if(request.getParameter("eliminar")!=null)
            {
                if (detallearticulos.size()>0) 
                {
                 int ultimo = detallearticulos.size() -1;
                 detallearticulos.remove(ultimo);
                }
                    
            } else if (request.getParameter("Finalizar")!=null)
            {
               int folioo= Integer.parseInt(request.getParameter("folio"));
               String login = u.getLogin();
               int id_cliente = Integer.parseInt(request.getParameter("clientestodos"));
               imei = request.getParameter("imei");
               modelo= request.getParameter("modelo");
               observacion= request.getParameter("observacioni");
               double anticipo = Double.parseDouble(request.getParameter("anticipo"));
               double totalv= Double.parseDouble(request.getParameter("total"));               
               validar=1;
             
               nota.create(new Nota(new Usuario(login), new Cliente(id_cliente), imei, modelo, 
                       totalv, anticipo, (totalv-anticipo), observacion));
               
               
                for (Articulo a : detallearticulos) 
                {
                    articulo.create(new Articulo(new Nota(folioo), a.getCantidad(), a.getDescripcion(), a.getCosto()));
                }
                
                    detallearticulos.clear();
                    imei="";
                    modelo="";
                    mensaje= "Registro correcto, ahora puedes imprimir tu nota";
                    request.setAttribute("mensaje", mensaje);
                    sesion.setAttribute("imei", imei);
                    sesion.setAttribute("modelo", modelo);
                    sesion.setAttribute("validar", validar);
                    
                
            }
            else if (request.getParameter("Imprimir")!=null) 
            {
                Nota notas= nota.leerultimo();
                int id_cliente = notas.getId_cliente();
                Cliente c = cliente.readi(id_cliente);
                ArrayList<Articulo> compras = articulo.read(notas.getFolio());
                validar=0;
                sesion.setAttribute("validar", validar);

                try {
                        Document documento = new Document(new Rectangle(164.4f,500),14,14,14,14);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        PdfWriter.getInstance(documento, baos);
                        // step 3
                       
                         documento.open();
                        Font titulos = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
                        Chunk encabezado = new Chunk("El Celular Veloz" , titulos);
                     
                        // step 4
                        Paragraph titulo= new Paragraph(encabezado);
                        documento.add(titulo);
                        documento.add(new Paragraph("La Nueva Tecnologia en Celular ",
                                FontFactory.getFont("Arial", 7, Font.BOLDITALIC)));
                        documento.add(new Paragraph("Rafael Veloz/Mireya Gutierrez\nTel: 6640-2906 ",
                                FontFactory.getFont("Arial", 8, Font.BOLDITALIC)));
                        documento.add(new Paragraph("C. Rusia Mz.13 L.11 Olimpica",
                                FontFactory.getFont("Arial", 8, Font.BOLDITALIC)));
                      
                        documento.add(new Paragraph("*Reparacion de Equipos \n*Venta de Accesorios ",
                                FontFactory.getFont("Arial", 8, Font.BOLDITALIC)));
                        /*documento.add(new Paragraph("     *Flexeos *Desbloqueos *Activaciones ",
                                FontFactory.getFont("Courier", 5)));
                        documento.add(new Paragraph("       *Liberaciones *Carga de Software ",
                                FontFactory.getFont("Courier", 5))); */
                        documento.add(new Paragraph("     Folio: "+ notas.getFolio(),
                                FontFactory.getFont("Arial", 12, Font.BOLDITALIC)));
                        
                        documento.add(new Paragraph("Atendio:" + u.getNombre() + " " + u.getApellido()
                                + "\nRecibido:" +notas.getFecharecepcion() ,
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                        documento.add(new Paragraph("Cliente:" + c.getNombre() + " " + c.getApellido(),
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                        documento.add(new Paragraph("Tel:" +c.getTelefono() +"\nEquipo:"+notas.getModelo() +"\nImei:"+notas.getImei(),
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                        documento.add(new Paragraph("Detalles ",
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                        
                        final float columnas[] = {0.15f,0.9f,0.45f};
                        
                        PdfPTable productos = new PdfPTable(columnas);
                        productos.setWidthPercentage(90);
                        productos.setHorizontalAlignment(Element.ALIGN_LEFT);
                        productos.getDefaultCell().setBorder(0);
                        for (Articulo ar : compras) 
                        {
                        productos.addCell(new Paragraph(String.valueOf(ar.getCantidad()),
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                         productos.addCell(new Paragraph(ar.getDescripcion(),
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                        productos.addCell(new Paragraph(String.valueOf(ar.getCosto()),
                                FontFactory.getFont("Arial", 8, Font.BOLD)));
                        }
                        documento.add(productos);
                        documento.add(new Paragraph("Observaciones:\n"+ notas.getObservaciones(),
                         FontFactory.getFont("Arial", 8, Font.BOLD)));  
                         documento.add(new Paragraph("Total:"+notas.getTotal()+" Anticipo:" + 
                                 notas.getAnticipo()+"\nAdeudo:"+ notas.getResto(),
                         FontFactory.getFont("Arial", 8, Font.BOLD)));      
                         Chunk nl = new Chunk(NEWLINE);
                         documento.add(nl);
                        documento.add(new Paragraph("En equipos mojados \nNO hay garantia.",
                         FontFactory.getFont("Arial", 8, Font.BOLD)));  
                        documento.add(new Paragraph("Despues de 30 dias \nNO se responde por "
                                + "\nningun trabajo.",
                         FontFactory.getFont("Arial", 8, Font.BOLD))); 
                        documento.add(new Paragraph("En sistemas de carga \nNO hay garantia.",
                         FontFactory.getFont("Arial", 8, Font.BOLD)));  
                        documento.add(new Paragraph("NO nos hacemos cargo \nDe chips y memorias.",
                         FontFactory.getFont("Arial", 8, Font.BOLD)));  
                        documento.add(new Paragraph("La procedencia de los\nEquipos es responsabilidad"
                                + "\nDel usuario.",
                         FontFactory.getFont("Arial", 8, Font.BOLD)));  
                       
                        
                        documento.close();

                        // setting some response headers
                        response.setHeader("Expires", "0");
                        response.setHeader("Cache-Control",
                            "must-revalidate, post-check=0, pre-check=0");
                        response.setHeader("Pragma", "public");
                        // setting the content type
                        response.setContentType("application/pdf");
                        // the contentlength
                        response.setContentLength(baos.size());
                        // write ByteArrayOutputStream to the ServletOutputStream
                        OutputStream os = response.getOutputStream();
                        baos.writeTo(os);
                        os.flush();
                        os.close();
                        
                } catch (DocumentException de) {
                de.printStackTrace();
                    System.err.println("documento " + de.getMessage());
                }
            }
          }
          catch(Exception e){
          
              System.out.println("Aqui hay algo raro");
              mensaje= "No puedes agregar productos vacios, y debes registrar un anticipo, "
                      + "si no lo hay registra 0";
              request.setAttribute("mensaje", mensaje);
              
          }finally {
                        for (Articulo a: detallearticulos) 
                        {
                        total = total + a.getCosto();
                        }
                        sesion.setAttribute("detallearticulos", detallearticulos);
                        sesion.setAttribute("total",total);
                        request.getRequestDispatcher("ventas.jsp").forward(request, response);
                }                   
    }
}







