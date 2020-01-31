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
import managernegozio.Negozio;
import managernegozio.Prodotto;

/**
 * Servlet che fa carica i prodotti di una determinata categoria di un negozio
 * @author cetra
 *
 */
@WebServlet("/VisualizzaProdotti")
public class VisualizzaProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Prodotto modelprod = new Prodotto();
	static Negozio modelNeg = new Negozio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaProdotti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeNegozio = request.getParameter("negozio");
		String nomeCategoria = request.getParameter("categoria");
		request.getSession().setAttribute("categoria", nomeCategoria);
		String usernameVenditore = (String) request.getSession().getAttribute("username-venditore");
		
		Collection<Prodotto> prodotti = null;
		
		try {
			prodotti = modelprod.getAllProductBySellerCategory(usernameVenditore, nomeCategoria);
			request.getSession().setAttribute("prodotti", prodotti);
			Negozio negozio = modelNeg.getNegozioByName(nomeNegozio);
			request.getSession().setAttribute("negozioBean", negozio);
			response.sendRedirect("./venditore/index-venditore-prodotti.jsp");
		}
		 catch (ParametroNonCorrettoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
