<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>个人信用模型</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
<style>
#lightcolor {
	width: 96%;
	padding-top:10px;
	padding-bottom:10px;
	padding-left:10px;
	margin-left:1%;
	background-color: #4B5C88;
	border:0;
}
</style>
  </head>
  
  <body>
<div style="height:8px; width:100%;"></div>
<div id="lightcolor" >
  <label id="labelhead" >查询结果 </label>
</div>
<div style="height:4px; width:100%;"></div>
<div id="lighttable">
  <table frame="void" width = "100%" height="86" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;">
    <span style="overflow:hidden;height:30"></span>
    <tr>
      <td width="40%">
      <%=(String)request.getAttribute("PersonalCreditModel") %>
      </td>
      <td width="60%">   <img src=<%= (String)request.getAttribute("PersonalCreditSrc")%>></td> 
       <!--右边部分，显示笑脸-->
    </tr>
  </table> 
</div>

<div id="buttoncon">


<div style="height:10px; width:100%;"></div>


  <button style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;"><a href="<%=request.getAttribute("PersonalCreditQueryCrowdServlet")%>">个人信用报告详情</a></button> 
   <!--点击后跳转到详细信用报告页面-->

</div>


  </body>
</html>
