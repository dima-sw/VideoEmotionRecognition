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

import control.InsertProduct;
import control.RegisterSeller;
import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import model.CategoriaDAO;
import model.NegozioDAO;
import model.VenditoreDAO;

class tc5_0_Inserisci_Prodotto {
	InsertProduct myServlet;
	VenditoreDAO model=new VenditoreDAO();
	CategoriaDAO modelcat = new CategoriaDAO();
	NegozioDAO modelneg = new NegozioDAO();
	Venditore vend;
	Negozio negozio;
	Categoria cat;
	
	
	
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
		myServlet = new InsertProduct();
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		model.addVenditore(vend);
		negozio=new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		modelneg.addNegozio(negozio);
		cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		modelcat.addCategoria(cat);
	}
	
	
	@AfterEach
	public void tearDown() throws SQLException {
		model.deleteVenditore("Mario");
		modelcat.deleteCategory("Pacifico", "Biscotti");
		modelneg.deleteShop("Pacifico");
	}
	
	
	/*Completare non funziona*/
	@Test
	void tc5_0_1() throws IOException, ServletException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
	
		when(request.getParameter("nomeNegozio")).thenReturn(negozio.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		when(request.getParameter("nomeProdotto")).thenReturn("");
		when(request.getParameter("ivaProdotto")).thenReturn("22");
		when(request.getParameter("prezzoProdotto")).thenReturn("24.99");
		when(request.getParameter("qtaProdotto")).thenReturn("100");
		when(request.getParameter("scontoProdotto")).thenReturn("20");
		
		

		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Nome prodotto non rispetta il formato", output.toString());
		
		
		
	}
	
	
	

	
}
