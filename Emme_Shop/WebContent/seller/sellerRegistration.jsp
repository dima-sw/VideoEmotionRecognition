<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
        <script type="text/javascript" src="../js/espressioni_regolari.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="../js/nav/menu-nav_top.js"></script>
        <script type="text/javascript" src="../js/top.js"></script>
        <script type="text/javascript" src="../js/scrollToDiv.js"></script>
        <script type="text/javascript" src="../js/translate.js"></script>
        <script type="text/javascript" src="../js/check-chrome.js"></script>
        <script type="text/javascript" src="http://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body onresize='resize()'  id='home' > 
    

            <div id='vendi' style='padding-top:10px;'>
              	<form id="regForm1" name="regForm1" action="../RegisterSeller" method="POST"   style='margin:0 auto;'> <!--Fase di realizzazione-->
                  <h2><center>Vendi con noi</center></h2><!-- Deve comparire in ogni statement -->
                  
                    <div class="tab1">  
                      <table>
                      	<tr>
                      		<td>
                      			<label for="Name:">Nome</label>	 <!--Nome e cognome-->
                      		</td>
                      		<td>
 	                         <input type="text" name="fname" onblur="isName(document.regForm1.fname)" placeholder="Nome...">
    						</td>
    						<td>                         
	                       	 	<div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
	  								<span class="tooltiptext">Campo Nome <br>formato: solo lettere.<br> Esempio:Max</span>
								</div>  
							</td>
						</tr>
						<tr>
						
							<td>
								<label for="">Cognome</label>	 <!--Nome e cognome-->
                      		</td>
							<td>
                          		<input type="text" name="lname" onblur="isName(document.regForm1.lname)" placeholder="Cognome...">
                   	       	</td>
		                   	<td>       	
		                   	     <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
		  								<span class="tooltiptext">Campo Cognome <br>formato: solo lettere.<br>Esempio: Super</span>
									</div>  
							</td>
						</tr>
						<tr>
							<td><label>Sesso</label></td>
                   			<td colspan='2'>	
		                          <input type="radio" id='sesso11' name="gender" value="M" checked><label for='sesso11'>Uomo&nbsp;</label><br>
		                          <input type="radio" id='sesso12' name="gender" value="F"><label for='sesso12'>Donna<br></label>
		                          <input type="radio" id='sesso13' name="gender" value="other"><label for='sesso13'>Altro&nbsp;&nbsp;</label>
                      		</td>
                      	</tr>
                      	</table>
                      </div>
                      <div class="tab1">
                       <table>
                       	<tr>
                       	 <td>
                          <label for="Contact Info:">Email</label><!--Contatti-->
                         </td>
                         <td>
                          <input type="email" name="email" onblur="isEmail(document.regForm1.email)" placeholder="E-mail...">
                      	 </td>
                      	 <td>  
	                       	 <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
	  								<span class="tooltiptext">Campo Email <br>formato: <br> una sola @.<br>Esempio: max@gmail.com</span>
								</div>  
						 </td>
						</tr>
						<tr>
						 <td>
                          <label for=" ">Telefono</label><!--Contatti-->
                         </td>
						  <td>	
                  	         <input type="tel" name="phone" onblur="isPhoneNumber(document.regForm1.phone)" placeholder="Telefono...">
                    	  </td>
                    	  <td>
                    	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
  								<span class="tooltiptext">Campo Tel <br>formato: 10 cifre.<br>Senza spazi<br>Esempio: 3334567895</span>
							</div>  
						  </td>
						 </tr>
						</table>
           	          </div>
                    <div class="tab1"> 
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
                          <input type="text" name="city" onblur="isStreet(document.regForm1.city)" placeholder="Citt&agrave*">
                       </td>
                       <td>   
                	        <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
  								<span class="tooltiptext">Campo Città <br>formato: lettere e cifre <br> senza limiti.<br>Esempio: Casagiove</span>
							</div>  
						</td>
						
					</tr>
					<tr>
					    <td>
                      		<label for="">CAP</label>	 <!--Indirizzo-->
                       </td>
						<td>
                          <input type="text" name="CAP" onblur="isCap(document.regForm1.CAP)" placeholder="CAP*">
                      	</td>
                      	<td>	
        	                <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
  								<span class="tooltiptext">Campo Cap<br>formato:5 cifre<br>Esempio: 55555</span>	
							</div>  
						</td>
					   </tr>
					   </table>
                      </div>
                      <div class="tab1">
                        <table>
                          <tr>
                            <td>
                              <label for="Date Access:">Username</label><!--Dati di accesso-->
                            </td>
                          	<td>
                          		<input type="text" name="username" onblur="isUsername(document.regForm1.username)" placeholder="Username*">
                     	    </td>
                     	    <td>
	                    	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
	  								<span class="tooltiptext">Campo Username <br>formato: lettere e numeri <br> min 3, max 16.<br>Esempio: Client980</span>
								</div>
							</td>
						   </tr>
						   <tr>
							<td>
							   <label for="Date Access:">Password</label><!--Dati di accesso-->
                            </td>
						   <td>
                          		<input type="password" name="password" onblur="isPassword(document.regForm1.password)" placeholder="Password*">
                	      	</td> 
	                	     <td>
	                	       <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
	  								<span class="tooltiptext">Campo Password <br>formato: almeno lettera minuscola e maiuscola, un numero, carattere speciale <br> min 6, max 25.<br>Esempio: suPer9#</span>
								</div>  
							</td>
							</tr>
							</table>
                	      </div>
                      <br>
                      <div class='steptab1' style="overflow:auto;">
                      <div style='text-align:center'> 
			                    <button type="button" class="verifica" id="prevBtn1" onclick="nextPrev(-1)">Indietro</button>
				                <button type="button" class="verifica" id="nextBtn1" onclick="nextPrev(1)">Avanti</button>
              		  </div>
             </div>
             
             <br><br><br>
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
                 
                 
                 
        </div>
        <%@include file='../WEB-INF/fragment/footer.jsp' %>
        <div onclick='topFunction()' id='topbutton' class='gotop'><img src="../images/top.png"></div>
        </div>
              
      
        
    </body>
</html>