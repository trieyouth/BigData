<%@page import="com.zero.entity.Adminuser"%>
<%@page import="com.zero.service.UserService"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.text.*"%>
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
    <title>用户管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" href="<c:url value='/css/mycss.css' />">
  </head>
  
  <body>
     <div style="height:10px; width:100%;"></div>
<div id="lightcolor">
<table frame="void" width = "100%" height="25" style="text-align:center;">
<tr>
  <td width="20%"  height="25"  ><label id="labelhead" >编号 </label></td>  <!--模板编号-->
  <td width="20%"  height="25"  ><label id="labelhead" >姓名 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >职位 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >激活 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >权限 </label></td>
</tr>
</table>
</div>

 <div style="height:4px; width:100%;"></div>


<div id="lighttable">
  <table frame="void" width = "100%" height="30" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;">
    <span style="overflow:hidden;height:30"></span> 
    
    <c:forEach var="user" items="${userList}">
    <tr>
      <td width="20%"  height="30" class="cell" ><label id="labelbody" ><c:out value="${user.adminId}"/></label></td>
      <!--模板编号-->
      <td width="20%"  height="30" class="cell"><label id="labelbody" > <c:out value="${user.adminName}"/></label></td>
      <!--生成时间-->
      <td width="20%"  height="30"class="cell"><label id="labelbody" ><c:out value="${user.adminTitle}"/> </label></td>
      <!--生成数量-->
      <td width="20%"  height="30"class="cell"><label id="labelbody" >已激活 </label></td>
      <!--创建人-->
      <td width="20%"  height="30"><label id="labelbody" ><a href="<c:url value='/manager/user/authshow/'/><c:out value="${user.adminName}"/>"
      
       style="color:#09F">查看权限 </a></label></td>
      <!--根据编号去跳转到相应也页面，yongjsp改href-->
     
    </tr>
	</c:forEach>
  </table>
</div>

       <div style="height:10px; width:100%;"></div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <a href="<c:url value="/manager/user/add"/>">
    <button name="btnGenerate" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">增加用户</button>
</a>
  
  </div>
  </body>
</html>
