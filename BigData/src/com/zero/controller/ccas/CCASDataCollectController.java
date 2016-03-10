package com.zero.controller.ccas;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
<<<<<<< HEAD
import org.omg.SendingContext.RunTime;
=======
import org.apache.hadoop.hive.ql.parse.HiveParser_PlFunctionParser.return_type_spec_return;
import org.rhq.helpers.pluginAnnotations.agent.Parameter;
>>>>>>> 8edc81c456780c5f93e22be5d7b0033cad4212f5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.zero.entitylib.CreditDataTemplate;
import com.zero.entity.Adminuser;
import com.zero.entity.CreditTemplateContext;
import com.zero.entity.Creditanalysistemplatecontext;
import com.zero.entity.Singleusercreditinformation;
import com.zero.entity.Templatedata;
import com.zero.entity.CreditTemplateAllInfo;
import com.zero.entity.Templateuser;
import com.zero.service.SimulationDataService;
import com.zero.service.SingInformationService;
import com.zero.service.TemplatService;
import com.zero.service.UserService;
import com.zero.entity.Templatedata;

@RequestMapping("/ccas/index/dataCollect")
@Controller
public class CCASDataCollectController {
	@Autowired
	SimulationDataService sds;
	@Autowired
	TemplatService ts;
	@Autowired
	UserService us;
	@Autowired
	SingInformationService sis;
	@Autowired  
    private HttpServletRequest request;
	
	/*@RequestMapping(value="/generateData",method=RequestMethod.POST)
	public String generateData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//【CreateTemplet.jsp】界面[生成模拟数据]和[保存为模版]
		String btnGenerateSimulateData=request.getParameter("btnGenerateSimulateData");
		String btnSaveSimulate=request.getParameter("btnSaveSimulate");

		//【TempletDetial.jsp】将模版数据生成模拟数据
		String btnSimulateGenerateData=request.getParameter("btnSimulateGenerateData");
		// System.out.println("btnSimulateGenerateData:"+btnSimulateGenerateData);
		if(btnGenerateSimulateData!=null || btnSaveSimulate!=null)
		{
			//CreateTemplet(request,response);
		}
		else if(btnSimulateGenerateData!=null)
		{
			SimulateGenerateData(request,response);
		}
		return "client-credit-analyse-system/data-collect/generateData";
	}*/
	
	
	//文件上传
	@RequestMapping("/dataFileInput")
	public String dataFileInput(){
		return "client-credit-analyse-system/data-collect/dataFileInput";
	}
	
