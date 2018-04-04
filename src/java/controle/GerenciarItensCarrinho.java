/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoProduto;
import modelo.Produto;
import modelo.ProdutoDAO;

/**
 *
 * @author Administrador
 */
public class GerenciarItensCarrinho extends HttpServlet {

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
            out.println("<title>Servlet GerenciarItensCarrinho</title>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();

            //Recebe os dados.
            String idCliente = request.getParameter("id_cliente");
            String idProduto = request.getParameter("id_produto");
            String qtd = request.getParameter("qtd_vendida");

            String op = request.getParameter("op");

            out.print("  cliente:" + idCliente);
            out.print("  produto:" + idProduto);
            out.print("  qtd:" + qtd);
            out.print("  op:" + op + "  ");

            try {

                //Carregar carrinho da sessão.
                ArrayList<PedidoProduto> carrinho = (ArrayList<PedidoProduto>) session.getAttribute("carrinho");

                switch (op) {
                    case "adicionar": {

                        Produto p1 = new Produto();
                        ProdutoDAO pDAO = new ProdutoDAO();
                        p1 = pDAO.carregarPorId(Integer.parseInt(idProduto));

                        PedidoProduto item = new PedidoProduto();
                        item.setProduto(p1);
                        item.setQuantidade(Double.parseDouble(qtd));
                        item.setValorUnitario(p1.getValor());
                        carrinho.add(item);

                    }
                    break;
                    case "remover": {
                        int id = Integer.parseInt(idProduto);

                        carrinho.remove(id);
                    }
                    break;
                }

                session.setAttribute("carrinho", carrinho);

                response.sendRedirect("form_inserir_pedido.jsp?novo_pedido=&id_cliente=" + idCliente);
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
