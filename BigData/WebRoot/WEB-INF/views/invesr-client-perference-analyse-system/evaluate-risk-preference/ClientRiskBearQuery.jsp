<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

   String PersonalCreditQuery="";
  if(request.getAttribute("ClientRiskBearQuery")!=null)
   {
       PersonalCreditQuery=(String)request.getAttribute("ClientRiskBearQuery");
   }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>风险承受能力条件人群查询</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link href="WebView/css/mycss.css" rel="stylesheet" type="text/css">

  </head>
  
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
  
  <body>
     <div style="height:4px; width:100%;"></div>
<form  method="post" action="EvaluateClientRiskPreferenceServlet">
  
  <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="nl1"  rquired>
          </label></td>
        <!--那么属性为参数名-->
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="nl2" rquired >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >岁 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 家庭月收入： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="jtysr1" rquired >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="jtysr2" rquired >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >元 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 预计投入的家庭收入的比例： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="yjtrdjtsrdbl1" rquired>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="yjtrdjtsrdbl2" rquired>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      
      
        <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 历史投资次数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="lstzcs1" rquired>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="lstzcs2" rquired>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >次 </label></td>
      </tr>
      
        <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 历史投资额度范围： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="lstzedfw1" rquired>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="lstzedfw2" rquired >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >元 </label></td>
      </tr>
      
      
        <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 存款剩余额度范围： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="cksyedfw1" rquired >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="cksyedfw2" rquired >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >元 </label></td>
      </tr>
      
      
    </table>
  </div>
 
  <div style="height:10px; width:100%;">
  </div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button name="btnRiskBearQuery" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">查询</button>
    <!--根据条件查询出客户组,下一个页面为ClientRiskQueryResult-->
<!--     <a href="WebView/InvesrClientPerferenceAnalyseSystem/EvaluateClientRiskPreference/ClientRiskBearQueryResult.jsp">查询测试</a>  -->
  </div>
</form>
  </body>
</html>
