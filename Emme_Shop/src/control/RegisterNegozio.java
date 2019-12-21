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
		Negozio negozio = new Negozio();
		
		HttpSession session=request.getSession();
		session.setAttribute("venditore-loggato","n");
		
		negozio.setNomeNegozio(request.getParameter("nomeNegozio"));
		negozio.setUsernameVenditore((String) session.getAttribute("username-venditore"));
		negozio.setDesign(request.getParameter("design"));
		negozio.setColore(request.getParameter("color"));
		negozio.setPartitaIva(request.getParameter("Piva").trim());
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		negozio.setDataIscrizione(currentTime);
		negozio.setDescrizione(request.getParameter("descrizione"));
		negozio.setVia(request.getParameter("street"));
		negozio.setCitta(request.getParameter("city"));
		negozio.setCap(request.getParameter("CAP"));
		negozio.setLogo("images/favicon.ico");
		
		session.setAttribute("NomeNegozio", negozio.getNomeNegozio());
		session.setAttribute("urlLogoNegozio", negozio.getLogo());
		
		try {
		
		negozio.addNegozio(negozio);
		
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
