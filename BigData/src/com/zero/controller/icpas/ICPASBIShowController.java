package com.zero.controller.icpas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.controller.ccas.AbsJsonProducer;
import com.zero.utils.BiUtil;

@RequestMapping("/icpas/index/BIShow")
@Controller
public class ICPASBIShowController {
	
	@Autowired
	BiUtil util;
	
	@RequestMapping("/bar")
	public String Bar(){
		return "invesr-client-perference-analyse-system/BI-show/bar";
	}
	
	@ResponseBody
	@RequestMapping("/ft")
	public String ft(){
		return util.getJson(new AbsJsonProducer("ft") {
			
			@Override
			public String produceJson(ResultSet res) {
				String msg1 = "";
				String msg2 = "";
				String msg3 = "";
				String msg4 = "";
				String msg5 = "";
				String msg = "";
				try {
					while (res.next()) {
						if (res.getString(1).equals("30锟斤拷锟斤拷锟斤拷")) {
							msg1 += res.getString(3) + ",";
						} else if (res.getString(1).equals("31-40锟斤拷")) {
							msg2 += res.getString(3) + ",";
						} else if (res.getString(1).equals("41-50锟斤拷")) {
							msg3 += res.getString(3) + ",";
						} else if (res.getString(1).equals("51-60锟斤拷")) {
							msg4 += res.getString(3) + ",";
						} else {
							msg5 += res.getString(3) + ",";
						}
					}
					
					msg += msg1.substring(0, msg1.length() - 1) + ";"
							+ msg2.substring(0, msg2.length() - 1) + ";"
							+ msg3.substring(0, msg3.length() - 1) + ";"
							+ msg4.substring(0, msg4.length() - 1) + ";"
							+ msg5.substring(0, msg5.length() - 1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return msg;
			}
			
			@Override
			public String getSql() {
				String sql = "select v2,v3,count(*) from  makedata2_table_orc group by v2,v3 order by v2,v3";
				return sql;
			}
		});
	}
}
