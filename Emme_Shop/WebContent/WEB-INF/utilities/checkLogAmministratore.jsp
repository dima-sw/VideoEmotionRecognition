<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*,manageraccouting.*"
    pageEncoding="UTF-8"
    session="true"
%>
<%!	
	String loggatoLog;
	String usernameLog; 
	String tipoLog;  
	Utente utenteLog;
	String requestURI;
%>	
<%
	synchronized(session) {
		session = request.getSession();
		
		loggatoLog=(String)session.getAttribute("amministratore-loggato");
		if(loggatoLog!= null && loggatoLog.equals("s") ){
			utenteLog=(GestoreAccouting)session.getAttribute("utente");
			usernameLog=utenteLog.getUsername();
			tipoLog="Amministratore";
			//response.sendRedirect("./WEB-INF/login-result/index-amminstratore.jsp");
		}
		else{
				requestURI = request.getRequestURI(); 
				if(!requestURI.equals("/emmeShop/index.jsp"))
					response.sendRedirect("http://localhost:8080/emmeShop/index.jsp");
		}
					
	}	
			
	%>