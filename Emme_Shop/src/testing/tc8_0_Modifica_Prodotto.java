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

import control.RemoveProd;
import control.UpdateProdotto;
import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import managernegozio.Prodotto;
import model.CategoriaDAO;
import model.NegozioDAO;
import model.ProdottoDAO;
import model.VenditoreDAO;

/**
 * Test Case 8_0_Modifica_Prodotto
 * @author cetra
 *
 */
class tc8_0_Modifica_Prodotto {

UpdateProdotto myServlet;
	
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
		myServlet = new UpdateProdotto();
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		model.addVenditore(vend);
		neg=new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		modeln.addNegozio(neg);
		cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		modelc.addCategoria(cat);
		prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		
	}
	

	@AfterEach
	public void tearDown() throws SQLException {
		model.deleteVenditore("Mario");
	}
	
	
	@Test
	public void tc_8_0_1() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn("");
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore nome formato errato", output.toString());
		
	}
	
	@Test
	public void tc_8_0_2() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn("classic@");
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore nome formato errato", output.toString());
		
	}
	
	@Test
	public void tc_8_0_3() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn("bel");
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore descrizione formato errato", output.toString());
		
	}
	
	@Test
	public void tc_8_0_4() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn("bello#");
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore descrizione formato errato", output.toString());
		
	}
	
	@Test
	public void tc_8_0_5() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn("25");
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore prezzo formato errato", output.toString());
		
	}
	
	@Test
	public void tc_8_0_6() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(222));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore iva formato errato", output.toString());
		
	}
	
	@Test
	public void tc_8_0_7() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn("2@");
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore quantità formato errato", output.toString());
		
	}
	

	@Test
	public void tc_8_0_8() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(233));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("Errore sconto formato errato", output.toString());
		
	}
	

	@Test
	public void tc_8_0_9() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("Biscotti","Pacifico","ringo");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		when(session.getAttribute("urlLogoProdotto")).thenReturn(cat.getPath());
		when(session.getAttribute("nomeProdottoImage")).thenReturn(prod.getIdProdotto());
		when(session.getAttribute("nomeProdottoCat")).thenReturn(prod.getNomeCategoria());
		
	
		when(request.getParameter("id")).thenReturn(String.valueOf(id));
		when(request.getParameter("nomeNegozio")).thenReturn(neg.getNomeNegozio());
		when(request.getParameter("nomeCategoria")).thenReturn(cat.getNomeCategoria());
		

		when(request.getParameter("nomeProdotto")).thenReturn(prod.getNome());
		when(request.getParameter("descProdotto")).thenReturn(prod.getDescrizione());
		when(request.getParameter("prezzoProdotto")).thenReturn(String.valueOf(prod.getPrezzo()));
		when(request.getParameter("ivaProdotto")).thenReturn(String.valueOf(prod.getIva()));
		when(request.getParameter("qtaProdotto")).thenReturn(String.valueOf(prod.getQuantita()));
		when(request.getParameter("scontoProdotto")).thenReturn(String.valueOf(prod.getSconto()));
		

		when(request.getParameter("path")).thenReturn(prod.getPath());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("OK", output.toString());
		
	}
	
	
	VenditoreDAO model=new VenditoreDAO();
	NegozioDAO modeln=new NegozioDAO();
	ProdottoDAO modelp=new ProdottoDAO();
	CategoriaDAO modelc=new CategoriaDAO();
	Negozio neg;
	Venditore vend;
	Categoria cat;
	Prodotto prod;

}
