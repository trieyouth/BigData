<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="com.zero.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
  		if(request.getAttribute("ContextDetail")!=null){
  			InvestTemplateAllInfo itallInfo = new InvestTemplateAllInfo();
  			InvestTemplateContext info = new InvestTemplateContext();
  			
  			itallInfo = (InvestTemplateAllInfo)request.getAttribute("TemplateDetail");
  			info=(InvestTemplateContext)request.getAttribute("ContextDetail");
  			
  System.out.println("fdakfa:"+info.getMaxAge());
  
  
  
   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
        <meta charset="utf-8">
<title>模板详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
<style>
#lightcolor {
	width: 96%;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 10px;
	margin-left: 1%;
	background-color: #4B5C88;
	border: 0;
}
</style>

  </head>
  
  <body>
<div style="height:4px; width:100%;"></div>
<form  method="post" action="">
 
  
  
  
  
  
  
  <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMinAge() %>"  name="nianling1" >
          </label></td>
        <!--那么属性为参数名-->
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMaxAge() %>"  name="nianling2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >岁 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 投资占总资产比： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMinInvestAssetRate() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMaxInvestAssetRate() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 投资资金稳定时间段： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMinInvestStabilizePeriod() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMaxInvestStabilizePeriod() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >年 </label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">投资类型偏好参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 股票、基金： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMinStockFundNum() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMaxStockFundNum() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 房地产： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMinEstateNum() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMaxEstateNum() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 保险： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMinInsuranceNum() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder="<%=itallInfo.getInvestTemplateContext().getMaxInsuranceNum() %>"  name="nianling1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
    </table>
  </div>
 
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
<!--     <label  id="labelhead">生成模拟数据记录数</label>
 -->    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
<!--         <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 共生成： </label></td>
 -->        <td width="25%"  height="25"  ><label id="labelbody" >
           <%--  <input  type="text" id="inputwidth"  placeholder="<%= %>"  name="nianling1" > --%>
          </label></td>
<!--         <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 条 </label></td>
 -->        <td width="25%"  height="25"  ></label></td>
        <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
      
      
      <%
      
      		}
      
       %>
    </table>
  </div>
  <div style="height:10px; width:100%;"></div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button name="btnGenerate" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">生成模拟数据</button>
    <!--点击此按钮后台获得参数-->
   
  </div>
</form>
  </body>
</html>
