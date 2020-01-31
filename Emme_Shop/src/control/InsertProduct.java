package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managernegozio.Prodotto;

/**
 * Servlet che inserisce un nuovo prodotto
 */
@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Prodotto modelprod=new Prodotto();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String risposta = "";
		String address="";
		PrintWriter writer = response.getWriter();
		String prezzo = "";
		try {
			HttpSession session=request.getSession();
			session.setAttribute("urlLogoProdotto", "images/favicon.ico");
			//serve per fare il testing
			prezzo = request.getParameter("prezzoProdotto");
			if(prezzo.equals("")) {
				prezzo = "0";
			}
			
			String iva = request.getParameter("ivaProdotto");
			if(iva.equals("")) {
				iva = "111";
			}
			
			String qta = request.getParameter("qtaProdotto");
			
			if(qta.equals("")) {
				qta = "000";
			}
			
			String sconto = request.getParameter("scontoProdotto");
			if(sconto.equals("")) {
				sconto = "000";
			}
			
            
			Prodotto prodotto=new Prodotto();

			
			prodotto.setNomeNegozio(request.getParameter("nomeNegozio"));

			prodotto.setNomeCategoria(request.getParameter("nomeCategoria"));
			prodotto.setNome(request.getParameter("nomeProdotto"));
			prodotto.setDescrizione(request.getParameter("descProdotto"));
			prodotto.setIva(Integer.parseInt(iva));
			prodotto.setPrezzo(Float.parseFloat(prezzo));
			prodotto.setQuantita(Integer.parseInt(qta));
			prodotto.setSconto(Integer.parseInt(sconto));
			prodotto.setPath("images/favicon.ico");
			
			
			if(Controlli.isStreet(prodotto.getNome())) {
				System.out.println("ok nome prodotto");
				if(Controlli.isDesc(prodotto.getDescrizione())) {
					System.out.println("ok descrizione");
					if(Controlli.isSconto(iva)) {
						System.out.println("ok iva");
						if(Controlli.isPrezzo(prezzo)) {
							System.out.println("ok prezzo");
							if(Controlli.isSconto(qta)) {
								System.out.println("ok quantita");
								if(Controlli.isSconto(sconto)) {
									risposta = "ok";
									System.out.println("ok sconto");
									if(!prodotto.getNomeNegozio().equals("Some problem")) {
										prodotto=modelprod.addProdotto(prodotto);
										session.setAttribute("nomeProdottoImage",prodotto.getIdProdotto());
										session.setAttribute("nomeProdottoCat",prodotto.getNomeCategoria());
										
										address="venditore/uploadImageProdotto.jsp";
										response.sendRedirect(address);
									}
								}else {
									System.out.println("sconto formato errato");
									risposta = "sconto non rispetta formato";
									address="venditore/inserisci-prodotto.jsp";
									response.sendRedirect(address);
								}
							}else {
								System.out.println("quantità formato errato");
								risposta = "quantita non rispetta formato";
								address="venditore/inserisci-prodotto.jsp";
								response.sendRedirect(address);
							}
						}else {
							System.out.println("prezzo formato errato");
							risposta = "prezzo non rispetta formato";
							address="venditore/inserisci-prodotto.jsp";
							response.sendRedirect(address);
						}
					}else {
						System.out.println("iva formato errato");
						risposta = "iva non rispetta formato";
						address="venditore/inserisci-prodotto.jsp";
						response.sendRedirect(address);
					}
				}else {
					System.out.println("descrizione formato errato");
					risposta = "descrizione non rispetta formato";
					address="venditore/inserisci-prodotto.jsp";
					response.sendRedirect(address);
				}
			}else {
				System.out.println("nome prodotto formato errato");
				risposta = "nome prodotto non rispetta formato";
				address="venditore/inserisci-prodotto.jsp";
				response.sendRedirect(address);
			}
			writer.print(risposta);
		}	
		catch(Exception e) {
			 address="errore.jsp";
			 response.sendRedirect(address);
			System.out.print(e);
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
