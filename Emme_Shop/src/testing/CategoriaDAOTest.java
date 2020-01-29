package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import model.CategoriaDAO;
import model.NegozioDAO;
import model.VenditoreDAO;

class CategoriaDAOTest {
	static Venditore vend;
	static VenditoreDAO modelv=new VenditoreDAO();
	static Negozio neg;
	static NegozioDAO modeln=new NegozioDAO();
	static CategoriaDAO model=new CategoriaDAO();
	
	@BeforeAll
	static public void setup()throws Exception {
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		modelv.addVenditore(vend);
		neg=new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		modeln.addNegozio(neg);
	}
	@AfterAll
	static public void remove()throws Exception{
		modelv.deleteVenditore("Mario");
		modeln.deleteShop("Pacifico");
	}
	
	@Test
	void testAddCat() throws Exception{
		try {
			Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
			model.addCategoria(cat);
			assertEquals("Pacifico",model.getCategoria("Pacifico", "Biscotti").getNomeNegozio());
			assertEquals("Biscotti",model.getCategoria("Pacifico", "Biscotti").getNomeCategoria());
		} finally {
			model.deleteCategory("Pacifico", "Biscotti");
		}
	}
	
	@Test
	void testGetCat() throws Exception{
		try {
			Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
			model.addCategoria(cat);
			assertEquals("Biscotti",model.getCategoria("Pacifico", "Biscotti").getNomeCategoria());
		} finally {
			model.deleteCategory("Pacifico", "Biscotti");
		}
	}
	
	@Test
	void testGetAllCategoryBySeller() throws Exception{
		try {
			Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
			model.addCategoria(cat);
			assertEquals(1,model.getAllCategoryBySeller("Mario").size());
		} finally {
			model.deleteCategory("Pacifico", "Biscotti");
		}
	}
	
	@Test
	void testUpdatePathCat() throws Exception{
		try {
			Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
			model.addCategoria(cat);
			model.updatePathCategoria("Pacifico", "Biscotti", "path/biscuits");
			assertEquals("path/biscuits",model.getCategoria("Pacifico", "Biscotti").getPath());
		} finally {
			model.deleteCategory("Pacifico", "Biscotti");
		}
	}
	
	@Test
	void testUpdateDescrizioneCat() throws Exception{
		try {
			Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
			model.addCategoria(cat);
			model.updateDescrizioneCategoria("Pacifico", "Biscotti", "Desc");
			assertEquals("Desc",model.getCategoria("Pacifico", "Biscotti").getDescrizione());
		} finally {
			model.deleteCategory("Pacifico", "Biscotti");
		}
	}
	

}
