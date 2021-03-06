<%-- 
    Document   : resultadonta
    Created on : 21/01/2015, 11:43:08 PM
    Author     : rubens
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="usuario" scope="session" class="com.pojo.Usuario" />
<% 
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" /> 
    <link href="../js/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../js/libs/bootstrap/css/barra.css" rel="stylesheet" />
        <title>Administrador</title>
    </head>
    <body>
        <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="index.jsp">
                        El Celular Veloz
                    </a>
                </li>
                <li class="nav-header" >Tareas</li>
                <li>
                    <a href="usuarios.jsp">Usuarios de Sistema</a>
                </li>
                <li>
                    <a href="clientes.jsp">Clientes</a>
                </li>
                <li>
                <a href="notas.jsp">Ventas</a>
                </li>
                <li>
                    <a href="busquedas.jsp">Consultas</a>
                </li>
                <li>
                    <a href="reportes.jsp">Reportes</a>
                </li>
                <li>
                   <a href="cierre.out">Salir</a>
                </li>
            </ul>
        </div>
        
        <!-- Page Content -->
       <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                      
                        <h3>Resultado de la Nota</h3>
                        
                        <% int a=0;  %> 
                        <c:forEach items="${anotas}" var="anotas">
                           
                        <div class="row">
                            <div class="col-md-10">
                                <div class="panel panel-info">
                                <div class="panel-heading"><h4>Nota Folio:  ${anotas.folio}</h4></div>   
                                <div class="panel-body">
                                    <div class="row">
                                        
                                        <div class="col-md-4">
                                            <p class="text-muted">Fecha de Recepcion: </p><p class="text-success">${anotas.fecharecepcion}</p>
                                        </div>
                                        
                                        <div class="col-md-4">
                                            
                                        </div>
                                        
                                        <div class="col-md-4">
                                            <p class="text-muted">Nombre del Vendedor: </p><p class="text-success">${anotas.nombreusuario} ${anotas.apellidousuario}</p>
                                        </div>
                                    </div>
                                        
                                        
                                   <div class="row">
                                        
                                        <div class="col-md-4">
                                            <p class="text-muted">Nombre del Cliente: </p><p class="text-success">${anotas.nombrecliente} ${anotas.apellidocliente}</p>
                                            <p class="text-muted">Telefono: </p><p class="text-success">${anotas.telefono}</p>
                                        </div>
                                        
                                        <div class="col-md-4">
                                            <p class="text-muted">Dispositivo: </p><p class="text-success">${anotas.modelo}</p>
                                            <p class="text-muted">Imei: </p><p class="text-success">${anotas.imei}</p>
                                        </div>
                                        
                                        <div class="col-md-4">
                                            <p class="text-muted">Total Nota: </p><p class="text-success">${anotas.total}</p>
                                            <p class="text-muted">Anticipo Nota: </p><p class="text-success">${anotas.anticipo}</p>
                                        </div>
                                    </div>
                                        
                                        <div class="row">
                                          
                                            <table class="table table-condensed table-responsive">
                                                <thead>
                                                <th>Cantidad</th>
                                                <th>Descripcion</th>
                                                <th>Precio</th>
                                                </thead>
                                                <tbody>
                                                    
                                                    <c:forEach items="${articulos}" var="articulos1" begin="<%= a %>" end="<%= a %>" >
                                                        <c:forEach items="${articulos1}" var="articulos2">
                                                    <tr>
                                                        <td>${articulos2.cantidad}</td>
                                                        <td>${articulos2.descripcion}</td>    
                                                        <td>${articulos2.costo}</td>
                                                    </tr>
                                                        </c:forEach>
                                                        </c:forEach>
                                                    
                                                    
                                                </tbody>

                                            </table>
                                            
                                           
                                        </div>    
                                        
                                        <div class="row">
                                           
                                            <div class="col-md-3">
                                              <p class="text-muted">Estatus Nota: </p><p class="text-success">${anotas.descripcionnota}</p>   
                                            </div>
                                            
                                            <div class="col-md-3">
                                              <p class="text-muted">Estatus Reparacion: </p><p class="text-success">${anotas.descripcionreparacion}</p> 
                                            </div>
                                            
                                            <div class="col-md-3">
                                               <p class="text-muted">Observaciones: </p><p class="text-success">${anotas.observaciones}</p> 
                                            </div>
                                            
                                            <div class="col-md-3">
                                                <p class="text-muted">Observaciones Reparacion: </p><p class="text-success">${anotas.obsreparacion}</p>
                                            </div>
                                        </div>
                                </div>   
                                            <div class="panel-footer">
                                                <p class="text-warning"><a href="notas.jsp">Imprimir</a></p>
                                            </div>
                            
                                </div>
                            </div>
                            
                            
                        </div>
                                                <% a=a+1;%>
                       </c:forEach>
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
           
    <script src="../js/libs/jquery/jquery.js"></script>               
    <script src="../js/libs/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>