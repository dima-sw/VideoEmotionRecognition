package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import managernegozio.Prodotto;

/**
 * Test di unita Prodotto
 * @author cetra
 *
 */
class ProdottoTest {

	@Test
	void testProdottoCostruttore() {
		Prodotto p = new Prodotto();
		assertNotNull(p);
	}
	
	@Test
	void testGetIdProdotto() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals(11111,p.getIdProdotto());
	}
	
	@Test
	void testSetIdProdotto() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setIdProdotto(12);
		assertEquals(12,p.getIdProdotto());
	}
	
	
	@Test
	void testGetIva() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals(22,p.getIva());
	}
	
	@Test
	void testSetIva() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setIva(23);
		assertEquals(23,p.getIva());
	}
	
	@Test
	void testGetPath() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals("images/negozi/Pacifico/500.jpg",p.getPath());
	}
	
	@Test
	void testSetPath() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setPath("images/negozi/Pacifico/500.jpg");
		assertEquals("images/negozi/Pacifico/500.jpg",p.getPath());
	}
	
	
	@Test
	void testGetPrezzo() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals(10.5f,p.getPrezzo());
	}
	
	@Test
	void testSetPrezzo() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setPrezzo(11.5f);
		assertEquals(11.5f,p.getPrezzo());
	}
	
	@Test
	void testGetQuantita() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals(4,p.getQuantita());
	}
	
	@Test
	void testSetQuantita() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setQuantita(5);
		assertEquals(5,p.getQuantita());
	}
	
	@Test
	void testGetSconto() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals(23,p.getSconto());
	}
	
	@Test
	void testSetSconto() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setSconto(25);
		assertEquals(25,p.getSconto());
	}
	
	
	@Test
	void testGetDescrizione() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals("Molto buoni e gustosi",p.getDescrizione());
	}
	
	@Test
	void testSetDescrizione() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setDescrizione("Ne buoni e ne gustosi");
		assertEquals("Ne buoni e ne gustosi",p.getDescrizione());
	}
	
	
	@Test
	void testGetNomeNegozio() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals("Pacifico",p.getNomeNegozio());
	}
	
	@Test
	void testSetNomeNegozio() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setNomeNegozio("Pac");
		assertEquals("Pac",p.getNomeNegozio());
	}
	
	@Test
	void testGetNomeCategoria() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals("Biscotti",p.getNomeCategoria());
	}
	
	@Test
	void testSetNomeCategoria() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setNomeCategoria("Libri");
		assertEquals("Libri",p.getNomeCategoria());
	}
	
	@Test
	void testGetNome() {
		 Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		 assertEquals("ringo",p.getNome());
	}
	
	@Test
	void testSetNome() {
		Prodotto p=new Prodotto(11111,"Pacifico","Biscotti","ringo",22,"images/negozi/Pacifico/500.jpg",10.5f,4,23,"Molto buoni e gustosi");
		p.setNome("briosche");
		assertEquals("briosche",p.getNome());
	}
	

}
