<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*,managernegozio.*,java.util.*"
    pageEncoding="UTF-8"
    session="true"
%>

<%!  Negozio neg=null;
	 Categoria cat = null;	
%>
<%	
	neg = (Negozio)	request.getSession().getAttribute("negozioBean");
	cat = (Categoria) request.getSession().getAttribute("categoriaNegozio");
	
	if(neg !=null && cat!=null) {
	
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
        
        <script type="text/javascript" src="../js/espressioni_regolari.js"></script>
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
    

            <div id='vendi' style='padding-top:10px;'><br><br>
              	<form id="regForm1" name="regForm1" action="../UpdateCategoria" method="POST"   style='margin:0 auto;'> <!--Fase di realizzazione-->
                  <h2><center>Modifica categoria</center></h2><!-- Deve comparire in ogni statement -->
                  
                    <div class="tab1"> 
                    <table>
                    <tr>
                    	<td ><label for="Name:">Negozio </label>	 </td>
                          <td><input type="text" name="nomeNegozio" value='<%=neg.getNomeNegozio()%>'  readonly></td>
					            
    	                	   <td> <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
  									<span class="tooltiptext">  Campo automatico</span>
								</div>  
								</td>
					</tr>
					<tr>
						<td>
							<label for="Name:">Categoria </label></td>			
						<td>
							<input type="text" name="nomeCategoria" value='<%=cat.getNomeCategoria()%>' placeholder=" Nome Categoria..." readonly></td>
							           	
    	               	    <td><div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
  								<span class="tooltiptext"> Campo Automatico</span>
							</div> </td> 
						</tr>		 
                      <tr>
                      <td><label for="Name:">Descrizione </label>	 <!--Nome e cognome--></td>
                         <td> <input type="text" name="descCategoria" onblur="isText(document.regForm1.descCategoria)" value="<%= cat.getDescrizione() %>" placeholder=" Descrizione Categoria..">   	
    	                </td>
    	                <td>	    <div class="tooltip"><img class="imageInfo" src="../images/info.png" width="20px" >	
  									<span class="tooltiptext"> Descrizione categoria formato:<br> min 10 mac 500 caratteri</span>
								</div> </td>
						</tr></table>		
								<input type="hidden" name="path" value="<%= cat.getPath() %>">
                          <br><br>
                         
                      <div class='steptab1' style="overflow:auto;">
                      <div style='text-align:center'> 
			                    <button type="button" class="verifica" id="prevBtn1" onclick="nextPrev(-1)">Indietro</button>
				                <button type="submit" class="verifica" id="nextBtn1" onclick="nextPrev(1)">Avanti</button>
              		  </div>
             </div>
         
             
             <br><br><br>
             <!-- Circles which indicates the steps of the form: -->
             
                </form>
                
            </div>  
            <script src='../js/step1.js'></script>
                 
                  <script type="text/javascript">
                 document.getElementById("nextBtn1").innerHTML = "Invia Modifiche";
              	
              </script>
                 
        </div>
       	
        <%@ include file="../WEB-INF/fragment/footer.jsp" %>
        <div onclick='topFunction()' id='topbutton' class='gotop'><img src="../images/top.png"></div>
        </div>
        <%} %>
    </body>
</html>