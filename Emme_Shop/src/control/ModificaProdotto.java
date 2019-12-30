package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eccezione.ParametroNonCorrettoException;
import managernegozio.Negozio;
import managernegozio.Prodotto;

/**
 * Servlet implementation class ModificaProdotto
 */
@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Prodotto modProd = new Prodotto();
    static Negozio modNeg = new Negozio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaProdotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("ID"));
		String nomeNegozio = request.getParameter("nomeNegozio");
		String nomeCategoria = request.getParameter("nomeCategoria");
		//System.out.println(nomeCategoria);
		request.setAttribute("categoria", nomeCategoria);
		request.setAttribute("nomeCategoria", nomeCategoria);
		
		try {
			Prodotto prodotto = modProd.getProductById(id);
			request.getSession().setAttribute("prodottoBean", prodotto);
			Negozio negozio = modNeg.getNegozioByName(nomeNegozio);
			request.getSession().setAttribute("negozioBean", negozio);
			response.sendRedirect("./venditore/modifica-prodotto.jsp");
		} catch (SQLException  | ParametroNonCorrettoException e) {
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
