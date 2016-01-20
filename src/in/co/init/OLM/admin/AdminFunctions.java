package in.co.init.OLM.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunctions {
	Connection con = null;
	ResultSet rs;
	Statement st;

	public boolean insert_book(String bookname, String bookauthor,
			String bookpublisher, String booktype, String bookcount,
			String bookprice, String status, String location) {
		boolean b = false;

		try {
			createconnection();
			PreparedStatement st;

			st = con.prepareStatement("insert into book(bookname,bookauthor,bookpublisher,booktype,bookcount,bookprice,book_status,location) values(?,?,?,?,?,?,?,?)");

			st.setString(1, bookname);
			st.setString(2, bookauthor);
			st.setString(3, bookpublisher);
			st.setString(4, booktype);
			st.setString(5, bookcount);
			st.setString(6, bookprice);
			st.setString(7, status);
			st.setString(8, location);
			int r = st.executeUpdate();

			System.out.println("<html>");
			System.out.println("<body>");
			System.out.println("Record inserted!!!");
			b = true;
			System.out.println("</body>");
			System.out.println("</html");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return b;
	}

	public boolean update_book(String bookname, String bookauthor,
			String bookpublisher, String booktype, String bookcount,
			String bookprice, String status, String location, String isbn) {
		boolean b = false;
		Statement st = null;
		PreparedStatement pstatement = null;
		// int counter = 0;
		try {
			createconnection();

			String original_name = null;
			String original_author = null;
			String original_publisher = null;
			String original_type = null;
			String original_count = null;
			String original_price = null;
			String original_status = null;
			String original_location = null;

			String new_name = null;
			String new_author = null;
			String new_publisher = null;
			String new_type = null;
			String new_count = null;
			String new_price = null;
			String new_status = null;
			String new_location = null;
			
			st= con.createStatement();
			 rs= st.executeQuery("select * from book where ISBN='"+ isbn + "'");

			 while(rs.next()== true)
			 {
				 original_name = rs.getString(2);
					original_author = rs.getString(3);
					original_publisher = rs.getString(4);
					original_type = rs.getString(5);
					original_count = rs.getString(6);
					original_price = rs.getString(7);
					original_status = rs.getString(8);
					original_location = rs.getString(9);


			 }
						
			if (bookname!= null)
			{
				if (bookname.equals("")) {
					new_name = original_name;
				} else {
					new_name = bookname;
				}
			}
			
			if (bookauthor !=null)
			{
				if (bookauthor.equals("")) {
					new_author = original_author;
				} else {
					new_author = bookauthor;
				}
			}
			
			if (bookpublisher!=null)
			{
				if (bookpublisher.equals("")) {
					new_publisher = original_publisher;
				} else {
					new_publisher = bookpublisher;
				}

			}
			
			if (booktype!=null)
			{
			if (booktype.equals("")) {
				new_type = original_type;
			} else {
				new_type = booktype;
			}
			}
			
			if(bookcount!=null)
			{
			if (bookcount.equals("")) {
				new_count = original_count;
			} else {
				new_count = bookcount;
			}
			}
			
			
			if(bookprice!=null)
			{	
			if (bookprice.equals("")) {
				new_price = original_price;
			} else {
				new_price = bookprice;
			}
			}
			
			
			if(status!=null)
			{	
			if (status.equals("")) {
				new_status = original_status;
			} else {
				new_status = status;
			}
			}
			
			
			if(location!=null)
			{
			if (location.equals("")) {
				new_location = original_location;
			} else {
				new_location = location;
			}
			}
			// String s1="select * from book where ISBN='"+isbn+"'";

			pstatement = con
					.prepareStatement("UPDATE book set bookname=?, bookauthor=?, bookpublisher=?, booktype=?, bookcount=?, bookprice=?, book_status=?, location=? where ISBN='"
							+ isbn + "'");
			pstatement.setString(1, new_name);
			pstatement.setString(2, new_author);
			pstatement.setString(3, new_publisher);
			pstatement.setString(4, new_type);
			pstatement.setString(5, new_count);
			pstatement.setString(6, new_price);
			pstatement.setString(7, new_status);
			pstatement.setString(8, new_location);

			pstatement.executeUpdate();

			System.out.println("Record updated!!!");
			b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public boolean insert_employee_record(String name, String contact,
			String mail, String login, String pass, String dob) {

		try {
			createconnection();
			PreparedStatement st;

			st = con.prepareStatement("insert into librarian(libname,libcontact,libmail,libloginid,libpassword,libdob) values(?,?,?,?,?,?)");
			st.setString(1, name);

			st.setString(2, contact);
			st.setString(3, mail);
			st.setString(4, login);
			st.setString(5, pass);
			st.setString(6, dob);

			int r = st.executeUpdate();

			System.out.println("<html>");
			System.out.println("<body>");
			System.out.println("Record inserted!!!");
			System.out.println("</body>");
			System.out.println("</html");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return true;
	}

	public ResultSet displaybooks() {
		try {
			createconnection();
			st = con.createStatement();

			rs = st.executeQuery("select * from book ");
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}

	public ResultSet send_password_customer(String loginid) {
		try {
			createconnection();
			st = con.createStatement();

			rs = st.executeQuery("select * from customer where loginid='"
					+ loginid + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}

	public ResultSet send_password_employee(String loginid) {
		try {
			createconnection();
			st = con.createStatement();

			rs = st.executeQuery("select * from librarian where libloginid='"
					+ loginid + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}

	public ResultSet displaybooks_month(String fromdate, String todate) {
		// String oldFormat = "yyyy/mm/dd";
		// String newFormat = "yyyy-MM-dd HH:mm:ss";

		// SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		// SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);

		// Date FromDate = null;
		// Date ToDate = null;

		try {

			createconnection();
			Statement ps = con.createStatement();
			String query = "select * from issue where issuedate between '"
					+ fromdate + "' and '" + todate + "'";
			rs = ps.executeQuery(query);
			System.out.println(fromdate);

			System.out.println(query);

		}
		// System.out.print(FromDate+" "+ToDate);
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return rs;

	}

	public ResultSet displaybooks_history(String isbn) {
		try {
			createconnection();
			st = con.createStatement();

			rs = st.executeQuery("select * from issue where ISBN='" + isbn
					+ "' ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;

	}

	public boolean check_return(String bid) {
		try {
			createconnection();
			st = con.createStatement();

			rs = st.executeQuery("select * from returnbook where ISBN='" + bid
					+ "' ");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return true;
	}

	public ResultSet search(String name, String author, String booktype,
			String location) {
		try {
			PreparedStatement p1, p2, p3, p4, st = null;
			createconnection();

			String s1 = "select * from book where bookname like ?";
			String s2 = "select * from book where bookname like ? and bookauthor like ?";
			String s3 = "select * from book where bookname like ? and booktype like ?";
			String s4 = "select * from book where bookname like ? and bookauthor like ? and booktype like ?";
			String s5 = "select * from book where bookname like ? and bookauthor like ? and booktype like ? and location like ? ";

			if (!name.equals("")) {
				st = con.prepareStatement(s1);

				st.setString(1, "%" + name + "%");

			}

			if (!author.equals("")) {
				st = con.prepareStatement(s2);

				st.setString(1, "%" + name + "%");
				st.setString(2, "%" + author + "%");
			}

			if (!booktype.equals("")) {
				st = con.prepareStatement(s3);

				st.setString(1, "%" + name + "%");
				st.setString(2, "%" + booktype + "%");
			}

			if (!booktype.equals("")) {
				st = con.prepareStatement(s4);

				st.setString(1, "%" + name + "%");
				st.setString(2, "%" + author + "%");
				st.setString(3, "%" + booktype + "%");
			}

			if (!location.equals("")) {
				st = con.prepareStatement(s5);

				st.setString(1, "%" + name + "%");
				st.setString(2, "%" + author + "%");
				st.setString(3, "%" + booktype + "%");
				st.setString(4, "%" + location + "%");
			}

			rs = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}

	public ResultSet search_name(String name) {
		String msg = null;
		try {
			PreparedStatement st = null;
			createconnection();

			String s1 = "select * from book where bookname like ?";

			if (!name.equals("")) {
				st = con.prepareStatement(s1);

				st.setString(1, "%" + name + "%");

			}

			rs = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}

	public boolean delete_reserve_entry(String isbn, String id) {
		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("delete from reserve where idcustomer='" + id
					+ "' and ISBN='" + isbn + "'");
			System.out.println("record deleted");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

		}
		return true;
	}

	public ResultSet display_cust(String cid) {

		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from customer where idcustomer='"
					+ cid + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}
public ResultSet bookdetails(String isbn)
{
	try {
		createconnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from book where ISBN='"+isbn+"' ");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {

	}
	return rs;
}

	public String return_email(String cid) {

		String mail = null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from customer where idcustomer='"
					+ cid + "'");
			while (rs.next())

			{
				mail = rs.getString(5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return mail;
	}

	public ResultSet display(String isbn) {

		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from book where ISBN='" + isbn
					+ "' ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}

	public int bookaval(String isbn) {
		int ct = 0;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select bookcount from book where ISBN='"
					+ isbn + "' ");
			System.out.println("check availablilty of books in book table");
			while (rs.next()) {
				ct = rs.getInt(1);
				return ct;
				// System.out.println(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return ct;
	}

	public void bookcount_change(int c, String isbn) {
		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("update book set bookstatus='" + c
					+ "' where ISBN='" + isbn + "' ");
			System.out.println("count updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public boolean setstatus(String isbn, String status) {

		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("update book set book_status='" + status
					+ "' where ISBN='" + isbn + "' ");
			System.out.println("status updated");

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return true;
	}

	public String showstatus(String isbn) {

		String status = null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select book_status from book where ISBN='"
					+ isbn + "' ");
			System.out.println("check availablilty of books in book table");
			while (rs.next()) {
				status = rs.getString(1);
				System.out.println(status);
				return status;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return status;

	}

	void bookdel(String id) {
		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("delete from book where ISBN='" + id + "'");
			System.out.println("record deleted");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

		}
	}

	public String retrieve_ids(String isbn) {
		String id = null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from reserve where ISBN='" + isbn
					+ "' ");
			System.out.println("check availablilty of books in book table");
			while (rs.next()) {
				id = rs.getString(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return id;

	}

	public ResultSet retrieve_isbn() {

		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from reserve");
			System.out.println("check availablilty of books in book table");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return rs;

	}

	void createconnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/library",
					"root", "12345");

			if (!con.isClosed())
				System.out.println("Successfully connected to "
						+ "MySQL server using TCP/IP...");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {

		}
	}

	void closeconnection() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException logOrIgnore) {
			}
		if (st != null)
			try {
				st.close();
			} catch (SQLException logOrIgnore) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException logOrIgnore) {
			}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new AdminFunctions().displaybooks_month("2012/12/05", "2012/12/06");

	}

}
