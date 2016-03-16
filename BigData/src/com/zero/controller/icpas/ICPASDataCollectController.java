package com.zero.controller.icpas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zero.common.Global;
import com.zero.entity.Adminuser;
import com.zero.entity.Creditanalysistemplatecontext;
import com.zero.entity.InvestTemplateAllInfo;
import com.zero.entity.Riskpreferencetemplatecontext;
import com.zero.entity.Secondtemplatedata;
import com.zero.entity.Secondtemplateuser;
import com.zero.entity.Singleuserriskinformation;
import com.zero.entity.Templatedata;
import com.zero.entity.Templateuser;
import com.zero.service.SimulationDataService;
import com.zero.service.SingInformationService;
import com.zero.service.TemplatService;
import com.zero.service.UserService;

@RequestMapping("/icpas/index/dataCollect")
@Controller
public class ICPASDataCollectController {
	@Autowired
	TemplatService ts;
	@Autowired  
    private HttpServletRequest request;
	@Autowired
	UserService us;
	@Autowired
	SingInformationService sis;
	@Autowired
	SimulationDataService sds;
	
	
	@RequestMapping("/dataFileInput")
	public String dataFileInput(){
		return "invesr-client-perference-analyse-system/data-collect/dataFileInput";
	}
	
	@RequestMapping("/operationLog")
	public String operationLog(){
		return "client-credit-analyse-system/data-collect/DataCollectMainFrame";
	}
	
	@RequestMapping(value="/generateData",method=RequestMethod.GET)
	public String generateData(Model model){
		model.addAttribute("OperateStatus", "");
		return "invesr-client-perference-analyse-system/data-collect/generateData";
	}
	
	//生成大数据
	@RequestMapping(value="/generateData",method=RequestMethod.POST)
	public String generateData(Model model,Riskpreferencetemplatecontext rptc){
	//	try{
		    System.out.println("-----------------------------------------");
			
			/////  大数据生成接口调用  ////
		    SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			Date date=new Date();
		    InvestTemplateAllInfo itai=new InvestTemplateAllInfo();
		    itai.setGenerateNums(rptc.getGerenalRecord());
		    itai.setId(Long.valueOf(df1.format(date)));
		    itai.setTime(df1.format(date));
		    Adminuser au=new Adminuser();
			au.setAdminName(request.getSession().getAttribute(Global.USERNAME)+"");
			itai.setUseUser(au);
			String[][] arr=sds.generateInvestSimulationData(itai);
		    
			
			model.addAttribute("OperateStatus", "生成数据成功！");
		//}
//		catch(Exception ex)
//		{
//			model.addAttribute("OperateStatus", "生成数据失败！");
//		}
		return "invesr-client-perference-analyse-system/data-collect/generateData";
	}
	
	@RequestMapping(value="/dataInput",method=RequestMethod.GET)
	public String dataInput(Model model){
		model.addAttribute("OperateStatus", "");
		return "invesr-client-perference-analyse-system/data-collect/dataInput";
	}
	
	//数据录入
	@RequestMapping(value="/dataInput",method=RequestMethod.POST)
	public String dataInput(Model model,Singleuserriskinformation suri){
		try{
			int id=us.findAdminID(request.getSession().getAttribute(Global.USERNAME)+"");
			suri.setUserId(id+"");
			suri.setUsername(request.getSession().getAttribute(Global.USERNAME)+"");
			System.out.println(suri.getAge());
		    sis.addSingleuserriskinformation(suri);
			model.addAttribute("OperateStatus", "数据录入成功！");
		}
		catch(Exception ex)
		{
			model.addAttribute("OperateStatus", "数据录入失败！");
		}
		
		return "invesr-client-perference-analyse-system/data-collect/dataInput";
	}

