package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Connessione con il db tramite ConnectionPool
 * @author cetra
 *
 */
public class DriverManagerConnectionPool {

	static private List<Connection> freeDbConnections;
	
	static {
			freeDbConnections = new LinkedList<Connection>();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("");
				
			} catch (ClassNotFoundException e) {
				System.out.println("DB driver not found!");
			} catch (Exception e) {
				System.out.println("DB connection pool error!");
				e.printStackTrace();
			}
		}
	
	
	//crea una nuova connessione, cambiare questo per farlo funzionare su un altro db!
	public static Connection createDBConnection() throws SQLException{
		
		String db = "jdbc/emmeshop_db";
		String username="root";
		String passwd="cetrangolo";
		//String passwd="manlio98";
		
		
		Connection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emmeshop_db?serverTimezone=CET", username, passwd);
				newConnection.setAutoCommit(false);
		return newConnection;
		
	}
	
	// dai una connessione 
	@SuppressWarnings("resource")
	public static Connection getDbConnection() throws SQLException{
		
		Connection con;
		
		if(! freeDbConnections.isEmpty())
		{
			con = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);
			
			try {
				if(con.isClosed()) con = getDbConnection();
			}catch(SQLException e)
			{
				con = getDbConnection();
			}
		}else {
			con = createDBConnection();
		}
		
		return con;
	}
	
	
	//rilasci la connessione
	public static synchronized void releaseConnection(Connection connection) {
		freeDbConnections.add(connection);
	}
	
	
}
