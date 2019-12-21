package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageraccouting.Utente;
import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;

/**
 * Servlet implementation class LoginVenditore
 */
@WebServlet("/LoginVenditore")
public class LoginVenditore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Venditore model=new Venditore();
    static Negozio modelnegozio=new Negozio();
    static Categoria modelcat=new Categoria();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginVenditore() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente utente=null;
		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (username==null || password==null)
				response.sendRedirect("./index.jsp");

			else {

				utente = model.checkLogin(username, password);
				
				request.getSession().setAttribute("venditore-loggato","n");
			
				if(utente==null) {
					response.sendRedirect("./index.jsp");
				}
				else {
					request.getSession().setAttribute("username", "");
					

					String address="";
					
					if(utente instanceof Venditore) {
						request.getSession().setAttribute("utente", utente);
						
						Venditore venditore=(Venditore) utente;
						address="./venditore/index-venditore.jsp";	
						
						Negozio negozio=modelnegozio.getNegozio(utente.getUsername());
						
						if(negozio!=null) {
							request.getSession().setAttribute("negozioBean", negozio);
						    request.getSession().setAttribute("negozioNome", negozio.getNomeNegozio());		
						}
						if(negozio==null){
							 response.sendRedirect("../seller/registrazione-negozio.jsp");
						
							 //request.getSession().setAttribute("venditore-loggato","s");
						}
						
						
						Collection<Categoria>  categorie=null;
						
						if(venditore!=null && negozio!=null)   
							{
							  
							  categorie= modelcat.getAllCategoryBySeller(venditore.getUsername());
							  request.getSession().setAttribute("categorie", categorie);
							}
					}
					response.sendRedirect(address);
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
