<%@page import="modelo.PerfilDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE  html>
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
        
        
        <!--Script para confirmar a exclusão-->
        <script type="text/javascript">
            function excluir(id, nome) {
                var url="gerenciar_perfil.do?op=excluir&id="+id;
                if (confirm("Tem certeza que deseja excluir o perfil"+nome+"?")){
                    window.open(url, "_self");
                }
            }
        </script>
        
        
        <title>Perfis</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3>Lista de Perfis <a href="form_inserir_perfil.jsp"><img src="Imagens/add.png"/></a></h3>
                </div>
            </div>
            <div class="row" id="lista2">
                <div class="col-md-4">
                    <table class="table table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Opções</th>
                        </tr>
                        
                        <%
                            ArrayList<Perfil> lista = new ArrayList<Perfil>();
                            try {
                                PerfilDAO pDAO = new PerfilDAO();
                                lista = pDAO.listar();
                            }
                            catch (Exception e){
                                out.print("Erro: "+e);
                            }

                            for(Perfil perfil:lista) {
                                %>
                                <tr>
                                    <td><%=perfil.getId() %></td>
                                    <td><%=perfil.getNome() %></td>
                                    <td>
                                        <a href="#" onclick="excluir(<%=perfil.getId() %>, '<%=perfil.getNome() %>')"><img src="Imagens/delete.png"/></a>&nbsp;&nbsp;
                                        <a href="form_alterar_perfil.jsp?id=<%=perfil.getId() %>"><img src="Imagens/edit.png"/></a>&nbsp;&nbsp;
                                        <a href="form_gerenciar_menu_perfil.jsp?id=<%=perfil.getId() %>"><img src="Imagens/note1.png" /></a>
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
