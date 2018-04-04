<%-- 
    Document   : form_alterar_funcionario
    Created on : 10/05/2017, 10:46:02
    Author     : Administrador
--%>

<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <title>Alterar Funcionário</title>
    </head>
    <body>
        <%
            ArrayList<Perfil> lista = new ArrayList<Perfil>();
    Funcionario funcionario = new Funcionario();
    
    try{
        int id = Integer.parseInt(request.getParameter("id"));
        FuncionarioDAO fDAO = new FuncionarioDAO();
        funcionario = fDAO.carregarPorId(id);
        
        PerfilDAO pDAO = new PerfilDAO();
        lista = pDAO.listar();
    }catch(Exception e){
        out.print("Erro:"+e);
    }
         %>
        
        <div style="border: solid 2px darkblue; width: 400px; height: 500px; padding-left: 15px;">
           <h3><center>Funcionário</center></h3>
           <form method="POST" id="form_funcionario" action="gerenciar_funcionario.do">
               <input type="hidden" name="op" value="alterar" />
               <input type="hidden" name="id" value="<%=funcionario.getId() %>" />
               <p>
                   <label><b>ID: <%=funcionario.getId() %></b></label></p>
               <p>
                   <label><strong>  Nome:</strong></label>
                   <input type="text" name="nome" id="nome" required value="<%=funcionario.getNome() %>" />
               </p>
               <p>
                <label><strong>  CPF:</strong></label>
                <input type="number" name="cpf" id="link" required value="<%=funcionario.getCpf() %>" disabled />
               </p>
               <p>
                <label><strong>  Endereço:</strong></label>
                <input type="text" name="endereco" id="endereco" required value="<%=funcionario.getEndereco() %>" />
               </p>
               <p>
                <label><strong>  Telefone:</strong></label>
                <input type="number" name="telefone" id="telefone" required value="<%=funcionario.getTelefone() %>" />
               </p>
               <p>
                <label><strong>  Email:</strong></label>
                <input type="text" name="email" id="email" required value="<%=funcionario.getEmail() %>" />
               </p>
               <p>
                <label><strong>  Senha:</strong></label>
                <input type="password" name="senha" id="senha" required value="<%=funcionario.getSenha() %>" />
               </p>
               <label><strong>  Perfil:</strong></label>
            <select name="id_perfil" size="1" required>
                <option value="">Selecione...</option>
                <%  
                    for(Perfil p:lista) { 
                        String selecionado = "";
                        if(p.getId() == funcionario.getPerfil().getId()) selecionado = "selected";
                %>
                <option value="<%=p.getId() %>" <%=selecionado %>><%=p.getNome() %></option>
                <% } %>
            </select>
               <p>
               <label>&nbsp;</label>
                <input type="submit" name="enviar" value="Salvar">
               </p>
           </form>
        </div>
    </body>
</html>
