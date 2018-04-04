/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.FuncionarioDAO;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "GerenciarSenha", urlPatterns = {"/gerenciar_senha.do"})
public class GerenciarSenha extends HttpServlet {

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
            out.println("<title>Servlet GerenciarSenha</title>");
            out.println("</head>");
            out.println("<body>");

            String cpf = request.getParameter("cpf");
            String senha_nova = request.getParameter("senha_nova");
            String msgErro = request.getParameter("msgErro");

            try {

                if (cpf.isEmpty()) {
                    out.print("O campo CPF deve ser preenchido!");
                } else if (senha_nova.isEmpty()) {
                    out.print("Informe a nova senha");
                }

                Funcionario funcionario = new Funcionario();

                funcionario = funcionario.verificarFuncionario(cpf);

                if (funcionario.getId() > 0) {
                    funcionario.alterarSenha(senha_nova, cpf);
                    //out.print("Senha alterada com sucesso!");
                    request.setAttribute("mensagem", "Senha Alterada!");
                    RequestDispatcher rd = request.getRequestDispatcher("form_alterar_senha.jsp");
                    rd.forward(request, response);

                } else {
                   // out.print("O funcionário não está cadastrado!");
                    request.setAttribute("mensagem1", "O funcionário não está cadastrado!");
                    RequestDispatcher rd = request.getRequestDispatcher("form_alterar_senha.jsp");
                    rd.forward(request, response);
                }

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
