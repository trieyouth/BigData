package com.zero.controller.ccas;

import java.sql.ResultSet;

public interface JsonProducer {

	String getSql();
	
	String produceJson(ResultSet res);
	
}
