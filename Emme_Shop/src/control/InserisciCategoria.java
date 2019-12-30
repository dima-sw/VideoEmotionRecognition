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

/**
 * Servlet implementation class InserisciCategoria
 */
@WebServlet("/InserisciCategoria")
public class InserisciCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Negozio mnegozio=new Negozio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeNegozio = request.getParameter("negozio");
		request.getSession().setAttribute("negozioNome", nomeNegozio);
		try {
			Negozio negozio =(Negozio) mnegozio.getNegozioByName(nomeNegozio);
			request.getSession().setAttribute("negozio", negozio);
			response.sendRedirect("./venditore/inserisci-categoria.jsp");
			
	
		} catch (ParametroNonCorrettoException e) {
			System.out.println("Error:"+e.getMessage());
			request.getSession().setAttribute("messaggioerrore", e.getMessage());
			request.getSession().setAttribute("redirecterror", "./venditore/index-venditore.jsp");
			response.sendRedirect("./error-page.jsp");
		}
		catch (SQLException e) {
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
