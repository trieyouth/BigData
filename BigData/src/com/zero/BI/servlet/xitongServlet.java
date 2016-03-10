package com.zero.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.dongliu.requests.Requests;
import net.dongliu.requests.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

   @WebServlet("/xitongServlet")
public class xitongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public xitongServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		 String res=StatisticsJobStatusBySc();
		String []str= res.split(",");
		int run= Integer.parseInt(str[1]);
		int finish= Integer.parseInt(str[0]);
		int err=Integer.parseInt(str[2]);
		int all=run+finish+err;
		ServletContext context=request.getSession().getServletContext();
		/*if(null==context.getAttribute("counter")){
			context.setAttribute("counter", 1);
		}else{
			int counter=(Integer)context.getAttribute("counter");
			context.setAttribute("counter", counter+1);
		}
		int countnum=(Integer) context.getAttribute("counter");*/
		HashSet sessions=(HashSet)context.getAttribute("username");
		int usernum=sessions.size();
		String msg= usernum+","+run+","+all;
		 out.print(msg); 
		 
		 
		 System.out.println(msg);
	}
	
	
	
	public static String StatisticsJobStatusBySc(){
		//閼惧嘲绶辩憴锝嗙�閸氬海娈戞潻鏂挎礀缂佹挻鐏�		JSONArray arr=sendReqGetRes("http://172.23.27.190:8090/jobs");
		//鐎涙ɑ鏂佺紒鎾寸亯
		/*HashMap<String,HashMap<String, Integer>> hashMap=new HashMap<String,HashMap<String, Integer>>();*/
		HashMap<String, Integer> map1=new HashMap<String, Integer>();
		map1.put("FINISHED", 0);
		map1.put("ERROR", 0);
		map1.put("RUNNING", 0);
		HashMap<String, Integer> map2=new HashMap<String, Integer>();
		map2.put("FINISHED", 0);
		map2.put("ERROR", 0);
		map2.put("RUNNING", 0);
		HashMap<String, Integer> mapOther=new HashMap<String, Integer>();
		mapOther.put("FINISHED", 0);
		mapOther.put("ERROR", 0);
		mapOther.put("RUNNING", 0);
		//瀵邦亞骞嗙拋鈩冩殶
//		for (int i = 0; i < arr.length(); i++) {
//			try {
//				JSONObject obj=(JSONObject) arr.get(i);
//				if(obj.getString("context").equals("sc1")){
//					String ststue=obj.getString("status");
//					map1.put(ststue, map1.get(ststue)+1);
//				}else if(obj.getString("context").equals("sc2")){
//					String ststue=obj.getString("status");
//					map2.put(ststue,  map2.get(ststue)+1);
//				}else{
//					String ststue=obj.getString("status");
//					mapOther.put(ststue,mapOther.get(ststue)+1);
//				}
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//		}
		
		int finish=map1.get("FINISHED")+map2.get("FINISHED")+mapOther.get("FINISHED");
		int run=map1.get("RUNNING")+map2.get("RUNNING")+mapOther.get("RUNNING");
		int err=map1.get("ERROR")+map2.get("ERROR")+mapOther.get("ERROR");
		String res=finish+","+run+","+err;
		return res;
	}
	/**
	 * 閸氭吘ob server閸欐垿锟紾et鐠囬攱鐪伴敍灞界殺鏉╂柨娲栭惃鍕波閺嬫粍鏂侀崗顧怱ONArray娑擄拷
	 * @param req
	 * @return
	 */
	public static JSONArray sendReqGetRes(String req){
		Response<String> resp = Requests.get(req).timeout(1000000000).text();
		JSONArray arr=null;
		try {
			arr=new JSONArray(resp.getBody());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	
	
	
	
	
}
