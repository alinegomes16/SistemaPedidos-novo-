<%-- 
    Document   : listar_produto
    Created on : 10/05/2017, 21:40:07
    Author     : Administrador
--%>

<%@page import="modelo.Produto"%>
<%@page import="modelo.ProdutoDAO"%>
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

        <script type="text/javascript">
            function excluir(id, nome) {
                var url = "gerenciar_produto.do?op=excluir&id=" + id;
                if (confirm("Tem certeza que deseja excluir o produto " + nome + "?")) {
                    window.open(url, "_self");
                }
            }
        </script>
        <title>Listar Produto</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>




        <!--lista1-->
        <div class="container-fluid" id="lista1">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <h1>Produto <a href="form_inserir_produto.jsp"><img src="Imagens/add.png"/></a></h1>
                </div>
            </div>


            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <table class="table table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Sabor</th>
                            <th>Volume</th>
                            <th>Fabricação</th>
                            <th>Validade</th>
                            <th>Valor</th>
                            <th>Quantidade Existente</th>
                            <th>Situação</th>
                            <th>Opções</th>
                        </tr>

                        <%                            ArrayList<Produto> lista = new ArrayList<Produto>();
                            try {
                                ProdutoDAO pDAO = new ProdutoDAO();
                                lista = pDAO.listar();
                            } catch (Exception e) {
                                out.print("Erro: " + e);
                            }

                            for (Produto produto : lista) {
                        %>
                        <tr>
                            <td><%=produto.getId()%></td>
                            <td><%=produto.getNome()%></td>
                            <td><%=produto.getSabor()%></td>
                            <td><%=produto.getVolume()%></td>
                            <td><%=produto.getFabricacao()%></td>
                            <td><%=produto.getValidade()%></td>
                            <td><%=produto.getValor()%></td>
                            <td><%=produto.getQtdExistente()%></td>
                            <td><%=produto.getSituacao()%></td>


                            <td>
                                <a href="#" onclick="excluir(<%=produto.getId()%>, '<%=produto.getNome()%>')"><img src="Imagens/delete.png"/></a>&nbsp;&nbsp;
                                <a href="form_alterar_produto.jsp?id=<%=produto.getId()%>"><img src="Imagens/edit.png"/></a>
                            </td>
                        </tr>
                        <%
                            }
                        %>

                    </table>
                </div>
            </div>
        </div>                
    </body>
</html>
