package com.zero.controller.icpas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/icpas/index")
@Controller
public class ICPASHomeController {
	@RequestMapping("/dataCollect")
	public String dataCollect(){
		return "invesr-client-perference-analyse-system/data-collect/DataCollectMainFrame";
	}
	
	@RequestMapping("/evaluateRiskPreference")
	public String clientPortray(){
		return "invesr-client-perference-analyse-system/evaluate-risk-preference/EvaluateClienRiskPreferenceMainFrame";
	}
	
	@RequestMapping("/BIShow")
	public String BIShow(){
		return "invesr-client-perference-analyse-system/BI-show/BIShowMainFrame";
	}
}
