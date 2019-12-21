package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageraccouting.Venditore;

/**
 * Servlet implementation class RegisterSeller
 */
@WebServlet("/RegisterSeller")
public class RegisterSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSeller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Venditore venditore = new Venditore();
		
		venditore.setUsername(request.getParameter("username"));
		venditore.setPassword(request.getParameter("password"));
		venditore.setNome(request.getParameter("fname"));
		venditore.setCognome(request.getParameter("lname"));
		venditore.setEmail(request.getParameter("email"));
		venditore.setSesso(request.getParameter("gender"));
		venditore.setTelefono(request.getParameter("phone"));
		venditore.setVia(request.getParameter("street"));
		venditore.setCitta(request.getParameter("city"));
		venditore.setCap(request.getParameter("CAP"));
		
		try {
		venditore.registrazione(venditore);
		HttpSession session=request.getSession();
		session.setAttribute("username-venditore", venditore.getUsername());
		String address="./seller/questionNegozio.jsp";//domanda se vuoi creare il tuo negozio subito

		response.sendRedirect(address);
	}
	catch (SQLException e) {//errore ricarica il form registrazione
		System.out.println("Error:" + e.getMessage());
		String address="./seller/venditore-registrazione.jsp";
		response.sendRedirect(address);
		
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
