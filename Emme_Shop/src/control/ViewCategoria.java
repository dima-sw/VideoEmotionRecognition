package control;

import java.io.IOException;
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
 * Servlet ricarica la jsp delle categorie di un negozio
 * @author cetra
 *
 */
@WebServlet("/ViewCategoria")
public class ViewCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Negozio modelneg=new Negozio();
	private static Categoria modelcat=new Categoria();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address="./venditore/index-venditore.jsp";
		try {
			
			Venditore utente=(Venditore)request.getSession().getAttribute("utente");
			
			Negozio negozio=modelneg.getNegozio(utente.getUsername());
			request.getSession().setAttribute("negozioBean", negozio);
			request.getSession().setAttribute("", negozio.getNomeNegozio());
			
			Collection<Categoria> categorie=null;
			categorie=modelcat.getAllCategoryBySeller(utente.getUsername());
			request.getSession().setAttribute("categorie", categorie);
			
			response.sendRedirect(address);
			
		} catch(NegozioNonEsistenteException e) {
			System.out.println("Errore:"+e.getMessage());
			//carica la registrazione del negozio per il venditore se non esiste
			response.sendRedirect("./seller/registrazione-negozio.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
