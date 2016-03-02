package com.zero.controller.ccas;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zero.service.HiveService;

@RequestMapping("/ccas/index/BIShow")
@Controller
public class CCASBIShowController {

	@Autowired
	HiveService hiveService;

	@RequestMapping("/BI")
	public String BI() {
		return "client-credit-analyse-system/BI-show/BI";
	}

	@RequestMapping("/map")
	public String map() {
		return "client-credit-analyse-system/BI-show/map";
	}

	// 原來的whereServlet
	@ResponseBody
	@RequestMapping(value = "/map/area", produces = "text/html;charset=UTF-8")
	public String mapArea() {
		String json = "[";
		Connection connection = null;
		Statement stmt = null;
		// 建立JDBC連接
		while (connection == null) {
			connection = hiveService.getConnection();
		}
		try {
			stmt = connection.createStatement();
			String sql = "select v61 ,sum(a.v4) as dd,sum(a.isbad) from (select v61,v4,case when v52='是'  then 1  else 0 end as isbad from makedata1_table_orc )a group by v61 order by dd";
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				String s = res.getString(2).substring(0,
						res.getString(2).length() - 4);
				System.out.println(s);
				json += "{\"name\":\"" + res.getString(1) + "\",\"value\":\""
						+ s + "\"},";
			}
			json = json.substring(0, json.length() - 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			json += "]";
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
		return json;
	}

	@RequestMapping("/jobpie")
	public String jobpie() {
		return "client-credit-analyse-system/BI-show/jobpie";
	}

	@ResponseBody
	@RequestMapping(value = "/jobpie/pie", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String jobpiePie() {
		String json = "[";
		Connection connection = null;
		Statement stmt = null;
		try {
			while (null == connection) {
				connection = hiveService.getConnection();
			}
			stmt = connection.createStatement();

			String sql = "select  v19,count(*)  from makedata1_table_orc where v52='是' group by v19";
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				json += "{\"name\":\"" + res.getString(1)
						+ "\"  ,  \"value\":\"" + res.getString(2) + "\"},";
			}
			json = json.substring(0, json.length() - 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			json += "]";
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
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/jobpie/ty/{type}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String jobpieTY(@PathVariable("type") String type) {
		String msg = "[";
		Connection connection = null;
		Statement stmt = null;
		try {
			type = URLDecoder.decode(type, "UTF-8");
			//type = new String(type.getBytes("UTF-8"),"UTF-8");
			System.out.println(type+":");
			while (null == connection) {
				connection = hiveService.getConnection();
			}
			stmt = connection.createStatement();
			String sql=  "select year,income ,sum(count) from (select substring(v62, 0,4) as year,case when cast(v9 as bigint)<36000 then 36000 when cast(v9 as bigint)< 72000 then 72000 when cast(v9 as bigint)< 96000 then 96000  when cast(v9 as bigint)< 120000 then 120000 else  1200001 end as income,count(*) as count from makedata1_table_orc where v19='"+type+"' group by  substring(v62, 0,4),income) a group by year,income order by year,income";
		    ResultSet res = stmt.executeQuery(sql);
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
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}finally {
			msg += "]";
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
		return msg;
	}
	
	@RequestMapping("/dklx")
	public String dklx() {
		return "client-credit-analyse-system/BI-show/dklx";
	}

	@RequestMapping("/dkzl")
	public String dkzl() {
		return "client-credit-analyse-system/BI-show/dkzl";
	}

	@RequestMapping("/xueli")
	public String xueli() {
		return "client-credit-analyse-system/BI-show/xueli";
	}

	@RequestMapping("/yixiang")
	public String yixiang() {
		return "client-credit-analyse-system/BI-show/yixiang";
	}

	@RequestMapping("/jiqun")
	public String jiqun() {
		return "client-credit-analyse-system/BI-show/jiqun";
	}
}
