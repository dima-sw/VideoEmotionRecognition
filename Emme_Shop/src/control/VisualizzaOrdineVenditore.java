package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eccezione.NegozioNonEsistenteException;
import eccezione.ParametroNonCorrettoException;
import manageraccouting.Utente;
import manageraccouting.Venditore;
import managernegozio.Negozio;
import managerordine.ArrayRiferimento;
import managerordine.Riferimento;

/**
 * Servlet implementation class VisualizzaOrdine_Venditore
 */
@WebServlet("/VisualizzaOrdineVenditore")
public class VisualizzaOrdineVenditore extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static Venditore venditore=null;
    static Negozio mnegozio=new Negozio();
    static Riferimento riferimento=new Riferimento();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaOrdineVenditore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 	
			
			venditore = (Venditore)request.getSession().getAttribute("utente");
			
				request.getSession().setAttribute("username-venditore",venditore.getUsername());
				try {
					//System.out.println(venditore.getUsername());
					Negozio negozio=(Negozio) mnegozio.getNegozio(venditore.getUsername());
					
					ArrayRiferimento riferimenti=null;
					riferimenti=(ArrayRiferimento) riferimento.getArrayRiferimento(negozio.getNomeNegozio());
					
					
					request.getSession().setAttribute("negozio", negozio);
					request.getSession().setAttribute("riferimenti", riferimenti);
					
					response.sendRedirect("./venditore/ordini.jsp");
					
					
				}
				catch (NegozioNonEsistenteException e) {
					System.out.println("Error:" + e.getMessage());
					request.getSession().setAttribute("messaggioerrore", e.getMessage());
					request.getSession().setAttribute("redirecterror", "./index.jsp");
					response.sendRedirect("./error-page.jsp");
					
				} catch (ParametroNonCorrettoException e) {
					System.out.println("Error:"+e.getMessage());
					request.getSession().setAttribute("messaggioerrore", e.getMessage());
					request.getSession().setAttribute("redirecterror", "./index.jsp");
					response.sendRedirect("./error-page.jsp");
				}
				catch (SQLException  e) {
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
