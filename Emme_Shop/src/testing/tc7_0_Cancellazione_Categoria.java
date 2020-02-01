package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import control.RemoveCat;
import control.RemoveProd;
import manageraccouting.Utente;
import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import managernegozio.Prodotto;
import model.CategoriaDAO;
import model.NegozioDAO;
import model.ProdottoDAO;
import model.VenditoreDAO;

/**
 * Test Case 7_0_Cancellazione_Categoria
 * @author cetra
 *
 */
class tc7_0_Cancellazione_Categoria {


	RemoveCat myServlet;
	
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
		myServlet = new RemoveCat();
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		model.addVenditore(vend);
		neg=new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		modeln.addNegozio(neg);
		cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		modelc.addCategoria(cat);
		
		
	}
	

	@AfterEach
	public void tearDown() throws SQLException {
		model.deleteVenditore("Mario");
	}
	
	
	@Test
	public void tc_7_0_1() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		Collection<Categoria>categorie;
		categorie=modelc.getAllCategoryBySeller(vend.getNome());
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("utente")).thenReturn((Utente)vend);
		when(session.getAttribute("negozioBean")).thenReturn(neg);
		when(session.getAttribute("negozioNome")).thenReturn(neg.getNomeNegozio());
		when(session.getAttribute("categorie")).thenReturn(categorie);
		
	
		when(request.getParameter("negozio")).thenReturn(neg.getNomeNegozio());
		//when(request.getParameter("username-venditore")).thenReturn(vend.getUsername());
		when(request.getParameter("categoria")).thenReturn(cat.getNomeCategoria());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("OK", output.toString());
		
	}
	
	
	VenditoreDAO model=new VenditoreDAO();
	NegozioDAO modeln=new NegozioDAO();
	CategoriaDAO modelc=new CategoriaDAO();
	Negozio neg;
	Venditore vend;
	Categoria cat;
	
}

