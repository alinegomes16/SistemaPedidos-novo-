<%-- 
    Document   : form_alterar_cliente
    Created on : 10/05/2017, 09:10:56
    Author     : Administrador
--%>

<%@page import="modelo.ClienteDAO"%>
<%@page import="modelo.Cliente"%>
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

        <title>Alterar Cliente</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");

            Cliente cliente = new Cliente();
            try {
                ClienteDAO cDAO = new ClienteDAO();
                cliente = cDAO.carregarPorId(Integer.parseInt(id));

            } catch (Exception e) {
                out.print("Erro: " + e);
            }

        %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <h3 class="text-center">Cliente</h3>
                    <form method="POST" class="form-group" id="form_cliente" action="gerenciar_cliente.do">
                        <input type="hidden" name="op" value="alterar" />
                        <input type="hidden" name="id" value="<%=cliente.getId()%>" />
                        <p>
                            <label><b>ID: <%=cliente.getId()%></b></label></p>
                        <p>
                            <label><strong>  Nome:</strong></label>
                            <input type="text" class="form-control" name="nome" id="nome" required value="<%=cliente.getNome()%>" />
                        </p>
                        <p>
                            <label><strong>  CPF:</strong></label>
                            <input type="text"  class="form-control" name="cpf" id="link" required value="<%=cliente.getCpf()%>" />
                        </p>
                        <p>
                            <label><strong>  Endereço:</strong></label>
                            <input type="text" class="form-control" name="endereco" id="endereco" required value="<%=cliente.getEndereco()%>" />
                        </p>
                        <p>
                            <label><strong>  Telefone:</strong></label>
                            <input type="text"  class="form-control" name="telefone" id="telefone" required value="<%=cliente.getTelefone()%>" />
                        </p>
                        <p>
                            <label>&nbsp;</label>
                            <input type="submit" class="btn btn-success" name="enviar" value="Salvar">
                        </p>
                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
