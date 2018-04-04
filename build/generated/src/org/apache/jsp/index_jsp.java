package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Menu;
import modelo.Funcionario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge, chrome=1\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        \n");
      out.write("        <!--Referencia o jquery-->\n");
      out.write("        <script src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <!--Referencia o CSS do Bootstrap-->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <!--Referencia o JS do Bootstrap-->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!--Favicon-->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"Imagens/anjos2_favicon2.png\"/> \n");
      out.write("        <title>Principal</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container-fluid\" style=\"border: 0px solid; height: 150px;\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <img class=\"img-responsive\" src=\"Imagens/anjos_topo3.jpg\" alt=\"Sorveteria Anjos\" >\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\" style=\"padding-top: 0px;\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" ");
 
//        try {
//            Funcionario userLogado = (Funcionario) session.getAttribute("usuario");
//            out.print("<img src='./Imagens/home.png'><a href='index.jsp'>Início</a> |");
//            for(Menu mLogado : userLogado.getPerfil().listarMenu(userLogado.getPerfil().getId())) {
//                out.print("<img src='./Imagens/"+mLogado.getIcone()+"'/><a href='"+mLogado.getLink()+"'>"+mLogado.getTitulo()+"</a> | ");
//            }
//            out.print("<b>"+userLogado.getNome()+"</b> <a href='sair.jsp'> (Sair) </a>");
//        } 
//        catch(Exception e){
//            response.sendRedirect("login.jsp");
//        }
    
      out.write("\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("          <div class=\"container-fluid\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("              <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#barraBasica1\">\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span> \n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("              </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"Imagens/home.png\"></a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"barraBasica1\">\n");
      out.write("              <ul class=\"nav navbar-nav\">\n");
      out.write("                  \n");
      out.write("                      ");
 
                            try {
                                Funcionario userLogado = (Funcionario) session.getAttribute("funcionario");
                               
                                for(Menu mLogado : userLogado.getPerfil().listarMenu(userLogado.getPerfil().getId())) {
                                    if (mLogado.getTitulo() == "Produto"){ 
      out.write("\n");
      out.write("                                    <li class=\"dropdown\">\n");
      out.write("                                      <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-expanded=\"false\">\n");
      out.write("                                        Matérias <span class=\"caret\"></span></a>\n");
      out.write("                                      <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                                        <li><a href=\"#\">HTML</a></li>\n");
      out.write("                                        <li><a href=\"#\">CSS</a></li>\n");
      out.write("                                        <li><a href=\"#\">JavaScript</a></li>\n");
      out.write("                                        <li class=\"divider\"></li>\n");
      out.write("                                        <li><a href=\"#\">PHP</a></li>\n");
      out.write("                                      </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                     ");
   
                                    }
                                    else{ 
      out.write("\n");
      out.write("                                    <li><img src=\"\"/><a href=\"");
out.print(mLogado.getLink()); 
      out.write('"');
      out.write('>');
out.print(mLogado.getTitulo());
      out.write("</a></li>\n");
      out.write("                                    ");

                                    }
                                
      out.write("\n");
      out.write("                                \n");
      out.write("                                ");

                                }
                                
      out.write("\n");
      out.write("              </ul>                 \n");
      out.write("                                <br>\n");
      out.write("                                <p class=\"text-right\">\n");
      out.write("                                    ");
out.print(userLogado.getNome()); 
      out.write("&nbsp;&nbsp;&nbsp;\n");
      out.write("                                    <a class=\"pull-right\" href=\"sair.jsp\"><span class=\"glyphicon glyphicon-off\"></span></a>\n");
      out.write("                                </p>\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                              \n");
      out.write("                            ");
    
                            } 
                            catch(Exception e){
                                response.sendRedirect("login.jsp");
                            }
                        
      out.write("  \n");
      out.write("                  \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("       \n");
      out.write("    \n");
      out.write("  ");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\" style=\"padding-top: 20px;\">\n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                    \n");
      out.write("                           \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
