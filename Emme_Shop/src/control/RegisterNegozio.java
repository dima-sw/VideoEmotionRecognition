package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managernegozio.Negozio;

/**
 * Servlet implementation class RegisterNegozio
 */
@WebServlet("/RegisterNegozio")
public class RegisterNegozio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Negozio model=new Negozio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterNegozio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			HttpSession session=request.getSession();
			session.setAttribute("venditore-loggato","n");
			
			String nomeNegozio=request.getParameter("nomeNegozio");
			String usernameVenditore=(String) session.getAttribute("username-venditore");
			String template=request.getParameter("design");
			String colore=request.getParameter("color");
			String partitaIva=request.getParameter("Piva").trim();
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dataIscrizione = sdf.format(dt);
			
			String descrizione=request.getParameter("descrizione");
			String via=request.getParameter("street");
			String citta=request.getParameter("city");
			String cap=request.getParameter("CAP");
			String Logo=("images/favicon.ico");
			
			session.setAttribute("NomeNegozio", nomeNegozio);
			session.setAttribute("urlLogoNegozio", Logo);
			
			
			
			model.addNegozio(nomeNegozio, usernameVenditore, template, colore, partitaIva,
					 dataIscrizione, descrizione, via, citta, cap, Logo);
			
			int n=1;
			if(n==0) throw new SQLException();
			//HttpSession session=request.getSession();
			//session.removeAttribute("username-venditore");
			
			String address="./seller/uploadImage.jsp";
			response.sendRedirect(address);
	}
	catch (SQLException e) {//errore ricarica il form registrazione
		System.out.println("Error:" + e.getMessage());
		String address="./seller/registrazione-negozio.jsp";
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
