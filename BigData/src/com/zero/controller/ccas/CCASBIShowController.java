package com.zero.controller.ccas;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteOrder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.IIOByteBuffer;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.dongliu.requests.Requests;
import net.dongliu.requests.Response;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

import com.zero.cache.LRUCache;
import com.zero.common.Global;
import com.zero.controller.ccas.AbsJsonProducer;
import com.zero.service.HiveService;

/*
 * created by youth
 * 這個controller的數據全部做了cache，不知道好不好，勿噴
 * connection只連接一次，存在的問題是，connection不知應該什麼時候關閉
 * */

@RequestMapping("/ccas/index/BIShow")
@Controller
public class CCASBIShowController {

	@Autowired
	HiveService hiveService;

	private final String AREA = "AREA";// 地区贷款量统计缓存
	private final String PIE = "PIE";// 行业逾期总表缓存
	private final String TY = "TY";// 行业逾期子表缓存
	private final String DKLX = "DKLX";// 贷款类型逾期展示缓存
	private final String DKZLPIE = "DKZLPIE";// 贷款量统计总表缓存
	private final String DKZLTY = "DKZLTY";// 贷款量统计数据缓存
	private final String XUELIPIE = "XUELIPIE";// 学历逾期
	private final String JQ_PERFORMANCE = "JQ_PERFORMANCE";//集群性能

