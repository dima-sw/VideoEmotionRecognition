<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
    
   <%
   		String urlLogo=(String)  session.getAttribute("urlLogoNegozio");
        if(urlLogo==null){
        	urlLogo="";
        	response.sendRedirect("../index.jsp");
        }
   %>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Cache-Control" content="no-store" />
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>EmmeShop</title>
        <link rel="icon" href="../images/favicon.ico" />
        <meta name='viewport' content='width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0'>
        <link rel='stylesheet' type='text/css' href='../css/table.css'>
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
              	<form id="regForm1" action="../upload" method="POST"  enctype="multipart/form-data"  style='margin:0 auto;'> <!--Fase di realizzazione-->
                  <h2><center>Vendi con noi</center></h2><!-- Deve comparire in ogni statement -->
                  
                    <div class="tab1"> 
                    	<img src="../<%=urlLogo %>" style="max-width:300px; width:50%;">
                     
                       <br><br>
                       <h3> Cambia logo sito! </h3>
				            <form action="upload" method="post" enctype="multipart/form-data">
				               <input type="file" name="file"  /><br><br><br>
				                <input type="submit" value="Carica Immagine" class="acquista-btn"/>
				            </form>  
				            
				            
				            <br><br>oppure<br><br><a href='../index.jsp#accedi'>Registrazione Completata...</a>
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