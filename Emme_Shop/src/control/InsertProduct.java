package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managernegozio.Prodotto;

/**
 * Servlet implementation class InsertProduct
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

		String address="";
		try {
			HttpSession session=request.getSession();
			session.setAttribute("urlLogoProdotto", "images/favicon.ico");
            
			Prodotto prodotto=new Prodotto();

			
			prodotto.setNomeNegozio(request.getParameter("nomeNegozio"));

			prodotto.setNomeCategoria(request.getParameter("nomeCategoria"));
			prodotto.setNome(request.getParameter("nomeProdotto"));
			prodotto.setDescrizione(request.getParameter("descProdotto"));
			prodotto.setIva(Integer.parseInt(request.getParameter("ivaProdotto")));
			prodotto.setPrezzo(Float.parseFloat(request.getParameter("prezzoProdotto")));
			prodotto.setQuantita(Integer.parseInt(request.getParameter("qtaProdotto")));
			prodotto.setSconto(Integer.parseInt(request.getParameter("scontoProdotto")));
			prodotto.setPath("images/favicon.ico");
			

			
			if(!prodotto.getNomeNegozio().equals("Some problem")) {
				prodotto=modelprod.addProdotto(prodotto);
				session.setAttribute("nomeProdottoImage",prodotto.getIdProdotto());
				session.setAttribute("nomeProdottoCat",prodotto.getNomeCategoria());
				
				address="venditore/uploadImageProdotto.jsp";
				response.sendRedirect(address);
			}
			else {
				response.sendRedirect("errore.jsp");
			}
		}
		catch(Exception e) {
			 address="errore.jsp";
			 response.sendRedirect(address);
			System.out.print(e);
		}
		finally {
			
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
