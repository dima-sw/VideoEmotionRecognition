<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*,managernegozio.*,java.util.*"
    pageEncoding="UTF-8"
    session="true"
%>

<%! 
	Collection<Prodotto>  prodotti=null;
	Negozio negozioBean = null;
	String categoria = "";
%>

<%
	negozioBean = (Negozio) request.getSession().getAttribute("negozioBean");
	prodotti = (Collection<Prodotto>) request.getSession().getAttribute("prodotti");
	categoria = (String)request.getSession().getAttribute("categoria");
	if (negozioBean != null) {
		
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
         <%if(negozioBean.getDesign().equals("left")){ %>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozioBean.getColore() %>/sidenav-nav_left/stile-nav_left.css'>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozioBean.getColore() %>/sidenav-nav_left/sidenav-nav_left.css'>
        <% }else if(negozioBean.getDesign().equals("top")){%>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozioBean.getColore() %>/sidenav-nav_top/stile-nav_top.css'>
         <link rel='stylesheet' type='text/css' href='../css_<%= negozioBean.getColore() %>/sidenav-nav_top/sidenav-nav_top.css'>
        <%} %>
        <link rel='stylesheet' type='text/css' href='../css/header.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= negozioBean.getColore() %>/content.css'>
        <link rel='stylesheet' type='text/css' href='../css/footer.css'>
        <link rel='stylesheet' type='text/css' href='../css/scrollbar.css'>
        <link rel='stylesheet' type='text/css' href='../css/slideshow.css'>
        <link rel='stylesheet' type='text/css' href='../css/translate.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= negozioBean.getColore() %>/step.css'>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <%if(negozioBean.getDesign().equals("left")){ %>
         <script type="text/javascript" src="../js/nav/menu-nav_left.js"></script>
         <% }else if(negozioBean.getDesign().equals("top")){%>
         <script type="text/javascript" src="../js/nav/menu-nav_top.js"></script>
         <%} %>
        <script type="text/javascript" src="../js/top.js"></script>
        <script type="text/javascript" src="../js/scrollToDiv.js"></script>
        <script type="text/javascript" src="../js/translate.js"></script>
        <script type="text/javascript" src="../js/check-chrome.js"></script>
        <script type="text/javascript" src="../js/product.js"></script>
        <script type="text/javascript" src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body onresize='resize()'  id='home' >
      
        <header>
           <%@ include file="../WEB-INF/fragment/headerseller.jsp" %>
            <script>
             $(".logo").html("<img src=\"../<%= negozioBean.getLogo() %>\" alt='<%= negozioBean.getNomeNegozio() %>' title='Logo <%= negozioBean.getNomeNegozio() %>'><p></p>");
			</script>   
            <div id='mySidenav' class="sidenav">
              <ul >
                
                <li  onclick="window.open('../VisualizzaOrdineVenditore','_self')">
                    Controlla ordini
                </li>
               
                
                <li  onclick="window.open('../ViewCategoria','_self')">
                    Categorie
                </li>
              </ul>    
            </div>
        </header>
        <div class="content">
                  
              
         			
         		<h2>Gestione Prodotti</h2>
                  <div class="wrapper" id="#ContentWrapper">
                  
                  <%
                    	 
                    			
						 if (prodotti != null && prodotti.size() != 0) {
								Iterator<?> it = prodotti.iterator();
								while (it.hasNext()) {
									Prodotto bean = (Prodotto) it.next();
				    %>
                   
                   
                   <div class="product" >
                        <form action='' method='POST'>
                          <div class="img">
                            <img src="../<%= bean.getPath() %>" title="<%= bean.getDescrizione() %>">
                          </div>
                          <div class='nomeProdotto'>
                            <span >
                                <%= bean.getNome() %>
                            </span>
                          </div>
                          <div class='note'>
                              <span>
                                Prezzo <%= bean.getPrezzo() %>&euro;<br>
                                Quantit&agrave; <%= bean.getQuantita() %>
                              </span>
                          </div>
                          <div class="mod">
                              <a href='../ModificaProdotto?ID=<%= bean.getIdProdotto() %>&nomeNegozio=<%= bean.getNomeNegozio() %>&nomeCategoria=<%= bean.getNomeCategoria() %>'><img src='../images/modify.png'></a>
                          </div>
                          <div class='del'>
                            <span>
                              <a href=''><img onclick="deleteProd('<%= bean.getIdProdotto() %>')" style="cursor:pointer;"  src='../images/delete.png'></a>
                            </span>
                          </div>
                          
                        </form>
                    </div>
                    
                    
                   
                    <% } }%>
                    <div class="category">
                          <div class="img">
                            <a href='../InserisciProdotto?negozio=nomeNeg&categoria=<%=categoria %>'><img src="../images/plus.png"></a>
                          </div>
                          <div class='nomeCategoria'>
                            <span >
                                <a href='../InserisciProdotto?negozio=nomeNeg&categoria=nomeCategoria'><p></p>Inserisci nuovo prodotto</a>
                            </span>
                          </div>
                    </div>
                    
                      
                      
                  </div>
                  
              </div>
        <%}%>
        <%@ include file="../WEB-INF/fragment/footer.jsp" %>

        
        
    </body>
</html>