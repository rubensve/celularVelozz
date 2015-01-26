<%-- 
    Document   : totales
    Created on : 22/01/2015, 08:51:10 PM
    Author     : rubens
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" /> 
    <link href="../js/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../js/libs/bootstrap/css/barra.css" rel="stylesheet" />
        <title>Consulta Clientes</title>
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
                <li class="nav-header">Tareas</li>
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
                        
                        <div class="container-fluid">
                            
                            
                            <table border="0" class="table table-hover table-responsive" >
                                <thead>
                                    <tr>
                                        <th>Folio</th>
                                        <th>Fecha de Recepcion</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                          <c:forEach items="${notas}" var="nota">
                                          <tr>
                                          <td><c:out value="${nota.folio}"/></td>
                                          <td><c:out value="${nota.fecharecepcion}"/></td>
                                          <td><c:out value="${nota.total}"/></td>
                                          </tr>
                                            </c:forEach>
                                </tbody>
                            </table>

                                        <div class="alert alert-success"><strong>Consulta Realizada Correctamente</strong></div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
        
        
                    
    <script src="js/libs/jquery/jquery.js"></script>               
    <script src="js/libs/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
