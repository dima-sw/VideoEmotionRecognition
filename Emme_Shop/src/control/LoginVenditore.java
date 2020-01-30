package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eccezione.NegozioNonEsistenteException;
import eccezione.ParametroNonCorrettoException;
import eccezione.UtenteNonTrovatoException;
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
	
	private static Venditore model=new Venditore();
    private static Negozio modelnegozio=new Negozio();
    private static Categoria modelcat=new Categoria();
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
		PrintWriter out=response.getWriter();
		
		Utente utente=null;
		
		try {
			String address="";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
	
			utente = model.checkLogin(username, password);

			
			request.getSession().setAttribute("venditore-loggato","n");	
			request.getSession().setAttribute("username", "");
			request.getSession().setAttribute("utente", utente);
					
			Venditore venditore=(Venditore) utente;
			address="./venditore/index-venditore.jsp";
			request.getSession().setAttribute("username-venditore",venditore.getUsername());
					
			Negozio negozio=modelnegozio.getNegozio(utente.getUsername());					
			request.getSession().setAttribute("negozioBean", negozio);
			request.getSession().setAttribute("negozioNome", negozio.getNomeNegozio());		
					
					
			Collection<Categoria>  categorie=null;
					
			categorie= modelcat.getAllCategoryBySeller(venditore.getUsername());
			request.getSession().setAttribute("categorie", categorie);
				
			
			response.sendRedirect(address);
			
		}
		catch(NegozioNonEsistenteException e) {
			
			System.out.println("Errore:"+e.getMessage());
			//carica la registrazione del negozio per il venditore se non esiste
			response.sendRedirect("./seller/registrazione-negozio.jsp");
		}
		catch (UtenteNonTrovatoException e) {
			out.print("Errore utente non trovato");
			System.out.println("Error:" + e.getMessage());
			//request.getSession().setAttribute("messaggioerrore", e.getMessage());
			//request.getSession().setAttribute("redirecterror", "./index.jsp");
			
			response.sendRedirect("./error-page.jsp?messaggioerrore=Errore utente non trovato&redirecterror=./index.jsp");
			
			
			//response.sendRedirect("./index.jsp");
		}
		
		catch (ParametroNonCorrettoException e) {
			System.out.println("Error:"+e.getMessage());
			request.getSession().setAttribute("messaggioerrore", e.getMessage());
			request.getSession().setAttribute("redirecterror", "./index.jsp");
			response.sendRedirect("./error-page.jsp");
			
			//response.sendRedirect("./index.jsp");
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			response.sendRedirect("./index.jsp");//usare#posizione nella pagina come accedi
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