	private LRUCache<String, String> cache = new LRUCache<String, String>(10,
			60000);

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
		return getJson(new AbsJsonProducer(AREA) {

			@Override
			public String produceJson(ResultSet res) {
				String json = "";
				try {
					while (res.next()) {
						String s = res.getString(2).substring(0,
								res.getString(2).length() - 4);
						System.out.println(s);
						json += "{\"name\":\"" + res.getString(1)
								+ "\",\"value\":\"" + s + "\"},";
					}
					if (json.length() >= 1) {
						json = json.substring(0, json.length() - 1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return json;
			}

			@Override
			public String getSql() {
				String sql = "select v61 ,sum(a.v4) as dd,sum(a.isbad) from (select v61,v4,case when v52='是'  then 1  else 0 end as isbad from makedata1_table_orc )a group by v61 order by dd";
				return sql;
			}
		});
	}

	@RequestMapping("/jobpie")
	public String jobpie() {
		return "client-credit-analyse-system/BI-show/jobpie";
	}

	@ResponseBody
	@RequestMapping(value = "/jobpie/pie", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String jobpiePie() {

		return getJson(new AbsJsonProducer(PIE) {

			@Override
			public String produceJson(ResultSet res) {
				String json = "";
				try {
					while (res.next()) {
						json += "{\"name\":\"" + res.getString(1)
								+ "\"  ,  \"value\":\"" + res.getString(2)
								+ "\"},";
					}
					if (json.length() >= 1) {
						json = json.substring(0, json.length() - 1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return json;
			}

			@Override
			public String getSql() {
				String sql = "select  v19,count(*)  from makedata1_table_orc where v52='是' group by v19";
				return sql;
			}
		});
	}

	@ResponseBody
	@RequestMapping(value = "/jobpie/ty/{type}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String jobpieTY(@PathVariable("type") String type) {
		final String s[] = new String[1];
		try {
			s[0] = URLDecoder.decode(type, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		;
		return getJson(new AbsJsonProducer(TY + type) {
			@Override
			public String produceJson(ResultSet res) {
				String msg = "";
				String msg1 = "";
				String msg2 = "";
				String msg3 = "";
				String msg4 = "";
				String msg5 = "";
				String msg6 = "";
				try {
					while (res.next()) {
						if (res.getString(2).equals("36000")) {
							msg1 += res.getString(3) + ",";
						}
						if (res.getString(2).equals("72000")) {
							msg2 += res.getString(3) + ",";
						}
						if (res.getString(2).equals("96000")) {
							msg3 += res.getString(3) + ",";
						}
						if (res.getString(2).equals("120000")) {
							msg4 += res.getString(3) + ",";
						}
						if (res.getString(2).equals("1200001")) {
							msg5 += res.getString(3) + ",";
						}
						if (res.getString(1).equals("2015")) {
							msg6 += res.getString(3) + ",";
						}
					}
					msg += msg1.substring(0, msg1.length() - 1) + ";"
							+ msg2.substring(0, msg2.length() - 1) + ";"
							+ msg3.substring(0, msg3.length() - 1) + ";"
							+ msg4.substring(0, msg4.length() - 1) + ";"
							+ msg5.substring(0, msg5.length() - 1) + ";"
							+ msg6.substring(0, msg6.length() - 1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return msg;
			}

			@Override
			public String getSql() {
				System.out.println(s[0]);
				String sql = "select year,income ,sum(count) from (select substring(v62, 0,4) as year,case when cast(v9 as bigint)<36000 then 36000 when cast(v9 as bigint)< 72000 then 72000 when cast(v9 as bigint)< 96000 then 96000  when cast(v9 as bigint)< 120000 then 120000 else  1200001 end as income,count(*) as count from makedata1_table_orc where v19='"
						+ s[0]
						+ "' group by  substring(v62, 0,4),income) a group by year,income order by year,income";
				return sql;
			}
		});
	}

	@RequestMapping("/dklx")
	public String dklx() {
		return "client-credit-analyse-system/BI-show/dklx";
	}

	@ResponseBody
	@RequestMapping(value = "/dklx/chart", produces = "text/html;charset=UTF-8")
	public String dklxChart() {
		return getJson(new AbsJsonProducer(DKLX) {

			@Override
			public String produceJson(ResultSet res) {
				System.out.println("cacacacacac");
				Map<String, StringBuffer> map = new HashMap<String, StringBuffer>();
				try {
					while (res.next()) {
						if (map.containsKey(res.getString(2))) {
							map.get(res.getString(2)).append(",")
									.append(res.getString(3));
						} else {
							map.put(res.getString(2),
									new StringBuffer(res.getString(3)));
						}
						System.out.println(res.getString(1) + ","
								+ res.getString(2) + "," + res.getString(3));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String msg = "";
				for (String year : map.keySet()) {
					msg += map.get(year) + ":";
				}
				if (msg.length() >= 1) {
					msg = msg.substring(0, msg.length() - 1);
				}
				return msg;
			}

			@Override
			public String getSql() {
				String sql = "select substring(v62, 0,4) as da,v3,count(*)  from makedata1_table_orc where v52='是' group by substring(v62, 0,4),v3 order by da ,v3;";
				return sql;
			}
		});
	}

	@RequestMapping("/dkzl")
	public String dkzl() {
		return "client-credit-analyse-system/BI-show/dkzl";
	}

	@ResponseBody
	@RequestMapping(value = "/dkzl/pie", produces = "text/html;charset=UTF-8")
	public String dkzlPie() {
		return getJson(new AbsJsonProducer(DKZLPIE) {

			@Override
			public String produceJson(ResultSet res) {
				String msg = " ";
				try {
					while (res.next()) {
						msg += res.getString(3) + ",";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (msg.length() >= 1) {
					msg = msg.substring(0, msg.length() - 1);
				}
				return msg;
			}

			@Override
			public String getSql() {
				String sql = "select substring(v62, 0,4) as a,substring(v62, 5,2) as b,sum(cast(v4 as bigint))  from makedata1_table_orc  group by substring(v62, 0,4),substring(v62, 5,2) order by a,b ";
				return sql;
			}
		});
	}

	@ResponseBody
	@RequestMapping(value = "/dkzl/ty/{year}/{mon}", produces = "text/html;charset=UTF-8")
	public String dkzlTY(@PathVariable("year") String year,
			@PathVariable("mon") String mon) {
		final String y = year;
		final String m = mon;
		return getJson(new AbsJsonProducer(DKZLTY) {

			@Override
			public String produceJson(ResultSet res) {
				String msg = " ";
				try {
					while (res.next()) {
						msg += "{\"name\":\"" + res.getString(1)
								+ "\"  ,  \"value\":\"" + res.getString(2)
								+ "\"},";
					}
					msg = msg.substring(0, msg.length() - 1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return msg;
			}

			@Override
			public String getSql() {
				String sql = "select v19,sum(cast(v4 as bigint)) from makedata1_table_orc where substring(v62, 0,4) ='"
						+ y
						+ "'and substring(v62, 5,2) = '"
						+ m
						+ "' group by v19";
				return sql;
			}
		});
	}

	@RequestMapping("/xueli")
	public String xueli() {
		return "client-credit-analyse-system/BI-show/xueli";
	}

	@ResponseBody
	@RequestMapping(value = "/xueli/pie", produces = "text/html;charset=UTF-8")
	public String xueliPie() {
		return getJson(new AbsJsonProducer(XUELIPIE) {

			@Override
			public String produceJson(ResultSet res) {
				String msg = " ";
				try {
					while (res.next()) {
						msg += "{\"name\":\"" + res.getString(1)
								+ "\"  ,  \"value\":\"" + res.getString(2)
								+ "\"},";
					}
					msg = msg.substring(0, msg.length() - 1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return msg;
			}

			@Override
			public String getSql() {
				String sql = "select v12,count(*)  from makedata1_table_orc where v52='是' group by v12";
				return sql;
			}
		});
	}

	@RequestMapping("/yixiang")
	public String yixiang() {
		return "client-credit-analyse-system/BI-show/yixiang";
	}

	@RequestMapping("/jiqun")
	public String jiqun() {
		return "client-credit-analyse-system/BI-show/jiqun";
	}
	
	@ResponseBody
	@RequestMapping(value = "/jiqun/performance",produces = "text/html;charset=UTF-8")
	public String jiqunPerformance(HttpSession session){
		final HttpSession hs = session;
		return getJson(new AbsJsonProducer(JQ_PERFORMANCE) {
			
			@Override
			public String produceJson(ResultSet resultSet) {
				String res=StatisticsJobStatusBySc();
				String []str= res.split(",");
				int run= Integer.parseInt(str[1]);
				int finish= Integer.parseInt(str[0]);
				int err=Integer.parseInt(str[2]);
				int all=run+finish+err;
				ServletContext context= hs.getServletContext();
				HashSet sessions=(HashSet)context.getAttribute(Global.USERNAME);
				int usernum=sessions.size();
				String msg= usernum+","+run+","+all;
				return msg;
			}
			
			@Override
			public String getSql() {
				return null;
			}
			
			private JSONArray sendReqGetRes(String req){
				Response<String> resp = Requests.get(req).timeout(1000000000).text();
				JSONArray arr=null;
				try {
					arr=new JSONArray(resp.getBody());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return arr;
			}
			
			private String StatisticsJobStatusBySc(){
				JSONArray arr=sendReqGetRes("http://172.23.27.190:8090/jobs");
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
				for (int i = 0; i < arr.length(); i++) {
					try {
						JSONObject obj=(JSONObject) arr.get(i);
						if(obj.getString("context").equals("sc1")){
							String ststue=obj.getString("status");
							map1.put(ststue, map1.get(ststue)+1);
						}else if(obj.getString("context").equals("sc2")){
							String ststue=obj.getString("status");
							map2.put(ststue,  map2.get(ststue)+1);
						}else{
							String ststue=obj.getString("status");
							mapOther.put(ststue,mapOther.get(ststue)+1);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				
				int finish=map1.get("FINISHED")+map2.get("FINISHED")+mapOther.get("FINISHED");
				int run=map1.get("RUNNING")+map2.get("RUNNING")+mapOther.get("RUNNING");
				int err=map1.get("ERROR")+map2.get("ERROR")+mapOther.get("ERROR");
				String res=finish+","+run+","+err;
				return res;
			}
		});
	}

	@RequestMapping(value = "/excel",method=RequestMethod.POST)
	public ResponseEntity<byte[]> createExcel(HttpSession session,String img) throws IOException{
			String[] url = img.split(",");
	        String u = url[1];
			byte[] b = new BASE64Decoder().decodeBuffer(u);;
	        HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("echart");
			HSSFRow row = sheet.createRow(60); 
	        HSSFCell cells = row.createCell(0);
	        cells.setCellType(HSSFCell.CELL_TYPE_BLANK);
	        HSSFPatriarch patri = sheet.createDrawingPatriarch();
	        HSSFClientAnchor anchor = new HSSFClientAnchor(20, 20, 20, 20,
	          (short) 10, 20, (short) 20, 45);
	        patri.createPicture(anchor, wb.addPicture(
	        		b, HSSFWorkbook.PICTURE_TYPE_PNG));
	        HttpHeaders headers = new HttpHeaders();  
		    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
		    headers.setContentDispositionFormData("attachment", "echart.xls");
		    ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		    wb.write(bos);
		    return new ResponseEntity<byte[]>(bos.toByteArray(),headers, HttpStatus.CREATED); 
	}
	
	private String getJson(AbsJsonProducer producer) {
		String json = cache.get(producer.getType());
		if (json != null) {
			return json;
		} else {
			if(producer.getSql() != null){
				json = "[";
				Connection connection = null;
				Statement stmt = null;
				try {
					
						while (null == connection) {
							connection = hiveService.getConnection();
						}
						stmt = connection.createStatement();
						ResultSet res = stmt.executeQuery(producer.getSql());
						json += producer.produceJson(res);
					json += "]";
					cache.put(producer.getType(), json);
				} catch (SQLException e) {
					e.printStackTrace();
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
			}else{
				json += producer.produceJson(null);
				cache.put(producer.getType(), json);
			}
		}
		return json;
	}
}
