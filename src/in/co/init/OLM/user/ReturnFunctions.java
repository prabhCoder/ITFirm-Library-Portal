package in.co.init.OLM.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReturnFunctions {
	Connection con=null;
	ResultSet rs;
	Statement st;



	
	
public int getid()
{
	 int id = 0; 
	try {
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select idreturn from returnbook ");
		System.out.println("id accessed-getid()");
		
		
		
		while(rs.next())
		{
			//System.out.println(rs.getInt(1));
			id=rs.getInt(1);
			
		}

	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	finally
	{
		
	}
	return id;
	
}
public int idincrement()
{
	int s2=getid();
	s2++;
	System.out.println("idincremntd:return"+s2);
	return s2;
}


public ResultSet returndate_remind(String isbn,String id)
{
	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from issue where ISBN='"+isbn+"' and idcustomer='"+id+"' ");
		System.out.println("returndate reminder");	
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
	
	}
	return rs;
}
public ResultSet returndate_reminder()
{
	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from issue ");
		System.out.println("returndate reminder");	
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
	
	}
	return rs;
}
public ResultSet get_issue_details(String isbn,String id)
{
	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from issue  ");
		
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
	
	}
	return rs;
}

public Integer calc_fine(String isbn,String cid,String issuestatus)
{Date idate=null;
	Date rdate=null;
	int days=0;
	long diff;
	int fine=0;

	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from issue where ISBN='"+isbn+"' and idcustomer='"+cid+"' and status='"+issuestatus+"'");
		System.out.println("fine calculated");	
			java.util.Date tdate=new java.util.Date();
      	while(rs.next())
		{
			
			rdate=rs.getDate(3);
			
			 diff=tdate.getTime()-rdate.getTime();
			days=(int) (diff/(1000*60*60*24));
		System.out.print("days "+days);
					
				
		
			
			}
      	if(days>0)
		{
			fine=days*10;
			System.out.print("FIne is "+fine);
		
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}
	return fine;
}




	
public boolean update_issue(String isbn,String cid,String status,String returndate)
{
	try
	{
		createconnection();
		st=con.createStatement();
		st.executeUpdate("update  issue set status='"+status+"', duedate='"+returndate+"' where ISBN='"+isbn+"' and idcustomer='"+cid+"' ");
		System.out.println("delete issued book from book table on return");	
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}
	return true;
}

public String change_returndate() {
	// SimpleDateFormat formatter = new
	// SimpleDateFormat("yyyy-MM-dd H-mm-ss");
	// java.util.Date today = new java.util.Date();
	// System.out.println(formatter.format(today.getDate()));
	String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	Calendar c1 = Calendar.getInstance(); // today

	String datetoday = sdf.format(c1.getTime());
	// System.out.println(datetoday);
	return datetoday;

}

public int bookaval(String isbn)
{int ct=0;
	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select bookcount from book where ISBN='"+isbn+"' ");
		System.out.println("check availablilty of books in book table");	
		while(rs.next())
		{
			ct=rs.getInt(1);
		return ct;
			//System.out.println(ct);
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}
		return ct;
}



public boolean change_bookcount(String isbn,int count)
{
	
	int newcount=count+1;
	try
	{
		createconnection();
		st=con.createStatement();
		st.executeUpdate("update book set bookcount='"+newcount+"' where ISBN='"+isbn+"' ");
		System.out.println("bookcount updated");
		
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}
	return true;
	
	
}

public boolean check_bookavlb(String isbn,String id)
{boolean b=false;
	try
	{
		
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select *  from issue where idcustomer='"+id+"' and ISBN='"+isbn+"' ");
		System.out.println("check book in issue table");	
		while(rs.next())
		{
		b=true;	
	return b;
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}
		return b;
		}

	
public ResultSet check_book_return(String isbn,String id)
{
	
	//String issuedt=null;
	try
{
	createconnection();
	st=con.createStatement();
	rs=st.executeQuery("select *  from issue where idcustomer='"+id+"' and ISBN='"+isbn+"' ");
	System.out.println("id accessed in return_functionsclass");	
	
}
catch(SQLException e)
{
	e.printStackTrace();
}
	finally{

	}
	return rs;
}


public boolean return_book(String isbn,String id,String isuedate)
{
	//int s1=idincrement();
	String s3=isuedate;
	String s2=returndate();
	
			try
		{
			createconnection();
			PreparedStatement st;
			st=con.prepareStatement("insert into returnbook(duedate,issuedate,idcustomer,ISBN) values(?,?,?,?,?)");
		//	st.setInt(1,s1);
			st.setString(1,s2);
			st.setString(2,s3);
			st.setString(3,id);
			st.setString(4,isbn);
			int r=st.executeUpdate();
			System.out.println("returned book  inserted");
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally{
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(st!=null)
				{
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			
			
			}
			return true;
			
}
	
	String returndate()
	{
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H-mm-ss");
//		java.util.Date today = new java.util.Date();
//		System.out.println(formatter.format(today.getDate()));
		 String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
		    SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
		    Calendar c1 = Calendar.getInstance(); // today
		   
		    String datetoday=sdf.format(c1.getTime());
		   // System.out.println(datetoday);
		return datetoday;
		
	}
	
	
		void createconnection()
		{
		
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    	con=DriverManager.getConnection("jdbc:mysql://localhost/library","root","12345");
		    	
		      if(!con.isClosed())
		        System.out.println("Successfully connected to " +"MySQL server");

		    } catch(Exception e) {
		      System.err.println("Exception: " + e.getMessage());
		    } finally {
				
			}
}
		
		void closeconnection()
		{
			if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
	        if (st != null) try { st.close(); } catch (SQLException logOrIgnore) {}
	        if (con != null) try { con.close(); } catch (SQLException logOrIgnore) {}
		}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

ReturnFunctions r=new ReturnFunctions();
r.calc_fine("3","1","issued");


	

//		String s1=request.getParameter("cloginid");
//		String s2=request.getParameter("cpassword");

	
	}

}
