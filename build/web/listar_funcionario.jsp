<%-- 
    Document   : listar_funcionario
    Created on : 10/05/2017, 10:45:43
    Author     : Administrador
--%>

<%@page import="modelo.Funcionario"%>
<%@page import="modelo.FuncionarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function excluir(id, nome) {
                var url="gerenciar_funcionario.do?op=excluir&id="+id;
                if (confirm("Tem certeza que deseja excluir o Funcionário "+nome+"?")){
                    window.open(url, "_self");
                }
            }
        </script>
        <title>Funcionário</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Funcionario <a href="form_inserir_funcionario.jsp"><img src="Imagens/add.png"/></a></h1>
        
        <table border="1" cellpadding="3px">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Perfil</th>
                <th>Opções</th>
            </tr>
            
            <%
                ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
                try {
                    FuncionarioDAO fDAO = new FuncionarioDAO();
                    lista = fDAO.listar();
                }
                catch (Exception e){
                    out.print("Erro: "+e);
                }
                
                for(Funcionario funcionario:lista) {
                    %>
                    <tr>
                        <td><%=funcionario.getId() %></td>
                        <td><%=funcionario.getNome() %></td>
                        <td><%=funcionario.getCpf() %></td>
                        <td><%=funcionario.getEndereco() %></td>
                        <td><%=funcionario.getTelefone() %></td>
                        <td><%=funcionario.getEmail() %></td>
                        <td><%=funcionario.getPerfil().getNome() %></td>
                        <td>
                            <a href="#" onclick="excluir(<%=funcionario.getId() %>, '<%=funcionario.getNome() %>')"><img src="Imagens/delete.png"/></a>&nbsp;&nbsp;
                            <a href="form_alterar_funcionario.jsp?id=<%=funcionario.getId() %>"><img src="Imagens/edit.png"/></a>
                        </td>
                    </tr>
                    <%
                }
            %>
            
        </table>
    </body>
</html>
