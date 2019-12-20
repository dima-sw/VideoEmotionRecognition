<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*"
    pageEncoding="UTF-8"
    session="true"
%>
<%!	
	String cercato="",cercato1="",cercato2="";
	String username="",tipo=""; 
%>

<%@include file="./WEB-INF/utilities/checkLogRedirect.jsp" %>

<%
	synchronized(session) {
		session = request.getSession();
		
	    username=(String)session.getAttribute("username");
	    cercato = (String)session.getAttribute("cercato");
	    tipo = (String)session.getAttribute("tipo");
	    
	    
		if(cercato!=null && cercato.equals("s")){
			
			if(tipo!=null && tipo.equals("cliente")){
				cercato1="<tr><td ><code>Cliente <b>"+username+"</b> non trovato oppure password errata!</code></td></tr>";
				cercato2="";
			}
			else if(tipo!=null && tipo.equals("venditore")){
				cercato1="";
				cercato2="<tr><td ><code>Venditore <b>"+username+"</b> non trovato oppure password errata!</code></td></tr>";
			}
			session.setAttribute("cercato","n");
		}
		else{
			cercato1="";cercato2="";cercato="";
		}
	
	}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>EmmeShop</title>
        <link rel="icon" href="images/favicon.ico" />
        <meta name='viewport' content='width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0'>
        <link rel='stylesheet' type='text/css' href='css/table2.css'>
        <link rel='stylesheet' type='text/css' href='css/sidenav-nav_top/stile-nav_top.css'>
        <link rel='stylesheet' type='text/css' href='css/sidenav-nav_top/sidenav-nav_top.css'>
        <link rel='stylesheet' type='text/css' href='css/header.css'>
        <link rel='stylesheet' type='text/css' href='css/content.css'>
        <link rel='stylesheet' type='text/css' href='css/footer.css'>
        <link rel='stylesheet' type='text/css' href='css/scrollbar.css'>
        <link rel='stylesheet' type='text/css' href='css/slideshow.css'>
        <link rel='stylesheet' type='text/css' href='css/translate.css'>
        <link rel='stylesheet' type='text/css' href='css/step.css'>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
        <link rel="stylesheet" href='css/tooltip.css' type="text/css">
        
       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/nav/menu-nav_top.js"></script>
        <script type="text/javascript" src="js/top.js"></script>
        <script type="text/javascript" src="js/scrollToDiv.js"></script>
        <script type="text/javascript" src="js/translate.js"></script>
        <script type="text/javascript" src="js/check-chrome.js"></script>
        <script type="text/javascript" src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        <script type="text/javascript" src="js/espressioni_regolari.js"></script>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body onresize='resize()'  id='home' 
    <% if(!cercato.equals("")) {%>
    		onload="closeNav(),scrollToDiv('accedi'),scrollToDivForAll('accedi')"
    <% 
       }
    %>
    //aggiunta per espressioni regolari
    
    
    >
      
        <header>
           <%@ include file="./WEB-INF/fragment/header.jsp" %>
                  
            <div id='mySidenav' class="sidenav">
              <ul >
                <li onclick="closeNav(),scrollToDiv('home'),scrollToDivForAll('home')">
                    Negozi
                </li>
                <li  onclick="closeNav(),scrollToDiv('chisiamo'),scrollToDivForAll('chisiamo')">
                    Chi siamo
                </li>
                <li  onclick="closeNav(),scrollToDiv('registrati'),scrollToDivForAll('registrati')">
                    Registrati
                </li>
                <li  onclick="closeNav(),window.open('seller/sellerRegistration.jsp','_self')">
                  Vendi con noi
                </li>
                <li  onclick="closeNav(),scrollToDiv('accediAdmin'),scrollToDivForAll('accediAdmin')">
                  Area Riservata
                </li>
              </ul>    
            </div>
        </header>
        <div class="content">
                  
              
          <div class="slideshow-container">

            <div class="mySlides fade">
              <img src="<%= getServletContext().getContextPath() %>/images/slideshow/1.jpg">
              <div class="text">McDonald's</div>
            </div>
            
            <div class="mySlides fade">
              <img src="<%= getServletContext().getContextPath() %>/images/slideshow/2.jpg">
              <div class="text">Adidas</div>
            </div>
            
            <div class="mySlides">
              <img src="<%= getServletContext().getContextPath() %>/images/slideshow/3.jpg">
              <div class="text">Book Store</div>
            </div>
            
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
            
            </div>
            <br>
            
           
            <div id='accedi'>
              <div class='login'>
                <form action='Login' method='POST'>
                  <p>
                    <span>Accedi come Cliente</span>
                    <span><input type="text" class='text-input' name="username" value="" placeholder='Username...' required/></span>
                    <span><input type="password" class='text-input' name="password"  placeholder='Password...' required/></span>
                    <input type="hidden" name="azione" value="Cliente"/>
                    <span><input type="submit" class='send-button' value="Accedi"/></span>
                    <span style="font-size:11px"><%=cercato1 %></span>
                  </p>
                </form>
                <form action='Login' method='POST'>
                  <p>
                    <span>Accedi come Venditore</span>
                    <span><input type="text" class='text-input' name="username" placeholder='Username...' value="" required/></span>
                    <span><input type="password" class='text-input' placeholder='Password...' name="password" required/></span>
                    <input type="hidden" name="azione" value="Venditore"/>
                    <span><input type="submit" class='send-button' value="Accedi"/></span>
                    <span style="font-size:11px"><%=cercato2 %></span>
                  </p>
                </form>
              </div>
            </div>  
            <div id='chisiamo'>
             	 <div class="chisiamo" >
             	 <p>
		                EmmeShop &egrave uno strumento molto potente per realizzare il vostro negozio online.
		                Dotato di tutti gli strumenti necessari per realizzare uno shop completo.
		                Combina una notevole semplicit&agrave  d'uso ad uno ottimo aspetto grafico.
             	 </p>
             	 <p>
              			Fino a qualche anno fa la mancanza di contatto con il
						prodotto, l’impossibilità di confrontarsi con un addetto alle
						vendite, i lunghi tempi di attesa e i costi di spedizione
						scoraggiavano gli utenti nel compiere acquisti online.<br>
						Oggi la situazione è completamente diversa:
						trend degli acquisti online sono in costante crescita.<br>
						Sempre più persone scelgono di concludere le proprie
						trattative online, complice anche una maggiore fiducia nel
						trattamento dei dati personali e nei metodi di pagamento.<br><br>
						
						I vantaggi per gli utenti sono innumerevoli:
						 <ul>
							 <li>la comodità di ricevere i prodotti direttamente a casa propria;
							 <li>la possibilità di comparare rapidamente le varie proposte di mercato;
							 <li>il vantaggio di acquistare prodotti difficilmente reperibili nelle proprie città;
							 <li>l’opportunità di usufruire di vantaggiose offerte e sconti promozionali.
						 </ul>
						Realizzare un sito e-commerce porta vantaggi anche alle grandi aziende, ai cosiddetti piccoli
						commercianti e persino ai privati che vogliono mettere in vendita i propri oggetti:
						<ul>
						  <li>attraverso una piattaforma di vendita online chiunque può ottenere una maggiore visibilità;
						  <li>qualunque cliente, da ogni parte del mondo, potrà acquistare prodotti;
						  <li>di conseguenza il venditore vedrà incrementare il fatturato dato che gli verrà offerta la possibilità di ottenere una visibilità in ogni angolo del mondo e non dovrà limitarsi più alla propria città o paese.
						</ul>
						Pertanto l’obiettivo principale del nostro progetto è la realizzazione di una piattaforma web che
						permetta di creare un proprio e-commerce, per aziende o privati.
						
              	</p>
              </div>
              <br>
            </div>  
            <div id='registrati' >
              <form  id="regForm" name="regForm" action="RegisterClient" method="POST"> <!--Fase di realizzazione-->
                <h1>Registrazione Cliente</h1><!-- Deve comparire in ogni statement -->
                
                  <div class="tab"> 
                    <!--Nome e cognome-->
                    <table>
                    <tr>
                    	<td>
                    		<label>Nome</label>
                    	</td>
                        <td>
                        	<input type="text" name="fname" placeholder="Nome..." onblur="isName(document.regForm.fname)" oninput="this.className = ''"> 
                        </td>
                        <td>
                        	<div class="tooltip">
                        		<img class="imageInfo" src="images/info.png" width="20px" >	
  								<span class="tooltiptext">Campo Nome<br>formato: solo lettere.<br> Esempio:Max</span>
							</div> 
						</td>
					</tr>
					<tr>
                        <td>
                        	<label>Cognome</label>
                        </td>
                        <td>
                        	<input type="text" name="lname" placeholder="Cognome..." onblur="isName(document.regForm.lname)" oninput="this.className = ''">
                        </td>
                        <td>
                        	<div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
  								<span class="tooltiptext">Campo Cognome<br>formato: solo lettere.<br>Esempio: Super</span>
							</div>  
                   		</td>
                   	</tr>
                   	<tr>
                   		<td><label>Sesso</label></td>
                   		<td colspan='2'>
	                        <input type="radio" name="gender" id='sesso1' value="M" checked><label for='sesso1'>Uomo&nbsp;</label><br>
	                        <input type="radio" name="gender" id='sesso2' value="F"><label for='sesso2'>Donna</label><br>
	                        <input type="radio" name="gender" id='sesso3' value="other"><label for='sesso3'>Altro&nbsp;&nbsp;&nbsp;</label>
                    	</td>
                    	</tr>
                    	</table>
                    </div>
                    <div class="tab">
                    <table>
                        <tr>
                        	<td>
                        		<label for="Contact Info:">Email</label><!--Contatti--></td>
                        	<td>
                        		<input type="email" name="email" placeholder="E-mail..." onblur="isEmail(document.regForm.email)" oninput="this.className = ''">
                        	</td>
                        	<td>
                        		<div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
		  							<span class="tooltiptext">Campo Email <br>formato: una sola @.<br>Esempio: max@gmail.com</span>
								</div> 
							</td>
						</tr>
						<tr>
							<td>
                        		<label for="">Telefono</label><!--Contatti-->
                        	</td>
                        	<td>
                        		<input type="tel" name="phone" placeholder="Telefono..." onblur="isPhoneNumber(document.regForm.phone)" oninput="this.className = ''">
                        	</td>
                        	<td>
                        		<div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
  								<span class="tooltiptext">Campo Tel <br>formato: 10 cifre.<br>Senza spazi<br>Esempio: 3334567895</span>
								</div>  
							</td>
						</tr>
						</table>
                    </div>
                    <div class="tab"> 
                    <table>
                    	<tr>
                    	
                    		<td>
                    			<label for="Address:">Via</label>	</td> <!--Indirizzo-->
	                         <td>
	                         	<input type="text" name="street" placeholder="Via*" onblur="isStreet(document.regForm.street)" oninput="this.className = ''">
	                         </td>
		                      <td> <div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
		  							<span class="tooltiptext">Campo Strada <br>formato: lettere e cifre <br> senza limiti.<br>Esempio: Via Giovanni XVII</span>
								</div> 
							 </td>
						</tr> 
						<tr>
							<td>
                    			<label for="Address:">Citt&agrave;</label>	</td> <!--Indirizzo-->
	                         <td>
                       			 <input type="text" name="city" placeholder="Citt&agrave*" onblur="isStreet(document.regForm.city)" oninput="this.className = ''">
                       		</td>
                       		<td>
		                        <div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
		  							<span class="tooltiptext">Campo Città <br>formato: lettere e cifre <br> senza limiti.<br>Esempio: Casagiove</span>
								</div> 
							</td>
							</tr>
							<tr>
							<td>
                    			<label for="Address:">Cap</label>	</td> <!--Indirizzo-->
	                         <td>	
                       			 <input type="text" name="CAP" placeholder="CAP*" onblur="isCap(document.regForm.CAP)" oninput="this.className = ''">
                       	 	 </td>
                       	 	 <td>
		                        <div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
		  							<span class="tooltiptext">Campo Cap <br>formato:5 cifre<br>Esempio: 55555</span>
								</div>  
							</td>
							</tr>
							</table>
           	    	</div>
                    <div class="tab">
                    <table>
                        <tr>
                        	<td><label for="Date Access:">Username</label><!--Dati di accesso--></td>
                        	<td><input type="text" name="username" placeholder="Username*" onblur="isUsername(document.regForm.username)" oninput="this.className = ''">
                         	</td>
                         	<td>
		                        <div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
		  							<span class="tooltiptext">Campo Username <br>formato: lettere e numeri <br> min 3, max 16.<br>Esempio: Client980</span>
								</div> 
							</td> 
						</tr>
						<tr>
							<td><label for="Date Access:">Username</label><!--Dati di accesso--></td>
                        	
                        	<td>
                        		<input type="password" name="password" placeholder="Password*" onblur="isPassword(document.regForm.password)" oninput="this.className = ''">
                         	</td>
                         	<td>
		                        <div class="tooltip"><img class="imageInfo" src="images/info.png" width="20px" >	
		  							<span class="tooltiptext">Campo Password <br>formato: almeno lettera minuscola e maiuscola, un numero, carattere speciale <br> min 6, max 25.<br>Esempio: suPer9#</span>
								</div>  
								
							</td>
					     </tr>
					     </table>
                    </div>
                    <!--<br>
                     <input type="submit" value="Submit">-->
            	
              <!--Aggiunte-->
              <br><br><br>
             <div class='steptab' style="overflow:auto;">
                
                    <button type="button" class="verifica" id="prevBtn" onclick="nextPrev(-1)">Indietro</button>
                
                    <button type="button" class="verifica" id="nextBtn"  onclick="nextPrev(1)">Avanti</button>
              
             </div>
             <!-- Circles which indicates the steps of the form: -->
             <div style="text-align:center;margin-top:40px;">
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
             </div>
             
             </form>
             <script src='js/step.js'></script>
            </div>  
            <br>
             <div id='accediAdmin'>
             <br><br><br><br><br><br><br>
              <div class='login'>
              
                <form action='Login' method='POST'>
                  <p>
                  <br><br><br>
                    <span>Area Riservata</span>
                    <span><input type="text" class='text-input' name="username" value="" placeholder='Username...' required/></span>
                    <span><input type="password" class='text-input' name="password"  placeholder='Password...' required/></span>
                    <input type="hidden" name="azione" value="Amministratore"/>
                    <span><input type="submit" class='send-button' value="Accedi"/></span>
                    <span style="font-size:9px"><%=cercato1 %></span>
                  </p>
                </form>
                
              </div>
            </div>  
             <br><br> <br><br><br><br>
                 
        </div>
        
        <%@ include file="./WEB-INF/fragment/footer.jsp" %>

        
      
        
    </body>
</html>