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
	
		loggatoLog=(String)session.getAttribute("cliente-loggato");
		
		
		if(loggatoLog != null && loggatoLog.equals("s") ){
			utenteLog=(Cliente)session.getAttribute("utente");
			usernameLog=utenteLog.getUsername();
			tipoLog="Cliente";
			response.sendRedirect("./cliente/index-cliente.jsp");
		}
		
		loggatoLog=(String)session.getAttribute("venditore-loggato");
		if(loggatoLog != null && loggatoLog.equals("s") ){
			utenteLog=(Venditore)session.getAttribute("utente");
			usernameLog=utenteLog.getUsername();
			tipoLog="Venditore";
			response.sendRedirect("./venditore/index-venditore.jsp");
		}

		loggatoLog=(String)session.getAttribute("amministratore-loggato");
		if(loggatoLog!= null && loggatoLog.equals("s") ){
			utenteLog=(GestoreAccouting)session.getAttribute("utente");
			usernameLog=utenteLog.getUsername();
			tipoLog="Amministratore";
			response.sendRedirect("./amministratore/index-amminstratore.jsp");
		}
		
		requestURI = request.getRequestURI(); 
		if(!requestURI.equals("/emmeShop/index.jsp"))
			response.sendRedirect("./index.jsp");
	}	
			
	%>