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
     <title>客户信用分析后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
 
     <style>

#continaer{
	margin: 0px auto;
	width:80%;
	height:750px;
	background-color:rgb(18,24,48);
	padding:10px;
	}
#header{
	height:20%;
	width:100%;
	margin:0 auto;
	padding:0;
	border:0;
	background-color:rgb(76,93,137);}
    hr{ margin-top:0;
	margin-bottom:0;}
	
#bod{
	height:79%;
	width:100%;
	margin-top:0%;
	padding:0;
	background-color:rgb(49,69,120);
	}
#leftbody{
	margin:0;
	padding:0;
	border:0;
	width:20%;
	height:100%;
	background-color:rgb(49,69,120);
	float:left;
	}
#rightbody{
	margin:0;
	padding:0;
	border:0;
	width:80%;
	height:100%;
	background-color:rgb(49,69,120);
	float:left;}
#navhead{
	width:100%;
	height:50px;
	border:0;
	margin:0;
	padding:0;
	background:rgb(49,69,120);}
	
#hrc{
	margin-top:0;}	
.nav ul {
	width: 800px;
	height: 50px;
	padding: 0;
	margin-top:0;
}
.nav ul li {
	float: left;
	list-style: none;
}
.nav ul li a {
	width: 145px;
	height: 41px;
	line-height: 41px;
	background: rgb(49,69,120);
	color: #000;
	font-size: 14px;
	display: block;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	font-family:Microsoft YaHei;
	color:#FFF;
}
.nav ul li a:hover {
	width: 145px;
	height: 41px;
	line-height: 41px;
	border: 1px solid rgb(49,69,120);
	color: #000;
}
	
.over {
        color:red;
        background:blue;
        font-size:larger;
    }
    .out {
        color:black;
        background:white;
        font-size:smaller;
    }
    .click {
        color:yellow;
        background:yellow;
        font-size:12px;
    }

</style>
 </head>
  <body>
    <div id="continaer">
	<div id="header">
    <a href="WebView/SystemManage/SMIndex.jsp">
    <img src="<c:url value='/images/manager/logo.png' />" width="620" height="75" alt="logo" > <hr color="#6F7DA0"/>
   </a>
   <div id="navhead">
   
   
    <div class="nav">
      <ul>
        <li><a href="<c:url value='manager/product/index'/>">产品管理</a></li>   <!--链接到了产品管理主框架-->
        <li><a href="<c:url value='manager/user/index'/>">用户管理</a></li>
      
      </ul>

    </div> 
   

   </div>
   
    
    <hr color="#848FAD"/>
    
     </div>
   

   
   <div id="bod">
		<div id="leftbody">
        <br/>
        </div>
        
        
        
        
     <div id="rightbody">
        <br/>
        <br/>
         <br/>
          <br/> 
        
        
       <!-- <img src="" width="700" height="330" alt="系统操作流程图"> --> </div>


   </div>
   
   
   
   
   
   
   
</div>


  </body>
</html>
