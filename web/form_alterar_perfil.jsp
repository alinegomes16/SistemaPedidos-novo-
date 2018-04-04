<%-- 
    Document   : form_alterar_perfil
    Created on : 16/03/2017, 23:25:43
    Author     : Administrador
--%>

<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Altera Perfil</title>
    </head>
    <body>
        <%
            //Recebe e valida o id e conecta ao BD;
            String id = request.getParameter("id");
              
                Perfil perfil = new Perfil();
                
                try{
                    PerfilDAO pDAO = new PerfilDAO();
                    perfil = pDAO.carregarPorId(Integer.parseInt(id));
                }
                catch(Exception e){
                    out.print("Erro: "+e);
                }
            
        %>
        
        <!--Obtendo os dados através do id-->
        <div style="border: solid 2px darkblue; width: 400px; height: 300px; padding-left: 15px;">
           <h3><center>Alterar Perfil</center></h3>
          
           <form method="POST" id="form_perfil" action="gerenciar_perfil.do?">
               <label><strong> ID: <%= perfil.getId() %></strong></label>
               <input type="hidden" name="op" value="alterar"/>
               <input type="hidden" name="id" value="<%= perfil.getId() %>"/>
               <p>
                   <label><strong>  Nome:</strong></label>
                   <input type="text" name="nome" id="nome" required value="<%=perfil.getNome() %>">
               </p>
               <p>
                <label><strong>  Descrição:</strong></label>
                <textarea name="descricao" id="descricao" required style="vertical-align: text-top;">
                    <%=perfil.getDescricao() %>
                </textarea>
               </p>
               <p>
                <label>&nbsp;</label>
                <input type="submit" name="enviar" value="Salvar">
               </p>
           </form>
        </div>
        
    </body>
</html>
