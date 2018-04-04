<%-- 
    Document   : form_inserir_perfil
    Created on : 30/04/2017, 16:55:46
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
        
        <title>Inserir Perfil</title>
    </head>
    <body>
         <div class="container">
             <div class="row">
                 <div class="col-md-4">
                     <h3><center>Novo Perfil</center></h3>
                       <form class="form-group" method="POST" id="form_perfil" action="gerenciar_perfil.do?op=inserir">
                           <p>
                               <label><strong>  Nome:</strong></label>
                               <input type="text" class="form-control" name="nome" id="nome" required placeholder="Digite o nome do perfil">
                           </p>
                           <p>
                            <label><strong>  Descrição:</strong></label>
                            <textarea class="form-control" name="descricao" id="descricao" required style="vertical-align: text-top;"></textarea>
                           </p>
                           <p>
                            <label>&nbsp;</label>
                            <input class="btn btn-primary" type="submit" name="enviar" value="Salvar">
                           </p>
                       </form>
                 </div>
             </div>        
        </div>
        
    </body>
</html>
