package com.zero.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.service.HiveService;

import net.sf.json.JSONObject;


@WebServlet("/xlpieServerlet")

public class xlpieServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public xlpieServerlet() {
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
		Connection connection = null;
		Statement stmt =null;
		out.print("[");
		try {
			HiveService service = new HiveService();
			// ����JDBC����
			while (null == connection) {
				connection = service.getConnection();
			}
		    stmt = connection.createStatement();
			 String sql=  "select v12,count(*)  from makedata1_table_orc where v52='��' group by v12";
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
