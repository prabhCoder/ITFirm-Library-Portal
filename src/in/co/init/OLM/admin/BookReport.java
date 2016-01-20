package in.co.init.OLM.admin;

import in.co.init.OLM.authentication.Authentication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.Statement;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class BookReport {
	    int rownum = 0;
	    HSSFSheet firstSheet;
	    Collection<File> files;
	    HSSFWorkbook workbook;
	    Connection con = null;
		String fromdate2 = null;
		 String todate2=null;
		
	    File exactFile;
	    {
	        workbook = new HSSFWorkbook();
	        firstSheet = workbook.createSheet("BOOK REPORT");
	        Row headerRow = firstSheet.createRow(rownum);
	        headerRow.setHeightInPoints(40);
	    }
	    
		void createconnection() {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/LIBRARY",
						"root", "12345");

				if (!con.isClosed())
					System.out.println("Successfully connected to "
							+ "MySQL server using TCP/IP...");

			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			} finally {
				// try {
				// if(con != null)
				// con.close();
				// } catch(SQLException e) {}
			}
		}
		
		public void setfromdate(String from)
      	{
           fromdate2 = from;
      	}
      	public String getfromdate(){
      		return fromdate2;
      	}
      	public void settodate(String to)
      	{
           todate2 = to;
      	}
      	public String gettodate(){
      		return todate2;
      	}
	    	
	   /* public static void main(String args[]) throws Exception {
	    	
	    	new ExcelWriter().createEX();
	        
	    }*/
	    
	    public void createEX(OutputStream out){
	    	
	    	createconnection();
	    	List<String> headerRow = new ArrayList<String>();
	        headerRow.add("ISBN");
	        headerRow.add("CUSTOMER_ID");
	        headerRow.add("ISSUEDATE");
	        headerRow.add("DUEDATE");
	        headerRow.add("REISSUE STATUS");
	        headerRow.add("ISSUE/RETURN STATUS");
	        
	        List<String> rows = new ArrayList<String>();
	        String s1 = null;
	        String s2 = null;
	        String s3 = null;
	        String s4 = null;
	        String s5 = null;
	        String s6 = null;
	        
	        AdminFunctions book = new AdminFunctions();
	        String fromdate1 = getfromdate(); 
	        String todate1 = gettodate();
	        System.out.println(fromdate1);
	        System.out.println(todate1);
	        
	        ResultSet rs= book.displaybooks_month(fromdate1,todate1);
	        List<List> recordToAdd = new ArrayList<List>();
	        recordToAdd.add(headerRow);
	       try{
	        while(rs.next())
	        {	
	        List<String> row = new ArrayList<String>();	
	        s1 = rs.getString(4);
	        s2 = rs.getString(5);
	        s3 = rs.getString(2);
	        s4 = rs.getString(3);
	        s5 = rs.getString(6);
	        s6 = rs.getString(7);
	        
	        row.add(s1);
	        row.add(s2);
	        row.add(s3);
	        row.add(s4);
	        row.add(s5);
	        row.add(s6);
	        
	       
	        recordToAdd.add(row);
	        }
	        BookReport cls = new BookReport(recordToAdd);
	        cls.createFile(out);
	       }catch(Exception e){
	    	   e.printStackTrace();
	       }
	        
	       
	    }
	    void createFile(OutputStream out){
	       
	        try {
	        	workbook.write(out);
	        	out.close();     
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	     BookReport(List<List> l1) throws Exception {
	        try {
	            for (int j = 0; j < l1.size(); j++) {
	                Row row = firstSheet.createRow(rownum);
	                List<String> l2= l1.get(j);
	                for(int k=0; k<l2.size(); k++)
	                {   
	                	firstSheet.setColumnWidth(0,5000);
	                    Cell cell = row.createCell(k);
	                    cell.setCellValue(l2.get(k));
	                    
	                    HSSFCellStyle hsfstyle=workbook.createCellStyle();
	                    
	                    hsfstyle.setBorderBottom(CellStyle.BORDER_THIN);
	                    hsfstyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	                    hsfstyle.setBorderLeft(CellStyle.BORDER_THIN);
	                    hsfstyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	                    hsfstyle.setBorderRight(CellStyle.BORDER_THIN);
	                    hsfstyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	                    hsfstyle.setBorderTop(CellStyle.BORDER_THIN);
	                    hsfstyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	                    
	                    
	                    
	                    
	                   /* hsfstyle.setFillForegroundColor(HSSFColor.BLACK.index);
	                    hsfstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);*/

	                    HSSFFont font = workbook.createFont();
	                    font.setColor(HSSFColor.BLACK.index);
	                    hsfstyle.setFont(font);

	                    cell.setCellStyle(hsfstyle);
	                    
	                   
	                }
	                rownum++;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        }
	    }

	     public static void main(String[] args) {
		
		}
		public BookReport() {
			// TODO Auto-generated constructor stub
		}
	}

