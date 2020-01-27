<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%!String error = ""; 
String href="";
%>
<% 
	error = (String) request.getSession().getAttribute("messaggioerrore"); 
	href=(String) request.getSession().getAttribute("redirecterror");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type='text/css' href="css/style.css">
<meta charset="ISO-8859-1">
<title>error</title>
</head>
<body>
<div class="cointaner">
<div class="sub-container">
<h2 id="title">D'oh!</h2>
<p><%=error%></p>

<span><a href="<%=href%>"><img src="https://img.icons8.com/android/24/000000/jog-reverse.png">Riprova</a></span>

</div>

<div class="image">
<img id="homer" src="images/simpsons_PNG94.png">
</div>




</div>

        <%@ include file="./WEB-INF/fragment/footer.jsp" %>

        

</body>
</html>