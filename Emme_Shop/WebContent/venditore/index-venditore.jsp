<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*,managernegozio.*,manageraccouting.*,java.util.*"
    pageEncoding="UTF-8"
    session="true"
%>

<%! Venditore venditore=null; 
	Negozio negozio=null;
	%>

<%

    
	venditore = (Venditore)request.getSession().getAttribute("utente");
	if (venditore!=null){//controllo inutile perchè gia fatto in precedenza
		session.setAttribute("username-venditore",venditore.getUsername());
		negozio=(Negozio) request.getSession().getAttribute("negozioBean");
		String nomeNegozio=(String)session.getAttribute("negozioNome");
	}
	
	Collection<Categoria>  categorie=null;
	if(venditore!=null && negozio!=null)
	{
		categorie=(Collection <Categoria>)request.getSession().getAttribute("categorie");
	
	
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>EmmeShop</title>
        <link rel="icon" href="../images/favicon.ico" />
        <meta name='viewport' content='width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0'>
        <link rel='stylesheet' type='text/css' href='../css/table.css'>
        <%if(negozio.getDesign().equals("left")){ %>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/sidenav-nav_left/stile-nav_left.css'>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/sidenav-nav_left/sidenav-nav_left.css'>
        <% }else if(negozio.getDesign().equals("top")){%>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/sidenav-nav_top/stile-nav_top.css'>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/sidenav-nav_top/sidenav-nav_top.css'>
        
        <%} %>
        <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/content.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/step.css'>
        <link rel='stylesheet' type='text/css' href='../css/header.css'>
        <link rel='stylesheet' type='text/css' href='../css/footer.css'>
        <link rel='stylesheet' type='text/css' href='../css/scrollbar.css'>
        <link rel='stylesheet' type='text/css' href='../css/slideshow.css'>
        <link rel='stylesheet' type='text/css' href='../css/translate.css'>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <%if(negozio.getDesign().equals("left")){ %>
         <script type="text/javascript" src="../js/nav/menu-nav_left.js"></script>
         <% }else if(negozio.getDesign().equals("top")){%>
         <script type="text/javascript" src="../js/nav/menu-nav_top.js"></script>
         <%} %>
        <script type="text/javascript" src="../js/top.js"></script>
        <script type="text/javascript" src="../js/scrollToDiv.js"></script>
        <script type="text/javascript" src="../js/translate.js"></script>
        <script type="text/javascript" src="../js/check-chrome.js"></script>
        <script type="text/javascript" src="../js/category.js"></script>
        <script type="text/javascript" src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
   
   
   
    </head>
    <body onresize='resize()'  id='home' >
      
        <header>
           <%@ include file="../WEB-INF/fragment/headerseller.jsp" %>
             <script>
             $(".logo").html("<img src=\"../<%= negozio.getLogo() %>\" alt='<%= negozio.getNomeNegozio() %>' title='Logo <%= negozio.getNomeNegozio() %>'><p></p>");
			</script>   
                  
            <div id='mySidenav' class="sidenav">
              <ul >
                
                <li  onclick="window.open('../VisualizzaOrdineVenditore','_self')">
                    Controlla ordini
                </li>
                
              </ul>    
            </div>
        </header>
        
        
        
        
        
        <div class="content">
                   <h2>Gestione Categorie</h2>                
                  <div class="wrapper" id="#ContentWrapper">
                    <%
                    	 
                    			
						 if (categorie != null && categorie.size() != 0) {
								Iterator<?> it = categorie.iterator();
								while (it.hasNext()) {
									Categoria bean = (Categoria) it.next();
									
				    %>
                    <div class="categorySeller" >
                          <div class="img">
                            <a href='../VisualizzaProdotti?negozio=<%= bean.getNomeNegozio() %>&categoria=<%= bean.getNomeCategoria() %>'><img title="<%= bean.getDescrizione() %>" src="../<%= bean.getPath() %>"></a>
                          </div>
                          	<a href='../VisualizzaProdotti?negozio=<%= bean.getNomeNegozio() %>&categoria=<%= bean.getNomeCategoria() %>'>
                            	<div class='nomeCategoria'>
	                            	<span >
	                                	<%= bean.getNomeCategoria() %>
	                            	</span>
	                       		</div>
                            </a>
                          <div class="mod">
                              <a href='../ModificaCategoria?negozio=<%= bean.getNomeNegozio() %>&categoria=<%= bean.getNomeCategoria() %>'><img src='../images/modify.png'></a>
                          </div>
                          <div class='del'>
                            <span>
                          		<a href='../RemoveCat?negozio=<%= bean.getNomeNegozio() %>&categoria=<%= bean.getNomeCategoria() %>'><img  style="cursor:pointer;" src='../images/delete.png'></a>
      
                          	</span>
                          </div>
                    </div>
                    <% } }%>
                   
                   <div class="category">
                          <div class="img">
                            <a href='../InserisciCategoria?negozio=<%=negozio.getNomeNegozio()%>'><img src="../images/plus.png"></a>
                          </div>
                          <div class='nomeCategoria'>
                            <span >
                            
                                <a href="../InserisciCategoria?negozio=<%=negozio.getNomeNegozio()%>"><p></p>Inserisci nuova categoria</a>
                            </span>
                          </div>
                    </div>
                      
                  </div>
		         
		        </div>
        <% }%>
        <%@ include file="../WEB-INF/fragment/footer.jsp" %>

        
      
        
    </body>
</html>