<%--
    Document   : form_inserir_pedido
    Created on : 10/05/2017, 22:00:54
    Author     : Administrador
--%>
<%@page import="modelo.PedidoProduto"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.FuncionarioDAO"%>
<%@page import="modelo.ClienteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Funcionario"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<PedidoProduto> carrinho = new ArrayList<PedidoProduto>();
    ArrayList<Produto> lista = new ArrayList<Produto>();
    
    try {
        ProdutoDAO pDAO = new ProdutoDAO();
        lista = pDAO.listar();
    } catch (Exception e) {
        out.print("Erro:" + e);
    }
    
    Cliente clienteSelect = new Cliente();
    String id_cliente = request.getParameter("id_cliente");
    try{
        ClienteDAO cDAO = new ClienteDAO();
        clienteSelect = cDAO.carregarPorId(Integer.parseInt(id_cliente));
    }catch(Exception e){
        out.print("Erro:" + e);
    }

    String novo_pedido = request.getParameter("novo_pedido");
    if (!novo_pedido.isEmpty()){ 
        session.setAttribute("carrinho", carrinho);
    }else{
        try{
            carrinho = (ArrayList<PedidoProduto>) session.getAttribute("carrinho");
            int totalItens = carrinho.size();
            //out.print("Total itens carrinho:"+totalItens);
        }catch(Exception e){
            out.print("Erro:" + e);
        }
    }
    
    
    
%>

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

        <title>Registrar Pedido</title>


    </head>
    <body>
        <%@include file="menu.jsp" %>

        <h3><center>Novo Pedido</center></h3>

        
        
        <form method="POST" id="form_pedido" action="gerenciar_itens_carrinho.do" style="padding-left: 40px">

            <!--Cliente cadastrado-->
            <div name="cliente" style="border: solid 2px darkblue; width: 350px; height:50px; padding-top: 10px;">
                <p>
                    <label><strong>  Cliente:</strong></label>
                    <input type="text" name="nome" id="nome" value="<%=clienteSelect.getNome()%>" disabled/> 
                    &nbsp;&nbsp;
                    <label><strong>ID: </strong><%=clienteSelect.getId()%></label>
                    <input type="hidden" name="id_cliente" id="id_cliente" value="<%=clienteSelect.getId()%>" />
                </p>
            </div><br>

            <!--Seleciona o produto-->
            <%
                DecimalFormat df = new DecimalFormat("R$ ##.##");
                
            %>
            
            <p>
                <label><strong>  Produto:</strong></label>
                <select name="id_produto" id="id_produto" size="1" onchange="">
                    <option value="">Selecionar...</option>
                    <%  
                         
                        for (Produto produtos : lista) {
                    %>
                    <option value="<%=produtos.getId()%>">
                        <%=produtos.getNome()%>     | 
                        <%=produtos.getSabor()%>        |
                        <%=produtos.getVolume()%>       |
                        <%=df.format(produtos.getValor())%>        |
                        <%=produtos.getQtdExistente()%>     |
                    </option>
                    <%
                        }
                    %>
                </select>
            </p>
            
            <p>
                <label><strong> Quantidade Vendida:</strong></label>
                <input type="number" name="qtd_vendida" id="qtdVendida" required/> &nbsp;&nbsp;&nbsp;
                <input type="hidden" name="op" value="adicionar" /> &nbsp;&nbsp;&nbsp;
                <input type="image" src="Imagens/adicionar_produto.png" />
                           
            </p>
        </form>
                

            <p>
                <!--Carrega a data atual.-->
                <%
                    SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataAtual = new Date();
                %>

                <label><strong>  Data do Pedido: </strong></label>
                <input type="text" name="dataPedido" id="dataPedido" value="<%out.println(dataFormato.format(dataAtual)); %>" disabled/>
            </p>


           

            <br>

            <!--carrinho-->
            <label><b>Carrinho</b></label>
            <div name="carrinho" style="border: solid 2px darkblue; width: 510px; height:100px;">
                
                <table>
                    <tr>
                        <th>|ID|</th>
                        <th>Produto|</th>
                        <th>QTD|</th>
                        <th>Valor Unit.|</th>
                        <th>Total|</th>
                        <th>Opções|</th>
                    </tr>
                    
                    <%
                        
                        double valorTotal = 0;
                        int i=0;
                        for (PedidoProduto item : carrinho){
                            valorTotal = valorTotal + (item.getQuantidade()*item.getValorUnitario());
                        %>
                        <tr>
                            <td><%=item.getProduto().getId()%></td>
                            <td><%=item.getProduto().getNome() %></td>
                            <td><%=item.getQuantidade() %></td>
                            <td><%=item.getValorUnitario() %></td>
                            <td><%=(item.getQuantidade()*item.getValorUnitario()) %></td>
                            <td>
                                <a href="gerenciar_itens_carrinho.do?op=remover&id_cliente=<%=id_cliente %>&id_produto=<%=i %>"><img src="Imagens/remover_produto.png" /></a>
                            </td>
                            
                        </tr>
                        
                        <%
                        i++;
                       }     
                    %>
                    
                </table> 
                  
                

            </div>

            <br>
            <form method="POST" id="form_pedido" action="gerenciar_pedido.do" style="padding-left: 40px">
            <p>
                <label><strong> Total a Pagar:</strong></label>
                <input type="text" name="totalPagar" id="totalPagar" disabled value="<%=df.format(valorTotal) %>" />

                <label>&nbsp;</label>
                <input type="submit" name="enviar" value="Finalizar pedido">
            </p>
            <br>
            
            <p>
                <label><strong>  Data da Entrega:</strong></label>
                <input type="date" name="dataEntrega" id="dataEntrega" />
            </p>
            <br>

            <!--Mostra o nome do atendente.-->
            <div>
                <%
                    Funcionario userLogado = (Funcionario) session.getAttribute("funcionario");
                %>
                <label><strong>  Atendente: </strong><%out.print(userLogado.getNome()); %></label>
                <input type="hidden" name="atendente" value="<%userLogado.getId();%>" />
            </div>
            </form>
            <br><br><br><br>

        </form>

    </body>
</html>
