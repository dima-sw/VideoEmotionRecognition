package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import model.NegozioDAO;
import model.VenditoreDAO;

class CategoriaDAOTest {
	static Venditore vend;
	static VenditoreDAO model=new VenditoreDAO();
	static Negozio neg;
	static NegozioDAO modeln=new NegozioDAO();
	
	@BeforeAll
	static public void setup()throws Exception {
		vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		model.addVenditore(vend);
		neg=new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		modeln.addNegozio(neg);
	}
	@AfterAll
	static public void remove()throws Exception{
		model.deleteVenditore("Mario");
		
	}
	
	@Test
	void testAddCat() throws Exception{
		Categoria cat=new Categoria();
	}
	
	@Test
	void testGetCat() throws Exception{
		
	}
	
	@Test
	void testGetAllCategoryBySeller() throws Exception{
		
	}
	
	@Test
	void testUpdatePathCat() throws Exception{
		
	}
	
	@Test
	void testUpdateDescrizioneCat() throws Exception{
		
	}
	
	@Test
	void testDeleteCat() throws Exception{
		
	}


}
