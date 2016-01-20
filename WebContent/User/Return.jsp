<%@page import="in.co.init.OLM.user.Userfunctions"%>
<%@page import="in.co.init.OLM.admin.SendEmail"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="in.co.init.OLM.user.ReturnFunctions"%>
<%@page import="in.co.init.OLM.authentication.Authentication"%>
<%@page import="in.co.init.OLM.admin.AdminFunctions"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>12</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<link href="../style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="117" background="../images/index_01.gif"><table width="100%" border="0" cellspacing="10" cellpadding="0">
      <tr>
        <td width="43%">&nbsp;</td>
        <td width="32%"><table width="100%" border="0" cellspacing="5" cellpadding="0">
          <tr class="white-text">
            <td width="5%"><img src="../images/clock.gif" width="9" height="9"></td>
           
           <%
           Date d=new Date();
           %>
            <td width="95%" class="white-text">Today's date is: <%= d %> </td>
          </tr>
        </table></td>
        <td width="25%"><table width="100%" border="0" cellspacing="5" cellpadding="0"></td>
           <td>
                    
<form action="Search_name.jsp" method="get">

Search-<br/>
<input type="text" name="bookname" value="Enter bookname" onfocus="if (this.value == 'Enter bookname') {this.value = '';}"/>



<input type="submit" value="Search">

</form> 
            
            </td>
          <td> <a href="../authentication/logout.jsp"><img src="../images/logout.jpg" alt="logout" width="65" height="57" border="0"/></a></td>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="473" align="right" background="../images/index_02.gif"><table width="91%" border="0" cellspacing="10" cellpadding="0">
          <tr>
            <td><img src="../images/Welcome.gif" width="419" height="38"></td>
          </tr>
          <tr>
            <td class="white-text">Explore the world's knowedge!!!<br>
              To encourage the library of the ideal of the society of free and responsible indviduals...</td>
          </tr>
          <tr>
           
          </tr>
        </table></td>
        <td><img src="../images/index_03.jpg" width="527" height="340" alt=""></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
          <td><a href="../home.jsp"><img src="../images/index_04.gif" alt="" width="201" height="57" border="0"></a></td>
        <td><a href="aboutus.jsp"><img src="../images/index_05.gif" alt="" width="119" height="57" border="0"></a></td>
        <td><a href="../authentication/display.jsp"><img src="../images/index_07.gif" alt="" width="108" height="57" border="0"></a></td>
		<td><a href="Advance_search.jsp"><img src="../images/index_09.gif" alt="" width="101" height="57" border="0"></a></td>
        <td><a href="contactus.jsp"><img src="../images/index_10.gif" alt="" width="259" height="57" border="0"></a></td>
     </tr>
    </table></td>
  </tr>
</table>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="bg1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="70%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="right"><p>&nbsp;</p>
              <table width="94%" border="0" cellspacing="10" cellpadding="0">
              <tr>
             
              </tr>
              <tr>
                        </tr>		
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/index_24.gif">
              <tr>
                <td width="68%" align="right"><table width="89%" border="0" cellspacing="10" cellpadding="0">
                  <tr>
                  <%
                  HttpSession session1=request.getSession(true);
              	String s=(String)session1.getAttribute("cid");
             AdminFunctions func=new AdminFunctions();
             Authentication auth=new Authentication();
         	String name=auth.return_name(s);
         
         	
         
      		if(name!=null)
         	{
          	out.println("<h1>Hello  " +name+"</h1>");
          	out.print("<br/>");
         	
             
            out.println("<a href=Books_in_account.jsp><h3>View books issued to you</h3></a>");
         	}
         	
             
                  

          		
          	String s1=request.getParameter("isbn");
          		
          		String status="available";
          		String status1="returned";
          			String isuedate=null;
          		Date rtrndate=null;
          ReturnFunctions rf=new ReturnFunctions();
          boolean b1=rf.check_bookavlb(s1, s); //check availability in issue table
          if(b1)
          {
          	ResultSet rs=rf.check_book_return(s1,s); //select issuedate from issue table
          	try {
          		while(rs.next())
          		{
          			 isuedate=rs.getString(2);
          			//rtrndate=rs.getDate(3);
          		}
          	} catch (SQLException e1) {
          		// TODO Auto-generated catch block
          		e1.printStackTrace();
          	}
          	
          	String returndate=rf.change_returndate();
        	Integer fine=0;
        	String issuestatus="issued";
         	 fine=rf.calc_fine(s1,s,issuestatus);
         out.print("<h3>Fine:  "+fine+"</h3>");
        	boolean b=rf.update_issue(s1,s,status1,returndate);
          	if(b)
          	{
          	
          		out.print("<h2>Book has been returned...</h2>");

              
           
          	}
          
          	int bookcount=rf.bookaval(s1);

          	rf.change_bookcount(s1,bookcount);
          	   	
          //long fine=rf.calc_fine(rtrndate);
       //   out.print("Fine is "+fine);
          	AdminFunctions function=new AdminFunctions();
          	int c=function.bookaval(s1);
          	
          	if(c>0)
          	{
          		func.setstatus(s1, status);
          	}
          	
          	
            String bookname=null;
		        String author=null;
		        ResultSet rs3=function.bookdetails(s1);
		        while(rs3.next())
		        {
		        	bookname=rs3.getString(2);
		        	author=rs3.getString(3);
		        	
		        }
			
		       
		          
		          
		          
            AdminFunctions afun=new AdminFunctions();
        	ResultSet rs1=afun.display_cust(s);
     		
         	String email=null;
         try {

         while (rs1.next()) {
            
         
           
             email=rs1.getString(5);
            
            
            
             String subject = "Hi this is test Mail";  
  	        String messageBody = "Test Mail from online library management!! Book id "+s1+" , "+bookname+" of author "+author+" has been returned on "+returndate+" !!";  
  
  	  
  	        new SendEmail().sendMail(email, subject, messageBody);
  	       
  	       out.print("<h2><br/>check mail</h2>");

         
            
         }
        } catch (SQLException e) {
         e.printStackTrace();
        }
          		
          }

          else
          {
          	out.print("<h2>book is not issued so cant be returned!!!</h2>");
          }
      %>
                          </tr>
                  <tr>
                  
                  </tr>
                </table></td>
                <td width="50%" align="left">
  
                
               
               
                </td>
                  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="right"><p>&nbsp;</p>
              <p>&nbsp;</p>
              <table width="94%" border="0" cellspacing="10" cellpadding="0">
              <tr>
                <td><img src="../images/index_45.gif" width="158" height="25" alt=""></td>
              </tr>
              <tr>
                <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
                  <tr>
                    <td width="98%"><span class="black-text-regular"><strong class="blye-text-regular">Fact about library!!</strong><br>
