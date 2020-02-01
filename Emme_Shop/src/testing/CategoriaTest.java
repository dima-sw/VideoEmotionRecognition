package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import managernegozio.Categoria;

/**
 * Test di unita Categoria
 * @author cetra
 *
 */
class CategoriaTest {

	@Test
	void testCategoriaIsEmpty() {
		Categoria cat=new Categoria();
		assertNotNull(cat);
	}
	
	@Test
	void testGetNomeNegozio() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		assertEquals("Pacifico",cat.getNomeNegozio());
	}
	
	@Test 
	void testSetNomeNegozio() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		cat.setNomeNegozio("Lumier");
		assertEquals("Lumier",cat.getNomeNegozio());
	}
	
	@Test
	void testGetNomeCategoria() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		assertEquals("Biscotti",cat.getNomeCategoria());
	}
	
	@Test 
	void testSetNomeCategoria() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		cat.setNomeCategoria("Libri");
		assertEquals("Libri",cat.getNomeCategoria());
	}
	
	@Test
	void testGetDescrizione() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		assertEquals("descrizione",cat.getDescrizione());
	}
	
	@Test 
	void testSetDescrizione() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		cat.setDescrizione("Desc");
		assertEquals("Desc",cat.getDescrizione());
	}
	
	@Test
	void testGetPath() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		assertEquals("path/biscotti",cat.getPath());
	}
	
	@Test 
	void testSetPath() {
		Categoria cat=new Categoria( "Pacifico",  "Biscotti", "path/biscotti",  "descrizione");
		cat.setPath("path/lumier");
		assertEquals("path/lumier",cat.getPath());
	}
	
	
	
}
