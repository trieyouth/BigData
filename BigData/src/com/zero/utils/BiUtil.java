package com.zero.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.zero.cache.LRUCache;
import com.zero.controller.ccas.AbsJsonProducer;
import com.zero.service.HiveService;

@Repository
@Service
public class BiUtil {

	@Autowired
	HiveService hiveService;
	
	public BiUtil(){
		
	}
	
	private LRUCache<String, String> cache = new LRUCache<String, String>(10,
			60000);
	
	public String getJson(AbsJsonProducer producer) {
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
