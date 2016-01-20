
package in.co.init.OLM.admin;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



public class Reminder {
	  Timer timer;

	  public Reminder(int seconds) {
	    timer = new Timer();
	    
	    timer.schedule(new ReserveRemindTask(),new java.util.Date(), seconds*1000*24);
	  }
	 public  class ReserveRemindTask extends TimerTask {
	
		// String ISBN=isbn;
		 public void run() {
		    	
		    
		    	String isbn=null;
		    	String id=null;
		    	String status=null;
		    	String email=null;
	    		AdminFunctions af=new AdminFunctions();
	    		ResultSet rs1=af.retrieve_isbn();
//	    		ResultSet rs2=af.display(isbn);
//	    		String name=null;
//	    		String author=null;
//	    		String publisher=null;
//	    		while(rs2.next())
//	    		{
//	    		
//	    			rs2.getString(2);
//	    			rs2.getString(3);
//	    			rs2.getString(4);
//	    		}
	    		try {
					while(rs1.next())
					{
						isbn=rs1.getString(3);
						System.out.println(isbn);
						status=af.showstatus(isbn);
						id=af.retrieve_ids(isbn);
						email=af.return_email(id);
						
						if(status.equals("available"))
							//mail will be sent initially to the first person who had reserved
			    		{
			    		          System.out.println(email);
			    		           String subject = "Hi this is test Mail";  
			    			        String messageBody = "Book of isbnid:"+isbn+" is available now!! You can issue!!";  
			    			  
			    			        new SendEmail().sendMail(email, subject, messageBody);
			    			       
			    			       System.out.print("check mail");

			    		}	       
						
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	    	
	
	    		 	
		    
	    		       }
	    		       
		    
	 }

		  public static void main(String args[]) throws java.text.ParseException {
		    System.out.println("About to schedule task.");
		 
		    new Reminder(3600);
		    
		  }
	 }

