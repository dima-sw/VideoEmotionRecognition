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
import manageraccouting.Utente;
import managernegozio.Categoria;
import managernegozio.Negozio;

/**
 * Servlet implementation class RemoveCat
 */
@WebServlet("/RemoveCat")
public class RemoveCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Categoria model=new Categoria();
    static Negozio modelneg=new Negozio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String address="./venditore/index-venditore.jsp";
		String neg=request.getParameter("negozio");
		String cat=request.getParameter("categoria");
		
		
		try {
			Utente utente=(Utente) request.getSession().getAttribute("utente");
			model.deleteCategory(neg, cat);
			Negozio negozio=modelneg.getNegozio(utente.getUsername());
			request.getSession().setAttribute("negozioBean", negozio);
			request.getSession().setAttribute("negozioNome", negozio.getNomeNegozio());
			Collection<Categoria> categorie=null;
			categorie=model.getAllCategoryBySeller(utente.getUsername());
			request.getSession().setAttribute("categorie", categorie);
			response.sendRedirect(address);
		}
		catch (ParametroNonCorrettoException e) {
			System.out.println("Error:" + e.getMessage());
			request.getSession().setAttribute("messaggioerrore", e.getMessage());
			request.getSession().setAttribute("redirecterror", "./ViewCategoria");
			response.sendRedirect("./error-page.jsp");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (NegozioNonEsistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
