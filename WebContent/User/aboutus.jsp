<%@page import="java.sql.ResultSet"%>
<%@page import="in.co.init.OLM.admin.AdminFunctions"%>
<%@page import="in.co.init.OLM.authentication.Authentication"%>
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
                <td width="68%" align="left"><table width="89%" border="0" cellspacing="10" cellpadding="0">
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
         	
             %>
                          </tr>
                  <tr>
                  
                  </tr>
                </table></td>
               
                  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="right"><p>&nbsp;</p>
              <p>&nbsp;</p>
              <table width="94%" border="10" cellspacing="10" cellpadding="0">
              <tr>
             
              </tr>
              <tr>
                <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
                  <tr>
                   
                   
                    <p style="font-size: 14px;"><br/>
                  The library the treasure house of books and periodicals  is a centre of intellectual activity of any institution.  The Central Library strives to its readers in the interest of creativity and innovation, the predecessors of Research and Development.  The library started along with the institution in the year 2000.

It has a well-equipped library stacking more than 22,000 volumes of choice books in various engineering subjects, management, basic sciences and general.
  The library subscribes to more than 200 periodicals in print.  Besides, the library has 189 bound volumes of periodicals.  The audiovisual educational programmes and video courses are often carried out in the library.

The services provided by the library includes Lending service, Reference service, Inter Library Loan, Internet Browsing, Current Awareness Service (CAS), and Selective Dissemination of Information  (SDI) Service.

A separate Digital Knowledge Centre has been established in order to enable the users to browse the e-journals, e-learning materials, digital library collections of this campus and other online journals. This facility is available in the intranet of this campus. Recently IIT Web courses were added. The library has one file server for digital library and 10 nodes for the purpose of Information Retrieval system.

The library services have been automated. It is a menu driven, interactive, user-friendly package, designed with utmost care to meet the studentsâ€™ information needs, such as the availability of books, status of the books, user details etc. The library has one file server and two computers for the automation. One system is placed at circulation counter and another system is kept at the entrance of the library for the purpose of searching Online Public Access Catalogue (OPAC).

An open reading area of 4000 Sq.ft for the students has been provided in the Library.
                   
                    </p>
                   
                 
             
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
          <td width="50%" align="center" class="gray-text-regular">&copy; 2009 Your Corporation. All rights reserved</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>