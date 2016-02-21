package com.zero.controller.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zero.entity.Adminuser;
import com.zero.entity.Logweb;
import com.zero.entity.self.LogModel;
import com.zero.service.LogService;
import com.zero.service.UserService;

/*
 * created by youth on 16-2-20
 * */

@RequestMapping("/manager/user")
@Controller
public class UserManagerController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LogService logService;
	
	//home
	@RequestMapping("/index")
	public String index(){
		return "manager/user-manager/UserManageFrame";
	}
	
	//user manage
	@RequestMapping("/manage")
	public String manage(Model model){
		model.addAttribute("userList",userService.findUserList());
		return "manager/user-manager/UserManage";
	}
	
	
	//user authority show 
	@RequestMapping("/authshow/{username}")
	public String authShow(@PathVariable("username")String username,Model model){
		int auth = userService.findAuthority(username);
		model.addAttribute("auth",auth);
		model.addAttribute("authDetail",auth==1?"���ʺ�̨����ϵͳ":auth==2?"���ʿͻ����÷���ϵͳ":auth==3?"����Ͷ�ʿͻ�����ƫ����ݷ������Ƽ�ϵͳ":"");
		model.addAttribute("username",username);
		return "manager/user-manager/UserAuthority";
	}
	
	//user authority update
	@RequestMapping("/authupdate/{username}")
	public String authUpdate(@PathVariable("username")String username,Model model){
		//System.out.println(username);
		int auth = userService.findAuthority(username);
		model.addAttribute("clientAuthDetail",auth == 1?"�Ѽ���":"δ����");
		model.addAttribute("invesrAuthDetail",auth == 2?"�Ѽ���":"δ����");
		model.addAttribute("managerAuthDetail",auth == 3?"�Ѽ���":"δ����");
		model.addAttribute("clientAuthChecked",auth == 1?"checked":"");
		model.addAttribute("invesrAuthChecked",auth == 2?"checked":"");
		model.addAttribute("managerAuthChecked",auth == 3?"checked":"");
		return "manager/user-manager/AlterUserAuthority";
	}
	
	//user authority update 
	@RequestMapping(value="/authupdate/{username}",method=RequestMethod.POST)
	public String authUpdate(@PathVariable("username")String username,String qx){
		userService.updateAuthority(Integer.valueOf(qx),username);
		return "redirect:/manager/user/authshow/"+username;
	}
	
	//add user
	@RequestMapping("/add")
	public String addUser(){
		return "manager/user-manager/AddUser";
	}
	
	//add user
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
	
	//user operate log show
	/*think in how to make it better 
	 * first ： paging
	 * second ： cache & reduce the times of database query
	 * */
	@RequestMapping("operate-log")
	public String operateLog(Model model){
		List<Logweb> logs = logService.selectAllLog();
		List<LogModel> list = new ArrayList<>();
		try{
			for(int i = 0;i<logs.size();i++){
				LogModel logModel = new LogModel();
				System.out.println("debug : "+"log admin id : "+logs.get(i).getAdminId());
				logModel.username = userService.findAdminName(logs.get(i).getAdminId());
				logModel.logContent = logs.get(i).getLogConten();
				logModel.logDate = logs.get(i).getLogDate();
				list.add(logModel);	
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("debug 数据库的用户操作日志坑爹啊，数据不完整");
		}
		model.addAttribute("logList",list);
		return "manager/user-manager/Operatelog";
	}
}
