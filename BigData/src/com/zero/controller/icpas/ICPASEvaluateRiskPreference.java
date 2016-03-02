package com.zero.controller.icpas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/icpas/index/evaluateRiskPreference")
@Controller
public class ICPASEvaluateRiskPreference {
	@RequestMapping(value="/clientRiskBearQuery",method=RequestMethod.GET)
	public String clientRiskBearQuery(){
		return "invesr-client-perference-analyse-system/evaluate-risk-preference/ClientRiskBearQuery";
	}
	
	@RequestMapping(value="/clientRiskBearQueryByCard",method=RequestMethod.GET)
	public String clientRiskBearQueryByCard(){
		return "invesr-client-perference-analyse-system/evaluate-risk-preference/ClientRiskBearQueryByCard";
	}
	
	@RequestMapping(value="/riskPreferenceType",method=RequestMethod.GET)
	public String riskPreferenceType(){
		return "invesr-client-perference-analyse-system/evaluate-risk-preference/RiskPreferenceType";
	}
}