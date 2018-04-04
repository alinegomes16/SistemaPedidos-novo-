<%-- 
    Document   : efetuar_pagamento
    Created on : 11/06/2017, 00:28:36
    Author     : Administrador
--%>

<%@page import="modelo.PedidoDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta lang="pt-br">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Referencia o jquery-->
        <script src="js/jquery-3.1.1.min.js"></script>
        <!--Referencia o CSS do Bootstrap-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!--Referencia o JS do Bootstrap-->
        <script src="js/bootstrap.min.js"></script>

        <title>Efetuar Pagamento</title>
    </head>
    <body>
        
        <%
            String id = request.getParameter("id");
            
            Pedido pedido = new Pedido();
            
            try {
                PedidoDAO pedidoDAO = new PedidoDAO();
                pedido = pedidoDAO.carregarPorId(Integer.parseInt(id));
            
            }
            catch (Exception e){
                out.print("Erro: "+e);
            }
            
         %>
        
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-2">
                    <h3 class="text-center">Pagamento</h3>

                    <form method="POST" id="busca_produto" action="finalizar_pedido.do" >
                        <input type="hidden" name="op" id="op" value="pagamento" >
                        <p>
                            <!--Carrega a data atual.-->
                            <%
                                SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
                                                  Date dataAtual = new Date();
                            %>
                            <label><strong>  Data pagamento:</strong></label>
                            <input type="text" class="form-control" name="data_pagamento" id="data_pagamento"  value="<%out.println(dataFormato.format(dataAtual)); %>" required>
                        </p>
                        <p>
                            <label><strong> Valor Total:</strong></label>
                            <input type="text" class="form-control" name="total_pagar" id="total_pagar" value="<%=pedido.getTotalPagar() %>" disabled />
                        </p>
                        <p>
                            <br>
                            <input type="submit" name="enviar" value="Buscar">

                        </p>
                    </form>
                </div>
            </div>        
        </div>

    </body>
</html>
