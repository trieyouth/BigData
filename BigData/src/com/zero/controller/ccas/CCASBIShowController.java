package com.zero.controller.ccas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/ccas/index/BIShow")
@Controller
public class CCASBIShowController {
	
	@RequestMapping("/BI")
	public String BI(){
		return "client-credit-analyse-system/BI-show/BI";
	}
	@RequestMapping("/map")
	public String map(){
		return "client-credit-analyse-system/BI-show/map";
	}
	@RequestMapping("/jobpie")
	public String jobpie(){
		return "client-credit-analyse-system/BI-show/jobpie";
	}
	@RequestMapping("/dklx")
	public String dklx(){
		return "client-credit-analyse-system/BI-show/dklx";
	}
	@RequestMapping("/dkzl")
	public String dkzl(){
		return "client-credit-analyse-system/BI-show/dkzl";
	}
	@RequestMapping("/xueli")
	public String xueli(){
		return "client-credit-analyse-system/BI-show/xueli";
	}
	@RequestMapping("/yixiang")
	public String yixiang(){
		return "client-credit-analyse-system/BI-show/yixiang";
	}
	@RequestMapping("/jiqun")
	public String jiqun(){
		return "client-credit-analyse-system/BI-show/jiqun";
	}
}
