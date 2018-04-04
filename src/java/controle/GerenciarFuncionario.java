package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.Perfil;

/**
 *
 * @author Administrador
 */
public class GerenciarFuncionario extends HttpServlet{

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
            out.println("<title>Servlet GerenciarFuncionario</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //Recebe os dados do formulário html.
            String op = request.getParameter("op"); 
            int id = 0;
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String id_perfil = request.getParameter("id_perfil");
            
            
            //Teste de condição de existência dos atributos. 
            try{
                if (op.equals("excluir") || op.equals("alterar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                    
                }
                if (op.equals("inserir") || op.equals("alterar")){
                    
                    if (nome.isEmpty()){
                        out.print("O campo Nome deve ser preenchido!");
                    }
                    else if (cpf.isEmpty()){
                        out.print("Informe um cpf valido!");
                    }       
                    else if (telefone.isEmpty()){
                        out.print("Informe um telefone valido!");
                    }          
                    else if (endereco.isEmpty()){
                        out.print("Informe um enereço!");
                    }
                    else if (email.isEmpty()){
                        out.print("Informe um email!");
                    }
                    else if (senha.isEmpty()){
                        out.print("Informe uma senha valida!");
                    }
                    else if (id_perfil.isEmpty()){
                        out.print("Selecione um perfil valido!");
                    }
                }
                
                DecimalFormat df = new DecimalFormat("");
                NumberFormat formato = NumberFormat.getInstance(); 
                
                //Instancia um objeto da classe menu para receber os dados.
                Funcionario funcionario = new Funcionario();
                funcionario.setId(id);
                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                
                if (!op.equals("excluir")){
                   funcionario.setTelefone(Integer.parseInt(telefone));
                }
                
                funcionario.setEndereco(endereco);
                funcionario.setEmail(email);
                funcionario.setSenha(senha);
                
                //se for excluir não é necessário o id_perfil;
                if (!op.equals("excluir")) {
                    Perfil p = new Perfil();
                p.setId(Integer.parseInt(id_perfil));
                funcionario.setPerfil(p);
                }
                
               
                
                //Testa qual opção de ação do DAO será usada.
                switch (op) {
                    case "inserir": funcionario.inserir();
                    break;
                    case "excluir": funcionario.excluir();
                    break;
                    case "alterar": funcionario.alterar();
                    break;
                }
                
                response.sendRedirect("listar_funcionario.jsp");
                
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
