package com.zero.test;


import java.util.regex.Pattern;

//import org.junit.Test;

import com.zero.dao.AuthorityDAO;
import com.zero.entity.Authority;

public class TestHib1 {
//	@Test
	public void test1(){
//		AuthorityDAO authorityDAO=new AuthorityDAO();
//		Authority authority=new Authority("moh");
//		authorityDAO.save(authority);
		System.out.println(Pattern.matches("/manager/([a-z]|/)*","/manager/user/dsa/index"));
	}
}
