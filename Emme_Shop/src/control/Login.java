package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managernegozio.Negozio;
import manageraccouting.Cliente;
import manageraccouting.GestoreAccouting;
import manageraccouting.Utente;
import manageraccouting.Venditore;
/**
 * Servlet implementation class ProductControl
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Cliente cliente=new Cliente();
	static Venditore venditore=new Venditore();
	static GestoreAccouting gestoreaccouting=new GestoreAccouting();
	static Negozio neg=new Negozio();
	
	public Login() {
		super();
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utente utente = null;
		
		try {
				String userN = request.getParameter("username");
				String passN = request.getParameter("password");
				String azione = request.getParameter("azione");
				
				
				if (azione==null || userN==null || passN==null)
					response.sendRedirect("./index.jsp");
				else {
				
				
							if(azione.equals("Cliente")) 
								utente = cliente.checkLogin(userN, passN);
							else if(azione.equals("Venditore")) 
								utente = venditore.checkLogin(userN, passN);
							else if(azione.equals("Amministratore")) 
								utente = gestoreaccouting.checkLogin(userN, passN);
							
								
							request.getSession().setAttribute("cercato","s");
							request.getSession().setAttribute("username", userN);
							
							
							request.getSession().setAttribute("cliente-loggato","n");
							request.getSession().setAttribute("venditore-loggato","n");
							request.getSession().setAttribute("amministratore-loggato","n");
				
							if(utente==null) {
									if(azione.equals("Cliente")){
										request.getSession().setAttribute("tipo", "cliente");
										request.getSession().setAttribute("nomeCliente", "nessuno");	
										response.sendRedirect("./index.jsp");
									}
									else if(azione.equals("Venditore")) {
										request.getSession().setAttribute("tipo", "venditore");
										Negozio negozio=null;
										request.getSession().setAttribute("negozioBean", negozio);	
										request.getSession().setAttribute("negozioNome", "nessuno");						
										response.sendRedirect("./index.jsp");
									}
									else if(azione.equals("Amministratore")) {
										request.getSession().setAttribute("tipo", "amministratore");
										response.sendRedirect("./index.jsp");
									}
									else response.sendRedirect("./index.jsp");
							}
							else {
								request.getSession().setAttribute("username", "");
								
								if(utente instanceof Venditore) {
									Venditore u1=(Venditore) utente;
									
								}
								String address = "";
								
								if(utente instanceof Cliente){
									request.getSession().setAttribute("utente", (Cliente)utente);
									
									address="./cliente/index-cliente.jsp";
									request.getSession().setAttribute("cliente-loggato","s");
									request.getSession().setAttribute("nomeCliente", ((Cliente) utente).getNome());	
									
								}
								else if(utente instanceof Venditore) {
									request.getSession().setAttribute("utente", utente);
									
									address="./venditore/index-venditore.jsp";	
									Negozio negozio=neg.getNegozio(utente.getUsername());
									if(negozio!=null) {
										request.getSession().setAttribute("negozioBean", negozio);
									    request.getSession().setAttribute("negozioNome", negozio.getNomeNegozio());		
									}
									request.getSession().setAttribute("venditore-loggato","s");
								}
								else if(utente instanceof GestoreAccouting) {
									request.getSession().setAttribute("utente", utente);
									
									request.getSession().setAttribute("cercato","");
									address="./amministratore/index-amministratore.jsp";				
									request.getSession().setAttribute("amministratore-loggato","s");
								}
			
								response.sendRedirect(address);
							}
				}
		} 
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
