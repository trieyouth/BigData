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


@WebServlet("/whereServerlet")

public class whereServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public whereServerlet() {
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
			String sql=  "select v61 ,sum(a.v4) as dd,sum(a.isbad) from (select v61,v4,case when v52='��'  then 1  else 0 end as isbad from makedata1_table_orc )a group by v61 order by dd";
		    ResultSet res = stmt.executeQuery(sql);  
		    String msg=" ";
		    while (res.next()) { 
		    	String s=res.getString(2).substring(0,res.getString(2).length()-4);
		    	System.out.println(s);
		    	msg+="{\"name\":\""+res.getString(1)+"\"  ,  \"value\":\""+s+"\"},";
		    }
		  
        out.print(msg.substring(0,msg.length()-1));
        System.out.println(msg);
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
