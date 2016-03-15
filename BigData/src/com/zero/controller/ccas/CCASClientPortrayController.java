package com.zero.controller.ccas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zero.entity.Singleusercreditinformation;
import com.zero.service.HiveQueryService;

@RequestMapping("/ccas/index/clientPortray")
@Controller
public class CCASClientPortrayController {
	
	@RequestMapping(value="/personalCreditQuery",method=RequestMethod.GET)
	public String personalCreditQuery(Model model){
		model.addAttribute("OperateStatus", "");
		return "client-credit-analyse-system/client-portray/PersonalCreditQuery";
	}
	
	@RequestMapping(value="/personalCreditQuery",method=RequestMethod.POST)
	public String personalCreditQuery(Singleusercreditinformation sis,Model model){  
		try{
			HiveQueryService hqs=new HiveQueryService();
			String Id=hqs.getInfoCreditReturnId(sis);
			String str="";
			model.addAttribute("OperateStatus", "");
			if(Id!="")
			{
				str=PersonalCreditQueryByCardPost(Id,model);
			}
			if(str.equals("client-credit-analyse-system/client-portray/PersonalCreditModel"))	
			{
				return "client-credit-analyse-system/client-portray/PersonalCreditModel";
			}
		}
		catch(Exception ex)
		{
			model.addAttribute("OperateStatus", "没有找到该证的相关信息！");
			return "client-credit-analyse-system/client-portray/PersonalCreditQuery";
		}
		model.addAttribute("OperateStatus", "没有找到该证的相关信息！");
		return "client-credit-analyse-system/client-portray/PersonalCreditQuery";
	}
	
	
	@RequestMapping(value="/personalCreditQueryByCard",method=RequestMethod.GET)
	public String PersonalCreditQueryByCardGet(Model model){
		model.addAttribute("OperateStatus", "");
		return "client-credit-analyse-system/client-portray/PersonalCreditQueryByCard";
	}
	
	String pId="";
	@RequestMapping(value="/personalCreditQueryByCard",method=RequestMethod.POST)
	public String PersonalCreditQueryByCardPost(String Id,Model model){
        pId=Id;
        try{
        	if( Id !="" && Id!=null )
        	{
        		List<String> list = new ArrayList<String>();
        		list.clear();
        		HiveQueryService hqs=new HiveQueryService();
        		try {
        			list=hqs.getInfoByCardnums(Id);
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        		if(list.size()>0)
        		{
        			String score=list.get(50);
        			System.out.println("score:"+score);
        			int level=Integer.parseInt(score)*4;
        			String ss="AAA";
        			if(level>300 && level<=350) {ss="AA";}
        			else if(level>250 && level<=300) {ss="A";}
        			else if(level>200 && level<=250) {ss="BBB";}
        			else if(level>150 && level<=200) {ss="BB";}
        			else if(level>100 && level<=150) {ss="B";}
        			else if(level>50 && level<=100) {ss="CCC";}
        			else if(level>0 && level<=50) {ss="CC";}
        			else if(level<=0) {ss="C";}
        			int loan=(int)(Integer.parseInt(score)*500*1.0);
        			if(loan>=500000) {loan=500000;}
        			String str="<h3><br>尊敬的"+Id+":<br>您的信用得分为："+score+"<br>"+"信用等级为："+ ss+"<br>"+"最高贷款金额为："+loan+"元</h3><br>";
        			System.out.println(str);
        			String picUrl="/images/ccas/"+ss+".jpg";
        			model.addAttribute("Id", Id);
        			model.addAttribute("level", level);
        			model.addAttribute("ss", ss);
        			model.addAttribute("loan", loan);
        			model.addAttribute("picUrl", picUrl);
        			System.out.println(picUrl);
            		return "client-credit-analyse-system/client-portray/PersonalCreditModel";
        		}
        	}
        }
        catch(Exception ex)
        {
        	model.addAttribute("OperateStatus", "没有找到该证的相关信息！");
        	return "client-credit-analyse-system/client-portray/PersonalCreditQueryByCard";
        }
        model.addAttribute("OperateStatus", "没有找到该证的相关信息！");
		return "client-credit-analyse-system/client-portray/PersonalCreditQueryByCard";
	}
	
	@RequestMapping(value="/checkCreditLevel")
	public String checkCreditLevel(){
		return "client-credit-analyse-system/client-portray/checkCreditLevel";
	}
	
	/**
	 * 【PersonalCreditQueryByCard.jsp】根据Id查询数据
	 *   跳转界面【PersonalCreditModel.jsp】 
	 * */
	@RequestMapping(value="/personalCreditModelDetail",method=RequestMethod.GET)
	public String QueryById(Model model)
	{
		HiveQueryService hqs=new HiveQueryService();
		List<String> list=new ArrayList<String>();
		list.clear();
		try {
			list=hqs.getInfoByCardnums(pId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "client-credit-analyse-system/client-portray/PersonalCreditModelDetail";
	}
}
