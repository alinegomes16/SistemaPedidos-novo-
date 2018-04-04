<%-- 
    Document   : form_alterar_menu
    Created on : 21/03/2017, 23:04:49
    Author     : Administrador
--%>

<%@page import="modelo.MenuDAO"%>
<%@page import="modelo.Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Menu</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            
            Menu menu = new Menu();
            
            try {
                MenuDAO mDAO = new MenuDAO();
                menu = mDAO.carregarPorId(Integer.parseInt(id));
            
            }
            catch (Exception e){
                out.print("Erro: "+e);
            }
            
         %>
        
        <div style="border: solid 2px darkblue; width: 400px; height: 300px; padding-left: 15px;">
           <h3><center>Menu</center></h3>
           <form method="POST" id="form_menu" action="gerenciar_menu.do">
               <input type="hidden" name="op" value="alterar" />
               <input type="hidden" name="id" value="<%=menu.getId() %>" />
               <p>
                   <label><b>ID: <%=menu.getId() %></b></label></p>
               <p>
                   <label><strong>  Título:</strong></label>
                   <input type="text" name="titulo" id="titulo" required value="<%=menu.getTitulo() %>" />
               </p>
               <p>
                <label><strong>  Link:</strong></label>
                <input type="text" name="link" id="link" required value="<%=menu.getLink() %>" />
               </p>
               <p>
                <label><strong>  Ícone:</strong></label>
                <input type="file" name="icone" id="icone" required value="<%=menu.getIcone() %>" />
               </p>
               <p>
                <label>&nbsp;</label>
                <input type="submit" name="enviar" value="Salvar">
               </p>
           </form>
        </div>
        
    </body>
</html>
