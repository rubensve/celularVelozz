<%-- 
    Document   : ventas
    Created on : 14/11/2014, 12:37:46 PM
    Author     : rubens
--%>

<%@page import="com.pojo.Usuario"%>
<%@page import="com.pojo.Nota"%>
<%@page import="com.dao.NotaDAO"%>
<%@page import="com.pojo.Articulo"%>
<%@page import="com.dao.ClienteDAO"%>
<%@page import="com.pojo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usuario" scope="session" class="com.pojo.Usuario" />
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
   
    ArrayList<Cliente> clientes = new ArrayList();
    
    String fecha = (String)session.getAttribute("fechaentrega");
    
    if ( (fecha == null) || (fecha.equals("")) ) {
      fecha = "11-07-1989";
     }
    
    ClienteDAO cli = new ClienteDAO();
    clientes = cli.readAll();
    NotaDAO notas = new NotaDAO();
    Nota nota = notas.readUltimo();
    session.setAttribute("nota", nota);
    request.setAttribute("clientes", clientes);
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
                <li class="nav-header">Tareas</li>
                <li>
                    <a href="usuarios.jsp">Usuarios de Sistema</a>
                </li>
                <li>
                    <a href="clientes.jsp">Clientes</a>
                </li>
                <li>
                    <a href="ventas.jsp">Ventas</a>
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
                            <h1>Nota de Venta</h1><br>
                            
                            <form role="form" class="form-horizontal" action="registro.pdf" method="POST" name="nota">
                                          
                                <div class="row">
                                    
                                    <div class="col-md-4">
                                        <div class="form-group">
                                        <label>Folio</label>
                                        <div class="col-md-11">
                                        <input type="text" class="form-control" 
                                               placeholder="Folio Nota" name="folio" value="<%= nota.getFolio() + 1 %>" readonly="true">
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                        <label>Fecha de Recepcion: </label>
                                        <div class="col-md-11">
                                        <input type="text" class="form-control"
                                               placeholder="Fecha" name="fecha" readonly="true"/> 
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                        <label>Fecha de Entrega:</label>  
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="fechaentrega" id="entrega"
                                                   placeholder="dd-mm-yyyy" value="<%=fecha%>">  
                                      </div>
                                        </div>
                                    </div>
                                </div>
                                
                                      <div class="row">
                                    
                                    <div class="col-md-4">
                                        <div class="form-group">
                                        <label>Le Atendio: </label>
                                        <div class="col-md-11">
                                        <input type="text" class="form-control" 
                                               placeholder="Usuario" 
                                               value="<jsp:getProperty name="usuario" property="nombre"/> <jsp:getProperty name="usuario" property="apellido" />"
                                               disabled>
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                        <label>Cliente: </label>
                                        <div class="col-md-11">
                                            <select class="form-control" name="clientestodos" >
                                                <option value="${cl.id}">${cl.nombre} ${cl.apellido}</option>
                                                 <c:forEach items="${clientes}" var="clientes">
                                                     <option value="<c:out value= "${clientes.id}"/>">
                                                     <c:out value="${clientes.nombre}"/>  
                                                     <c:out value="${clientes.apellido}" />
                                                     </option>
                                                 </c:forEach>
                                            </select>
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                        <label>IMEI</label>  
                                        <div class="col-md-11">
                                        <input type="text" class="form-control"
                                               name="imei" value="${sessionScope.imei}" placeholder="IMEI" />  
                                      </div>
                                        </div>
                                    </div>
                                </div>
                                        
                                <div class="row">
                                    
                                    <div class="col-md-2">
                                        <div class="form-group">
                                        <label>Cantidad</label>
                                        <div class="col-md-10">
                                            <input type="number" class="form-control" 
                                                   placeholder="0" name="cantid" />
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                        <label>Descripción: </label>
                                        <div class="col-md-11">
                                        <input type="text" class="form-control"
                                        placeholder="Descripción" name="descrip"/> 
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                        <label>Precio:</label>  
                                        <div class="col-md-10">
                                            <input type="number" class="form-control"
                                                   placeholder="Precio" name="prec" />  
                                      </div>
                                        </div>
                                    </div>
                                </div>
                                        <br>
                                        <div class="row">
                                            
                                            <div class="col-md-8">
                                                    <table border="0" class="table table-hover table-responsive" >
                                            <thead>
                                                <tr>
                                                    <th>Cantidad</th>
                                                    <th>Descripcion</th>
                                                    <th>Precio</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                      <c:forEach items="${articulos}" var="articulos">
                                                      <tr>
                                                      <td><c:out value="${articulos.cantidad}"/></td>
                                                      <td><c:out value="${articulos.descripcion}"/></td>
                                                      <td><c:out value="${articulos.costo}"/></td>
                                                      </tr>
                                                        </c:forEach>
                                            </tbody>
                                        </table>              
                                                
                                            </div>
                                            
                                            <div class="col-md-4">
                                                    <div class="row">


                                                 <div class="form-group">
                                                 <label>Precio Total</label>  
                                                 <div class="col-md-11">
                                                 <input type="number" class="form-control" placeholder="Total"
                                                        value="${sessionScope.total}" name="total" readonly="true">  
                                               </div>
                                                 </div>
                                                </div>
                                
                                      
                                          <div class="row">
                                    
                                        <div class="form-group">
                                        <label>Anticipo</label>  
                                        <div class="col-md-11">
                                        <input type="number" class="form-control" name= "anticipo" placeholder="Anticipo">  
                                      </div>
                                        </div>
                                </div>
                                        
                                          <div class="row">
                                    
                                        <div class="form-group">
                                        <label>Resta</label>  
                                        <div class="col-md-11">
                                        <input type="number" class="form-control"
                                           placeholder="Resta" readonly="true">  
                                      </div>
                                        </div>
                                    </div>
                                            
                                            </div>
                                            
                                        </div>
                                               <br>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <button type="submit" class="btn btn-success" name="Agregar" value="Agregar">Agregar</button>
                                            </div>
                                            <div class="col-md-3">
                                            <button type="submit" class="btn btn-danger" name="eliminar" value="eliminar">Eliminar</button>
                                            </div>
                                            <div class="col-md-3">
                                            <button type="submit" class="btn btn-info" name="Imprimir" value="Imprimir">Imprimir</button>
                                            </div>
                                            <div class="co-md-3">
                                            <button type="submit" class="btn btn-warning" name="Finalizar" value="Finalizar">Registrar Venta</button>
                                            </div>
                                            
                                        </div>         
                            </form>
                        </div>
                       
                    </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
        
    <script type="text/javascript">
        var currentDt = new Date();
    var mm = currentDt.getMonth() + 1;
    var dd = currentDt.getDate();
    var yyyy = currentDt.getFullYear();
    var date = dd + '-' + mm + '-' + yyyy;
    document.nota.fecha.value= date;
    
    </script>

    <script src="../js/libs/jquery/jquery.js"></script>
    <script src="../js/libs/bootstrap/js/bootstrap.min.js"></script>
  
    </body>
</html>

