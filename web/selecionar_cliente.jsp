<%-- 
    Document   : selecionar_cliente
    Created on : 14/06/2017, 10:20:01
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

        <title>Selecionar Cliente</title>



    </head>

    <body>
        <div class="container-fluid" style="border: 0px solid; height: 150px;">
            <div class="row">
                <img class="img-responsive" src="Imagens/anjos_topo3.jpg" alt="Sorveteria Anjos" >
            </div>
            <div class="row" style="padding-top: 0px;">
                <%@include file="menu.jsp" %>
            </div>
       
        
           
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <form class="form-group" method="POST" id="busca_cliente" action="gerenciar_cliente.do" >
                        <input type="hidden" name="op" id="op" value="selecionar" >
                        <input type="hidden" name="novo_pedido" id="novo_pedido" value="sim" />
                        <p>
                            <label><strong> Cliente:</strong></label>
                            <input type="text" class="form-control" name="nome" id="nome">                

                            <!--Retorna mensagem de erro-->
                            <span class="text-danger text-center">${mensagem}</span>

                            

                        </p>             
                        <input type="submit" class="btn btn-primary" name="id_cliente" id="id_cliente" value="Buscar" />
                    </form>
                </div>
            </div>
        </div>





    </body>
</html>
