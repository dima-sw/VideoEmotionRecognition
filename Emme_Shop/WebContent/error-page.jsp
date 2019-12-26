<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!String error = ""; 
%>

<% 

	error = (String) request.getSession().getAttribute("messaggioerrore"); 

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
<h1>D'oh!</h1>
<p><%=error%></p>

<a href="#"><img src="https://img.icons8.com/android/24/000000/jog-reverse.png">Riprova</a>
</div>

<div class="image">
<img id="homer" src="images/simpsons_PNG94.png">
</div>




</div>

</body>
</html>