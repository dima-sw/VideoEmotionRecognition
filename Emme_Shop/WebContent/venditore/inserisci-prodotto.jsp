<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="javax.servlet.*,managernegozio.*,java.util.*"
    pageEncoding="UTF-8" session="true"%>
    <%!
    	String nomeNegozio=null;
    	Negozio neg=null;
		
    %>

   <%
  		 String categoria = (String) session.getAttribute("categoriaNome");

   		String UsernameVenditore=(String) session.getAttribute("username-venditore");
   		
   		nomeNegozio= (String)session.getAttribute("negozioNome");
   		if(nomeNegozio==null)
   			nomeNegozio="some problem";
   		else{	
   				neg=(Negozio) session.getAttribute("negozio");
   		
   %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>EmmeShop</title>
        <link rel="icon" href="../images/favicon.ico" />
        <meta name='viewport' content='width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0'>
        <link rel='stylesheet' type='text/css' href='../css/table2.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= neg.getColore() %>/sidenav-nav_top/stile-nav_top.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= neg.getColore() %>/sidenav-nav_top/sidenav-nav_top.css'>
        <link rel='stylesheet' type='text/css' href='../css/header.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= neg.getColore() %>/content.css'>
        <link rel='stylesheet' type='text/css' href='../css/footer.css'>
        <link rel='stylesheet' type='text/css' href='../css/scrollbar.css'>
        <link rel='stylesheet' type='text/css' href='../css/slideshow.css'>
        <link rel='stylesheet' type='text/css' href='../css/translate.css'>
        <link rel='stylesheet' type='text/css' href='../css_<%= neg.getColore() %>/step.css'>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
        <link rel="stylesheet" href='../css/tooltip.css' type="text/css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="../js/nav/menu-nav_top.js"></script>
        <script type="text/javascript" src="../js/top.js"></script>
        <script type="text/javascript" src="../js/scrollToDiv.js"></script>
        <script type="text/javascript" src="../js/translate.js"></script>
        <script type="text/javascript" src="../js/check-chrome.js"></script>
        <script type="text/javascript" src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        <script type="text/javascript" src="../js/espressioni_regolari.js"></script>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body onresize='resize()'  id='home' > 
    

            <div id='vendi' style='padding-top:20px;'><br>
              	<form id="regForm1" name="regForm1" action="../InsertProduct" method="POST"   style='margin:0 auto;'> <!--Fase di realizzazione-->
               			 <h2><center>Nuovo Prodotto</center></h2><!-- Deve comparire in ogni statement -->
		
					    	<div class='tab1'> <br><center>
					    		<table>
					    			<tr>
					    				<td>
									    		<label for="">Negozio</label>	 <!--Nome e Username-->
										</td>
										<td>	           	 
									           	 <input type="text" name="nomeNegozio" value='<%=nomeNegozio %>'  readonly>
									     </td>
									     <td>       
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo inserito automaticamente</span>
												</div> 
										 </td>
									 </tr>
									 <tr>
									 
					    				<td>
									    		<label for="">Categoria</label>	 <!--Nome e Username-->
										</td>
									     <td>      	
									           	<input type="text" name="nomeCategoria" value="<%=categoria %>" readonly>
										  </td>
										  <td>         	
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo inserito automaticamente </span>
												</div>  
										  </td>
									  </tr>
									  <tr>
									  
					    				<td>
									    		<label for="">Nome Prodotto</label>	 <!--Nome e Username-->
										</td>
									  		<td>	
												<input type="text" name="nomeProdotto" onblur="isStreet(document.regForm1.nomeProdotto)"  placeholder=" Nome...">
											</td>
											<td>          	
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo Nome Prodotto <br>formato: campo illimitato, sia lettere che numeri<br>Esempio: Mortadella </span>
												</div>
											</td>
									  </tr>
									  <tr>
									  
					    				<td>
									    		<label for="">Descrizione</label>	 <!--Nome e Username-->
										</td>
									  		<td>		
												<input type="text" name="descProdotto" onblur="isText(document.regForm1.descProdotto)"  placeholder=" Descrizione...">
										    </td>
										    <td>      	
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo Descrizione Prodotto <br>formato:  minimo 10 max 500 caratteri</span>
												</div> 
											</td>
									  </tr>
									  <tr>	
									  
					    				<td>
									    		<label for="">Prezzo(€)</label>	 <!--Nome e Username-->
										</td>
											<td>	
												<input type="text" name="prezzoProdotto" onblur="isPrezzo(document.regForm1.prezzoProdotto)"  placeholder=" Prezzo...">
										    </td>      	
										    <td>
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo Prezzo Prodotto <br>formato: solo numeri con . decimale e nessun o 2 decimali caratteri<br>Esempio: 125.55</span>
												</div> 
											</td>
									 </tr>
									 <tr>		
									 	
					    				<td>
									    		<label for="">Iva</label>	 <!--Nome e Username-->
										</td>
											<td>	
												<input type="text" name="ivaProdotto" onblur="isSconto(document.regForm1.ivaProdotto)"  placeholder=" IVA...">
										    </td>
										    <td>      	
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo IVA Prodotto <br>formato: solo numeri interi da 0 a 99<br>Esempio: 24 </span>
												</div> 
											</td>
									</tr>	
									<tr>
											
					    				<td>
									    		<label for="">Quantit&agrave;</label>	 <!--Nome e Username-->
										</td>
											<td>	
												<input type="text" name="qtaProdotto" onblur="isQuantità(document.regForm1.qtaProdotto)"  placeholder=" Quantita...">
										     </td>
										     <td>      	
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo Quantità Prodotto <br>formato: solo numeri senza limite<br>Esempio: 125 </span>
												</div>
											 </td>
									</tr>
									<tr>
											
					    				<td>
									    		<label for="">Sconto(%)</label>	 <!--Nome e Username-->
										</td>
											<td>		
												<input type="text" name="scontoProdotto" onblur="isSconto(document.regForm1.scontoProdotto)"  placeholder=" Sconto...">
										    </td>  
										    <td>     	
				    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
				  									<span class="tooltiptext">Campo Sconto Prodotto <br>formato: solo numeri interi da 0 a 99<br>Esempio: 22 </span>
												</div>
											</td>
									</tr>
								</table>
					        </div>
					        
					       
					      
					       
					         <br><br><br>
                      <div class='steptab1' style="overflow:auto;">
	                  <div style='text-align:center'>
	                  		<button type="button" class="verifica" id="prevBtn1" onclick="nextPrev(-1)">Indietro</button>
							<button type="submit" class="verifica" id="nextBtn1" onclick="nextPrev(1)">Avanti</button>&nbsp;&nbsp;&nbsp;
					  </div>
              
             <!-- Circles which indicates the steps of the form: -->
             
                </form>
                
            </div>  
            <script src='../js/step1.js'></script>
              <script type="text/javascript">
                 document.getElementById("nextBtn1").innerHTML = "Inserisci";
              	
              </script>
        
        
        <br>   <br>
        </div>
     	<%@ include file='../WEB-INF/fragment/footer.jsp' %>
        <div onclick='topFunction()' id='topbutton' class='gotop'><img src="../images/top.png"></div>
        </div>
              
      
        <%} %>
    </body>
</html>