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

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.zero.entitylib.CreditDataTemplate;
import com.zero.entity.Adminuser;
import com.zero.entity.CreditTemplateContext;
import com.zero.entity.Templatedata;
import com.zero.entity.CreditTemplateAllInfo;
import com.zero.service.SimulationDataService;
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
    private HttpServletRequest request;
	
	@RequestMapping(value="/generateData",method=RequestMethod.GET)
	public String generateData(Model model){
		return "client-credit-analyse-system/data-collect/generateData";
	}
	
	@RequestMapping(value="/generateData",method=RequestMethod.POST)
	public String generateData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//【CreateTemplet.jsp】界面[生成模拟数据]和[保存为模版]
				String btnGenerateSimulateData=request.getParameter("btnGenerateSimulateData");
				String btnSaveSimulate=request.getParameter("btnSaveSimulate");
				
				//【TempletDetial.jsp】将模版数据生成模拟数据
				String btnSimulateGenerateData=request.getParameter("btnSimulateGenerateData");
		       // System.out.println("btnSimulateGenerateData:"+btnSimulateGenerateData);
				if(btnGenerateSimulateData!=null || btnSaveSimulate!=null)
				{
					CreateTemplet(request,response);
				}
				else if(btnSimulateGenerateData!=null)
				{
					SimulateGenerateData(request,response);
				}
			return "client-credit-analyse-system/data-collect/generateData";
	}
	
	
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
    public void CreateTemplet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		//基本信息参数【年龄】【月收入】【工作年限】
		String nl1=request.getParameter("nl1");
		String nl2=request.getParameter("nl2");
		String ysr1=request.getParameter("ysr1");
		String ysr2=request.getParameter("ysr2");
		String gznx1=request.getParameter("gznx1");
		String gznx2=request.getParameter("gznx2");
		//信贷记录参数【信用卡账户数】【银行贷款笔数】【银行消费类贷款笔数】
		String xykzhs1=request.getParameter("xykzhs1");
		String xykzhs2=request.getParameter("xykzhs2");
		String yhdkbs1=request.getParameter("yhdkbs1");
		String yhdkbs2=request.getParameter("yhdkbs2");
		String yhxfldkbs1=request.getParameter("yhxfldkbs1");
		String yhxfldkbs2=request.getParameter("yhxfldkbs2");
		//贷款参数【贷款总额度】【申请贷款次数】【原贷款逾期次数】【征信查询记录】
		String dkzed1=request.getParameter("dkzed1");
		String dkzed2=request.getParameter("dkzed2");
		String sqdkcs1=request.getParameter("sqdkcs1");
		String sqdkcs2=request.getParameter("sqdkcs2");
		String ydkyqcs1=request.getParameter("ydkyqcs1");
		String ydkyqcs2=request.getParameter("ydkyqcs2");
		String zxcxjl1=request.getParameter("zxcxjl1");
		String zxcxjl2=request.getParameter("zxcxjl2");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		Date date=new Date();
		//共生成数量
		String sum=request.getParameter("gsc");
		CreditTemplateAllInfo  cta=new CreditTemplateAllInfo();
		cta.setGenerateNums(sum);
		cta.setId(df1.format(date));
		cta.setTime(df1.format(date));
		CreditTemplateContext cdc=new CreditTemplateContext();
		cdc.setMinAge(nl1);
		cdc.setMaxAge(nl2);
		cdc.setMinMonthlyIncome(ysr1);
		cdc.setMaxMounthlyIncome(ysr2);
		cdc.setMinWorkYears(gznx1);
		cdc.setMaxWorkYears(gznx2);
		
		cdc.setMinCreditNum(xykzhs1);
		cdc.setMaxCreditNum(xykzhs2);
		cdc.setMinLoansNum(yhdkbs1);
		cdc.setMaxLoansNum(yhdkbs2);
		cdc.setMinExpenseLoansNum(yhxfldkbs1);
		cdc.setMaxExpenseLoansNum(yhxfldkbs2);
		
		cdc.setMinLoansAmount(dkzed1);
		cdc.setMaxLoansAmount(dkzed2);
		cdc.setMinApplyForLoanNum(sqdkcs1);
		cdc.setMaxApplyForLoanNum(sqdkcs1);
		cdc.setMinOverdueLoanNum(ydkyqcs1);
		cdc.setMaxOverdueLoanNum(ydkyqcs2);
		cdc.setMinCreditInquiryNum(zxcxjl1);
		cdc.setMaxCreditInquiryNum(zxcxjl2);
		cta.setCreditTemplateContext(cdc);
		Adminuser au=new Adminuser();
		au.setAdminName("Admin");
		cta.setUseUser(au);
		String btnGenerate=request.getParameter("btnGenerateSimulateData");
		String btnSave=request.getParameter("btnSaveSimulate");
		request.setAttribute("GenerateOrSave",null);
		if(btnGenerate!=null)//生成模拟数据
		{
			
			try
			{
				String[][] str=sds.generateCreditSimulationData(cta);
				System.out.println(str.length);
				if(str.length>0)
					request.setAttribute("GenerateOrSave", "模拟数据生成成功！");
				else
					request.setAttribute("GenerateOrSave", "模拟数据生成失败");
			}
			catch(Exception ex)
			{
				request.setAttribute("GenerateOrSave", "模拟数据生成失败");
				System.out.println(ex.toString());
			}
		}
		else if(btnSave!=null)//插入到数据模板的接口
		{
			try
			{
				Templatedata ta=new Templatedata();				
		
				SimpleDateFormat ms=new SimpleDateFormat("HH:mm:ss");
				Date n=new Date();
				System.out.println("Time:"+ms.format(n));
				
				ta.setTempDate(n);
				ta.setAdminId(1);
				ta.setTempTime(new java.sql.Time(new java.util.Date().getTime()));
				ts.insertTemplateData(ta, cta);
				request.setAttribute("GenerateOrSave", "模板保存成功！");
			}
			catch(Exception ex)
			{
				request.setAttribute("GenerateOrSave", "模板保存失败");
				System.out.println(ex.toString());
			}
		}
		System.out.println(request.getAttribute("GenerateOrSave"));
    }

    /**
     * 将模板数据生成模拟数据 【TempletDetial.jsp】
     * 
     * */
    public void SimulateGenerateData (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		//基本信息参数【年龄】【月收入】【工作年限】
		String nl1=request.getParameter("nl1");
		String nl2=request.getParameter("nl2");
		String ysr1=request.getParameter("ysr1");
		String ysr2=request.getParameter("ysr2");
		String gznx1=request.getParameter("gznx1");
		String gznx2=request.getParameter("gznx2");
		//信贷记录参数【信用卡账户数】【银行贷款笔数】【银行消费类贷款笔数】
		String xykzhs1=request.getParameter("xykzhs1");
		String xykzhs2=request.getParameter("xykzhs2");
		String yhdkbs1=request.getParameter("yhdkbs1");
		String yhdkbs2=request.getParameter("yhdkbs2");
		String yhxfldkbs1=request.getParameter("yhxfldkbs1");
		String yhxfldkbs2=request.getParameter("yhxfldkbs2");
		//贷款参数【贷款总额度】【申请贷款次数】【原贷款逾期次数】【征信查询记录】
		String dkzed1=request.getParameter("dkzed1");
		String dkzed2=request.getParameter("dkzed2");
		String sqdkcs1=request.getParameter("sqdkcs1");
		String sqdkcs2=request.getParameter("sqdkcs2");
		String ydkyqcs1=request.getParameter("ydkyqcs1");
		String ydkyqcs2=request.getParameter("ydkyqcs2");
		String zxcxjl1=request.getParameter("zxcxjl1");
		String zxcxjl2=request.getParameter("zxcxjl2");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		Date date=new Date();
		//共生成数量
		String sum=request.getParameter("gsc");
		CreditTemplateAllInfo  cta=new CreditTemplateAllInfo();
		cta.setGenerateNums(sum);
		cta.setId(df1.format(date));
		cta.setTime(df1.format(date));
		CreditTemplateContext cdc=new CreditTemplateContext();
		cdc.setMinAge(nl1);
		cdc.setMaxAge(nl2);
		cdc.setMinMonthlyIncome(ysr1);
		cdc.setMaxMounthlyIncome(ysr2);
		cdc.setMinWorkYears(gznx1);
		cdc.setMaxWorkYears(gznx2);
		
		cdc.setMinCreditNum(xykzhs1);
		cdc.setMaxCreditNum(xykzhs2);
		cdc.setMinLoansNum(yhdkbs1);
		cdc.setMaxLoansNum(yhdkbs2);
		cdc.setMinExpenseLoansNum(yhxfldkbs1);
		cdc.setMaxExpenseLoansNum(yhxfldkbs2);
		
		cdc.setMinLoansAmount(dkzed1);
		cdc.setMaxLoansAmount(dkzed2);
		cdc.setMinApplyForLoanNum(dkzed1);
		cdc.setMaxApplyForLoanNum(dkzed2);
		cdc.setMinOverdueLoanNum(ydkyqcs1);
		cdc.setMaxOverdueLoanNum(ydkyqcs2);
		cdc.setMinCreditInquiryNum(zxcxjl1);
		cdc.setMaxCreditInquiryNum(zxcxjl2);
		cta.setCreditTemplateContext(cdc);
		Adminuser au=new Adminuser();
		au.setAdminName("Admin");
		cta.setUseUser(au);
		String btnGenerate=request.getParameter("btnSimulateGenerateData");
		request.setAttribute("GenerateOrSave",null);
		try
		{
			String[][] str=sds.generateCreditSimulationData(cta);
			System.out.println(str.length);
			if(str.length>0)
			{
				request.setAttribute("GenerateOrSave", "模拟数据生成成功！");
			}
			else
			{
				request.setAttribute("GenerateOrSave", "模拟数据生成失败");
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("GenerateOrSave", "模拟数据生成失败");
		}
		System.out.println(request.getAttribute("GenerateOrSave"));
    }
    
    
    
}