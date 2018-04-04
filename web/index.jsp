<%-- 
    Document   : index
    Created on : 30/04/2017, 17:51:50
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!--Referencia o jquery-->
        <script src="js/jquery-3.1.1.min.js"></script>
        <!--Referencia o CSS do Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!--Referencia o JS do Bootstrap-->
        <script src="js/bootstrap.min.js"></script>

        <!--Favicon-->
        <link rel="shortcut icon" href="Imagens/anjos2_favicon2.png"/> 
        <title>Principal</title>
    </head>
    <body>
        
        
        <div class="container-fluid" style="border: 0px solid; height: 150px;">
            <div class="row">
                <img class="img-responsive" src="Imagens/anjos_topo3.jpg" alt="Sorveteria Anjos" >
            </div>
            <div class="row" style="padding-top: 0px;">
                <%@include file="menu.jsp" %>
            </div>
        </div>
        
        <div class="container">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-4 col-md-offset-4">
                    
                           
                </div>
            </div>
        </div>
        
    </body>
</html>
