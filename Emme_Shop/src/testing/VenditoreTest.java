package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import manageraccouting.Venditore;

class VenditoreTest {

	@Test
	void testVenditoreCostructorEmpty() {
		Venditore vd=new Venditore();
		assertNotNull(vd);
	}

	
	@Test
	void testCheckLogin() {
		
	}
}
