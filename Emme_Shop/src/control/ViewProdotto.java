package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eccezione.ParametroNonCorrettoException;
import managernegozio.Negozio;
import managernegozio.Prodotto;

/**
 * Servlet ricarica la jsp dei prodotti di una relativa categoria di un negozio
 * @author cetra
 *
 */
@WebServlet("/ViewProdotto")
public class ViewProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static Prodotto modelprod=new Prodotto();
       static Negozio modelneg=new Negozio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProdotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomeNegozio = (String) request.getSession().getAttribute("negozioNome");
		String nomeCategoria = (String) request.getSession().getAttribute("categoria");
		request.getSession().setAttribute("categoria", nomeCategoria);
		String usernameVenditore = (String) request.getSession().getAttribute("username-venditore");
		
		Collection<Prodotto> prodotti = null;
		
		try {
			prodotti = modelprod.getAllProductBySellerCategory(usernameVenditore, nomeCategoria);
			request.getSession().setAttribute("prodotti", prodotti);
			Negozio negozio = modelneg.getNegozioByName(nomeNegozio);
			request.getSession().setAttribute("negozioBean", negozio);
			response.sendRedirect("./venditore/index-venditore-prodotti.jsp");
		}
		 catch (ParametroNonCorrettoException e) {
			 System.out.println("Error:"+e.getMessage());
				request.getSession().setAttribute("messaggioerrore", e.getMessage());
				request.getSession().setAttribute("redirecterror", "./venditore/index-venditore.jsp");
				response.sendRedirect("./error-page.jsp");
				
		} catch (SQLException e) {
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
