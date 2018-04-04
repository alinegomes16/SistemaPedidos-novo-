<%-- 
    Document   : form_inserir_funcionario
    Created on : 10/05/2017, 10:28:51
    Author     : Administrador
--%>
<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Perfil> lista = new ArrayList<Perfil>();
    try{
        PerfilDAO pDAO = new PerfilDAO();
        lista = pDAO.listar();
    }catch(Exception e){
        out.print("Erro:"+e);
    }
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.maskedinput.js"></script>
        <script>
            $(document).ready(function(){
                $('#telefone').mask("(99) 9999-9999");
                $('#cpf').mask("999.999.999-99");
            });
        </script>
        
        <title>Inserir Funcionário</title>
        
    </head>
    <body>
        <div style="border: solid 2px darkblue; width: 400px; height: 500px; padding-left: 15px;">
           <h3>Novo Funcionario</h3>
           <form method="POST" id="form_funcionario" action="gerenciar_funcionario.do?op=inserir">
               <p>
                   <label><strong>  Nome:</strong></label>
                   <input type="text" name="nome" id="nome" required placeholder="Digite um nome"/>
               </p>
               <p>
                <label><strong>  CPF:</strong></label>
                <input type="text" name="cpf" id="cpf" required placeholder="Informe o cpf" />
               </p>
               <p>
                <label><strong>  Endereço:</strong></label>
                <input type="text" name="endereco" id="endereco" required placeholder="Informe o Endereço" />
               </p>
               <p>
                <label><strong> Telefone:</strong></label>
                <input type="text" name="telefone" id="telefone" required placeholder="Informe o telefone" />
               </p>
               <p>
                <label><strong> Email:</strong></label>
                <input type="email" name="email" id="email"  placeholder="Informe o Email"/>
               </p>
               <p>
                <label><strong> Senha:</strong></label>
                <input type="password" name="senha" id="senha" required placeholder="Informe a Senha"/>
               </p>
               <p>
                <label><strong>  Perfil:</strong></label>
                    <select name="id_perfil" size="1" required>
                    <option value="">Selecione...</option>
                        <% for(Perfil p:lista) { %>
                    <option value="<%=p.getId() %>"><%=p.getNome() %></option>
                        <% } %>
                    </select>  
               </p>
               <p>
                  <label>&nbsp;</label>
                  <input type="submit" name="enviar" value="Salvar"> 
               </p>
  
           </form>
        </div>
    </body>
</html>
