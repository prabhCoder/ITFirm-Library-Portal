package in.co.init.OLM.user;

import in.co.init.OLM.admin.AdminFunctions;
import in.co.init.OLM.admin.SendEmail;
import in.co.init.OLM.entity.Book;
import in.co.init.OLM.entity.Branch;
import in.co.init.OLM.entity.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Userfunctions {
	Connection con = null;
	ResultSet rs;
	Statement st;

	Timer timer;

	public boolean insert_customer_record(String name, String add,
			String contact, String mail, String login, String pass, String dob) {

		try {
			createconnection();
			PreparedStatement st;

			st = con.prepareStatement("insert into customer(custname,custaddress,custcontact,custmail,loginid,cpassword,cdob) values(?,?,?,?,?,?,?)");
			st.setString(1, name);
			st.setString(2, add);
			st.setString(3, contact);
			st.setString(4, mail);
			st.setString(5, login);
			st.setString(6, pass);
			st.setString(7, dob);

			int r = st.executeUpdate();

			System.out.println("<html>");
			System.out.println("<body>");
			System.out.println("Record inserted!!!");
			System.out.println("</body>");
			System.out.println("</html");

		} catch (SQLException e) {
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
				return status;
				// System.out.println(ct);
			}
		} catch (SQLException e) {
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
		return status;

	}

	public String getBookStatus(String isbn) {
		String bookStatus = null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select book_status from book where ISBN="
					+ isbn);
			System.out.println("check availablilty of books in book table");
			while (rs.next()) {
				bookStatus = rs.getString("book_status");
			}
		} catch (SQLException e) {
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
		return bookStatus;
	}

	public Integer getBookCount(String isbn) {
		Integer bookcount = null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select bookcount from book where ISBN="
					+ isbn);
			System.out.println("check availablilty of books in book table");
			while (rs.next()) {
				bookcount = rs.getInt("bookcount");
			}
		} catch (SQLException e) {
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
		return bookcount;
	}
	public int getid() {
		int id = 0;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select idissue from issue ");
			System.out.println("id accessed");

			while (rs.next()) {
				// System.out.println(rs.getInt(1));
				id = rs.getInt(1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{

		}
		return id;

	}

	public int idincrement() {
		int s2 = getid();
		s2++;
		System.out.println("idincremntd:" + s2);
		return s2;
	}

	public boolean checkIssueStatus(String custId) {
		boolean status = false;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select status from issue where idcustomer="
					+ custId + " and status='issued'");
			System.out.println("check availablilty of book in account");

			if (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
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
		return status;
	}

	public int check_book_available(String id) {
		int ct = 0;
		// String issuedt=null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select count(*) from issue where idcustomer='"
					+ id + "'  ");
			System.out.println("check availablilty of book in account");
			while (rs.next()) {
				ct = rs.getInt(1);
				return ct;
				// System.out.println(ct);
			}
		} catch (SQLException e) {
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

	public ResultSet display_books(String cid) {
		String s = "issued";

		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from issue where idcustomer='" + cid
					+ "' and status='" + s + "'  group by 'issuedate'");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		finally{

		}
		return rs;
	}

	public boolean issuelogic(String isbn, String custId, String status) {// int
		// s1=idincrement();
		String s2 = issuedate();
		String s3 = duedate();
		String flag = "no";// flag signifies if book is reissued or not
		try {
			createconnection();
			PreparedStatement st;
			st = con.prepareStatement("insert into issue(issuedate,duedate,ISBN,idcustomer,flag,status) values(?,?,?,?,?,?)");
			// st.setInt(1,s1);
			st.setString(1, s2);
			st.setString(2, s3);
			st.setString(3, isbn);
			st.setString(4, custId);
			st.setString(5, flag);
			st.setString(6, status);
			int r = st.executeUpdate();
			System.out.println("Record inserted");
		} catch (SQLException e) {
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

	
	public boolean CheckIssueAccount(String isbn,String id,String bookStatus)
	{boolean issuestatus=false;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from issue where ISBN='"+isbn+"' and idcustomer='" + id
					+ "' and status='" + bookStatus+ "' ");
			while(rs.next())
			{
				System.out.println("record exist");
				issuestatus=true;
			}
			System.out.println(issuestatus);

		} catch (SQLException e) {
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
		return issuestatus;
	}
	
	
	public boolean issueBook(String custId,String isbn) {

		Userfunctions func = new Userfunctions();
		Customer customer = func.findByCustId(custId);

		Book book = func.findByIsbn(isbn);

		// check book availibility
		String bookStatus = func.getBookStatus(isbn);

		// if(null!= bookStatus && "available".equals(bookStatus)){

		// user issue status
		boolean issueStatus = func.checkIssueStatus(custId);
		boolean isIssueDone=false;

		// make entry in issue table
		if (!issueStatus) {
			
			String status = "issued";
			func.issuelogic(isbn, custId, status);
			

			// decrease book count

			AdminFunctions admin = new AdminFunctions();
			int bookCount = admin.bookaval(isbn);
			func.change_bookcount(isbn, bookCount);

			// send mail
			String subject = "Hi this is test Mail";
			String messageBody = "Test Mail from online library management!! Book id "
					+ isbn + "has been issued to you!!";

			/*SendEmail mail = new SendEmail();
			mail.sendMail(customer.getEmailId(), subject, messageBody);*/
			isIssueDone=true;
		}
		
		
		// }
		
		return isIssueDone;

	}

	public Customer findByCustId(String custId) {
		Customer customer = null;
		try {
			createconnection();
			StringBuilder query = new StringBuilder();
			query.append("select idcustomer,custname,custaddress,custcontact,custmail,cpassword,loginid from customer where idcustomer='"
					+ custId + "'");

			st = con.createStatement();
			rs = st.executeQuery(query.toString());

			while (rs.next()) {

				customer = new Customer();
				customer.setCustId(rs.getInt("idcustomer"));
				customer.setName(rs.getString("custname"));
				customer.setAddress(rs.getString("custaddress"));
				customer.setEmailId(rs.getString("custmail"));
				customer.setContactNumber(rs.getString("custcontact"));
				customer.setLoginId(rs.getString("loginid"));
				customer.setPassword(rs.getString("cpassword"));

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		finally{
			
		}

		return customer;

	}

	public Book findByIsbn(String isbn) {
		Book book = null;
		try {
			createconnection();
			StringBuilder query = new StringBuilder();
			query.append("select isbn,bookname,bookauthor,bookpublisher,booktype,bookcount,bookprice,book_status,location ");
			query.append("from book where isbn=" + isbn + "");
			st = con.createStatement();
			rs = st.executeQuery(query.toString());

			while (rs.next()) {

				book = new Book();
				book.setIsbn(rs.getInt("isbn"));
				book.setName(rs.getString("bookname"));
				book.setAuthor(rs.getString("bookauthor"));
				book.setPublisher(rs.getString("bookpublisher"));
				book.setType(rs.getString("booktype"));
				book.setCount(rs.getInt("bookcount"));
				book.setPrice(rs.getInt("bookprice"));
				book.setStatus(rs.getString("book_status"));

				Branch branch = new Branch();
				branch.setLocation(rs.getString("location"));

				book.setBranch(branch);

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		finally{
			
		}

		return book;

	}

	public boolean change_bookcount(String isbn, int count) {

		int newcount = count - 1;
		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("update book set bookcount='" + newcount
					+ "' where ISBN=" + isbn);
			System.out.println("bookcount updated");

		}

		catch (SQLException e) {
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

	public int check_useraccount(String isbn, String id) {
		int count = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select count(*) from issue where ISBN='"
					+ isbn + "' and idcustomer='" + id + "' ");
			if (rs.next()) {
				count = rs.getInt(1);
				return count;
			}
		} catch (SQLException e) {
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
		return count;
	}

	public String check_book_return(String isbn, String id) {

		String issuedt = null;
		try {
			createconnection();
			st = con.createStatement();
			rs = st.executeQuery("select issuedate from issue where idcustomer='"
					+ id + "' and ISBN='" + isbn + "' ");
			System.out.println("id accessed");
			while (rs.next()) {
				issuedt = rs.getString(2);
				return issuedt;
			}
		} catch (SQLException e) {
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
		return issuedt;
	}

	public String issuedate() {
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
	
	public String duedate() {
		String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Calendar dd = Calendar.getInstance(); // today
		dd.add(Calendar.DATE, 14);
		String duetoday = sdf.format(dd.getTime());
		return duetoday;

	}

	public boolean reissue_entry_issuetable(String isbn, String cid,
			String idate, String rdate, String flag) {
		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("update issue set issuedate='" + idate
					+ "' , duedate='" + rdate + "' , flag='" + flag
					+ "' where ISBN='" + isbn + "' and idcustomer='" + cid
					+ "' ");
			System.out.println("book reissued updated");

		}

		catch (SQLException e) {
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

	public boolean delete_rec(String isbn, String id, String isue, String retrn) {
		// TODO Auto-generated method stub
		try {
			createconnection();
			st = con.createStatement();
			st.executeUpdate("delete from issue where ISBN='" + isbn
					+ "' and idcustomer='" + id + "' and issuedate='" + isue
					+ "' and duedate='" + retrn + "' ");
			System.out.println("record deleted");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		finally{
		
		}
		return true;

	}

	public boolean reserve(String isbn, String id) {
		int s1 = idincrement();
		String s2 = issuedate();

		try {
			createconnection();
			PreparedStatement st;
			st = con.prepareStatement("insert into reserve(reservedate,ISBN,idcustomer) values(?,?,?)");
			// st.setInt(1,s1);
			st.setString(1, s2);
			st.setString(2, isbn);
			st.setString(3, id);

			int r = st.executeUpdate();
			System.out.println("Record inserted");
		} catch (SQLException e) {
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

	void createconnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/library",
					"root", "12345");

			if (!con.isClosed())
				System.out.println("Successfully connected to "
						+ "MySQL server");

		} catch (Exception e) {
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
public static void main(String[] args) {
	Userfunctions uf=new Userfunctions();
	uf.CheckIssueAccount("1", "2", "issued");
	}
}

