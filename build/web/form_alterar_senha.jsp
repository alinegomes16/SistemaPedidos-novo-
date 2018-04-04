<%-- 
    Document   : form_alterar_senha
    Created on : 20/05/2017, 23:50:06
    Author     : Administrador
--%>

<%@page import="modelo.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Alterar Senha</title>
    </head>
    <body>



        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3 class="text-center">Alterar Senha</h3>
                    <form class="form-group" method="POST" id="form_perfil" action="gerenciar_senha.do">
                        <p>
                            <label><strong>  CPF:</strong></label>
                            <input type="text" class="form-control" name="cpf" id="cpf" required placeholder="Digite o sue CPF">
                        </p>
                        <!--                           <p>
                                                       <label><strong>  Senha Antiga:</strong></label>
                                                       <input type="password" class="form-control" name="senha_antiga" id="senha_antiga" placeholder="Digite a senha antiga">
                                                   </p>-->
                        <p>
                            <label><strong>  Nova Senha:</strong></label>
                            <input type="password" class="form-control" name="senha_nova" id="senha_nova" required placeholder="Digite a nova senha">
                        </p> 
                        <!--                           <p>
                                          
                                                       <input type="hidden" class="form-control" name="msgErro" id="msgErro" value="<%String msgErro;%>">
                                                   </p>-->
                        <p>
                            <label>&nbsp;</label>
                            <input class="btn btn-primary" type="submit" name="enviar" value="Alterar">

                        </p>
                        
                        <h4 class="text-success text-center">${mensagem}</h4>
                        <h4 class="text-danger text-center">${mensagem1}</h4>
                        
                        <p>
                            <a href="login.jsp" class="btn btn-default">Logar</a>
                        </p>
                                
                       
                    </form>
                </div>
            </div>        
        </div>


    </body>
</html>
