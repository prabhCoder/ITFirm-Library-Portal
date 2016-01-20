package in.co.init.OLM.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.OutputStream;

public class DownloadUserReport extends HttpServlet {
	
	
	
	
	private static final long serialVersionUID = 1L;
       
    
    public DownloadUserReport() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter out=response.getWriter();
		out.print("test");*/
		
		 String filename = "UserReport.xls";
	     response.setContentType("APPLICATION/OCTET-STREAM"); 

        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 

        OutputStream out=response.getOutputStream();    
        HttpSession session1 = request.getSession(false);
        
        String s1=(String)session1.getAttribute("cid");

        UserReport user = new UserReport();
        user.setCID(s1);
        user.createEX(out);
        
        
}  
	  
	   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}






