/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;

/**
 *
 * @author Administrador
 */
public class GerenciarProduto extends HttpServlet {

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
            out.println("<title>Servlet GerenciarProduto</title>");
            out.println("</head>");
            out.println("<body>");

            //Recebe os dados do formulário html.
            String op = request.getParameter("op"); //Variavel que traz a opção.
            int id = 0;
            String nome = request.getParameter("nome");
            String sabor = request.getParameter("sabor");
            String volume = request.getParameter("volume");
            String fabricacao = request.getParameter("fabricacao");
            String validade = request.getParameter("validade");
            String valor = request.getParameter("valor");
            String qtdExistente = request.getParameter("qtd_existente");
            String situacao = request.getParameter("situacao");

            //Teste de condição de existência dos atributos. 
            try {
                if (op.equals("excluir") || op.equals("alterar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                }
                if (op.equals("inserir") || op.equals("alterar")) {
                    if (nome.isEmpty()) {
                        out.print("O campo Nome deve ser preenchido!");
                    } else if (sabor.isEmpty()) {
                        out.print("Informe um sabor valido!");
                    } else if (volume.isEmpty()) {
                        out.print("Informe um volume!");
                    } else if (fabricacao.isEmpty()) {
                        out.print("Informe a data de fabricação!");
                    } else if (validade.isEmpty()) {
                        out.print("Informe a data de validade!");
                    } else if (valor.isEmpty()) {
                        out.print("Informe o preço do produto!");
                    } else if (qtdExistente.isEmpty()) {
                        out.print("Informe a quantidade!");
                    } else if (situacao.isEmpty()) {
                        out.print("Informe a situação produto!");
                    }
                }

                NumberFormat format = NumberFormat.getInstance();
                SimpleDateFormat dataFormato = new SimpleDateFormat("yyy-MM-dd");

                //Instancia um objeto da classe p para receber os dados.
                Produto p = new Produto();

                //Testa qual opção de ação do DAO será usada.
                switch (op) {
                    case "inserir": {

                        p.setId(id);
                        p.setNome(nome);
                        p.setSabor(sabor);
                        p.setVolume(volume);
                        p.setFabricacao(dataFormato.parse(fabricacao));
                        p.setValidade(dataFormato.parse(validade));
                        p.setValor(Double.parseDouble(valor));
                        p.setQtdExistente(Double.parseDouble(qtdExistente));
                        p.setSituacao(situacao);
                        p.inserir();
                    }
                    break;
                    case "excluir": {
                        p.setId(id);
                        p.excluir();
                    }
                    break;
                    case "alterar": {
                        p.setId(id);
                        p.setNome(nome);
                        p.setSabor(sabor);
                        p.setVolume(volume);
                        p.setFabricacao(dataFormato.parse(fabricacao));
                        p.setValidade(dataFormato.parse(validade));
                        p.setValor(Double.parseDouble(valor));
                        p.setQtdExistente(Double.parseDouble(qtdExistente));
                        p.setSituacao(situacao);
                        p.alterar();
                    }
                    break;
                    
                }

                response.sendRedirect("listar_produto.jsp");

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
