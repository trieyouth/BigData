package com.zero.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/manager/product")
@Controller
public class ProductManagerController {

	@RequestMapping("/index")
	public String index(){
		return "manager/product-manager/ProductManageMainFrame";
	}
	
}
