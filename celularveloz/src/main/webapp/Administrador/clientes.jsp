<%-- 
    Document   : clientes
    Created on : 12/11/2014, 04:09:00 PM
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
        <title>Clientes</title>
    </head>
    <body>
        
        <input type="text" name="alerta" id="alert" value="${requestScope.mensajes}" hidden />
        
        <script>
            var mensaje= document.getElementById("alert").value;
            if (mensaje==null || mensaje=="") 
            {
                
            }
            else 
            {
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
                    <a href="usuarios.jsp"> Usuarios de Sistema</a>
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
                      
                         <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Clientes
                    <small>Administracion</small>
                </h1>
            </div>
            </div>
            
            <!-- Portfolio Item Row -->
                <div class="row">

                    <div class="col-md-6">
                        <img class="img-responsive" src="clientes.jpg" alt="Clientes">
                    </div>

                    <div class="col-md-4">
                        <h3>Administracion de Clientes</h3>
                        <p>Podrás registrar clientes en el sistema, recuerda que es parte importante el que los 
                        usuarios que tengan un rol de cajero no puedan hacer notas sin clientes.</p>
                        <h3>Opciones en este apartado</h3>
                        <ul>
                            <li>Registro de Clientes</li>
                            <li>Modificacion de Clientes</li>
                            <li>Eliminar Clientes</li>
                        </ul>
                    </div>

                </div>
                <!-- /.row -->
                <br>

                <div class="row">
                    <div class="col-md-4">  


                            <button  type="button" class="btn btn-lg btn-success" data-toggle="modal" data-target="#altaCliente" > 
                                               <img src="graphic5 (1).png"> Registrar
                                            </button>

                        <div class="modal fade" id="altaCliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                            <div class="modal-dialog">
                                  <div class="modal-content">
                                      <div class="modal-header">
                                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          <h3>Registro de Clientes</h3>
                                      </div>
                                      <div class="modal-body">

                                          <form role="form" action="regclien.lo" method="POST">
                                                <div class="form-group">
                                                  <label>Nombre</label>
                                                  <input type="text" class="form-control" name="nomA"
                                                         placeholder="Nombre de Cliente" required>
                                                </div>
                                                <div class="form-group">
                                                  <label>Apellido</label>
                                                  <input type="text" class="form-control" name="apeA" 
                                                         placeholder="Apellido" required>
                                                </div>
                                                <div class="form-group">
                                                  <label>Dirección</label>
                                                  <input type="text" class="form-control" name="dirA" 
                                                         placeholder="Dirección" required>
                                                </div>
                                                <div class="form-group">
                                                  <label>Telefono</label>
                                                  <input type="tel" class="form-control" name="telA" 
                                                         placeholder="Telefono" required>
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
                    <button class="btn btn-lg btn-danger" data-toggle="modal" data-target="#bajaCliente"> 
                            <img src="cancel4 (1).png"> Eliminar</button>
                      <div class="modal fade" id="bajaCliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                            <div class="modal-dialog">
                                  <div class="modal-content">
                                      <div class="modal-header">
                                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          <h3>Baja de Usuarios</h3>
                                      </div>
                                      <div class="modal-body">

                                          <form role="form" action="eliminarc.los" method="POST">
                                                <div class="form-group">
                                                  <label>Id Cliente</label>
                                                  <input type="text" class="form-control" name="idA"
                                                         placeholder="Introduce el Id de Cliente" required>
                                                </div>
                                                <p class="help-block">Puedes revisar el id cliente en el apartado
                                                Consultas de esta misma aplicación</p>
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
                        <button class="btn btn-lg btn-info" data-toggle="modal" data-target="#modiCliente" > 
                            <img src="drawing4 (1).png"> Modificar
                        </button>

                     <div class="modal fade" id="modiCliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                            <div class="modal-dialog">
                                  <div class="modal-content">
                                      <div class="modal-header">
                                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          <h3>Modificar Clientes</h3>
                                      </div>
                                      <div class="modal-body">

                                          <form role="form" action="modificarc.los" method="POST">
                                                <div class="form-group">
                                                    <p class="help-block">Introduce el ID del Cliente a Modificar.</p>
                                                  <label>ID Cliente</label>
                                                  <input type="text" class="form-control" name="idB"
                                                         placeholder="Introduce el ID del Cliente" required>
                                                </div>
                                                <div class="form-group">
                                                  <label>Nombre</label>
                                                  <input type="text" class="form-control" name="nomB" 
                                                         placeholder="Nombre del Cliente" required>
                                                </div>
                                                
                                                <div class="form-group">
                                                  <label>Apellido</label>
                                                  <input type="text" class="form-control" name="apeB" 
                                                         placeholder="Apellido" required>
                                                </div>
                                              
                                              <div class="form-group">
                                                  <label>Dirección</label>
                                                  <input type="text" class="form-control" name="dirB" 
                                                         placeholder="Nombre del Cliente" required>
                                                </div>
                                                
                                                <div class="form-group">
                                                  <label>Telefono</label>
                                                  <input type="text" class="form-control" name="telB" 
                                                         placeholder="Apellido" required>
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