package com.zero.controller.login;



import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zero.common.Global;
import com.zero.service.UserService;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	private static final String MESSAGE= "message";
	private static final String INFO = "�û������������";
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute(MESSAGE,"");
		return "login/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String username, String password, Model model,HttpSession session){
		System.out.println(username);
		System.out.println(password);
		boolean loginFlag =  userService.loginValidation1(username, password);
		if(loginFlag){
			session.setAttribute(Global.USERNAME, username);
			if(userService.findAuthority(username,1)){
				return "redirect:/ccas/index";
			}
			
			if(userService.findAuthority(username,2)){
				return "redirect:/icpas/index";
			}
			
			if(userService.findAuthority(username,3)){
				return "redirect:/manager/index";
			}
			
			session.removeAttribute(Global.USERNAME);
			return "error";
		}else{
			model.addAttribute(MESSAGE,INFO);
			return "login/login";
		}
	}
}
