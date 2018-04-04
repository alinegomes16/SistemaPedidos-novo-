<%-- 
    Document   : form_inserir_produto
    Created on : 20/05/2017, 23:10:42
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
        
        <title>Inserir Produto</title>
    </head>
    
    <body>
        
        <div class="container">
             <div class="row">
                 <div class="col-md-4">
                     <h3 class="text-center">Novo Produto</h3>
                       <form class="form-group" method="POST" id="form_produto" action="gerenciar_produto.do?op=inserir">
                           <p>
                               <label><strong>  Nome:</strong></label>
                               <input type="text" class="form-control" name="nome" id="nome" required>
                           </p>
                           <p>
                               <label><strong>  Sabor:</strong></label>
                               <input type="text" class="form-control" name="sabor" id="sabor" required>
                           </p>
                           <p>
                               <label><strong>  Volume:</strong></label>
                               <input type="text" class="form-control" name="volume" id="volume">
                           </p>
                           <p>
                               <label><strong>  Fabricacao:</strong></label>
                               <input type="date" class="form-control" name="fabricacao" id="fabricacao" required>
                           </p>
                           <p>
                               <label><strong>  Validade:</strong></label>
                               <input type="date" class="form-control" name="validade" id="validade" required>
                           </p>
                           <p>
                               <label><strong>  Valor:</strong></label>
                               <input type="text" class="form-control" name="valor" id="valor" required>
                           </p>
                           <p>
                               <label><strong>  Quantidade existente:</strong></label>
                               <input type="number" class="form-control" name="qtd_existente" id="qtd_existente" required>
                           </p>
                           <p>
                               <label><strong>  Situacao (estoque):</strong></label>
                               <input type="hidden" class="form-control" name="situacao" id="situacao">
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
