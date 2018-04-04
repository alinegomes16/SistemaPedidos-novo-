<%-- 
    Document   : form_gerenciar_menu_perfil
    Created on : 02/04/2017, 23:18:13
    Author     : Administrador
--%>


<%@page import="modelo.MenuDAO"%>
<%@page import="modelo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //Recebe e valida o id, conecta ao BD e carrega a lista de menu pelo perfil.
    Perfil p = new Perfil();
    ArrayList<Menu> listaNaoPerfil = new ArrayList<Menu>();
    
    
    try{
        int id = Integer.parseInt(request.getParameter("id"));
        p.carregarPorId(id);
        listaNaoPerfil = p.listarNaoMenu(id);
    } 
    catch(Exception e) {
        out.print("Erro: "+e);
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
            function desvincular(id_perfil, id_menu, titulo){
                var url="gerenciar_menu_perfil.do?op=desvincular&id_perfil="+id_perfil+"&id_menu="+id_menu;
                if (confirm("Tem certeza que deseja desvincular o menu"+titulo+"?")){
                    window.open(url," _self");
                }
            }
        </script>
        
        <title>Menu - Perfil</title>
        
    </head>
    <body>
       
        
         <div style="border: solid 2px darkblue; width: 400px; height: 400px; padding-left: 15px;">
           <h3><center>Gerenciar Perfil</center></h3>
           <form method="POST" id="form_usuario" action="gerenciar_menu_perfil.do">
             
               <input type="hidden" name="op" value="vincular"/>
               <input type="hidden" name="id_perfil" value="<%= p.getId() %>"/>
               
               <label><strong> ID: </strong><%=p.getId() %></label>&nbsp;&nbsp;&nbsp;&nbsp;
               <label><strong>  Perfil </strong><%= p.getNome() %></label>
               
               
               <p>
                <label><strong>  Menu:</strong></label>
                <select size="1" name="id_menu" id="id_menu">
                    <option value="">Selecionar...</option>
                    <%
                        for (Menu menus:listaNaoPerfil){     
                    %>
                    <option value="<%=menus.getId() %>"><%=menus.getTitulo() %></option>
                    <%
                        }
                    %>
                </select>&nbsp;
                <input type="submit" value="+">
               </p>
           </form>
        
           <br><br>    
           <table border="1" cellpadding="3px">
                     <tr>
                         <th>ID</th>
                         <th>Nome</th>
                         <th>Desvincular</th>
                     </tr>

                     <%
                         for(Menu m:p.getMeusMenus()) {
                             %>
                             <tr>
                                 <td><%=m.getId() %></td>
                                 <td><%=m.getTitulo() %></td>
                                 <td>
                                    <center>
                                        <a href="#" onclick="desvincular(<%=p.getId() %>,<%=m.getId()%> ,'<%=m.getTitulo()%>')"><img src="Imagens/delete.png"/></a>
                                    </center>     
                                 </td>   
                             </tr>
                             <%
                         }
                     %>
                 </table>  
                 <div style="padding-left: 300px; padding-top: 50px">
                     <a href="listar_perfil.jsp">Voltar</a>
                 </div>      
            </div>
                
        
    </body>
</html>