	//保存为模板
	@RequestMapping(value="/saveAsTemplate",method=RequestMethod.POST)
    public String SavaAsTemplate(Riskpreferencetemplatecontext rptc,Model model)
	{
		try{
			Secondtemplatedata std=new Secondtemplatedata();	
			Secondtemplateuser stu=new Secondtemplateuser();
			stu.setDataNumber(Long.parseLong(rptc.getGerenalRecord()));
			Date n=new Date();
			std.setTempDate(n);
			stu.setUseDate(n);
			int id=us.findAdminID(request.getSession().getAttribute(Global.USERNAME)+"");
			std.setAdminId(id);
			stu.setAdminId(id);
			std.setTempTime(new java.sql.Time(new java.util.Date().getTime()));
			stu.setUseTime(std.getTempTime());
			//System.out.println("AdminId:"+stu.getAdminId()+"   DataNumber:"+stu.getDataNumber()+"   UseDate:"+stu.getUseDate()+"  UseTime:"+stu.getUseTime());
			ts.insertSecondTemplateData(std,stu, rptc);
			model.addAttribute("OperateStatus", "保存成功");
		}
		catch(Exception ex){
			model.addAttribute("OperateStatus", "保存失败");
		}
		//return "invesr-client-perference-analyse-system/data-collect/saveAsTemplate";  //跳转到模板的名称和描述
		return "invesr-client-perference-analyse-system/data-collect/generateData";
	}      
	
	//查看所有的模板
	@RequestMapping(value="/templetCreateRecordDetail",method=RequestMethod.GET)
	public ModelAndView TempletCreateRecordDetail()
	{
		List<Secondtemplatedata> std=new ArrayList<Secondtemplatedata>();
		std.clear();
    	try{
    		std=ts.checkTotalRiskTemplate();
    		//model.addAttribute("OperateStatus", "全部模板显示成功！");
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return new  ModelAndView("invesr-client-perference-analyse-system/data-collect/templetCreateRecordDetail", "Secondtemplatedatas", std);
	}
	
	//根据模板的Id删除模板
	@RequestMapping(value="/deleteTemplate/{Id}",method=RequestMethod.GET)
	 @ResponseBody
	public ModelAndView deleteTemplate(@PathVariable("Id") String Id)
	{
//		System.out.println("++++ deleteTemplatelGET +++++");
//		System.out.println(Id);
		try{
    	    ts.deleteSecondTemplateDataByID(Id);
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return TempletCreateRecordDetail();
	}
	
	//加载采集记录信息
    @RequestMapping(value="/collectingRecord",method=RequestMethod.GET)
    public ModelAndView ShowDataCollectingRecord()
    {
    	List<Secondtemplateuser> stu=new ArrayList<Secondtemplateuser>();
    	stu.clear();
    	try{
    		stu=ts.checkTotalRiskTemplateUser();
    		//model.addAttribute("OperateStatus", "全部模板显示成功！");
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return new  ModelAndView("invesr-client-perference-analyse-system/data-collect/collectingRecord","Secondtemplateusers",stu);
    }
    
  //加载采集记录信息
    @RequestMapping(value="/collectingRecord",method=RequestMethod.POST)
    public ModelAndView ShowDataCollecting()
    {
    	return ShowDataCollectingRecord();
    }
    
    //根据采集记录Id查看信息详细
    @RequestMapping(value="/checkCollecting/{tid}",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView CheckCollecting(@PathVariable("tid") String tid,Model model)
    {
    	System.out.println("tid:"+tid);
    	Riskpreferencetemplatecontext rptc=new Riskpreferencetemplatecontext();
    	try{
    		rptc=ts.checkUseDetailRiskTemplate(tid);
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return new ModelAndView("invesr-client-perference-analyse-system/data-collect/generateDataDetail","rptc", rptc);
    }
    
    //根据采集记录id删除信息
    @RequestMapping(value="/deleteCollecting/{aid}/{tid}",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView DeleteCollecting(@PathVariable("aid") String aid,@PathVariable("tid") String tid)
    {
    	System.out.println("aid:"+aid+"  tid:"+tid);
    	try{
    		ts.deleteSecondTemplateUser(tid, aid);
    	}
    	catch(Exception ex)
    	{
    	}
    	return ShowDataCollectingRecord();
    }
    
    @RequestMapping(value="/generateDataDetail",method=RequestMethod.POST)
    public ModelAndView GenerateDataDetail(Riskpreferencetemplatecontext rptc,Model model)
    {
    	String str=generateData(model,rptc);
    	if(str.equals("invesr-client-perference-analyse-system/data-collect/generateData"))
    	{
    		return ShowDataCollectingRecord();
    	}
    	return new ModelAndView("invesr-client-perference-analyse-system/data-collect/generateDataDetail","rptc",rptc);
    }
}