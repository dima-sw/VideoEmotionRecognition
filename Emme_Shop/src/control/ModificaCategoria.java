package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managernegozio.Categoria;

/**
 * Servlet implementation class ModificaCategoria
 */
@WebServlet("/ModificaCategoria")
public class ModificaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Categoria modCat = new Categoria();
       
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
		String nomeNegozio=request.getParameter("negozioNome");
		String nomeCategoria = request.getParameter("categoria");
		request.getSession().setAttribute("negozioNome", nomeNegozio);
		
		try {
			Categoria categ = modCat.getCategoria(nomeNegozio, nomeCategoria);
			request.getSession().setAttribute("categoriaNegozio", categ);
			response.sendRedirect("./venditore/modifica-categoria.jsp");
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
