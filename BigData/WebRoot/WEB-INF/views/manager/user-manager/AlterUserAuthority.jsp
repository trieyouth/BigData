<%@page import="com.zero.service.UserService"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <title>更改用户权限</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link href="<c:url value='/css/mycss.css' />" rel="stylesheet" type="text/css"  >
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
   
   
   <div id="lightcolor" >
   
   <%
   String srcpath = "UserManage?username=" +request.getParameter("alterusername") + "&DId=1";
   %>
      <form method="post">
      
      
<table frame="void" width = "85%" height="30">
<tr>
  <td width="25%" height="30"><label id="labelhead" >编号 </label></td>  <!--模板编号-->
  <td width="25%" height="30"><label id="labelhead" >权限描述 </label></td>
   <td width="25%" height="30"><label id="labelhead" >状态 </label></td>  <!--模板编号-->
  <td width="25%" height="30"><label id="labelhead" >设置 </label></td>
</tr>
</table>
</div>
    <div style="height:1px; width:100%;"></div>  
    <div id="lightcolor" >

<table frame="void" width = "85%" height="22px">

<%-- <% 
//客户权限设置
UserService uService = new UserService();
int userqx=uService.findAuthority(request.getParameter("alterusername"));

String qxdetial1 = new String();
String check1 = new String();
String check2 = new String();
String check3 = new String();
if(userqx == 1){
	qxdetial1="已激活";
	check1="checked";
}
else{
	qxdetial1 = "未激活";
}

String qxdetial2 = new String();
if(userqx == 2){
	qxdetial2="已激活";
	check2="checked";
}
else{
	qxdetial2 = "未激活";
}

String qxdetial3 = new String();
if(userqx == 3){
	qxdetial3="已激活";
	check3="checked";
}
else{
	qxdetial3 = "未激活";
}

%>
 --%>

<tr>
  <td width="25%" height="22px"><label id="labelbody" >qx0001 </label></td>  <!--模板编号-->
  <td width="25%" height="22px"><label id="labelbody" >访问后台管理系统 </label></td>
   <td width="25%" height="30"><label id="labelhead" >${clientAuthDetail}</label></td>  <!--模板编号-->
  <td width="25%" height="30">
  <label id="labelhead" >
  <input name="qx" type="radio"  value="1"  ${clientAuthChecked} >   <!--checked控制默认是不是打钩-->

  </label>
 
</tr>

<tr>
  <td width="25%" height="22px"><label id="labelbody" >qx0002 </label></td>  <!--模板编号-->
  <td width="25%" height="22px"><label id="labelbody" >访问客户信用分析系统 </label></td>
   <td width="25%" height="30"><label id="labelhead"  >${invesrAuthDetail}</label></td>  <!--模板编号-->
  <td width="25%" height="30">
  <label id="labelhead" >
  
  <input name="qx" type="radio"  value="2" ${invesrAuthChecked}>

  </label>
 
 
</tr>


<tr>
  <td width="25%" height="22px"><label id="labelbody" >qx0003 </label></td> 
   <!--模板编号-->
  <td width="25%" height="22px"><label id="labelbody" >访问投资客户风险偏好数据分析与推荐系统 </label></td>
   <td width="25%" height="30"><label id="labelhead" >${managerAuthDetail}</label></td> 
    <!--模板编号-->
  <td width="25%" height="30">
  <label id="labelhead" >
  <input name="qx" type="radio"  value="3"  ${managerAuthChecked} >

  </label>

</tr>
</table>
</div>  
 <div style="height:8px; width:100%;"></div>
   <div id="buttoncon">
	
    <button  type="submit"  name="btnGenerate" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">更改用户权限</button>

 </form>
  </div>
  </body>
</html>
