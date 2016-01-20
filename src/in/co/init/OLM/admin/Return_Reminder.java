
package in.co.init.OLM.admin;


import in.co.init.OLM.user.ReturnFunctions;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;





public class Return_Reminder {
	  Timer timer;

	  public Return_Reminder(int seconds) {
	    timer = new Timer();
	    
	    timer.schedule(new ReserveRemindTask(), new java.util.Date(),seconds*1000*24);
	  }
	
	 public  class ReserveRemindTask extends TimerTask {
	
		// String ISBN=isbn;
		 public void run() {
		    	
		
			
		    	String isbn=null;
		    	String id=null;
		    	String status=null;
		    	String email=null;
		    	Date rdate=null;
		    	Date idate=null;
		    	boolean dateDiff=false;
		    	
	    		AdminFunctions af=new AdminFunctions();
				ReturnFunctions rf=new ReturnFunctions();
				ResultSet rs=rf.returndate_reminder();
				try {
					while(rs.next())
					{
						idate=rs.getDate(2);
						rdate=rs.getDate(3);
						id=rs.getString(5);
						status=rs.getString(7);
						email=af.return_email(id);
						Calendar cal=Calendar.getInstance();
						cal.setTime(rdate);
						cal.add(Calendar.DATE, -1);
						
						java.util.Date expectedDate= cal.getTime();
						java.util.Date currentDate=new java.util.Date();
						int d1=expectedDate.getDate();
						int d2=currentDate.getDate();
						//rdate=rs.getDate(3);
						
					
						//long diff=rdate.getTime()-idate.getTime();
						
						
						
						if(status.equals("issued") )
						{
							if(d1==d2)
							{
								//System.out.println("matched");
		    		          System.out.println(email);
		    		           String subject = "Hi this is test Mail";  
		    			        String messageBody = "Returndate is tomorrow!!";  
		    			  
		    			        new SendEmail().sendMail(email, subject, messageBody);
		    			       
		    			       System.out.print("check mail");
							
						}
						}
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	    		 
		  
	    		       
	    		       
		    
		 }
				}

		  public static void main(String args[]) {
		    System.out.println("About to schedule task.");
		   
		
			    new Return_Reminder(3600);
		    
		  }
	 }


