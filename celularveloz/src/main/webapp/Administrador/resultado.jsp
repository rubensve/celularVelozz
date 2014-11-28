<%-- 
    Document   : resultado
    Created on : 13/11/2014, 01:32:44 PM
    Author     : rubens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="usuario" scope="request" class="com.pojo.Usuario" />
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
                    <a href="#">Reportes</a>
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
                                        <th>Login</th>
                                        <th>Password</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Rol</th>
                                    </tr>
                                </thead>
                                <tbody>
                                          <c:forEach items="${usuarios}" var="usuarios">
                                          <tr>
                                          <td><c:out value="${usuarios.login}"/></td>
                                          <td><c:out value="${usuarios.password}"/></td>
                                          <td><c:out value="${usuarios.nombre}"/></td>
                                          <td><c:out value="${usuarios.apellido}"/></td>
                                          <td><c:out value="${usuarios.rol}"/></td>
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
        
        
                    
    <script src="../js/libs/jquery/jquery.js"></script>               
    <script src="../js/libs/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>