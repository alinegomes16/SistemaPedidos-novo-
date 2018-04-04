/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pedido;

/**
 *
 * @author Administrador
 */
public class GerenciarPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GerenciarPedido</title>");
            out.println("</head>");
            out.println("<body>");

            //Recebe os dados do formulário html.
            String op = request.getParameter("op");
            int id = 0;

            String data_pedido = request.getParameter("data_pedido");
            String data_entrega = request.getParameter("data_entrega");
            String data_pagamento = request.getParameter("data_pagamento");
            String qtd_vendida = request.getParameter("qtd_vendida");
            String total_pagar = request.getParameter("total_pagar");
            String situacao = request.getParameter("situacao");
            String id_cliente = request.getParameter("id_cliente");
            String id_funcionario = request.getParameter("id_produto");

            //Teste de condição de existência dos atributos. 
            try {
                if (op.equals("excluir") || op.equals("alterar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                }
                if (op.equals("inserir") || op.equals("alterar")) {
                    if (data_pedido.isEmpty()) {
                        out.print("A data de pedido deve ser preenchida!");
                    }
                    if (data_entrega.isEmpty()) {
                        out.print("A data de entega deve ser preenchida!");
                    } else if (data_pagamento.isEmpty()) {
                        out.print("A data de pagamento deve ser preenchida!");
                    } else if (qtd_vendida.isEmpty()) {
                        out.print("Informe a quantidade vendida!");
                    } else if (total_pagar.isEmpty()) {
                        out.print("Informe o total!");
                    } else if (situacao.isEmpty()) {
                        out.print("Informe uma situção!");
                    } else if (id_cliente.isEmpty()) {
                        out.print("Selecione um perfil valido!");
                    } else if (id_funcionario.isEmpty()) {
                        out.print("Funcioário inexistente!");
                    }
                }

                //Instancia um objeto da classe menu para receber os dados.
                Pedido pedido = new Pedido();
                pedido.setId(id);
                pedido.setDataPedido(new Date(pedido.getDataPedido().getTime()));
                pedido.setDataEntrega(new Date(pedido.getDataEntrega().getTime()));
                pedido.setDataPagamento(new Date(pedido.getDataPagamento().getTime()));
                pedido.setQtdVendida(Double.parseDouble(qtd_vendida));
                pedido.setTotalPagar(Double.parseDouble(total_pagar));
                pedido.setSituacao(situacao);

                Cliente c = new Cliente();
                c.setId(Integer.parseInt(id_cliente));
                pedido.setCliente(c);

                Funcionario f = new Funcionario();
                f.setId(Integer.parseInt(id_funcionario));
                pedido.setFuncionario(f);

                //se for excluir não é necessário o id_perfil;
//                if (!op.equals("excluir")) {
//                    Perfil p = new Perfil();
//                p.setId(Integer.parseInt(id_perfil));
//                produto.setPerfil(p);
//                }
                //Testa qual opção de ação do DAO será usada.
                switch (op) {
                    case "inserir":
                        pedido.inserir();
                        break;
//                    case "excluir": pedido.excluir();
//                    break;
//                    case "alterar": produto.alterar();
//                    break;
                        
                   
                }

                response.sendRedirect("");

            } catch (Exception e) {
                out.print("Erro: " + e);
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
