<%-- 
    Document   : reportes
    Created on : 22/01/2015, 07:25:25 PM
    Author     : rubens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        
                        <div class="row">
                            <h3>Introduce un intervalo de fechas para conocer tus ventas</h3>
                            <hr>
                            <form class="form-horizontal" method="get" action="fechas.fe">
                                
                                <div class="col-md-4">
                                    <label> Fecha Inicial:</label> 
                                    <input type="text" class="form-control" name="inicial" placeholder="aaaa-mm-dd">  
                                </div>
                                
                                <div class="col-md-4">
                                    <label> Fecha Final:</label> 
                                    <input type="text" class="form-control" name="final" placeholder="aaaa-mm-dd">  
                                </div>
                                
                                <div class="col-md-4">
                                    <br>
                                    <button type="submit" class="btn btn-success">Consultar</button>
                                </div>
                            </form>
                        </div>
                        <br>
                        <div class="row">
                            <h3>Selecciona un mes para conocer tus ventas</h3>
                            <hr>
                            <form class="form-horizontal" method="get" action="mes.me">
                                
                                <div class="col-md-6">
                                    <label> Mes:</label> 
                                    <select class="form-control" name="mes">
                                        <option value="1">Enero</option>
                                        <option value="2">Febrero</option>
                                        <option value="3">Marzo</option>
                                        <option value="4">Abril</option>
                                        <option value="5">Mayo</option>
                                        <option value="6">Junio</option>
                                        <option value="7">Julio</option>
                                        <option value="8">Agosto</option>
                                        <option value="9">Septiembre</option>
                                        <option value="10">Octubre</option>
                                        <option value="11">Noviembre</option>
                                        <option value="12">Diciembre</option>
                                    </select>  
                                </div>
                                
                                <div class="col-md-6">
                                    <br>
                                    <button type="submit" class="btn btn-success">Consultar</button>
                                </div>
                                
                            
                            </form>
                            
                            
                        </div>

<br>
                        <div class="row">
                            <h3>Notas Canceladas y Eliminadas</h3>
                            <hr>
                            <form class="form-horizontal" method="get" action="cancel.can">
                                
                                <div class="col-md-6">
                                    <label>Busqueda</label> 
                                    <select class="form-control" name="criterio">
                                        <option>Canceladas</option>
                                        <option>Eliminadas</option>
                                    </select>  
                                </div>
                                
                                <div class="col-md-6">
                                    <br>
                                    <button type="submit" class="btn btn-success">Consultar</button>
                                </div>
                                
                            
                            </form>
                            
                            
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