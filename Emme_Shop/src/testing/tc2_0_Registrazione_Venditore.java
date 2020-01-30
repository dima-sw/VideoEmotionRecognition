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

import control.LoginVenditore;
import control.RegisterSeller;
import manageraccouting.Utente;
import manageraccouting.Venditore;
import model.VenditoreDAO;

class tc2_0_Registrazione_Venditore {

	RegisterSeller myServlet;
	Venditore vend;
	VenditoreDAO model=new VenditoreDAO();
	
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
		myServlet = new RegisterSeller();
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
			
	}
	

	@AfterEach
	public void tearDown() throws SQLException {
		model.deleteVenditore("Mario");
	}
	
	
	@Test
	public void tc_2_0_1() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn("");
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore nome formato errato", output.toString());
	}

	@Test
	public void tc_2_0_2() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
	
		when(request.getParameter("fname")).thenReturn("123");
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore nome formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_3() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn("");
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore cognome formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_4() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn("123");
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore cognome formato errato", output.toString());
	}

	@Test
	public void tc_2_0_5() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn("c@asd");
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore email formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_6() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn("000");
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore telefono formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_7() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn("aaaaaaaaaa");
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore telefono formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_8() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn("");
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore via formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_9() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn("");
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore città formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_10() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn("8");
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore cap formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_11() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn("8510E");
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore cap formato errato", output.toString());
	}

	@Test
	public void tc_2_0_12() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn("M");
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore username formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_13() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn("_Mario");
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore username formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_14() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn("Pas");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore password formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_15() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn("Password0");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore password formato errato", output.toString());
	}
	
	@Test
	public void tc_2_0_16() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		

		when(request.getParameter("fname")).thenReturn(vend.getNome());
		when(request.getParameter("lname")).thenReturn(vend.getCognome());
		when(request.getParameter("gender")).thenReturn(vend.getSesso());
		when(request.getParameter("email")).thenReturn(vend.getEmail());
		when(request.getParameter("phone")).thenReturn(vend.getTelefono());
		when(request.getParameter("street")).thenReturn(vend.getVia());
		when(request.getParameter("city")).thenReturn(vend.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("username")).thenReturn(vend.getUsername());
		when(request.getParameter("password")).thenReturn(vend.getPassword());
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("OK", output.toString());
	}
}
