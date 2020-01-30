package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import control.LoginVenditore;
import manageraccouting.Venditore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mock;


class tc1_0_Login_Venditore {

	LoginVenditore myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;

	
	@BeforeEach
	public void setUp() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new LoginVenditore();
		
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		model.addVenditore(vend);
	}
	

	@AfterEach
	public void tearDown() throws SQLException {
		
	}
	
	
	@Test
	public void tc_1_0_1() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getParameter("username")).thenReturn("aaaaa");
		when(request.getParameter("password")).thenReturn("Password0#");
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore utente non trovato", output.toString());
		
	}
	
	@Test
	public void tc_1_0_2() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getParameter("username")).thenReturn("Mario");
		when(request.getParameter("password")).thenReturn("aaaaa");
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore utente non trovato", output.toString());
		
	}
	
	
	
}
