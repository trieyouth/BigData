package com.controller.login;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/login")
@Controller
public class LoginController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String login(){
		return "login/login";
	}
	
	
}
