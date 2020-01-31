package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eccezione.CategoriaNonEsisteException;
import eccezione.ParametroNonCorrettoException;
import managernegozio.Categoria;
import managernegozio.Negozio;

/**
 * Servlet implementation class ModificaCategoria
 */
@WebServlet("/ModificaCategoria")
public class ModificaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Categoria modCat = new Categoria();
	static Negozio modNeg=new Negozio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out=response.getWriter();
		
		String nomeNegozio=request.getParameter("negozio");
		String nomeCategoria = request.getParameter("categoria");
		request.getSession().setAttribute("negozioNome", nomeNegozio);
		
		try {
			Categoria categ = modCat.getCategoria(nomeNegozio, nomeCategoria);
			Negozio negozio=modNeg.getNegozioByName(nomeNegozio);
			request.getSession().setAttribute("categoriaNegozio", categ);
			request.getSession().setAttribute("negozioBean", negozio);
			response.sendRedirect("./venditore/modifica-categoria.jsp");
			//out.print("OK");
		} catch (ParametroNonCorrettoException e) {
			System.out.println("Error:" + e.getMessage());
			request.getSession().setAttribute("messaggioerrore", e.getMessage());
			request.getSession().setAttribute("redirecterror", "./index.jsp");
			response.sendRedirect("./error-page.jsp");
		} catch ( SQLException e) {
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
