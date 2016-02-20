package com.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class myserverlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("[");
		
        int[] series = new int[]{21,23,28,26,21,33,44};//×Ý×ø±ê  
        String msg="";
        for (int i = 0; i < series.length; i++) {
        	msg+="{\"ser\":\""+series[i]+"\"  ,  \"zhou\":\""+"today"+i+"\"},";
			
		}
        System.out.println("df");
        out.print(msg.substring(0,msg.length()-1));
        System.out.println(msg.substring(0,msg.length()-1));
        out.print("]");
        out.flush();
        //PrintWriter pw = response.getWriter();   
       // pw.print(data.toString());  
       // pw.close();  
       
        //System.out.println(data.category);
        
       // response.setContentType("application/json");
        
		//response.getWriter().write(data.toString());
		
       
      // request.getSession().setAttribute("activityList", data);
       
		//response.sendRedirect(request.getContextPath() + "/10.jsp");

	}

}
