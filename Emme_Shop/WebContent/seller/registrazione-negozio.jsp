<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
    
   <%
   		String UsernameVenditore=(String) session.getAttribute("username-venditore");
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
        <link rel='stylesheet' type='text/css' href='../css/sidenav-nav_top/stile-nav_top.css'>
        <link rel='stylesheet' type='text/css' href='../css/sidenav-nav_top/sidenav-nav_top.css'>
        <link rel='stylesheet' type='text/css' href='../css/header.css'>
        <link rel='stylesheet' type='text/css' href='../css/content.css'>
        <link rel='stylesheet' type='text/css' href='../css/footer.css'>
        <link rel='stylesheet' type='text/css' href='../css/scrollbar.css'>
        <link rel='stylesheet' type='text/css' href='../css/slideshow.css'>
        <link rel='stylesheet' type='text/css' href='../css/translate.css'>
        <link rel='stylesheet' type='text/css' href='../css/step.css'>
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
    

            <div id='vendi' style='padding-top:20px;'>
              	<form id="regForm1" name="regForm1" action="../RegisterNegozio" method="POST"   style='margin:0 auto;'> <!--Fase di realizzazione-->
               			 <h2><center>Creazione Shop</center></h2><!-- Deve comparire in ogni statement -->
		
					    	<div class='tab1'> 
					    		<table>
					    			<tr>
					    				<td>
								    		<label for="">Nome Shop</label>	 <!--Nome e Username-->
								        </td>
								        <td>
								           	<input type="text" name="nomeNegozio" onblur="isUsername(document.regForm1.nomeNegozio)"  placeholder=" Nome Shop...">
									    </td>
									    <td>       	
			    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext">Campo Nome <br>negozio formato: lettere e numeri <br> min 3, max 16.<br>Esempio: Client980</span>
											</div> 
										</td>
									</tr>
									<tr>
										<td>
								    		<label for="">Venditore</label>	 <!--Nome e Username-->
								        </td>
										<td>
								            <input type="text" name="usernameVenditore" value="<%=UsernameVenditore%>" readonly >
								        </td>
								        <td>    
			    	                	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext">Campo automatico</span>
											</div> 
										</td>
									</tr>
								</table>
					        </div>
					        
					        <div class='tab1'>	  
					        	<table>
					        		<tr>
					        		 	<td>
								            <label for="Colore sfumature:">Colore</label>
										</td>
										<td>	            
								            <input type="radio" name="color" id='color1' value="Verde" checked><label for='color1'><input type="color" name="favColor" value="#32CD32" disabled></label> 
								            <input type="radio" name="color" id='color2' value="Blue"> <label for='color2'><input type="color" name="favColor" value="#0000FF" disabled></label>
								            <input type="radio" name="color" id='color3' value="Yellow"> <label for='color3'><input type="color" for='color3' name="favColor" value="#FFFF00" disabled></label>
								        	
								        </td>
								    </tr>
								    <tr>   
								    	<td><label>Design menù</label></td>
										<td>			
								            <input type="radio" name="design" id='design1' value="top" checked> <label for='design1'><img src='../images/utilities/top.PNG' style='max-width:250px;width:40%;border:1px dashed #141414;'></label>
								            <br><input type="radio" name="design" id='design2' value="left" checked> <label for='design2'><img src='../images/utilities/left.PNG' style='max-width:250px;width:40%;border:1px dashed #141414;'> </label>
								            
										</td>
									</tr>
								</table>
					         </div>
					        
					        <div class='tab1'> 
					        	<table>
					        		<tr>
					        			<td>
								    		<label for="Address:">Via</label>	 <!--Indirizzo-->
										</td>
										<td>	           	
								           	<input type="text" name="street" onblur="isStreet(document.regForm1.street)" placeholder="Via*">
									     </td>
									     <td>      	
			                	    	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext">Campo Strada <br>formato: lettere e cifre <br> senza limiti.<br>Esempio: Via Giovanni XVII</span>
											</div>  
										 </td>
									</tr>
									<tr>
										<td>
								    		<label for="">Citt&agrave;</label>	 <!--Indirizzo-->
										</td>
										<td>
								            <input type="text" name="city"onblur="isStreet(document.regForm1.city)" placeholder="Citt&agrave*">
									    </td>
									    <td>        
			                    		    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext">Camppo Città <br>formato: lettere e cifre <br> senza limiti.<br>Esempio: Casagiove</span>
											</div>  
										</td>
									</tr>
									<tr>
										<td>
								    		<label for="">Cap</label>	 <!--Indirizzo-->
										</td>
										<td>
								            <input type="text" name="CAP" onblur="isCap(document.regForm1.CAP)" placeholder="CAP*">
								        </td>
								        <td>	 
			                		        <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext">Campo Cap <br>formato:5 cifre<br>Esempio: 55555</span>
											</div>  
										</td>
									</tr>
								</table>
					        </div>
					    	
					        <div class='tab1'>
					        	<table>
					        		 <tr>
					        		 	<td>
								            <label for="Info negozio:">Partita IVA</label>
										</td>
										<td>
								            <input type="text" name="Piva" onblur="isPivaIT(document.regForm1.Piva)" placeholder="P.iva...">
								        </td>
								        <td>      
			                    		    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext"> Partita-iva formato:11 cifre<br>Esempio: 54353265306</span>
											</div> 
										</td>
									</tr>
									
									<tr>
										<td>
								            <label for="Info negozio:">Breve descrizione</label>
										</td>
										<td>
								        	<textarea name="descrizione" onblur="isText(document.regForm1.descrizione)" placeholder="Inserisci la descrizione per catturare il massimo numero di clienti..." ></textarea>
								        </td>
								        <td>	 
			                       			 <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
			  									<span class="tooltiptext">  formato: min 10 caratteri<br>max 500</span>
											</div>  
										</td>
									</tr>
								</table>
					        </div>
					       
					         <br><br><br>
                      <div class='steptab1' style="overflow:auto;">
	                  <div style='text-align:center'>
	                  		<button type="button" class="verifica" id="prevBtn1" onclick="nextPrev(-1)">Indietro</button>
							<button type="button" class="verifica" id="nextBtn1" onclick="nextPrev(1)">Avanti</button>
					  </div>
              
              <br>
             <!-- Circles which indicates the steps of the form: -->
             <div style="text-align:center;margin-top:40px;">
                <span class="step1"></span>
                <span class="step1"></span>
                <span class="step1"></span>
                <span class="step1"></span>
             </div>
                </form>
                
            </div>  
            <script src='../js/step1.js'></script>
              
        <br><br>
        <br><br>
        <br><br>   
        </div>
     	<%@ include file='../WEB-INF/fragment/footer.jsp' %>
        <div onclick='topFunction()' id='topbutton' class='gotop'><img src="../images/top.png"></div>
        </div>
              
      
        
    </body>
</html>