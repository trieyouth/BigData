package com.zero.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.service.HiveService;

@WebServlet("/dklServerlet")

public class dklServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public dklServerlet() {
	        super();
	    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("send");
		System.out.println("dd");
        if ("one".equals(action)) {	
            this.Pie(request, response);
        }else if("two".equals(action)){
        	this.ty(request,response);
        }   
	}
	private void ty(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("[");
		Connection connection = null;
		Statement stmt =null;
		String mon = request.getParameter("type");
		String year = request.getParameter("year");
		/*mon = new String(mon.getBytes("iso8859-1"),"UTF-8");
		year = new String(year.getBytes("iso8859-1"),"UTF-8");*/
		
		try {
			HiveService service = new HiveService();
			// ����JDBC����
			while (null == connection) {
				connection = service.getConnection();
			}
			stmt = connection.createStatement();
			 String sql=  "select v19,sum(cast(v4 as bigint)) from makedata1_table_orc where substring(v62, 0,4) ='"+year+"'and substring(v62, 5,2) = '"+mon+"' group by v19";
			    ResultSet res = stmt.executeQuery(sql);
			    String msg=" ";
			    while (res.next()) { 
			    	msg+="{\"name\":\""+res.getString(1)+"\"  ,  \"value\":\""+res.getString(2)+"\"},";
			    }
	       
	          out.print(msg.substring(0,msg.length()-1));
	         out.print("]");
	          out.flush();
		       
		        System.out.println(msg);
			} catch (SQLException e) {  
	            e.printStackTrace();   
	            System.exit(1);  
	        } finally {  
	            try {  
	                if (connection != null) {  
	                	connection.close();  
	                	connection = null;  
	                }  
	                if (stmt != null) {  
	                    stmt.close();  
	                    stmt = null;  
	                }  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
			
			

	private void Pie(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection connection = null;
		Statement stmt =null;
		try {
			HiveService service = new HiveService();
			// ����JDBC����
			while (null == connection) {
				connection = service.getConnection();
			}
			 String sql=  "select substring(v62, 0,4) as a,substring(v62, 5,2) as b,sum(cast(v4 as bigint))  from makedata1_table_orc  group by substring(v62, 0,4),substring(v62, 5,2) order by a,b ";

		    stmt = connection.createStatement();
		    ResultSet res = stmt.executeQuery(sql);
		    String msg=" ";
		    while (res.next()) { 
		    	msg+=res.getString(3)+",";
		    }
          out.print(msg.substring(0,msg.length()-1));
          out.flush();
		} catch (SQLException e) {  
            e.printStackTrace();   
            System.exit(1);  
        } finally {  
            try {  
                if (connection != null) {  
                	connection.close();  
                	connection = null;  
                }  
                if (stmt != null) {  
                    stmt.close();  
                    stmt = null;  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }
	}

	
	
}