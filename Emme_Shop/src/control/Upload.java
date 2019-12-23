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

import dao.NegozioDAO;
import managernegozio.Negozio;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Negozio negozio = new Negozio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String UPLOAD_DIRECTORY = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\emmeShop\\images\\negozi";
        
    	HttpSession session=request.getSession();
		String nomeNegozio=(String) session.getAttribute("NomeNegozio");
		String urlLogo="";
		UPLOAD_DIRECTORY+="\\"+nomeNegozio;
		if(!(new File(UPLOAD_DIRECTORY)).exists())
			new File(UPLOAD_DIRECTORY).mkdir();

        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
        	 try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest( new ServletRequestContext(request));
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        int index = name.indexOf(".");
                        String estensione= name.substring(index);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + nomeNegozio+estensione));
                        urlLogo="images/negozi/"+nomeNegozio+"/"+nomeNegozio+estensione;
                        session.setAttribute("urlLogoNegozio", urlLogo);
                        negozio.updateLogoNegozio(nomeNegozio,urlLogo);
                    }
                }
                negozio.updateLogoNegozio(nomeNegozio,urlLogo);
               //File uploaded successfully
               //request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               //request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            //request.setAttribute("message","Sorry this Servlet only handles file upload request");
        }
     
        //request.getRequestDispatcher("./seller/uploadImage.jsp").forward(request, response);
        response.sendRedirect("./seller/uploadImage.jsp");
    }

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
