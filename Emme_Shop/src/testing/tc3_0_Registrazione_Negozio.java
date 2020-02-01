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

import control.RegisterNegozio;
import control.RegisterSeller;
import manageraccouting.Venditore;
import managernegozio.Negozio;
import model.VenditoreDAO;

/**
 * Test Case 3_0_Registrazione_Negozio
 * @author cetra
 *
 */
class tc3_0_Registrazione_Negozio {

	RegisterNegozio myServlet;
	Venditore vend;
	VenditoreDAO model=new VenditoreDAO();
	Negozio neg;
	
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
		myServlet = new RegisterNegozio();
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		model.addVenditore(vend);
		neg = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		
	}
	

	@AfterEach
	public void tearDown() throws SQLException {
		model.deleteVenditore("Mario");
	}
	
	
	@Test
	public void tc_3_0_1() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn("A");
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore nome formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_2() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn("Adi#");
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore nome formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_3() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn("#");
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore via formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_4() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn("#");
		when(request.getParameter("CAP")).thenReturn(vend.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore città formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_5() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn("8");
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore cap formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_6() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn("A3432");
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore cap formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_7() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(neg.getCap());
		when(request.getParameter("Piva")).thenReturn("1234");
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore Piva formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_8() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(neg.getCap());
		when(request.getParameter("Piva")).thenReturn("A0000000000");
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore Piva formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_9() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(neg.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn("A");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore descrizione formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_10() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(neg.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn("#asdasda");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore descrizione formato errato", output.toString());
	}
	
	@Test
	public void tc_3_0_11() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("venditore-loggato")).thenReturn("n");
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("color")).thenReturn(neg.getColore());
		when(request.getParameter("design")).thenReturn(neg.getDesign());
		when(request.getParameter("street")).thenReturn(neg.getVia());
		when(request.getParameter("city")).thenReturn(neg.getCitta());
		when(request.getParameter("CAP")).thenReturn(neg.getCap());
		when(request.getParameter("Piva")).thenReturn(neg.getPartitaIva());
		when(request.getParameter("descrizione")).thenReturn(neg.getDescrizione());
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("OK", output.toString());
	}
	
}
