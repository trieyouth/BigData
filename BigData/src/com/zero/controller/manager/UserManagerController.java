package com.zero.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zero.entity.Adminuser;
import com.zero.service.UserService;



@RequestMapping("/manager/user")
@Controller
public class UserManagerController {

	@Autowired
	private UserService userService;
	
	//用户管理首页
	@RequestMapping("/index")
	public String index(){
		return "manager/user-manager/UserManageFrame";
	}
	
	//用户管理首页
	@RequestMapping("/manage")
	public String manage(Model model){
		model.addAttribute("userList",userService.findUserList());
		return "manager/user-manager/UserManage";
	}
	
	//用户操作日志页
	@RequestMapping("operate-log")
	public String operateLog(){
		return "manager/user-manager/OperateLog";
	}
	
	//用户权限查看
	@RequestMapping("/authshow/{username}")
	public String authShow(@PathVariable("username")String username,Model model){
		int auth = userService.findAuthority(username);
		model.addAttribute("auth",auth);
		model.addAttribute("authDetail",auth==1?"访问后台管理系统":auth==2?"访问客户信用分析系统":auth==3?"访问投资客户风险偏好数据分析与推荐系统":"");
		model.addAttribute("username",username);
		return "manager/user-manager/UserAuthority";
	}
	
	//用户权限更新
	@RequestMapping("/authupdate/{username}")
	public String authUpdate(@PathVariable("username")String username,Model model){
		System.out.println(username);
		int auth = userService.findAuthority(username);
		model.addAttribute("clientAuthDetail",auth == 1?"已激活":"未激活");
		model.addAttribute("invesrAuthDetail",auth == 2?"已激活":"未激活");
		model.addAttribute("managerAuthDetail",auth == 3?"已激活":"未激活");
		model.addAttribute("clientAuthChecked",auth == 1?"checked":"");
		model.addAttribute("invesrAuthChecked",auth == 2?"checked":"");
		model.addAttribute("managerAuthChecked",auth == 3?"checked":"");
		return "manager/user-manager/AlterUserAuthority";
	}
	
	//用户权限更新
	@RequestMapping(value="/authupdate/{username}",method=RequestMethod.POST)
	public String authUpdate(@PathVariable("username")String username,String qx){
		userService.updateAuthority(Integer.valueOf(qx),username);
		return "redirect:/manager/user/authshow/"+username;
	}
	
	
	//增加用户
	@RequestMapping("/add")
	public String addUser(){
		return "manager/user-manager/AddUser";
	}
	
	//增加用户
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(String username,String passwd1,String userback,String qx){
//		System.out.println(username);
//		System.out.println(passwd1);
//		System.out.println(userback);
//		System.out.println(qx);
		Adminuser user = new Adminuser();
		user.setAdminName(username);
		user.setAdminTitle(userback);
		user.setAdminPasswd(passwd1);
		userService.insertAdmin(user,Integer.valueOf(qx));
		return "redirect:/manager/user/manage";
	}
	
}
