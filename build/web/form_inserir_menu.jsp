<%-- 
    Document   : form_inserir_menu
    Created on : 18/03/2017, 19:32:07
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Menu</title>
    </head>
    <body>
         <div style="border: solid 2px darkblue; width: 400px; height: 300px; padding-left: 15px;">
           <h3><center>Novo Menu</center></h3>
           <form method="POST" id="form_menu" action="gerenciar_menu.do?op=inserir">
               <p>
                   <label><strong>  Título:</strong></label>
                   <input type="text" name="titulo" id="titulo" required placeholder="Digite um título"/>
               </p>
               <p>
                <label><strong>  Link:</strong></label>
                <input type="text" name="link" id="link" required placeholder="Informe o link"/>
               </p>
               <p>
                <label><strong>  Ícone:</strong></label>
                <input type="file" name="icone" id="icone" />
               </p>
               <p>
                <label>&nbsp;</label>
                <input type="submit" name="enviar" value="Salvar">
               </p>
           </form>
        </div>
        
        
    </body>
</html>
