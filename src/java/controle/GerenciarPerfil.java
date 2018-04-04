/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Perfil;

/**
 *
 * @author Administrador
 */
public class GerenciarPerfil extends HttpServlet {

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
            out.println("<title>Servlet GerenciarPerfil</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //Busca os dados do formulário html.
            String op = request.getParameter("op"); //Variavel que traz a opção.
            int id = 0;
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            
            
            //Teste de condição de existência dos atributos. 
            try{
                if (op.equals("excluir") || op.equals("alterar")){
                    id = Integer.parseInt(request.getParameter("id"));
                }
                if (op.equals("inserir") || op.equals("alterar")){
                    if (nome.isEmpty()){
                        out.print("O campo Nome deve ser preenchido!");
                    }
                    else if (descricao.isEmpty()){
                        out.print("O campo Descrição deve ser preenchido!");
                    }
                }
                
                Perfil perfil = new Perfil();
                perfil.setId(id);
                perfil.setNome(nome);
                perfil.setDescricao(descricao);
                    
                
                switch (op) {
                    case "inserir": perfil.inserir();
                    break;
                    case "excluir": perfil.excluir();
                    break;
                    case "alterar": perfil.alterar();
                    break;
                }
                
                response.sendRedirect("listar_perfil.jsp");
                
            }
            catch (Exception e){
                    out.print("Erro: "+e);
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
