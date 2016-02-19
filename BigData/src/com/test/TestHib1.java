package com.test;


import org.junit.Test;

import com.dao.AuthorityDAO;
import com.entity.Authority;

public class TestHib1 {
	@Test
	public void test1(){
		AuthorityDAO authorityDAO=new AuthorityDAO();
		Authority authority=new Authority("moh");
		authorityDAO.save(authority);
	}
}
