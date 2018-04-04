<%-- 
    Document   : listas_de_produto
    Created on : 07/06/2017, 11:14:58
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

        <title>Listar Produto</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                <ul class="nav nav-tabs nav-justified">
                                    <li role="presentation" class="active"><a href="listar_produto.jsp">Todos</a></li>
                                    <li role="presentation"><a href="listar_produto.jsp">Estoque cheio</a></li>
                                    <li role="presentation"><a href="listar_produto.jsp">Estoque normal</a></li>
                                    <li role="presentation"><a href="listar_produto.jsp">Estoque baixo</a></li>
                                   
                                </ul>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
    </body>
</html>
