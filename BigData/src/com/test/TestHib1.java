package com.test;


import org.junit.Test;

import com.entity_dao.Authority;
import com.entity_dao.AuthorityDAO;

public class TestHib1 {
	@Test
	public void test1(){
		AuthorityDAO authorityDAO=new AuthorityDAO();
		Authority authority=new Authority("moh");
		authorityDAO.save(authority);
	}
}
