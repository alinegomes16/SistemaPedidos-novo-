<%@page import="modelo.Menu"%>
<%@page import="modelo.Funcionario"%>

 <% 
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
    %>
    
   
    
    
    
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#barraBasica1">
                <span class="sr-only">Toggle navigation</span> 
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
                <a class="navbar-brand" href="index.jsp"><img src="Imagens/home.png"></a>
            </div>

            <div class="collapse navbar-collapse" id="barraBasica1">
              <ul class="nav navbar-nav">
                  
                      <% 
                            try {
                                Funcionario userLogado = (Funcionario) session.getAttribute("funcionario");
                               
                                for(Menu mLogado : userLogado.getPerfil().listarMenu(userLogado.getPerfil().getId())) {
                                    if (mLogado.getTitulo() == "Produto"){ %>
                                    <li class="dropdown">
                                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                        Matérias <span class="caret"></span></a>
                                      <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">HTML</a></li>
                                        <li><a href="#">CSS</a></li>
                                        <li><a href="#">JavaScript</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">PHP</a></li>
                                      </ul>
                                    </li>
                                     <%   
                                    }
                                    else{ %>
                                    <li><img src=""/><a href="<%out.print(mLogado.getLink()); %>"><%out.print(mLogado.getTitulo());%></a></li>
                                    <%
                                    }
                                %>
                                
                                <%
                                }
                                %>
              </ul>                 
                                <br>
                                <p class="text-right">
                                    <%out.print(userLogado.getNome()); %>&nbsp;&nbsp;&nbsp;
                                    <a class="pull-right" href="sair.jsp"><span class="glyphicon glyphicon-off"></span></a>
                                </p>
                                
                                
                              
                            <%    
                            } 
                            catch(Exception e){
                                response.sendRedirect("login.jsp");
                            }
                        %>  
                  
            </div>
          </div>
        </nav>
       
    
  