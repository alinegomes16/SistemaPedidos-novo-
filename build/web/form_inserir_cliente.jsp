<%-- 
    Document   : form_inserir_cliente
    Created on : 10/05/2017, 08:53:17
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
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.maskedinput.js"></script>
        
        <script>
            $(document).ready(function(){
                $('#telefone').mask("(99) 9999-9999");
                $('#cpf').mask("999.999.999-99");
            });
        </script>

        <!--Favicon-->
        <link rel="shortcut icon" href="Imagens/anjos2_favicon2.png"/>
        <title>Inserir Cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <h3 class="text-center">Novo Cliente</h3>
                    <form method="POST"  class="form-group" id="form_cliente" action="gerenciar_cliente.do?op=inserir">
                        <p>
                            <label><strong>  Nome:</strong></label>
                            <input type="text" class="form-control" name="nome" id="nome" required placeholder="Digite um nome"/>
                        </p>
                        <p>
                            <label><strong>  CPF:</strong></label>
                            <input type="text" class="form-control" name="cpf" id="cpf" />
                        </p>
                        <p>
                            <label><strong>  Endereço:</strong></label>
                            <input type="text" class="form-control" name="endereco" id="endereco"  />
                        </p>
                        <p>
                            <label><strong> Telefone:</strong></label>
                            <input type="text" class="form-control" name="telefone" id="telefone" />
                        </p>
                        <p>
                            <label>&nbsp;</label>
                            <input type="submit" class="btn btn-primary" name="enviar" value="Salvar">
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
