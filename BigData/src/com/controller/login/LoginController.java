package com.controller.login;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity_dao.AdminuserDAO;
import com.service.UserService;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	private UserService userService = new UserService();
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("message","");
		return "login/login";
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String login(String username, String password, Model model,HttpSession session){
		boolean loginFlag =  userService.loginValidation1(username, password);
		System.out.println("loginFlag : "+loginFlag);
		if(loginFlag){
			session.setAttribute("loginUserName", username);
			if(userService.findAuthority(username,1)){
				
			}
			return "null";
		}else{
			return "null";
		}
	}
	
}
