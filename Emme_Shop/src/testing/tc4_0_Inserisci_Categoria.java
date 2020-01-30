package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import control.InsertCategoria;
import control.LoginVenditore;
import manageraccouting.Venditore;
import model.CategoriaDAO;

class tc4_0_Inserisci_Categoria {
	
	InsertCategoria myServlet;
	
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
		myServlet = new InsertCategoria();
	}
	
	@AfterEach
	public void tearDown() throws SQLException {
		CategoriaDAO cat = new CategoriaDAO();
		cat.deleteCategory("Adidas","Biscotti");
	}
	
	
	@Test
	void tc_4_0_1() throws IOException, ServletException{
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("urlLogoCategoria")).thenReturn("images/favicon.ico");
		
		when(request.getParameter("nomeNegozio")).thenReturn("Adidas");
		when(request.getParameter("nomeCategoria")).thenReturn("@Biscotti");
		when(request.getParameter("descCategoria")).thenReturn("descrizione");
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Nome categoria formato errato", output.toString());

	}
	
	
	
	
    /*test inserisci categoria senza errori*/
	@Test
	void tc_4_0_2() throws IOException, ServletException{
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("urlLogoCategoria")).thenReturn("images/favicon.ico");
		
		when(request.getParameter("nomeNegozio")).thenReturn("Adidas");
		when(request.getParameter("nomeCategoria")).thenReturn("Biscotti");
		when(request.getParameter("descCategoria")).thenReturn("descrizione");
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("", output.toString());

	}
	
	
	
	
	
	
	
	
	

}
