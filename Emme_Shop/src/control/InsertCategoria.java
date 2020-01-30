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

import managernegozio.Categoria;
import managernegozio.Negozio;


/**
 * Servlet implementation class InsertCategoria
 */
@WebServlet("/InsertCategoria")
public class InsertCategoria extends HttpServlet {
	static Categoria mcategoria= new Categoria();
	static Negozio negozio = new Negozio();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String address="";
		String urlLogoCategoria="images/favicon.ico";
		String risposta = "";
		try {
			
			HttpSession session=request.getSession();
			session.setAttribute("urlLogoCategoria",urlLogoCategoria );
          
			Negozio neg=(Negozio) session.getAttribute("negozio");
			String negozio=(String) session.getAttribute("negozioNome");
			
			
			String nomeNegozio=request.getParameter("nomeNegozio");
			String nomeCategoria=request.getParameter("nomeCategoria");
			String descCategoria=request.getParameter("descCategoria");
			
			if(Controlli.isStreet(nomeCategoria)) {
				System.out.println("ok nomeCategoria");
				Categoria categoria=mcategoria.addCategoria(nomeNegozio,nomeCategoria,urlLogoCategoria,descCategoria);
				request.getSession().setAttribute("nomeCategoriaImage",categoria.getNomeCategoria());
				address="venditore/uploadImageCategoria.jsp";
				response.sendRedirect(address);
			}else {
				System.out.println("Nome categoria errato");
				risposta = "Nome categoria formato errato";
			}
			
			writer.print(risposta);
		}catch(SQLException e ) {
			request.getSession().setAttribute("messaggioerrore", e.getMessage());
			request.getSession().setAttribute("redirecterror", "./venditore/index-venditore.jsp");
			response.sendRedirect("../error-page.jsp");
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