A library is a delivery room for the birth of ideas, a place where history comes to life.<br/> We provide the options of issuing/returning/reservation a book to a member only</span></td>
                    <td width="2%" rowspan="2"><img src="../images/index_52.jpg" width="117" height="126" alt=""></td>
                  </tr> 
                  <tr>
                    <td><a href="#"><img src="../images/index_58.gif" alt="" width="84" height="20" border="0"></a></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="30%" align="right" valign="top"><p>&nbsp;</p>
          <table width="90%" border="0" cellspacing="10" cellpadding="0">
          <tr>
            <td><p><img src="../images/index_16.gif" width="140" height="33" alt=""></p>
              <p>&nbsp;</p></td>
          </tr>
          <tr>
           
          </tr>
          <tr>
            <td class="black-text-regular">
          <%  
            		if(name!=null)
               	{
                	out.println("<h3 style='color:orange;'>Logged in</h3>");
                  
                 
               	}
            		else
            		{
            			  out.print("<a href='../authentication/login.jsp'> LOGIN </a> to be a member of this library!!");
            		}
             %>
         
              <p>&nbsp;</p></td>
          </tr>
          <tr>
            <td><a href="#"><img src="../images/index_28.gif" alt="" width="79" height="16" border="0"></a></td>
          </tr>
          <tr>
            <td><p>&nbsp;</p>
              <p>&nbsp;</p>
              <p><img src="../images/index_32.gif" width="178" height="28" alt=""></p></td>
          </tr>
          <tr>
                        <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
              <tr>
               <td width="96%" class="black-text-regular"><a href="book1_issue.jsp">&bull; Programming with java </a><br>
                  <br>
                  Java Technical book latest edition </td>
                <td width="4%"><img src="images/index_40.jpg" width="33" height="33" alt=""></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#A2A2A2"><img src="images/spacer.gif" width="1" height="1"></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
              <tr>
                <td width="96%"><span class="black-text-regular"><a href="book2_issue.jsp">&bull;C# for java developers </a><br>
                    <br>
						DotNet skills enhanced </span></td>
                <td width="4%"><img src="images/index_49.jpg" width="36" height="36" alt=""></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#A2A2A2"><img src="images/spacer.gif" width="1" height="1"></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
              <tr>
                <td width="96%"><span class="black-text-regular"><a href="book3_issue.jsp">&bull;English grammer </a><br>
                     
                    <br> Enhance your english</span></td>
                <td width="4%"><img src="images/index_55.jpg" width="38" height="37" alt=""></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="88" background="images/index_63.gif">
      <table width="100%" border="0" cellspacing="10" cellpadding="0">
        <tr>
          <td width="50%" align="center"><a href="terms_of_use.jsp"><strong>Terms of Use</strong></a><strong class="blye-text-regular"> | </strong><a href="privacy_statement.jsp"><strong>Privacy Statement </strong></a></td>
          <td width="50%" align="center" class="gray-text-regular">&copy; 2012 GreatLibrary Corporation. All rights reserved</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>