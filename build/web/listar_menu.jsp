<%-- 
    Document   : listar_menu
    Created on : 21/03/2017, 22:36:41
    Author     : Administrador
--%>

<%@page import="modelo.MenuDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Menu"%>
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
        
        <script type="text/javascript">
            function excluir(id, titulo) {
                var url="gerenciar_menu.do?op=excluir&id="+id;
                if (confirm("Tem certeza que deseja excluir o menu "+titulo+"?")){
                    window.open(url, "_self");
                }
            }
        </script>
        
        <title>Menu</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3>Menu <a href="form_inserir_menu.jsp"><img src="Imagens/add.png"/></a></h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <table class="table table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Título</th>
                            <th>Link</th>
                            <th>Ícone</th>
                            <th>Opções</th>
                         </tr>
                        
                    <%
                ArrayList<Menu> lista = new ArrayList<Menu>();
                try {
                    MenuDAO mDAO = new MenuDAO();
                    lista = mDAO.listar();
                }
                catch (Exception e){
                    out.print("Erro: "+e);
                }
                
                for(Menu menu:lista) {
                    %>
                    <tr>
                        <td><%=menu.getId() %></td>
                        <td><%=menu.getTitulo() %></td>
                        <td><%=menu.getLink() %></td>
                        <td><%=menu.getIcone() %></td>
                        <td>
                            <a href="#" onclick="excluir(<%=menu.getId() %>, '<%=menu.getTitulo() %>')"><img src="Imagens/delete.png"/></a>&nbsp;&nbsp;
                            <a href="form_alterar_menu.jsp?id=<%=menu.getId() %>"><img src="Imagens/edit.png"/></a>
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
