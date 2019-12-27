package control;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managernegozio.Categoria;
import managernegozio.Negozio;


/**
 * Servlet implementation class InsertCategoria
 */
@WebServlet("/InsertCategoria")
public class InsertCategoria extends HttpServlet {
	static Categoria categoria= new Categoria();
	static Negozio negozio = new Negozio();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address="";
		try {
			HttpSession session=request.getSession();
			session.setAttribute("urlLogoCategoria", "images/favicon.ico");
          
			Negozio neg=(Negozio) session.getAttribute("negozioBean");
			String negozio=(String) session.getAttribute("negozioNome");
			
			categoria.addCategoria(request.getParameter("nomeNegozio"), request.getParameter("nomeCategoria"), 
					                "images/favicon.ico", request.getParameter("descCategoria"));
			request.getSession().setAttribute("nomeCategoriaImage",categoria.getNomeCategoria());
			address="venditore/uploadImageCategoria.jsp";
			response.sendRedirect(address);
			
		}catch(SQLException e ) {
			request.getSession().setAttribute("messaggioerrore", e.getMessage());
			request.getSession().setAttribute("redirecterror", "./venditore/index-venditore.jsp");
			response.sendRedirect("../error-page.jsp");
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