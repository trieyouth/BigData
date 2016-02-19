package com.controller.login;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.AdminuserDAO;
import com.service.UserService;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("message","");
		return "login/login";
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String login(String username, String password, Model model,HttpSession session){
		boolean loginFlag =  userService.loginValidation1(username, password);
		Map<String,String> map = new HashMap<String,String>();
		if(loginFlag){
			return map.toString();
		}
		return "index";
//		if(loginFlag){
//			session.setAttribute("loginUserName", username);
//			if(userService.findAuthority(username,1)){
//				
//			}
//			return "null";
//		}else{
//			return "null";
//		}
	}
	
}
