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
    
<title>个人信用查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/mycss.css"/>" rel="stylesheet" type="text/css">
  </head>
  


  <body style="background:#fff;">
  
 <div style="height:8px; width:100%;"></div>
      <div id="lightcolor" style="width:97%;magin 0px auto;" >
      <form method="post">
        <label id="labelbody" >证件类型： </label>
        <select name="cars"  style=" border: 1; background:#4B5C88;color:#FFF;">
          <option value="fiat" selected="selected" style="background: #4B5C88;"> 身份证  </option>
          <option value="volvo" style="background: #4B5C88;"> 护照 </option>
          <option value="saab" style="background: #4B5C88;" > 军官证  </option>   <!--证件类型-->
        </select>
        <input name="ID" type="text" style="border:#000 soild 1px;" >   <!--证件号码-->
        
        </div>
        <button name="btnClientPortrayQuery"  type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;margin:6px;">查询333</button>  
      
        
      </form>

  </body>
</html>
