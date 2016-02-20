package com.zero.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
@Controller
public class HomeController {
	
	@RequestMapping("/ccas")
	public String ccasIndex(){
		return "client-credit-analyse-system/CCASIndex";
	}
	
	@RequestMapping("/icpas")
	public String icpasIndex(){
		return "invesr-client-preference-analyse-system/ICPASIndex";
	}
	
	@RequestMapping("/manager")
	public String manager(){
		return "manager/SMIndex";
	}
}
