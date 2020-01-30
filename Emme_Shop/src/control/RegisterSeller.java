package control;

import java.io.IOException;
import java.io.PrintWriter;
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
       static Venditore model=new Venditore();
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
		
		PrintWriter out=response.getWriter();
		String risposta="";
		String address="";
		
		try {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nome=request.getParameter("fname");
		String cognome=request.getParameter("lname");
		String email=request.getParameter("email");
		String sesso=request.getParameter("gender");
		String telefono=request.getParameter("phone");
		String via=request.getParameter("street");
		String città=request.getParameter("city");
		String cap=request.getParameter("CAP");
		
		if(Controlli.isUsername(username)) {
			System.out.println("Username ok");
			
			if(Controlli.isPassword(password)) {
				System.out.println("password ok");
				
				if(Controlli.isName(nome)) {
					System.out.println("nome ok");
					
					if(Controlli.isName(cognome)) {
						System.out.println("Cognome ok");
						
						if(Controlli.isEmail(email)) {
							System.out.println("email ok");
							
							if(Controlli.isPhoneNumber(telefono)) {
								System.out.println("Telefono ok");
								
								if(Controlli.isStreet(via)) {
									System.out.println("Via ok");
									
									if(Controlli.isStreet(città)) {
										System.out.println("città ok");
										
										if(Controlli.isCap(cap)) {
											out.print("OK");
											System.out.println("Cap ok");
											Venditore venditore=null;
											venditore=model.addVenditore(username, password, nome, cognome, email, sesso, telefono, via, città, cap);
											HttpSession session=request.getSession();
											session.setAttribute("username-venditore", venditore.getUsername());
											address="./seller/questionNegozio.jsp";//domanda se vuoi creare il tuo negozio subito
										}else {
											System.out.println("Errore cap formato errato");
											risposta="Errore cap formato errato";
											String addresss="./seller/sellerRegistration.jsp";
											response.sendRedirect(addresss);
										}
									}else {
										System.out.println("Errore città formato errato");
										risposta="Errore città formato errato";
										String addresss="./seller/sellerRegistration.jsp";
										response.sendRedirect(addresss);
									}
								}else {
									System.out.println("Errore via formato errato");
									risposta="Errore via formato errato";
									String addresss="./seller/sellerRegistration.jsp";
									response.sendRedirect(addresss);
								}
							}else {
								System.out.println("Errore telefono formato errato");
								risposta="Errore telefono formato errato";
								String addresss="./seller/sellerRegistration.jsp";
								response.sendRedirect(addresss);
							}
						}else {
							System.out.println("Errore email formato errato");
							risposta="Errore email formato errato";
							String addresss="./seller/sellerRegistration.jsp";
							response.sendRedirect(addresss);
						}
					}else {
						System.out.println("Errore cognome formato errato");
						risposta="Errore cognome formato errato";
						String addresss="./seller/sellerRegistration.jsp";
						response.sendRedirect(addresss);
					}
				}else {
					System.out.println("Errore nome formato errato");
					risposta="Errore nome formato errato";
					String addresss="./seller/sellerRegistration.jsp";
					response.sendRedirect(addresss);
				}
			}else {
				System.out.println("Errore password formato errato");
				risposta="Errore password formato errato";
				String addresss="./seller/sellerRegistration.jsp";
				response.sendRedirect(addresss);
			}
		}else {
			System.out.println("Errore username formato errato");
			risposta="Errore username formato errato";
			String addresss="./seller/sellerRegistration.jsp";
			response.sendRedirect(addresss);
		}
	
		
		response.sendRedirect(address);
		
		out.print(risposta);
	}
	catch (SQLException e) {//errore ricarica il form registrazione
		System.out.println("Error:" + e.getMessage());
		String addresss="./seller/sellerRegistration.jsp";
		response.sendRedirect(addresss);
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
