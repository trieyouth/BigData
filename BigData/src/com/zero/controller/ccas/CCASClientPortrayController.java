package com.zero.controller.ccas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zero.entitylib.PersonalCredit;
import com.zero.entity.PersonalCreditQuery;
import com.zero.service.HiveQueryService;

@RequestMapping("/ccas/index/clientPortray")
@Controller
public class CCASClientPortrayController {
	//@RequestMapping(value="/personalCreditQuery",method=RequestMethod.GET)
	public String personalCreditQuery(){
		return "client-credit-analyse-system/client-portray/PersonalCreditQuery";
	}
	//@RequestMapping(value="/personalCreditQuery",method=RequestMethod.POST)
	public String personalCreditQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//【PersonalCreditQueryByCard.jsp】根据Id查询数据                
		 String btnClientPortrayQuery=request.getParameter("btnClientPortrayQuery");
		 if(btnClientPortrayQuery!=null)
		 {
			 return QueryById(request,response);
		 }
		return null;
		
	}
	//@RequestMapping(value="/personalCreditQueryByCard",method=RequestMethod.GET)
	public String PersonalCreditQueryByCard(){
		return "client-credit-analyse-system/client-portray/PersonalCreditQueryByCard";
	}
	//@RequestMapping(value="/personalCreditQueryByCard",method=RequestMethod.POST)
	public String PersonalCreditQueryByCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 //【PersonalCreditQuery.jsp】根据Id查询数据                               
		 String btnPersonalCreditQuery=request.getParameter("btnPersonalCreditQuery");
		 if(btnPersonalCreditQuery!=null)
		 {
			 return PersonalCreditQuery(request,response);
		 }
		return null;
		
	}
	@RequestMapping(value="/checkCreditLevel")
	public String checkCreditLevel(){
		return "client-credit-analyse-system/client-portray/checkCreditLevel";
	}
	
	
	
	
	
	
	
	/**
	 * 【PersonalCreditQueryByCard.jsp】根据Id查询数据
	 *   跳转界面【PersonalCreditModel.jsp】 
	 * */
	public String QueryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String Id=request.getParameter("ID");
		String btnClientPortrayQuery=request.getParameter("btnClientPortrayQuery");
		//			System.out.println("Id:"+Id);
		List<String> lt=null;
		HiveQueryService hqs=new HiveQueryService();
		try {

			lt=hqs.getInfoByCardnums(Id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(lt.size()>0)
		{
			String score=lt.get(50);
			//System.out.println("score:"+score);
			int level=Integer.parseInt(score)/10;
			int loan=(int)(Integer.parseInt(score)*5000*1.0/10);
			if(loan>=50000) {loan=50000;}
			String str="<h3><br>尊敬的"+Id+":<br>您的信用得分为："+score+"<br>"+"信用等级为："+ level+"级<br>"+"最高贷款金额为："+loan+"元</h3><br>";
			request.setAttribute("PersonalCreditModel", str);
			//System.out.println(str);
			int ss=0;
			if(level>=9){ss=5;}
			else if(level>=7 && level<9) {ss=4;}
			else if(level>=4 && level<7) {ss=3;}
			else if(level>=1 && level<4) {ss=2;}
			else {ss=1;}
			String strSrc="WebView//images//"+ss+".png";
			
			String PersonalCreditQueryCrowdServlet="PersonalCreditQueryCrowdServlet?Id="+Id;
			System.out.println("PersonalCreditQueryCrowdServlet?Id="+Id);
			request.setAttribute("PersonalCreditQueryCrowdServlet",PersonalCreditQueryCrowdServlet);
			
			//System.out.println(strSrc);
			request.setAttribute("PersonalCreditSrc", strSrc);
		}
		return "client-credit-analyse-system/client-portray/PersonalCreditModel";
	}

    /***
     * 【PersonalCreditQuery.jsp】根据Id查询数据
     * 
     * */
	@RequestMapping(value="/personalCreditQuery",method=RequestMethod.GET)
	public String LoadPersonalCreditQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		return "";
	}
	
	@RequestMapping(value="/personalCreditQuery",method=RequestMethod.POST)
	public String PersonalCreditQuery(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			System.out.println("btnPersonalCreditQuery:*****************");
           
			//基本信息参数【年龄】【月收入】【工作年限】
			String nl1=request.getParameter("nl1");
			String nl2=request.getParameter("nl2");
			String ysr1=request.getParameter("ysr1");
			String ysr2=request.getParameter("ysr2");
			String gznx1=request.getParameter("gznx1");
			String gznx2=request.getParameter("gznx2");
			//信贷记录参数【信用卡账户数】【银行贷款笔数】
			String xykzhs1=request.getParameter("xykzhs1");
			String xykzhs2=request.getParameter("xykzhs2");
			String yhdkbs1=request.getParameter("yhdkbs1");
			String yhdkbs2=request.getParameter("yhdkbs2");
			//贷款参数【贷款总额度】【申请贷款次数】
			String dkzed1=request.getParameter("dkzed1");
			String dkzed2=request.getParameter("dkzed2");
			String sqdkcs1=request.getParameter("sqdkcs1");
			String sqdkcs2=request.getParameter("sqdkcs2");

			PersonalCreditQuery pq=new PersonalCreditQuery();
			//基本信息参数
			pq.setMinAge(Integer.parseInt(nl1));
			pq.setMaxAge(Integer.parseInt(nl2));
			pq.setMinMonthlyIncome(Integer.parseInt(ysr1));
			pq.setMaxMonthlyIncome(Integer.parseInt(ysr2));
			pq.setMinWorkYears(Integer.parseInt(gznx1));
			pq.setMaxWorkYears(Integer.parseInt(gznx2));
			//信贷记录参数
			pq.setMinCreditNum(Integer.parseInt(xykzhs1));
			pq.setMaxCreditNum(Integer.parseInt(xykzhs2));
			pq.setMinLoansNum(Integer.parseInt(yhdkbs1));
			pq.setMaxLoansNum(Integer.parseInt(yhdkbs2));
			//贷款参数
			pq.setMinLoansAmount(Integer.parseInt(dkzed1));
			pq.setMaxLoansAmount(Integer.parseInt(dkzed2));
			pq.setMinApplyForLoanNum(Integer.parseInt(sqdkcs1));
			pq.setMaxApplyForLoanNum(Integer.parseInt(sqdkcs2));

			List<ArrayList<String>> lt=new ArrayList<ArrayList<String>>();
			PersonalCredit pc;
			HiveQueryService hqs=new HiveQueryService();
			List<PersonalCredit> list=new ArrayList<PersonalCredit>();
			list.clear();
//			try {
				lt=hqs.getInfoArrByFuzzy(pq);
				System.out.println("***************size:-------"+lt.size());
				for(int i=0;i<lt.size();i++)
				{ 
					List<String> ll=lt.get(i);
					pc=new PersonalCredit();
					pc.setId(ll.get(0));
					pc.setPId(ll.get(1));
					pc.setAge(ll.get(13));
					int score=Integer.parseInt(ll.get(50))/10;
					pc.setLevel(score+"");
					pc.setDetailInfo("PersonalCreditQueryCrowdServlet?Id="+pc.getId());
					list.add(pc);
				}
				//System.out.println(lt.size()+"-----------------------------------");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
            
			//System.out.println("size:"+lt.size());
//			pc.setId("10");
//			pc.setPId("1033115620");
//			pc.setAge("30");
//			pc.setLevel("6");
//			pc.setDetailInfo("PersonalCreditQueryCrowdServlet？Id="+pc.getId());
//			list.add(pc);
			request.setAttribute("PersonalCreditQuery", list);
			return "client-credit-analyse-system/client-portray/PersonalCreditQueryCrowd";
		}
		catch(Exception ex)
		{   System.out.println(ex.toString());
//			request.setAttribute("PersonalCreditQuery", "全部都不能为空！");
		return "client-credit-analyse-system/client-portray/PersonalCreditQuery";
		}
   }

	/***
	 * 【Kreditlinien.jsp】显示最高贷款金额和等级图片
	 * */
	public void QueryFee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String Id=request.getParameter("txtFeeID");
		String btnQueryFee=request.getParameter("btnQueryFee");
		if(Id!=null && Id!="")
		{
			List<String> lt=null;
			HiveQueryService hqs=new HiveQueryService();
			try {

				lt=hqs.getInfoByCardnums(Id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(lt.size()>0)
			{
				String score=lt.get(50);
				int level=Integer.parseInt(score)/10;
				int loan=(int)(Integer.parseInt(score)*5000*1.0/10);
				if(loan>=50000) {loan=50000;}
				String str="<h3><br>最高贷款金额为："+loan+"元</h3><br>";
				request.setAttribute("PersonalCreditModel", loan);
				int ss=0;
				if(level>=9){ss=5;}
				else if(level>=7 && level<9) {ss=4;}
				else if(level>=4 && level<7) {ss=3;}
				else if(level>=1 && level<4) {ss=2;}
				else {ss=1;}
				String strSrc="WebView//images//"+ss+".png";
				request.setAttribute("PersonalCreditSrc", strSrc);
			}
			request.getRequestDispatcher("WebView/ClientCreditAnalyseSystem/ClientPortray/Kreditlinien.jsp").forward(request, response);
		}
	}
}
