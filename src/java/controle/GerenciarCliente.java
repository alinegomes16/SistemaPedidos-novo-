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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Cliente;

/**
 *
 * @author Administrador
 */
public class GerenciarCliente extends HttpServlet {

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
            out.println("<title>Servlet GerenciarCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            
             //Abri a sessão.
            HttpSession session = request.getSession();
            
            //Recebe os dados do formulário html.
            String op = request.getParameter("op"); 
            int id = 0;
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            
            //Teste de condição de existência dos atributos. 
            try{
                if (op.equals("excluir") || op.equals("alterar")){
                    id = Integer.parseInt(request.getParameter("id"));
                }
                if (op.equals("inserir") || op.equals("alterar")){
                    if (nome.isEmpty()){
                        out.print("O campo Nome deve ser preenchido!");
                    }
                }
                
                //Instancia um objeto da classe menu para receber os dados.
                Cliente cliente = new Cliente();
                
               
                
                //Testa qual opção de ação do DAO será usada.
                switch (op) {
                    case "inserir": {
                        cliente.setId(id);
                        cliente.setNome(nome);
                        cliente.setCpf(cpf);
                        cliente.setEndereco(endereco);
                        cliente.setTelefone(telefone);
                        cliente.inserir();
                    }
                    break;
                    case "excluir": {
                        cliente.setId(id);
                        cliente.excluir();
                    }
                    break;
                    case "alterar": {
                        cliente.setId(id);
                        cliente.setNome(nome);
                        cliente.setCpf(cpf);
                        cliente.setEndereco(endereco);
                        cliente.setTelefone(telefone);
                        cliente.alterar();
                    }
                    break;
                    case "selecionar": {
                        String novo_pedido = request.getParameter("novo_pedido");
                        
                        cliente = cliente.carregarPorNome(nome);
      
                        if (cliente.getId() > 0) {
                            
                            session.setAttribute("cliente", cliente);
                            response.sendRedirect("form_inserir_pedido.jsp");
                         

                        } else {

//                            request.setAttribute("mensagem", "Cliente não cadastrado!");
//                            RequestDispatcher rd = request.getRequestDispatcher("selecionar_cliente.jsp");
//                            rd.forward(request, response);
                              response.sendRedirect("form_inserir_cliente.jsp");
                        }

                    }
                }
                
                response.sendRedirect("listar_cliente.jsp");
                
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
