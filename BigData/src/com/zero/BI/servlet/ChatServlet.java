package com.zero.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet瀹炵幇绫籆hatServlet
 */
   @WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChatServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
        if ("send".equals(action)) {	
            this.send(request, response);
        }else if("get".equals(action)){
        	this.get(request,response);
        }
		
	}
	
	
	public void send(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
		ServletContext application=getServletContext();		
		response.setContentType("text/html;charset=UTF-8");
		ArrayList al = new ArrayList();
		for(int i=1;i<13;i++){
			al.add(i);
		}
		application.setAttribute("message",al);		
        Random random = new Random();
		request.getRequestDispatcher("ChatServlet?action=get&nocache=" + random.nextInt(10000)).forward(request, response);
	}
	
	
	public void get(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");	
		response.setHeader("Cache-Control", "no-cache");	
		PrintWriter out = response.getWriter();	
		ServletContext application=getServletContext();		
		if(null!=application.getAttribute("message")){
			ArrayList al=(ArrayList)application.getAttribute("message");
			out.println(al);	
			out.close();	
		}
	}
}
