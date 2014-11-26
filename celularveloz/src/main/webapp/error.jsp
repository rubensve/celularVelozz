<%-- 
    Document   : error
    Created on : 25/11/2014, 11:11:31 PM
    Author     : rubens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
        <title>Bienvenido a el Celular Veloz</title>
        <link href="js/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="js/libs/bootstrap/css/login.css" rel="stylesheet">
    </head>
    <body>
        <h2 align="center" >Usuario o Password Incorrecto</h2>
        <div class="container" >
            <%@include file="log.jspf" %> 
        </div>
        <script src="js/libs/jquery/jquery.js"></script>
        <script src="js/libs/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>