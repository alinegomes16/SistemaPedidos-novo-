<%-- 
    Document   : atualizar_quantidade
    Created on : 10/06/2017, 23:26:26
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta lang="pt-br">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Referencia o jquery-->
        <script src="js/jquery-3.1.1.min.js"></script>
        <!--Referencia o CSS do Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!--Referencia o JS do Bootstrap-->
        <script src="js/bootstrap.min.js"></script>

        <title>Atualizar Quantidade</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3 class="text-center">Produto</h3>

                    <form method="POST" id="busca_produto" action="atualizar_produto.do" >
                        <input type="hidden" name="op" id="op" value="buscarProduto" >
                        <p>
                            <label><strong>  Código:</strong></label>
                            <input type="text" class="form-control" name="id" id="id" required>
                            <br>
                            <input type="submit" name="enviar" value="Buscar">

                        </p>
                    </form>
                    
                    <form class="form-group" method="POST" id="form_produto" action="gerenciar_produto.do?op=inserir">
                        <p>
                            <label><strong>  Situacao (estoque):</strong></label>
                            <input type="number" class="form-control" name="situacao" id="situacao">
                        </p>

                        <p>
                            <label>&nbsp;</label>
                            <input class="btn btn-primary" type="submit" name="enviar" value="Atualizar">
                        </p>
                    </form>
                </div>
            </div>        
        </div>

    </body>
</html>
