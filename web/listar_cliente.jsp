<%-- 
    Document   : listar_cliente
    Created on : 10/05/2017, 09:31:40
    Author     : Administrador
--%>


<%@page import="modelo.ClienteDAO"%>
<%@page import="modelo.Cliente"%>
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
                var url = "gerenciar_cliente.do?op=excluir&id=" + id;
                if (confirm("Tem certeza que deseja excluir o cliente " + nome + "?")) {
                    window.open(url, "_self");
                }
            }
        </script>
        <title>Cliente</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-2">
                    <h3>Cliente <a href="form_inserir_cliente.jsp"><img src="Imagens/add.png"/></a></h3>

                    <table class="table table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Endereço</th>
                            <th>Telefone</th>
                            <th>Opções</th>
                        </tr>

                        <%                ArrayList<Cliente> lista = new ArrayList<Cliente>();
                            try {
                                ClienteDAO cDAO = new ClienteDAO();
                                lista = cDAO.listar();
                            } catch (Exception e) {
                                out.print("Erro: " + e);
                            }

                            for (Cliente cliente : lista) {
                        %>
                        <tr>
                            <td><%=cliente.getId()%></td>
                            <td><%=cliente.getNome()%></td>
                            <td><%=cliente.getCpf()%></td>
                            <td><%=cliente.getEndereco()%></td>
                            <td><%=cliente.getTelefone()%></td>
                            <td>
                                <a href="#" onclick="excluir(<%=cliente.getId()%>, '<%=cliente.getNome()%>')"><img src="Imagens/delete.png"/></a>&nbsp;&nbsp;
                                <a href="form_alterar_cliente.jsp?id=<%=cliente.getId()%>"><img src="Imagens/edit.png"/></a>&nbsp;&nbsp;
                                <a href="form_inserir_pedido.jsp?novo_pedido=sim&id_cliente=<%=cliente.getId()%>"><img src="Imagens/comprar1.png"/></a>
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
