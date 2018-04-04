<%-- 
    Document   : form_alterar_produto
    Created on : 10/05/2017, 21:48:09
    Author     : Administrador
--%>

<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Produto"%>
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
        <title>Alterar Produto</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");

            Produto produto = new Produto();
            try {
                ProdutoDAO pDAO = new ProdutoDAO();
                produto = pDAO.carregarPorId(Integer.parseInt(id));

            } catch (Exception e) {
                out.print("Erro: " + e);
            }

        %>

        <%@include file="menu.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <h3 class="text-center">Produto</h3>
                    <form method="POST" class="form-group" id="form_produto" action="gerenciar_produto.do">
                        <input type="hidden" name="op" value="alterar" />
                        <input type="hidden" name="id" value="<%=produto.getId()%>" />
                        <p>
                            <label><b>ID: <%=produto.getId()%></b></label></p>
                        <p>
                            <label><strong>  Nome:</strong></label>
                            <input type="text" class="form-control" name="nome" id="nome" required value="<%=produto.getNome()%>" />
                        </p>
                        <p>
                            <label><strong>  Sabor:</strong></label>
                            <input type="text" class="form-control" name="sabor" id="sabor" required value="<%=produto.getSabor()%>" />
                        </p>
                        <p>
                            <label><strong>  Volume:</strong></label>
                            <input type="text" class="form-control" name="volume" id="volume" required value="<%=produto.getVolume()%>" />
                        </p>
                        <p>
                            <label><strong> Fabricação:</strong></label>
                            <input type="date" class="form-control" name="fabricacao" id="fabricacao" required value="<%=produto.getFabricacao()%>" />
                        </p>
                        <p>
                            <label><strong> Validade:</strong></label>
                            <input type="date" class="form-control" name="validade" id="validade" required value="<%=produto.getValidade()%>" />
                        </p><p>
                            <label><strong> Valor:</strong></label>
                            <input type="number" class="form-control" name="valor" id="valor" required value="<%=produto.getValor()%>" />
                        </p>
                        <p>
                            <label><strong> Quantidade Exixtente:</strong></label>
                            <input type="number" class="form-control" name="qtd_existente" id="qtd_existente" required value="<%=produto.getQtdExistente()%>" />
                        </p>
                        <p>
                            <label><strong> Situação:</strong></label>
                            <input type="text" class="form-control" name="situacao" id="situacao" required value="<%=produto.getSituacao()%>" />
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
