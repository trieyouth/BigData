package com.zero.controller.ccas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ccas/index")
@Controller
public class CCASHomeController {
	
	
	@RequestMapping("/dataCollect")
	public String dataCollect(){
		return "client-credit-analyse-system/data-collect/DataCollectMainFrame";
	}
	
	@RequestMapping("/clientPortray")
	public String clientPortray(){
		return "client-credit-analyse-system/client-portray/ClientPortrayMainFrame";
	}
	
	@RequestMapping("/BIShow")
	public String BIShow(){
		return "client-credit-analyse-system/BI-show/BIShowMainFrame";
	}
}