	//文件上传
	//只是完成了文件上传，还没有加入数据库记录
	//数据表 userId filepath 
	@RequestMapping(value="/dataFileInput",method=RequestMethod.POST)
	public String dataFileInput(@RequestParam("file") CommonsMultipartFile file) throws IOException {
       System.out.println("上传文件 fileName："+file.getOriginalFilename());
       String path=request.getSession().getServletContext().getRealPath("/") + "WEB-INF/tmp/upData/"  
               + file.getOriginalFilename();
       File newFile=new File(path);
       //通过CommonsMultipartFile的方法直接写文件
       file.transferTo(newFile);
       
       Session ssh = null;
       try {
 			Connection conn = new Connection(hostname);
 			conn.connect();
 			boolean isconn = conn.authenticateWithPassword(username, password);
 			if (!isconn) {
 				System.out.println("连不起");
 			} else {
 				System.out.println("ok");
 				ssh = conn.openSession();
 				ssh.execCommand("hdfs dfs -put Documents/tomcat/webapps/BigData/WEB-INF/tmp/upData/"+ file.getOriginalFilename() +"/tmp/");
 				Thread.sleep(30000);
 			}
 			ssh.close();
 			conn.close();
 			System.out.println("close");
 		} catch (IOException e) {
 			e.printStackTrace();
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
       return "client-credit-analyse-system/data-collect/dataFileInput";
	}
	
	@RequestMapping("/dataInput")
	public String dataInput(){
		return "client-credit-analyse-system/data-collect/dataInput";
	}
	
	@RequestMapping("/filedownload")  
	public ResponseEntity<byte[]> download() throws IOException {  
	    HttpHeaders headers = new HttpHeaders();  
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
	    headers.setContentDispositionFormData("attachment", "model.CVS");  
	    String path=request.getSession().getServletContext().getRealPath("/") + "WEB-INF/resources/file/model.CSV";
	    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path)),  
	                                      headers, HttpStatus.CREATED);  
	}  
	
	//待改
	@RequestMapping("/templateManage")
	public String templateManage(HttpServletRequest request, HttpServletResponse response){
		List<CreditDataTemplate> list=new ArrayList<CreditDataTemplate>();
		list.clear();
		Templatedata td;
		CreditDataTemplate cdt;
		List<Templatedata> lt=ts.checkTotalCreditTemplate();
		
		if(lt.size()>0)
		{
			System.out.println("size:"+lt.size());
			for(int i=0;i<lt.size();i++)
			{
				td=new Templatedata();
				td=lt.get(i);
				cdt=new CreditDataTemplate();
				cdt.setId(td.getTempId().toString());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				String dateNowStr = sdf.format(td.getTempDate());  
				
				cdt.setGenerateTime( dateNowStr+" "+td.getTempTime());
				//cdt.setGenerateSum(td.getDataNumber().toString());
				cdt.setCreator(us.findAdminName(td.getAdminId()));
				cdt.setDetailInformation("TempletDetialServlet?Id="+td.getTempId()+"&S=1");
				cdt.setUseInformation("TempletDetialServlet?Id="+td.getTempId()+"&S=2");   		
				list.add(cdt);
			}
			//System.out.println("CreateRecordServlet");
		}
		request.getSession().setAttribute("CreditDataTemplate", list);
		return "client-credit-analyse-system/data-collect/TempletCreateRecordDetail";
	}
	
	
	@RequestMapping("/operationLog")
	public String operationLog(){
		return "client-credit-analyse-system/data-collect/DataCollectMainFrame";
	}

	
	/**
	 *    根据身份证的Id查询【CreateRecord.jsp】
	 *  跳转 【TempletCreateRecordDetail.jsp】并显示查询出来的信息
	 */
    public void CreateRecordById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String Id=request.getParameter("ID");
    	//System.out.println("Id:"+Id);
    	if(Id!=null && Id!="")
    	{
    		System.out.println(Id);
    		List<CreditDataTemplate> list=new ArrayList<CreditDataTemplate>();
    		list.clear();
    		Templatedata td;
    		CreditDataTemplate cdt;
    		List<Templatedata> lt=ts.checkTotalCreditTemplate();
    		if(lt.size()>0)
    		{
    			
    			for(int i=0;i<lt.size();i++)
    			{
    				td=new Templatedata();
    				td=lt.get(i);
    				cdt=new CreditDataTemplate();
    				if(Id.equals(td.getTempId()))
    				{
    					cdt.setId(td.getTempId().toString());
    					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    					String dateNowStr = sdf.format(td.getTempDate());  
    					cdt.setGenerateTime( dateNowStr+" "+td.getTempTime());
    					//cdt.setGenerateSum(td.getDataNumber().toString());
    					cdt.setCreator(us.findAdminName(td.getAdminId()));
    					cdt.setDetailInformation("TempletDetialServlet?Id="+td.getTempId()+"&S=1");
    					cdt.setUseInformation("TempletDetialServlet?Id="+td.getTempId()+"&S=2");   		
    					list.add(cdt);
    				}
    			}
    			//System.out.println("CreateRecordServlet");
    		
    			request.getSession().setAttribute("CreditDataTemplate", list);
    			request.getRequestDispatcher("WebView/ClientCreditAnalyseSystem/DataCollect/TempletCreateRecordDetail.jsp").forward(request, response);
    		}
    	}
    	 else 
    	    {
    	    	request.getRequestDispatcher("WebView/ClientCreditAnalyseSystem/DataCollect/CreateRecord.jsp").forward(request, response);
    	    }
    }
   
    /**
     * 生成模拟数据、保存为数据模板[保存到数据库和XML] 【CreateTemplet.jsp】
     * 
     */
    //加载生成模拟数据或保存数据模板的界面
    @RequestMapping(value="/generateData",method=RequestMethod.GET)
	public String generateData(Model model){
    	model.addAttribute("OperateStatus", "");
		return "client-credit-analyse-system/data-collect/generateData";
	}
    
    //生成模拟数据 
    @RequestMapping(value="/generateData",method=RequestMethod.POST)
    public String generateData(Model model,Creditanalysistemplatecontext catc) 
    {
    	//System.out.println("----------  "+catc.getMaxAge());
    	
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		Date date=new Date();
		CreditTemplateAllInfo  cta=new CreditTemplateAllInfo();
		cta.setId(df1.format(date));
		cta.setTime(df1.format(date));
		CreditTemplateContext cdc=new CreditTemplateContext();
		cta.setCreditTemplateContext(cdc);
		Adminuser au=new Adminuser();
		au.setAdminName("zhangsan");
		cta.setUseUser(au);
		try
		{
			String[][] str=sds.generateCreditSimulationData(cta);
			if(str.length>0)
			{
				model.addAttribute("OperateStatus", "模拟数据生成成功！");
			}
			else
			{
				model.addAttribute("OperateStatus", "模拟数据生成失败！");
			}
		}
		catch(Exception ex)
		{
			model.addAttribute("OperateStatus", "模拟数据生成失败！"); 
		}
    	
		return "client-credit-analyse-system/data-collect/generateData";
    }
    
	//保存为数据模板
    @RequestMapping(value="/saveAsTemplate",method=RequestMethod.POST)
    public String SaveAsTemplate(Model model,Creditanalysistemplatecontext catc) 
    {
    	System.out.println("=====++++++=====  "+catc.getMaxAge());
    	try
    	{
    		Templatedata ta=new Templatedata();				
    		SimpleDateFormat ms=new SimpleDateFormat("HH:mm:ss");
    		Date n=new Date();
    		ta.setTempDate(n);
    		ta.setAdminId(1);
    		ta.setTempTime(new java.sql.Time(new java.util.Date().getTime()));
    		System.out.println("Admin="+ta.getAdminId()+" Date="+ta.getTempDate()+" Time= "+ta.getTempTime());
    		ts.insertTemplateData(ta, catc);
    		model.addAttribute("OperateStatus", "模板保存成功！");
    	}
    	catch(Exception ex)
    	{
    		model.addAttribute("OperateStatus", "模板保存失败！");
    	}
    	return "client-credit-analyse-system/data-collect/generateData";
    }

    //数据录入 dataInput.jsp
    @RequestMapping(value="/dataInput",method=RequestMethod.GET)
    public String DataInput(Model model)
    {
    	model.addAttribute("OperateStatus", "");
    	return "client-credit-analyse-system/data-collect/dataInput";
    }
    
    //录入数据保存
    @RequestMapping(value="/dataInput",method=RequestMethod.POST)
    public String DataInput(Model model,Singleusercreditinformation sci)
    {
    	System.out.println("age:"+sci.getAge()+" AdministrativerPunishment:"+sci.getAdministrativerPunishment()+" CivilJudgmentRecord:"+sci.getCivilJudgmentRecord()+" CreditNum:"+sci.getCreditNum()+" ElectricityArrears:"+sci.getElectricityArrears()+" Enforcement:"+sci.getEnforcement()+" GenerateRecordNum:"+sci.getGenerateRecordNum()+
				" HouseLoan:"+sci.getHouseLoan()+" LoansNum:"+sci.getLoansNum()+" MonthlyIncome:"+sci.getMonthlyIncome()+" OwingTaxes:"+sci.getOwingTaxes()+" SelectOwingTaxes:"+sci.getSelectOwingTaxes());
    	try{
    		sis.addSingleusercreditinformation(sci);
    		model.addAttribute("OperateStatus", "保存成功！");
    	}
    	catch(Exception ex)
    	{
    		model.addAttribute("OperateStatus", "保存失败！");
    	}
    	return "client-credit-analyse-system/data-collect/dataInput";
    }
    
    //查询所有的模板
    @RequestMapping(value="/TempletCreateRecordDetail",method=RequestMethod.GET)
    public ModelAndView  CheckAllTemplates()
    {
    	//model.addAttribute("OperateStatus", "");
    	List<Templatedata> tds=new ArrayList<Templatedata>();
    	tds.clear();
    	try{
    		tds=ts.checkTotalCreditTemplate();
    		//System.out.println("Size:"+tds.size());
    		//model.addAttribute("OperateStatus", "全部模板显示成功！");
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return new  ModelAndView("client-credit-analyse-system/data-collect/TempletCreateRecordDetail", "Templatedatas", tds);
    }
    
//    //根据模板Id查看模版详细
//    @RequestMapping(value="/checkTemplate/{id}",method=RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView CheckTemplate(@PathVariable("id") String id)
//    {
//    	System.out.println("=== Id =="+id);
//    	try{
//    		
//    	}
//    	catch(Exception ex)
//    	{
//    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
//    	}
//    	return new ModelAndView("client-credit-analyse-system/data-collect/generateDataDetail");
//    }
    
    //根据id删除模板
    @RequestMapping(value="/deleteTemplate/{id}",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView DeleteTemplet(@PathVariable("id") String id)
    {
    	//System.out.println("===================== Id ================ "+id);
    	try{
    		ts.deleteTemplateDataByID(id);
    		System.out.println("ok!");
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return CheckAllTemplates();
    }
    
    
    //加载采集记录信息
    @RequestMapping(value="/collectingRecord",method=RequestMethod.GET)
    public ModelAndView ShowDataCollectingRecord()
    {
    	//model.addAttribute("OperateStatus", "");
    	List<Templateuser> tus=new ArrayList<Templateuser>();
    	tus.clear();
    	try{
    		//tus=ts.
    		//System.out.println("the Size of Singleusercreditinformation : "+scis.size()+"  SingleuserinfoId="+scis.get(0).getSingleuserinfoId());
    		//model.addAttribute("OperateStatus", "全部模板显示成功！");
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return new  ModelAndView("client-credit-analyse-system/data-collect/collectingRecord");
    }
    
    //根据采集记录Id查看信息详细
    @RequestMapping(value="/checkCollectiong/{id}",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView CheckCollectiong(@PathVariable("id") String id)
    {
    	//System.out.println("=== Id =="+id);
    	Singleusercreditinformation sci=new Singleusercreditinformation();
    	try{
    		
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return new ModelAndView("client-credit-analyse-system/data-collect/dataInputDetail");
    }
    
    //根据采集记录id删除信息
    @RequestMapping(value="/deleteCollecting/{id}",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView DeleteCollecting(@PathVariable("id") String id)
    {
    	System.out.println("===================== Id ================ "+id);
    	try{
    		
    	}
    	catch(Exception ex)
    	{
    		//model.addAttribute("OperateStatus", "全部模板显示失败！");
    	}
    	return ShowDataCollectingRecord();
    }
}