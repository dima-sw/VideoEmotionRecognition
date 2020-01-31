package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managernegozio.Categoria;

/**
 * Servlet update Categoria
 * @author cetra
 *
 */
@WebServlet("/UpdateCategoria")
public class UpdateCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoria() {
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
		
		Categoria bean=new Categoria();
		bean.setNomeNegozio(request.getParameter("nomeNegozio"));
		bean.setNomeCategoria(request.getParameter("nomeCategoria"));
		String desc=request.getParameter("descCategoria");

		if(Controlli.isDesc(desc)) {
			bean.setDescrizione(desc);
			out.print("OK");
		}else {
			System.out.println("Errore descrizione formato errato");
			out.print("Errore descrizione formato errato");
			String addresss="./venditore/modifica-categoria.jsp";
			response.sendRedirect(addresss);
		}
		
		bean.setPath(request.getParameter("path"));
		session.setAttribute("urlLogoCategoria",bean.getPath());
		try 
		{
			session.setAttribute("urlLogoCategoria", bean.getPath());
	       
			bean.updateDescrizioneCategoria(bean.getNomeNegozio(), bean.getNomeCategoria(), bean.getDescrizione());
			request.getSession().setAttribute("nomeCategoriaImage",bean.getNomeCategoria());
			
			address="venditore/uploadImageCategoria.jsp";
			response.sendRedirect(address);
			
	}
		catch(Exception e) {
			 address="errore-page.jsp";
			 request.getSession().setAttribute("messaggioerrore", e.getMessage());
			 request.getSession().setAttribute("redirecterror", "./venditore/modifica-categoria.jsp");	
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
