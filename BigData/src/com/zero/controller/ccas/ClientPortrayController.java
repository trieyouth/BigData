package com.zero.controller.ccas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/ccas/index/clientPortray")
@Controller
public class ClientPortrayController {
	@RequestMapping(value="/personalCreditQuery",method=RequestMethod.GET)
	public String personalCreditQuery(){
		return "client-credit-analyse-system/client-portray/PersonalCreditQuery";
	}
	
	@RequestMapping(value="/personalCreditQueryByCard",method=RequestMethod.GET)
	public String PersonalCreditQueryByCard(){
		return "client-credit-analyse-system/client-portray/PersonalCreditQueryByCard";
	}
}
