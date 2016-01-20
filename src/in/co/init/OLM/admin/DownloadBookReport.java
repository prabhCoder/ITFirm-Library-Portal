package in.co.init.OLM.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.OutputStream;




/**
 * Servlet implementation class Downloadxls
 */
public class DownloadBookReport extends HttpServlet {
	
	
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadBookReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String filename = "BookReport.xls";
	     response.setContentType("APPLICATION/OCTET-STREAM"); 

        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 

        OutputStream out=response.getOutputStream();    
        HttpSession session5=request.getSession(false);
        String fd=(String)session5.getAttribute("fromd");
        String tod=(String)session5.getAttribute("tod");
        BookReport rep = new BookReport();
        rep.setfromdate(fd);
        rep.settodate(tod);
        rep.createEX(out);
        
}  
	  
	   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}















