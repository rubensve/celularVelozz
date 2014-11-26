<%-- 
    Document   : usuarios
    Created on : 11/11/2014, 06:45:37 PM
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
        <title>Usuarios de Sistema</title>
    </head>
    <body>
        <script>alert("No se pudo completar la tarea, intente nuevamente");</script>
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
                        
            <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Usuarios de Sistema
                    <small>Administracion</small>
                </h1>
            </div>
            </div>
            
            <!-- Portfolio Item Row -->
        <div class="row">

            <div class="col-md-6">
                <img class="img-responsive" src="08.jpg" alt="Usuarios">
            </div>

            <div class="col-md-4">
                <h3>Administracion de Usuarios</h3>
                <p>Al registrar un usuario tenemos la opción de escoger que actividades puede realizar dentro
                de nuestro sistema, si quieres que tenga todos los privilegios el rol debe de ser Administrador, 
                si quieres que solamente haga ventas selecciona Cajero.</p>
                <h3>Opciones en este apartado</h3>
                <ul>
                    <li>Registro de Usuarios</li>
                    <li>Modificacion de Usuarios</li>
                    <li>Eliminar Usuarios</li>
                </ul>
            </div>

        </div>
        <!-- /.row -->
        <br>
        
        <div class="row">
            <div class="col-md-4">  
                
              
                    <button  type="button" class="btn btn-lg btn-success" data-toggle="modal" data-target="#ventanaAlta" > 
                                       <img src="graphic5 (1).png"> Registrar
                                    </button>
            
                <div class="modal fade" id="ventanaAlta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                    <div class="modal-dialog">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                  <h3>Registro de Usuarios</h3>
                              </div>
                              <div class="modal-body">
                                
                                  <form role="form" action="registroc.lo" method="POST">
                                        <div class="form-group">
                                          <label>Login</label>
                                          <input type="text" class="form-control" name="loginA"
                                                 placeholder="Introduce el nombre de Usuario">
                                        </div>
                                        <div class="form-group">
                                          <label>Contraseña</label>
                                          <input type="password" class="form-control" name="passwordA" 
                                                 placeholder="Contraseña">
                                        </div>
                                        <div class="form-group">
                                          <label>Nombre</label>
                                          <input type="text" class="form-control" name="nombreA" 
                                                 placeholder="Nombre">
                                        </div>
                                        <div class="form-group">
                                          <label>Apellido</label>
                                          <input type="text" class="form-control" name="apellidoA" 
                                                 placeholder="Apellido">
                                        </div>
                                      <div class="form-group">
                                        <label>Rol</label>
                                        <select class="form-control" name="rolA">
                                        <option>Administrador</option>
                                        <option>Cajero</option>
                                        </select>
                                      </div> 
                                        <button type="submit" class="btn btn-success">Registrar</button>
                                      </form>
                              </div>
                              <div class="modal-footer">
                                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                              </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
            <button class="btn btn-lg btn-danger" data-toggle="modal" data-target="#ventanaBaja"> 
                    <img src="cancel4 (1).png"> Eliminar</button>
              <div class="modal fade" id="ventanaBaja" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                    <div class="modal-dialog">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                  <h3>Baja de Usuarios</h3>
                              </div>
                              <div class="modal-body">
                                
                                  <form role="form" action="eliminarc.lo" method="POST">
                                        <div class="form-group">
                                          <label>Login</label>
                                          <input type="text" class="form-control" name="loginB"
                                                 placeholder="Introduce el nombre de Usuario">
                                        </div>
                                        <p class="help-block">Escribe el Login del Usuario a eliminar.</p>
                                        <button type="submit" class="btn btn-warning">Eliminar</button>
                                      </form>
                              </div>
                              <div class="modal-footer">
                                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                              </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-4">
                <button class="btn btn-lg btn-info" data-toggle="modal" data-target="#ventanaModificar" > 
                    <img src="drawing4 (1).png"> Modificar
                </button>
            
             <div class="modal fade" id="ventanaModificar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                    <div class="modal-dialog">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                  <h3>Modificar Usuarios</h3>
                              </div>
                              <div class="modal-body">
                                
                                  <form role="form" action="modificarc.lo" method="POST">
                                        <div class="form-group">
                                            <p class="help-block">Introduce el Login del Usuario a Modificar.</p>
                                          <label>Login</label>
                                          <input type="text" class="form-control" name="loginC"
                                                 placeholder="Introduce el nombre de Usuario">
                                        </div>
                                        <div class="form-group">
                                          <label>Contraseña</label>
                                          <input type="password" class="form-control" name="passwordC" 
                                                 placeholder="Contraseña">
                                        </div>
                                        <div class="form-group">
                                          <label>Nombre</label>
                                          <input type="text" class="form-control" name="nombreC" 
                                                 placeholder="Nombre">
                                        </div>
                                        <div class="form-group">
                                          <label>Apellido</label>
                                          <input type="text" class="form-control" name="apellidoC" 
                                                 placeholder="Apellido">
                                        </div>
                                      <div class="form-group">
                                        <label>Rol</label>
                                        <select class="form-control" name="rolC">
                                        <option>Administrador</option>
                                        <option>Cajero</option>
                                        </select>
                                      </div> 
                                        <button type="submit" class="btn btn-info">Modificar</button>
                                      </form>
                              </div>
                              <div class="modal-footer">
                                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                              </div>
                        </div>
                    </div>
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

