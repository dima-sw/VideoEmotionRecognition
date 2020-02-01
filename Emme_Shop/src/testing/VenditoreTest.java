package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import manageraccouting.Venditore;
import model.VenditoreDAO;

/**
 * Test di unita Venditore
 * @author cetra
 *
 */
class VenditoreTest {
	static VenditoreDAO model= new VenditoreDAO();
	
	@Test
	void testVenditoreIsEmpty() {
		Venditore vd=new Venditore();
		assertNotNull(vd);
	}
	
	@Test 
	void testGetNome() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("Mario", vend.getNome());
	}

	@Test 
	void testSetNome() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setNome("Romolo");
		assertEquals("Romolo", vend.getNome());
	}
	
	@Test 
	void testGetCognome() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("Cetrangolo", vend.getCognome());
	}

	@Test 
	void testSetCognome() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setCognome("Lulic");
		assertEquals("Lulic", vend.getCognome());
	}
	
	@Test 
	void testGetEmail() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("cetrangolomario98@gmail.com", vend.getEmail());
	}

	@Test 
	void testSetEmail() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setEmail("lulic@gmail.com");
		assertEquals("lulic@gmail.com", vend.getEmail());
	}
	
	@Test 
	void testGetSesso() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("F", vend.getSesso());
	}

	@Test 
	void testSetSesso() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setSesso("M");
		assertEquals("M", vend.getSesso());
	}
	
	@Test 
	void testGetTelefono() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("3415578614", vend.getTelefono());
	}

	@Test 
	void testSetTelefono() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setTelefono("0000000000");
		assertEquals("0000000000", vend.getTelefono());
	}
	
	@Test 
	void testGetVia() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("Umberto1", vend.getVia());
	}

	@Test 
	void testSetVia() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setVia("Gianflanco");
		assertEquals("Gianflanco", vend.getVia());
	}
	
	@Test 
	void testGetCitta() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("Salerno", vend.getCitta());
	}

	@Test 
	void testSetCitta() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setCitta("Roma");
		assertEquals("Roma", vend.getCitta());
	}
	
	@Test 
	void testGetCap() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		assertEquals("85100", vend.getCap());
	}

	@Test 
	void testSetCap() {
		Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
		vend.setCap("84600");
		assertEquals("84600", vend.getCap());
	}
}
