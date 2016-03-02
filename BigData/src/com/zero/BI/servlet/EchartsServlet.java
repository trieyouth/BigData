package com.zero.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class EchartsServlet
 */
@WebServlet("/echartsServlet")
public class EchartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
	 	String[] categories = {"Ь", "����", "����", "ţ�п�"};  
	    Integer[] values = {80, 50, 75, 100};  
	    Map<String, Object> json = new HashMap<String, Object>();  
	    json.put("categories", categories);  
	    json.put("values", values);  
	    JSONObject js = JSONObject.fromObject(json);

	    PrintWriter out = response.getWriter();  
        out.println(js);  
        out.flush();  
        out.close(); 
	}

}
