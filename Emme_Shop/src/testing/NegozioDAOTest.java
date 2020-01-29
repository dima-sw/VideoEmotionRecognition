package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manageraccouting.Venditore;
import managernegozio.Negozio;
import model.NegozioDAO;
import model.VenditoreDAO;


class NegozioDAOTest {
	private static NegozioDAO model=new NegozioDAO();
	private static Connection connection;
	
	
	
	@BeforeAll
	 static public void setUp() throws Exception {
		 VenditoreDAO modelVenditore=new VenditoreDAO();
		 modelVenditore.addVenditore(new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100"));
	}


	@Test
	void testGetNegozio() throws Exception {
		try {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		model.addNegozio(negozio);
		
		Negozio test = model.getNegozio(negozio.getUsernameVenditore());
		
		assertEquals(negozio.getUsernameVenditore(),test.getUsernameVenditore());
		
		}finally{
			model.deleteShop("Pacifico");
		}
		
		
	}
	
	
	@Test
	void testAddNegozio() throws Exception {
		try {
			Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
			model.addNegozio(negozio);
			assertEquals(negozio.getNomeNegozio(), model.getNegozio("Mario").getNomeNegozio());
		}finally {
			model.deleteShop("Pacifico");
		}
	}
	
	@Test
	void testUpdateLogoNegozio() throws Exception {
		try {
			Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
			boolean result = model.updateLogoNegozio(negozio.getNomeNegozio(), negozio.getLogo());
			assertTrue(result);
		}finally {
			model.deleteShop("Pacifico");
		}
	}
	
	
	

	@Test
	void getNegozioByName() throws Exception {
		try {
			Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
			model.addNegozio(negozio);
			Negozio test = model.getNegozioByName(negozio.getNomeNegozio());
			assertEquals(negozio.getNomeNegozio(),test.getNomeNegozio());
		}finally {
			model.deleteShop("Pacifico");
		}
		
	}
	
	
	
	
	
	
	
	
	
	@AfterAll
	static public void remove() throws Exception  {
		 VenditoreDAO modelVenditore=new VenditoreDAO();
		 modelVenditore.deleteVenditore("Mario");
		 
	}
	

}
