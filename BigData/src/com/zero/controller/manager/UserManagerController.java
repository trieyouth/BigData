package com.zero.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/manager/user")
@Controller
public class UserManagerController {

	@RequestMapping("/index")
	public String index(){
		return "manager/user-manager/UserManageFrame";
	}
	
}
