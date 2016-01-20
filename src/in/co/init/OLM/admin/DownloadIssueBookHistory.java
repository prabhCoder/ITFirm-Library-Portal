package in.co.init.OLM.admin;

import in.co.init.OLM.user.UserReport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DownloadIssueBookHistory
 */
public class DownloadIssueBookHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadIssueBookHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String filename = "UserReport.xls";
	       response.setContentType("APPLICATION/OCTET-STREAM"); 
	       response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 
	       HttpSession session1=request.getSession(false);
	       String bookisbn = (String)session1.getAttribute("isbn1");
	       IssueReport issuerep=new IssueReport();
	       issuerep.setISBN(bookisbn);
	       OutputStream out=response.getOutputStream();  
	       issuerep.createEX(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
