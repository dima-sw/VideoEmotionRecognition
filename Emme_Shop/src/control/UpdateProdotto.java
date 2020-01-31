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
 * Servlet implementation class UpdateProdotto
 */
@WebServlet("/UpdateProdotto")
public class UpdateProdotto extends HttpServlet {
	
	static Prodotto modelProd= new Prodotto();
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProdotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String address="";
		HttpSession session=request.getSession();
		String risposta="";
		Prodotto bean=new Prodotto();
		try
		{	
			bean.setIdProdotto(Integer.parseInt(request.getParameter("id")));
			bean.setNomeNegozio(request.getParameter("nomeNegozio"));
			bean.setNomeCategoria(request.getParameter("nomeCategoria"));
			bean.setNome(request.getParameter("nomeProdotto"));
			bean.setDescrizione(request.getParameter("descProdotto"));
			bean.setPrezzo(Float.parseFloat(request.getParameter("prezzoProdotto")));
			bean.setIva(Integer.parseInt(request.getParameter("ivaProdotto")));
			bean.setQuantita(Integer.parseInt(request.getParameter("qtaProdotto")));
			bean.setSconto(Integer.parseInt(request.getParameter("scontoProdotto")));
			bean.setPath(request.getParameter("path"));
			session.setAttribute("urlLogoProdotto",bean.getPath());
		
			if(Controlli.isStreet(bean.getNome())) {
				risposta="OK";		
				System.out.println("Nome ok");
				
				if(Controlli.isDesc(bean.getDescrizione())) {
					risposta="OK";			
					System.out.println("Descrizione ok");
					
					if(Controlli.isPrezzo(String.valueOf(bean.getPrezzo()))) {
						risposta="OK";			
						System.out.println("Prezzo ok");
						
						if(Controlli.isSconto(String.valueOf(bean.getIva()))) {
							risposta="OK";		
							System.out.println("Iva ok");
							
							if(Controlli.isQuantità(String.valueOf(bean.getQuantita()))) {
								risposta="OK";		
								System.out.println("Quantità ok");
								
								if(Controlli.isSconto(String.valueOf(bean.getSconto()))) {
									risposta="OK";			
									System.out.println("Sconto ok");
								
								}else {
									System.out.println("Errore sconto formato errato");
									risposta="Errore sconto formato errato";
									String addresss="./venditore/modifica-prodotto.jsp";
									response.sendRedirect(addresss);
								}
							}else {
								System.out.println("Errore quantità formato errato");
								risposta="Errore quantità formato errato";
								String addresss="./venditore/modifica-prodotto.jsp";
								response.sendRedirect(addresss);
							}
						}else {
							System.out.println("Errore iva formato errato");
							risposta="Errore iva formato errato";
							String addresss="./venditore/modifica-prodotto.jsp";
							response.sendRedirect(addresss);
						}
					}else {
						System.out.println("Errore prezzo formato errato");
						risposta="Errore prezzo formato errato";
						String addresss="./venditore/modifica-prodotto.jsp";
						response.sendRedirect(addresss);
					}
				}else {
					System.out.println("Errore descrizione formato errato");
					risposta="Errore descrizione formato errato";
					String addresss="./venditore/modifica-prodotto.jsp";
					response.sendRedirect(addresss);
				}
			}else {
				System.out.println("Errore nome formato errato");
				risposta="Errore nome formato errato";
				String addresss="./venditore/modifica-prodotto.jsp";
				response.sendRedirect(addresss);
			}
				modelProd.updateProdotto(bean);
				
				session.setAttribute("nomeProdottoImage",bean.getIdProdotto());
				session.setAttribute("nomeProdottoCat",bean.getNomeCategoria());
				address="venditore/uploadImageProdotto.jsp";
				response.sendRedirect(address);
				out.print(risposta);
	}
	catch(Exception e) {
		 address="errore-page.jsp";
		 request.getSession().setAttribute("messaggioerrore", e.getMessage());
		 request.getSession().setAttribute("redirecterror", "./venditore/modifica-prodotto.jsp");	
		 response.sendRedirect(address);
		 System.out.print(e);
		 
	}
	finally {
		
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
