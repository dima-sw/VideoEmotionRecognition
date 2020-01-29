package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import managernegozio.Prodotto;
import model.CategoriaDAO;
import model.NegozioDAO;
import model.ProdottoDAO;
import model.VenditoreDAO;

class ProdottoDAOTest {
	
	static Venditore vend;
	static VenditoreDAO modelv=new VenditoreDAO();
	static Negozio neg;
	static NegozioDAO modeln=new NegozioDAO();
	static CategoriaDAO modelc=new CategoriaDAO();
	static Categoria cat;
	static ProdottoDAO modelp = new ProdottoDAO();
	
	@BeforeAll
	static public void setup()throws Exception {
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		modelv.addVenditore(vend);
		neg=new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		modeln.addNegozio(neg);
		cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		modelc.addCategoria(cat);
	}
	

	@AfterAll
	static public void remove()throws Exception{
		modelv.deleteVenditore("Mario");
		modeln.deleteShop("Pacifico");
		modelc.deleteCategory("Pacifico", "Biscotti");
	}
	
	@Test
	void testGetPathByID() throws Exception{
		int id=0;
		try {
		Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		id=modelp.getIDProd("Biscotti","Pacifico","ringo");
		assertEquals(prod.getPath(),modelp.getPathByID(id));
		}finally {
			modelp.deleteProduct(id);
		}
	}
	
	@Test
	void testGetAllProductBySellerCat() throws Exception{
		int id=0;
		try {
		Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		id=modelp.getIDProd("Biscotti","Pacifico","ringo");
		
		
		assertEquals(1,modelp.getAllProductBySellerCategory("Mario", "Biscotti").size());
		}finally {
			modelp.deleteProduct(id);
		}
	}
	
	@Test
	void testAddProdotto() throws Exception{
		int id=0;
		try {
		Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		id=modelp.getIDProd("Biscotti","Pacifico","ringo");
		if(id==0)
			fail("Errore prodotto non inserito");
		}finally {
			modelp.deleteProduct(id);
		}
	}

	
	@Test
	void testDeleteProduct() throws Exception{
		int id=0;
		try {
		Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		id=modelp.getIDProd("Biscotti","Pacifico","ringo");
		boolean result = modelp.deleteProduct(id);
		assertTrue(result);
		}finally {
			modelp.deleteProduct(id);
		}
	}
	
	@Test
	void testGetProductById() throws Exception {
		int id=0;
		try {
		Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		id=modelp.getIDProd("Biscotti","Pacifico","ringo");
		Prodotto actual = modelp.getProductById(id);
		assertEquals(id,actual.getIdProdotto());
		}finally {
			modelp.deleteProduct(id);
		}
		
	}
	
	@Test
	void testUpdateProdotto() throws Exception{
		int id=0;
		try {
		Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		modelp.addProdotto(prod);
		id=modelp.getIDProd("Biscotti","Pacifico","ringo");
		Prodotto prod2=new Prodotto(id,"Pacifico","Biscotti","Mileb",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		assertTrue(modelp.updateProdotto(prod2));
		}finally {
			modelp.deleteProduct(id);
		}
		
	}
	
	
	
	@Test
	void  testUpdatePathProdotto() throws Exception{
		int id = 0;
		try {
			
			Prodotto prod= new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
			modelp.addProdotto(prod);
			id = modelp.getIDProd(prod.getNomeCategoria(),prod.getNomeNegozio(),"ringo");
			assertTrue( modelp.updatePathProdotto(prod.getNomeNegozio(), prod.getNomeCategoria(),id,prod.getPath()));
		}finally {
			modelp.deleteProduct(id);
		}
		
	}
	




}
