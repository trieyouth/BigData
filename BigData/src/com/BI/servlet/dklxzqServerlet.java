package com.BI.servlet;

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

import com.service.HiveService;

import net.sf.json.JSONObject;


@WebServlet("/dklxzqServerlet")

public class dklxzqServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public dklxzqServerlet() {
	        super();
	    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String year = request.getParameter("year");
		type = new String(type.getBytes("iso8859-1"),"UTF-8");
		year = new String(year.getBytes("iso8859-1"),"UTF-8");
		System.out.println("dd");
		Connection connection = null;
		Statement stmt =null;
		try {
			HiveService service = new HiveService();
			// 建立JDBC连接
			while (null == connection) {
				connection = service.getConnection();
			}
			stmt = connection.createStatement();
		 
			String sql=  "select substring(v62, 5,2) as da,v52,count(*)  from makedata1_table_orc where v3= '"+type+"' and substring(v62, 0,4)='"+year+"' group by substring(v62, 5,2),v52 order by da";
			//String sql2=  "select substring(v62, 5,2) as da,v52,count(*)  from makedata1_table_orc where v3= '"+type+"' and substring(v62, 0,4)='"+year+"' and v52='否' group by substring(v62, 5,2),v52 order by da";
		   ResultSet res = stmt.executeQuery(sql);  
		    String msg1 ="";
		    String msg2="";
			 while (res.next()) { 
				 if(res.getString(2).equals("是")){
		        	msg1+=res.getString(3)+",";
		            System.out.println(res.getString(1)+","+res.getString(2)+","+res.getString(3));  
		        } else{
		        	msg2+=res.getString(3)+",";
		        }
			 }
			 String msg=msg1.substring(0,msg1.length()-1)+":"+msg2.substring(0,msg2.length()-1);
			 System.out.println(msg);
		        out.print(msg);
	            out.flush();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	      
	       
       

	}

}
