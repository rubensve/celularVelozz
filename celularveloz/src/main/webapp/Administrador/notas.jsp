<%-- 
    Document   : notas
    Created on : 28/11/2014, 02:28:06 PM
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
        <input type="text" id="mensaj" value="${requestScope.mensaj}" hidden>
        <script>
            var mensaje= document.getElementById("mensaj").value;
            
            if (mensaje==null || mensaje=="") 
            {
    
            }
            else {
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
                       
                        <div class="container-fluid" id="ventas">
                            <h3>Realizar Ventas</h3>
                            <form action="ventas.ve" method="post">
                                <div class="row">
                                    
                                    <div class="col-md-7">
                                        <label>IMPORTANTE!!!!</label>
                                        <p>Recuerda que para realizar una nota a un cliente nuevo
                                         este tiene que registrarse en el apartado clientes, de otro 
                                         modo no te aparecera en la lista y no podras realizarle la 
                                         venta. <a href="clientes.jsp">Ir a clientes.</a> </p>
                                    </div>
                                    <div class="col-md-3">
                                        <br><br>
                                        <button type="submit" class="btn btn-success btn-lg">Venta</button>
                                    </div>                             
                                </div>

                            </form>
                        </div>
                        <hr>
                         <div class="container-fluid" id="finalizarn">
                            <h3>Finalizar Notas</h3>
                            <form action="fina.fin" method="post">
                                
                                <div class="row" >
                                    <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Folio Nota:</label>  
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="folion"
                                                   placeholder="Folio"  required/>  
                                  </div>
                                  </div>
                                    </div>
                                    
                                    <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Reparacion:</label>  
                                        <select class="form-control" name="reparacion">
                                            <option>Reparado</option>
                                            <option>Sin reparacion</option>
                                        </select>
                                  </div>
                                    </div>
                                    
                                    <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Estado de Nota:</label>  
                                        <select class="form-control" name="estatusnota">
                                            <option>Abierta</option>
                                            <option>Pagada</option>
                                            <option>Cancelada</option>
                                        </select>
                                  </div>
                                    </div>
                                    <div class="col-md-3">
                                        <br>                                        
                                     <button type="submit" class="btn btn-warning btn-lg">Finalizar</button>
                                    </div>
                                
                                </div>
                            </form>
                        </div>
                          <hr>
                        <div class="container-fluid" id="reimpresion">
                            <h3>Reimpresion de Notas</h3>
                            <form action="reimpr.pdf" method="post">
                                
                                <div class="row" >
                               
                                    <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Folio Nota:</label>  
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="folion"
                                                   placeholder="Folio" required/>  
                                  </div>
                                  </div>
                                    </div>
                                
                                    <div class="col-md-4">
                                        <br>                                        
                                     <button type="submit" class="btn btn-info btn-lg">Imprimir</button>
                                    </div>
                                
                                </div>
                            </form>
                        </div>
                          <hr>
                        <div class="container-fluid" id="elimin">
                            <h3>Eliminar Nota</h3>
                            <form action="elim.el" method="post">
                                
                                <div class="row" >
                               
                                    <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Folio Nota:</label>  
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="folion"
                                                   placeholder="Folio" required/>  
                                  </div>
                                  </div>
                                    </div>
                                
                                    <div class="col-md-4">
                                        <br>                                        
                                     <button type="submit" class="btn btn-danger btn-lg">Eliminar</button>
                                    </div>
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
