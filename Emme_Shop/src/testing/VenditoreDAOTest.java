/*package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import manageraccouting.Venditore;
import model.VenditoreDAO;

class VenditoreDAOTest extends TestCase{

		
		private static VenditoreDAO model=new VenditoreDAO();
		private static Connection connection;
		
		
		
		
		@Test
		 void testCheckLoginSeller() throws Exception{
			try {
			Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
			
			model.addVenditore(vend);
			Venditore ret=(Venditore) model.checkLoginSeller(vend.getUsername(),vend.getPassword());
			assertEquals(ret.getUsername(), vend.getUsername());
			}finally {
			model.deleteVenditore("Mario");
			
			}
		}
		
		@Test
		void testAddVenditore() throws Exception{
			try {
				Venditore vend= new Venditore("Mario","Password0#","Mario","Cetrangolo","cetrangolomario98@gmail.com","F","3415578614","Umberto1","Salerno","85100");
				
			}finally {
				model.deleteVenditore("Mario");
			}
		}
		
		
		
	}
*/