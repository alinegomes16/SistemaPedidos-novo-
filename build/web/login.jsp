<%-- 
    Document   : login
    Created on : 15/04/2017, 15:13:00
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

        <title>Login</title>
    </head>
    <body>
        
        <div class="container-fluid" style="border: 1px; height: 150px;">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4 text-center">
                    <img class="img-responsive" src="Imagens/anjos2_slide3.png" />
                     <!--<h1 class="text-center">Sorveteria Anjos</h1>-->
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title text-center"><b>Login</b></h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-group" name="login" method="post" action="valida_login.do">
                            <p>
                                <br>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                    </span>
                                    <input type="text" class="form-control" name="cpf" placeholder="CPF" required />
                                    
                                </div>
                            </p>
                            <p>
                                <!--<label><b>&nbsp; </b></label>-->
                                <br>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-lock"></span>
                                    </span>
                                    <input type="password" class="form-control" name="senha" placeholder="senha" required />
                                </div>    
                            </p>
                            <h4 class="text-danger text-center">${mensagem}</h4>
                            <br>
                            <p>
                                <input type="submit" class=" btn btn-primary center-block" value="Entrar" />
                            </p>
                            </form>
                        </div>
                        <div class="panel-footer">
                            <h6 class="text-center"><strong><a href="form_alterar_senha.jsp">Alterar senha</a></strong></h6>
                        </div>
                    </div>  
                </div>
            </div>
        </div>
        
        <br><br><br>
<!--        <div style="border: solid 2px darkblue; width: 300px; height: 200px; padding-left: 15px;">
            <h3><center>Acesso ao Sistema</center></h3>
                <form name="login" method="post" action="valida_login.do">
                    <p>
                        <label><b>Usuário: </b></label>
                        <input type="text" name="login" placeholder="Digite o usuario" required />
                    </p>
                    <p>
                        <label><b>Senha: </b></label>
                        <input type="password" name="senha" placeholder="Digite a senha" required />
                    </p>
                    <p>
                        <input type="submit" value="Entrar" />
                    </p>
                </form>
        </div>-->
    </body>
</html>
