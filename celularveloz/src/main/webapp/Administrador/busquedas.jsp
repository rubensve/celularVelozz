<%-- 
    Document   : busquedas
    Created on : 12/11/2014, 07:52:57 PM
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
        <input type="text" name="alerta1" id="alerta1" value="${requestScope.mensaje}" hidden> 
        <script>
            var mensaje= document.getElementById("alerta1").value;
            if (mensaje==null || mensaje=="") 
            {
                
            }
            else{
                alert(mensaje);
            }
           
        </script>
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
                      
                        
                        <div class="row">
                            <div class="col-md-6">
                                    <h3>Busqueda Individual de Usuarios</h3>
                                    <div class="container-fluid" id="busquedaUsuario">
                                    <form role="form"  action="usuario.usu" method="post">
                                    <div class="form-group">
                                    <label>Login</label>
                                    <input type="text" class="form-control" name="busA"
                                      placeholder="Introduce el login ">
                                    </div>
                                    <p class="help-block">Busqueda de Usuarios por Login.</p>
                                    <button type="submit" class="btn btn-lg btn-success">Buscar</button>
                                    </form>
                                </div>
                            </div>
                            
                            <div class="col-md-6">
                                <div class="container-fluid" id="busquedaUsuarios">
                                <h3>Mostrar todos los usuarios del Sistema</h3>
                                <form role="form"  action="usuarios.usu" method="get">
                                <p class="help-block">Mostrar todos los Usuarios</p>
                                <button type="submit" class="btn btn-lg btn-info">Buscar</button>
                                </form>
                                </div>
                            </div>
                            
                        </div>
                        <hr>
                        
                        <div class="row">
                            <div class="col-md-6">
                                <div class="container-fluid" id="busquedaCliente">
                                <h3>Busqueda Individual de Clientes</h3>
                                <form role="form"  action="cliente.cli" method="get">
                                <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="busB"
                                placeholder="Introduce el Nombre ">
                                </div>
                                <p class="help-block">Busqueda de Cliente por Nombre.</p>
                                <button type="submit" class="btn btn-lg btn-danger">Buscar</button>
                                </form>
                               </div>
                            </div>
                           
                            <div class="col-md-6">
                                <div class="container-fluid" id="busquedaClientes">
                                <h3>Mostrar todos los Clientes del Sistema</h3>
                                <form role="form"  action="clientes.cli" method="get">
                                <p class="help-block">Mostrar todos los Usuarios</p>
                                <button type="submit" class="btn btn-lg btn-warning">Buscar</button>
                                </form>
                                </div>
                                </div>    
                        </div>
                        <hr>
                       
                        <div class="row">
                            <div class="col-md-6">
                                <form role="form"  action="nota.not" method="post">
                                <div class="container-fluid" id="busquedaNota">
                                <h3>Busqueda Individual de Notas</h3>
                                <div class="form-group">
                                        <label>Criterio de Busqueda</label>  
                                        <select class="form-control" name="criterio">
                                            <option>Folio</option>
                                            <option>Nombre del Cliente</option>
                                            <option>Fecha</option>
                                        </select>
                                  </div>
                                
                                <div class="form-group">
                                <label>Folio</label>
                                <input type="text" class="form-control" name="folion"
                                placeholder="Introduce el Folio">
                                </div>
                                    <hr>
                                <p class="help-block">Busqueda de Nota por Folio.</p>
                                <div class="form-group">
                                <label>Nombre:</label>
                                <input type="text" class="form-control" name="nombre"
                                placeholder="Nombre Cliente">
                                </div>
                                <div class="form-group">
                                <label>Apellido:</label>
                                <input type="text" class="form-control" name="apellido"
                                placeholder="Apellido Cliente">
                                </div>
                                <p class="help-block">Busqueda de Nota por Nombre.</p>
                                <hr>
                                <div class="form-group">
                                <label>Fecha Inicial</label>
                                <input type="text" class="form-control" name="inicial"
                                placeholder="aaaa-mm-dd">
                                </div>
                                <div class="form-group">
                                <label>Fecha Final:</label>
                                <input type="text" class="form-control" name="final"
                                placeholder="aaaa-mm-dd">
                                </div>
                                <p class="help-block">Busqueda de Nota por Fecha.</p>
                                <button type="submit" class="btn btn-lg btn-success">Buscar</button>
                                </div>
                                 </form>
                            </div>
                            
                            <div class="col-md-6">
                                <div class="container-fluid" id="busquedaNotas">
                                <h3>Mostrar todos las Notas del Sistema</h3>
                                <form role="form"  action="notas.not" method="get">
                                <p class="help-block">Mostrar todos los Usuarios</p>
                                <button type="submit" class="btn btn-lg btn-info">Buscar</button>
                                </form>
                                </div>
                            </div>    
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
