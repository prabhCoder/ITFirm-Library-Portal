package in.co.init.OLM.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Authentication {
	Connection con=null;
	ResultSet rs;
	Statement st;

	
	
	public String compare_loginid(String loginid)
	{
		boolean b=false;
		String msg=null;
		try
		{
			createconnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from customer where loginid='"+loginid+"' ");
			if(rs.next())
			{
				
				msg="invalid";
				
			}
			else
			{
				msg="valid";
			}
			
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
		
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		
		}
		return msg;


	}
	
	
	public String compare_employeeloginid(String loginid)
	{
		boolean b=false;
		String msg=null;
		try
		{
			createconnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from customer where loginid='"+loginid+"' ");
			if(rs.next())
			{
				
				msg="invalid";
				
			}
			else
			{
				msg="valid";
			}
			
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
		
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		
		}
		return msg;


	}
	
	
public String authentication(String login,String password)
{
	/*boolean b=false;*/
	String msg=null;
	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from customer where loginid='"+login+"' and cpassword='"+password+"' ");
		if(rs.next())
		{
			
			 msg="success";
			//String id=rs.getString(1);
			System.out.println("success");
			
		}
		else
		{
			msg="error";
		}
		
	
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
	
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	}
	return msg;


}
public String authentication_emp(String login,String password)
{
	
	String msg=null;
	try
	{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from librarian where libloginid='"+login+"' and libpassword='"+password+"' ");
		if(rs.next())
		{
			
			 msg="success";
			//String id=rs.getString(1);
			System.out.println("success");
			
		}
		else
		{
			msg="error";
		}
		
	
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	}
	return msg;


}

public String get_userid(String login)
{String id=null;
try{
	createconnection();
	st=con.createStatement();
	rs=st.executeQuery("select * from customer where loginid='"+login+"'");
	if(rs.next())
	{
		id=rs.getString(1);
		
	}
	
}
catch(SQLException e)
{
	e.printStackTrace();
}
finally{

}

return id;
	
}

public String return_name(String cid)
{String ret_name=null;
	try{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from customer where idcustomer='"+cid+"'");
		if(rs.next())
		{
			ret_name=rs.getString(2);
			
		}
		
		else
		{
			System.out.println("error");
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	}
	
	return ret_name;
}


public String return_name_emp(String loginid)
{String ret_name=null;
	try{
		createconnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from librarian where libloginid='"+loginid+"'");
		if(rs.next())
		{
			ret_name=rs.getString(2);
			
		}
		
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	
	}
	return ret_name;
}


public boolean add(String id,String name,String add,String contact,String email,String password,String dob)
{createconnection();
	PreparedStatement st;
	

		try
	{
		
		st=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
		st.setString(1, id);
		st.setString(2, name);
		st.setString(3, add);
		st.setString(4, contact);
		st.setString(5, email);
		st.setString(6, password);
		st.setString(7, dob);
		
		
		int r=st.executeUpdate();
		
		
		System.out.println("<html>");
		System.out.println("<body>");
		System.out.println("Record inserted!!!");
		System.out.println("</body>");
		System.out.println("</html");
		return true;
	
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		finally{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		
		}
		return true;
}

void deleteacc(String id)
{
	try
	{createconnection();
		st=con.createStatement();
		st.executeUpdate("delete from customer where idcustomer='"+id+"'");
		System.out.println("record deleted");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		
	}
	finally{
	
	}
}
	
		void createconnection()
		{
		
			

		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    	con=DriverManager.getConnection("jdbc:mysql://localhost/library","root","12345");
		    	
		      if(!con.isClosed())
		        System.out.println("Successfully connected to " +
		          "MySQL server using TCP/IP...");

		    } catch(Exception e) {
		      System.err.println("Exception: " + e.getMessage());
		    
			}
		    finally {
				
			}
}
//		void closeconnection()
//		{
//			if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
//	        if (st != null) try { st.close(); } catch (SQLException logOrIgnore) {}
//	        if (con != null) try { con.close(); } catch (SQLException logOrIgnore) {}
//		}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	


	Authentication a=new Authentication();
	a.authentication_emp("richa","123");
	
	

//		String s1=request.getParameter("cloginid");
//		String s2=request.getParameter("cpassword");

	
	}

}
