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


@WebServlet("/dklxServerlet")

public class dklxServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public dklxServerlet() {
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
		try {
			HiveService service = new HiveService();
			// ����JDBC����
			while (null == connection) {
				connection = service.getConnection();
			}
		    stmt = connection.createStatement();
		    String sql=  "select substring(v62, 0,4) as da,v3,count(*)  from makedata1_table_orc where v52='��' group by substring(v62, 0,4),v3 order by da ,v3;";
		    ResultSet res = stmt.executeQuery(sql);  
	        System.out.println("ִ�С�regular hive query�����н��:");  
	        Map<String, StringBuffer> map =new HashMap<String, StringBuffer>();
	        while (res.next()) { 
	        	if(map.containsKey(res.getString(2))){
	             map.get(res.getString(2)).append(",").append(res.getString(3));
	        	}else{
	        		map.put(res.getString(2),new StringBuffer( res.getString(3)));
	        	}
	            System.out.println(res.getString(1)+","+res.getString(2)+","+res.getString(3));  
	        } 
	        String msg="";
	        for (String year : map.keySet()) {
				msg+=map.get(year)+":";
			}
	        System.out.println(map);
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
