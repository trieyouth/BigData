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

@WebServlet("/jobPieServerlet")

public class jobPieServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public jobPieServerlet() {
	        super();
	    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("pie");
		
        if ("pie".equals(action)) {	
            this.Pie(request, response);
        }else if("ty".equals(action)){
        	this.ty(request,response);
        }
		
		

       
       

	}
	private void ty(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection connection = null;
		Statement stmt =null;
		String type = request.getParameter("type");
		type = new String(type.getBytes("UTF-8"),"UTF-8");
		
		System.out.println(type+":");
		try {
			HiveService service = new HiveService();
			// ����JDBC����
			while (null == connection) {
				connection = service.getConnection();
			}
			stmt = connection.createStatement();
			 String sql=  "select year,income ,sum(count) from (select substring(v62, 0,4) as year,case when cast(v9 as bigint)<36000 then 36000 when cast(v9 as bigint)< 72000 then 72000 when cast(v9 as bigint)< 96000 then 96000  when cast(v9 as bigint)< 120000 then 120000 else  1200001 end as income,count(*) as count from makedata1_table_orc where v19='"+type+"' group by  substring(v62, 0,4),income) a group by year,income order by year,income";
			    ResultSet res = stmt.executeQuery(sql);
			    String msg="";
		        String msg1 ="";
		        String msg2 ="";
		        String msg3 ="";
		        String msg4="";
		        String msg5 ="";
		        String msg6 ="";
		        
		        while (res.next()) { 
		        	if(res.getString(2).equals("36000")){
		        		msg1+=res.getString(3)+",";
		        	}
		        	if(res.getString(2).equals("72000")){
		        		msg2+=res.getString(3)+",";
		        	}
		        	if(res.getString(2).equals("96000")){
		        		msg3+=res.getString(3)+",";
		        	} 
		        	if(res.getString(2).equals("120000")){
		        		msg4+=res.getString(3)+",";
		        	}
		        	if(res.getString(2).equals("1200001")){
		        		msg5+=res.getString(3)+",";
		        	}
		        	if(res.getString(1).equals("2015")){
		        		msg6+=res.getString(3)+",";
		        	}    
		        } 
		        msg+=msg1.substring(0,msg1.length()-1)+";"+msg2.substring(0,msg2.length()-1)+";"+msg3.substring(0,msg3.length()-1)+";"+msg4.substring(0,msg4.length()-1)+";"+msg5.substring(0,msg5.length()-1)+";"+msg6.substring(0,msg6.length()-1);
		        out.print(msg);
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
		out.print("[");
		Connection connection = null;
		Statement stmt =null;
		try {
			HiveService service = new HiveService();
			// ����JDBC����
			while (null == connection) {
				connection = service.getConnection();
			}
	     String sql=  "select  v19,count(*)  from makedata1_table_orc where v52='��' group by v19";

		    stmt = connection.createStatement();
		    ResultSet res = stmt.executeQuery(sql);
		    String msg=" ";
		    while (res.next()) { 
		    	msg+="{\"name\":\""+res.getString(1)+"\"  ,  \"value\":\""+res.getString(2)+"\"},";
		    }
       
        out.print(msg.substring(0,msg.length()-1));
         out.print("]");
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