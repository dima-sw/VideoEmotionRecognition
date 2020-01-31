package control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import managernegozio.Prodotto;

/**
 * Servlet effettua upload del logo del prodotto
 * @author cetra
 *
 */
@WebServlet("/uploadProdotto")
public class UploadProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Prodotto model=new Prodotto();
	
	//stringhe tomcat
		static String UPLOAD_DIRECTORY_CETRANGOLO ="C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5_Tomcat8.5\\webapps\\Emme_Shop\\images\\negozi";
		static String UPLOAD_DIRECTORY_SANTONASTASIO = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\emme_Shop\\images\\negozi";
	    
		static String UPLOAD_DIRECTORY=UPLOAD_DIRECTORY_CETRANGOLO;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadProdotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
    	String nomeNegozio=(String) session.getAttribute("negozioNome");
    	String cat=(String) session.getAttribute("nomeProdottoCat");
    	int nomeProdottoImage= (int) session.getAttribute("nomeProdottoImage");//id
    	
		
		String urlLogo="";
		String directory=model.openCartellaNegozio(nomeNegozio, UPLOAD_DIRECTORY);
		
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
        	 try {
        		 	List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest( new ServletRequestContext(request));
               
                		urlLogo=model.createPathProdottoImage(multiparts, nomeNegozio, cat, nomeProdottoImage, directory);
                        session.setAttribute("urlLogoProdotto", urlLogo);
                        model.updatePathProdotto(nomeNegozio,cat,nomeProdottoImage,urlLogo);
                    
                
               //File uploaded successfully
               //request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
            	response.sendRedirect("./venditore/uploadImageProdotto.jsp");
               //request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            //request.setAttribute("message","Sorry this Servlet only handles file upload request");
        }
     
        //request.getRequestDispatcher("./seller/uploadImage.jsp").forward(request, response);
       
        response.sendRedirect("./venditore/uploadImageProdotto.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		doGet(request, response);

}
}
