package com.zero.controller.icpas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/icpas/index/dataCollect")
@Controller
public class ICPASDataCollectController {
	@RequestMapping(value="/generateData",method=RequestMethod.GET)
	public String generateData(Model model){
		return "invesr-client-perference-analyse-system/data-collect/CreateTemplet";
	}
	
	@RequestMapping(value="/generateData",method=RequestMethod.POST)
	public String generateData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		return null;
	}
	
	@RequestMapping("/dataFileInput")
	public String dataFileInput(){
		return "invesr-client-perference-analyse-system/data-collect/dataFileInput";
	}
	
	@RequestMapping("/dataInput")
	public String dataInput(){
		return "invesr-client-perference-analyse-system/data-collect/dataInput";
	}
	
	@RequestMapping("/templateManage")
	public String templateManage(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	@RequestMapping("/operationLog")
	public String operationLog(){
		return "client-credit-analyse-system/data-collect/DataCollectMainFrame";
	}
	
}