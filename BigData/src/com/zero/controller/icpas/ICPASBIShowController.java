package com.zero.controller.icpas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/icpas/index/BIShow")
@Controller
public class ICPASBIShowController {
	@RequestMapping("/bar")
	public String Bar(){
		return "invesr-client-perference-analyse-system/BI-show/bar";
	}
}
