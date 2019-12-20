package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession().getAttribute("cliente-loggato")==null && request.getSession().getAttribute("venditore-loggato")==null && request.getSession().getAttribute("amministratore-loggato")==null) {

			response.sendRedirect("index.jsp");
		}
		else if(request.getSession().getAttribute("cliente-loggato").equals("s") ) {
			request.getSession().removeAttribute("cart");
			request.getSession().setAttribute("cliente-loggato","n");
			response.sendRedirect("index.jsp#accedi");
		}
		else if(request.getSession().getAttribute("venditore-loggato").equals("s")) {
			request.getSession().removeAttribute("cart");
			request.getSession().setAttribute("venditore-loggato","n");
			response.sendRedirect("index.jsp#accedi");
		}
		else if(request.getSession().getAttribute("amministratore-loggato").equals("s")) {
			request.getSession().removeAttribute("cart");
			request.getSession().setAttribute("amministratore-loggato","n");
			response.sendRedirect("index.jsp#accediAdmin");
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
