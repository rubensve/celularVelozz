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
        String fechaentrega;
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario) sesion.getAttribute("usuario");
        sesion.setAttribute("usuario", u);
        ArrayList<Articulo> articulos;
        NotaDAO nota = new NotaDAO();
        ArticuloDAO articulo = new ArticuloDAO();
        ClienteDAO cliente = new ClienteDAO();
        
        
        if (sesion.getAttribute("articulos")==null) 
                {
                 articulos = new ArrayList(); 
                }
                else{
                articulos= (ArrayList<Articulo>) sesion.getAttribute("articulos");
                }

        try
        {
            if (request.getParameter("Agregar")!=null)
            {
                int folio = Integer.parseInt(request.getParameter("folio"));
                int cantidad= Integer.parseInt(request.getParameter("cantid"));
                String descripcion = request.getParameter("descrip");
                double precio = Double.parseDouble(request.getParameter("prec"));
                imei = request.getParameter("imei");
                fechaentrega = request.getParameter("fechaentrega");
                int id_cliente= Integer.parseInt(request.getParameter("clientestodos"));
                Cliente cl= cliente.readi(id_cliente);
                
                sesion.setAttribute("imei", imei);
                sesion.setAttribute("fechaentrega", fechaentrega);
                articulos.add(new Articulo(new Nota(folio),cantidad, descripcion, precio));
                sesion.setAttribute("articulos", articulos);
                sesion.setAttribute("cl", cl);
            }
            else if(request.getParameter("eliminar")!=null)
            {
                if (articulos.size()>0) 
                {
                 int ultimo = articulos.size() -1;
                 articulos.remove(ultimo);
                }
            } else if (request.getParameter("Finalizar")!=null)
            {
               int folio = Integer.parseInt(request.getParameter("folio"));
               String fecharecepcion = request.getParameter("fecha");
               fechaentrega = request.getParameter("fechaentrega");
               String login = u.getLogin();
               int id_cliente = Integer.parseInt(request.getParameter("clientestodos"));
               imei = request.getParameter("imei");
               double anticipo = Double.parseDouble(request.getParameter("anticipo"));
               double totalv= Double.parseDouble(request.getParameter("total"));               
               
               nota.create(new Nota(folio, fecharecepcion, fechaentrega, new Usuario(login), new Cliente(id_cliente), imei, 
                       totalv, anticipo, (totalv-anticipo)));
               
               
                for (Articulo a : articulos) 
                {
                    articulo.create(new Articulo(new Nota(folio), a.getCantidad(), a.getDescripcion(), a.getCosto()));
                }
                
                    articulos.clear();
                    sesion.removeAttribute(imei);
                    sesion.removeAttribute(fechaentrega);  
                    
            
            }
            else if (request.getParameter("Imprimir")!=null) 
            {
                Nota notas= nota.readUltimo();
                int id_cliente = notas.getId_usuario();
                Cliente c = cliente.readi(id_cliente);
                ArrayList<Articulo> compras = articulo.read(notas.getFolio());
                
                
                try {
                        Document documento = new Document(new Rectangle(227,360),16, 16,16,16);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        PdfWriter.getInstance(documento, baos);
                        // step 3
                        documento.open();
                        Font titulos = new Font(FontFamily.COURIER, 16, Font.BOLD);
                        Font subtitulos = new Font(FontFamily.COURIER,10, Font.BOLDITALIC
                        );
                        Chunk encabezado = new Chunk("El Celular Veloz" , titulos);
                        Chunk subencabezado = new Chunk(" La Nueva Tecnologia en Celular", subtitulos);
                        // step 4
                        Paragraph titulo= new Paragraph(encabezado);
                        titulo.setAlignment(1);
                        Paragraph subtitulo= new Paragraph(subencabezado);
                        subtitulo.setAlignment(1);
                        documento.add(titulo);
                        documento.add(subencabezado);
                        documento.add(new Paragraph("   Rafael Veloz/Mireya Gutierrez ",
                                FontFactory.getFont("Courier", 9)));
                        documento.add(new Paragraph("Calle Rusia Mz.13 Lote 11 Col. Olimpica",
                                FontFactory.getFont("Courier", 8)));
                      
                        documento.add(new Paragraph("*Reparacion de Equipos y Venta de Accesorios ",
                                FontFactory.getFont("Courier", 7)));
                        documento.add(new Paragraph("     *Flexeos *Desbloqueos *Activaciones ",
                                FontFactory.getFont("Courier", 7)));
                        documento.add(new Paragraph("       *Liberaciones *Carga de Software ",
                                FontFactory.getFont("Courier", 7)));
                        documento.add(new Paragraph("     Folio: "+ notas.getFolio(),
                                FontFactory.getFont("Courier", 16, Font.BOLDITALIC)));
                        
                        documento.add(new Paragraph("Atendio:" + u.getNombre() + " " + u.getApellido()
                                + " Recibido:" +notas.getFecharecibido() ,
                                FontFactory.getFont("Courier", 7)));
                        documento.add(new Paragraph("Cliente:" + c.getNombre() + " " + c.getApellido()
                                + " Entrega:" +notas.getFechaentrega(),
                                FontFactory.getFont("Courier", 7)));
                        documento.add(new Paragraph("Direccion:" + c.getDireccion()
                                + " Tel:" +c.getTelefono() + " Imei:"+notas.getImei(),
                                FontFactory.getFont("Courier", 7)));
                        documento.add(new Paragraph("C.|             Concepto              | Precio ",
                                FontFactory.getFont("Courier", 7)));
                        
                        final float columnas[] = {0.15f,2f,0.45f};
                        
                        PdfPTable productos = new PdfPTable(columnas);
                        productos.setWidthPercentage(100);
                        productos.setHorizontalAlignment(Element.ALIGN_LEFT);
                        productos.getDefaultCell().setBorder(0);
                        for (Articulo ar : compras) 
                        {
                        productos.addCell(new Paragraph(String.valueOf(ar.getCantidad()),
                                FontFactory.getFont("Courier", 8)));
                         productos.addCell(new Paragraph(ar.getDescripcion(),
                                FontFactory.getFont("Courier", 8)));
                        productos.addCell(new Paragraph(String.valueOf(ar.getCosto()),
                                FontFactory.getFont("Courier", 8)));
                        }
                        documento.add(productos);
                        documento.add(new Paragraph("Observaciones:"+ notas.getObservaciones(),
                         FontFactory.getFont("Courier", 7)));  
                         documento.add(new Paragraph("Total:"+notas.getTotal()+" Anticipo:" + 
                                 notas.getAnticipo()+" Adeudo:"+ notas.getResta(),
                         FontFactory.getFont("Courier", 8)));      
                         Chunk nl = new Chunk(NEWLINE);
                         documento.add(nl);
                        documento.add(new Paragraph("En equipos mojados NO hay garantia.",
                         FontFactory.getFont("Courier", 6)));  
                        documento.add(new Paragraph("Despues de 30 dias NO se responde por "
                                + "ningun trabajo.",
                         FontFactory.getFont("Courier", 6))); 
                        documento.add(new Paragraph("En sistemas de carga NO hay garantia.",
                         FontFactory.getFont("Courier", 6)));  
                        documento.add(new Paragraph("NO nos hacemos cargo de chips y memorias.",
                         FontFactory.getFont("Courier", 6)));  
                        documento.add(new Paragraph("La procedencia de los equipos es responsabilidad"
                                + " del usuario.",
                         FontFactory.getFont("Courier", 6)));  
                       
                        
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
          }finally {
                        for (Articulo a: articulos) 
                        {
                        total = total + a.getCosto();
                        }
                        sesion.setAttribute("total",total);
                        response.sendRedirect("ventas.jsp"); 
                }                   
    }
}







