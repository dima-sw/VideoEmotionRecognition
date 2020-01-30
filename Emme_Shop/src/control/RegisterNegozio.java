package control;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		PrintWriter out=response.getWriter();
		String risposta="";
		String address="";
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
			
			
			
			if(Controlli.isUsername(nomeNegozio)) {
				System.out.println("Nome ok");
				
				if(Controlli.isPivaIT(partitaIva)) {
					System.out.println("PIva ok");
					
					if(Controlli.isStreet(via)) {
						System.out.println("Via ok");
						
						if(Controlli.isStreet(citta)) {
							System.out.println("Città ok");
							
							if(Controlli.isDesc(descrizione)) {
								System.out.println("Descrizione ok");
							
							if(Controlli.isCap(cap)) {
								out.print("OK");		
								System.out.println("Cap ok");
								
								session.setAttribute("NomeNegozio", nomeNegozio);
								session.setAttribute("urlLogoNegozio", Logo);
								model.addNegozio(nomeNegozio, usernameVenditore, template, colore, partitaIva,
										 dataIscrizione, descrizione, via, citta, cap, Logo);
								address="./seller/uploadImage.jsp";
							}else {
								System.out.println("Errore cap formato errato");
								risposta="Errore cap formato errato";
								String addresss="./seller/registrazione-negozio.jsp";
								response.sendRedirect(addresss);
							}
							}else {
								System.out.println("Errore descrizione formato errato");
								risposta="Errore descrizione formato errato";
								String addresss="./seller/registrazione-negozio.jsp";
								response.sendRedirect(addresss);
							}
							
						}else {
							System.out.println("Errore città formato errato");
							risposta="Errore città formato errato";
							String addresss="./seller/registrazione-negozio.jsp";
							response.sendRedirect(addresss);
						}
					}else {
						System.out.println("Errore via formato errato");
						risposta="Errore via formato errato";
						String addresss="./seller/registrazione-negozio.jsp";
						response.sendRedirect(addresss);
					}
				}else {
					System.out.println("Errore Piva formato errato");
					risposta="Errore Piva formato errato";
					String addresss="./seller/registrazione-negozio.jsp";
					response.sendRedirect(addresss);
				}
			}else {
				System.out.println("Errore nome formato errato");
				risposta="Errore nome formato errato";
				String addresss="./seller/registrazione-negozio.jsp";
				response.sendRedirect(addresss);
			}
						
				
			
			
			
			int n=1;
			if(n==0) throw new SQLException();
			//HttpSession session=request.getSession();
			//session.removeAttribute("username-venditore");
			
			
			response.sendRedirect(address);
			out.print(risposta);
	}
	catch (SQLException e) {//errore ricarica il form registrazione
		System.out.println("Error:" + e.getMessage());
		String addresss="./seller/registrazione-negozio.jsp";
		response.sendRedirect(address);
	}
}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
