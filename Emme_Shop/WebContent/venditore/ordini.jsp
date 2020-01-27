<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*,control.*,managerordine.*,managernegozio.*,manageraccouting.*,java.util.*,model.*"
    pageEncoding="UTF-8"
    session="true"
%>


<%!ArrayRiferimento riferimenti=null;
	Negozio negozio=null;
	Venditore venditore=null; %>
<%
    
	
	venditore = (Venditore)request.getSession().getAttribute("utente");
   
	negozio= (Negozio)request.getSession().getAttribute("negozio");
	
	riferimenti= (ArrayRiferimento) request.getSession().getAttribute("riferimenti");
	//System.out.println(riferimenti);
	
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
        <link rel='stylesheet' type='text/css' href='../css/header.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/content.css'>
        <link rel='stylesheet' type='text/css' href='../css/footer.css'>
        <link rel='stylesheet' type='text/css' href='../css/scrollbar.css'>
        <link rel='stylesheet' type='text/css' href='../css/translate.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= negozio.getColore() %>/popup.css'>
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
        <script type="text/javascript" src="../js/cart.js"></script>
        <script type="text/javascript" src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body onresize='resize()'  id='home' >
      
      <div id="alertBox"><br>
       <center> 
        <label id="msg"></label><p>
            <input value="ok" id="btnA" type="button" >
       </center>
      </div>
      
    <div id="back">
    </div>
      
      
      
        <header>
           <%@ include file="../WEB-INF/fragment/headerseller.jsp" %>
                  <script>
             $(".logo").html("<img src=\"../<%= negozio.getLogo() %>\" alt='<%= negozio.getNomeNegozio() %>' title='Logo <%= negozio.getNomeNegozio() %>'><p></p>");
			</script>
            <div id='mySidenav' class="sidenav">
              <ul >
                <li onclick="window.open('index-venditore.jsp','_self')">
                    Il Mio Negozio
                </li>
               <!--  <li onclick="window.open('formCliente.jsp','_self')">
                     in fase di sviluppo: Ordini per clienti
                </li>
                <li onclick="window.open('formData.jsp','_self')">
                   in fase di sviluppo: Ordini per data
                </li>
                -->
              </ul>    
            </div>
        </header>
        <div class="content">
                  
              
         			
         		 
                  <br><center><h2>Ordini Ricevuti Dal Più Recente</h2></center><br>
                   
                            
                            
                            
                            <%
                            	if(riferimenti!=null){
                            		Prodotto model=new Prodotto();
                            %>		
                            		<center><caption></caption>
				                   
				                            
                            
		                            <%		
				                            for(Riferimento r : riferimenti.getAllRiferimento()){
				                            	
				                    %>
				                     <table style="max-width:80%;">
				                    		<thead>
				                              <tr>
				                                <th>Numero Ordine</th>
				                                <th>Prodotto</th>
				                                <th>Destinazione</th>
				                                <th>Username Cliente</th>
				                                <th>Data</th>
				                                <th>Qta</th>
				                                <th>Nota</th>
				                                <th>PrezzoUnitario</th>
				                                <th>Sconto</th>
				                                <th>Iva</th>
				                              </tr>
				                            </thead>
				                            <tbody>
				                              <tr>
				                                  <td data-label="Numero Ordine"><br><%=r.getNumero_Fattura() %></td>
				                                  <td data-label="Prodotto"><img  height="45px" src="../<%= model.getPathByID(r.getId_prodotto()) %>"><br>cod. <%= r.getId_prodotto() %> </td>
				                            	
					                              <td data-label="Destinazione"><br><%=r.getFatturaRiferimento().getCittaDestinazione() %>, <%=r.getFatturaRiferimento().getViaDestinazione() %>, (<%=r.getFatturaRiferimento().getCapDestinazione() %>)</td>
					                              <td data-label="Nome Cliente"><br><%=r.getFatturaRiferimento().getUsername_Cliente() %></td>
					                              <td data-label="Data"><br><%=r.getFatturaRiferimento().getDataOrdine() %></td>
					                           
					                              <td data-label="Qta"><br><%=r.getQtaOrdinata() %></td>
					                              <td data-label="Nota"><br><%=r.getNote() %></td>
					                              <td data-label="PrezzoUnitario"><br><%=r.getPrezzoUnitario() %>€</td>
					                              <td data-label="Sconto"><br><%=r.getSconto() %>%</td>
					                              <td data-label="Iva"><br><%=r.getIva() %>%</td>
					                            </tr>
			                               </tbody>
			                               </table><br>
				                            
		                              		<%}%>
			                          </center>
                              <%}else{%>
                              		<br><h3>Non ci sono ordini da parte degli utenti della piattaforma!</h3>
                              <%} %>
                              
                              
                          
                           
                             
                  
                  
                  
              </div>
        
        <%@ include file="../WEB-INF/fragment/footer.jsp" %>
		
		
    </body>
</html>