package com.zero.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
@Controller
public class HomeController {
	
	@RequestMapping("/ccas/index")
	public String ccasIndex(){
		return "client-credit-analyse-system/CCASIndex";
	}
	
	@RequestMapping("/icpas/index")
	public String icpasIndex(){
		return "invesr-client-perference-analyse-system/ICPASIndex";
	}
	
	@RequestMapping("/manager/index")
	public String manager(){
		return "manager/SMIndex";
	}
	
}
