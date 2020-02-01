package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import managernegozio.Negozio;

/**
 * Test di unita Negozio
 * @author cetra
 *
 */
class NegozioTest {

	@Test
	void testNegozioCostruttore() {
		Negozio negozio = new Negozio();
		assertNotNull(negozio);
	}
	
	@Test
	void testGetLogo() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("images/negozi/Pacifico/Pacifico.png",negozio.getLogo());
	}
	
	@Test
	void testSetLogo() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setLogo("images/negozi/Pacifico/Pac.png");
		assertEquals("images/negozi/Pacifico/Pac.png",negozio.getLogo());
	}
	
	@Test
	void testGetNomeNegozio() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("Pacifico",negozio.getNomeNegozio());
	}
	
	@Test
	void testSetNomeNegozio() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setNomeNegozio("Nutella");
		assertEquals("Nutella",negozio.getNomeNegozio());
	}
	
	
	@Test
	void testGetUsernameVenditore() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("Mario",negozio.getUsernameVenditore());
	}
	
	@Test
	void testSetUsernameVenditore() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setUsernameVenditore("Manlio");;
		assertEquals("Manlio",negozio.getUsernameVenditore());
	}
	
	@Test
	void testGetDesign() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("left",negozio.getDesign());
	}
	
	
	@Test
	void testSetDesign() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setDesign("right");
		assertEquals("right",negozio.getDesign());
	}
	
	@Test
	void testGetColore() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("Verde",negozio.getColore());
	}
	
	
	@Test
	void testSetColore() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setColore("Blue");
		assertEquals("Blue",negozio.getColore());
	}
	
	@Test
	void testGetPartitaIva() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("11111111112",negozio.getPartitaIva());
	}
	
	
	@Test
	void testSetPartitaIva() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setPartitaIva("123456789");;
		assertEquals("123456789",negozio.getPartitaIva());
	}
	
	@Test
	void testGetDataIscrizione() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("2019-05-01",negozio.getDataIscrizione());
	}
	
	
	@Test
	void testSetDataIscrizione() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setDataIscrizione("2019-05-02");
		assertEquals("2019-05-02",negozio.getDataIscrizione());
	}
	
	@Test
	void testGetDescrizione() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("Pacifico nasce nel 1920, a Herzogenaurach",negozio.getDescrizione());
	}
	
	
	@Test
	void testSetDescrizione() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setDescrizione("Pacifico nasce nel 1922");
		assertEquals("Pacifico nasce nel 1922",negozio.getDescrizione());
	}
	
	@Test
	void testGetVia() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("senerchia",negozio.getVia());
	}
	
	
	@Test
	void testSetVia() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setVia("Petrarca");
		assertEquals("Petrarca",negozio.getVia());
	}
	
	@Test
	void testGetCitta() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("casagiove",negozio.getCitta());
	}
	
	
	@Test
	void testSetCitta() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setCitta("caserta");
		assertEquals("caserta",negozio.getCitta());
	}
	
	
	@Test
	void testGetCap() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		assertEquals("81023",negozio.getCap());
	}
	
	
	@Test
	void testSetCap() {
		Negozio negozio = new Negozio("Pacifico","Mario","left","Verde","11111111112","2019-05-01","Pacifico nasce nel 1920, a Herzogenaurach","senerchia","casagiove","81023","images/negozi/Pacifico/Pacifico.png");
		negozio.setCap("81021");
		assertEquals("81021",negozio.getCap());
	}
	
	
	
	
	
	
	

}
