<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>投资客户分析偏好数据分析与推荐系统索引页</title>
<c:import url="header1.jsp"/>
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
	<c:import url="header2.jsp"/>

   
   <div id="bod">
		<div id="leftbody">
        <br/>
        </div>

     <div id="rightbody">
        <br/>
        <br/>
         <br/>
          <br/> 
        
        
       <img src="<c:url value='/images/icpas/InvesrClientPerferenceAnalyseSystemLogoIndex.png'/>" width="700" height="330" alt="系统操作流程图"> </div>


   </div>

   
</div>

<script async>
	var height900=document.getElementById("continaer");
	w=height900.offsetWidth;
	h=w*0.5;
	//height900.style.height=h+"px";
	pd=w*0.01;
	//height900.style.padding=pd+"px"
</script>

  </body>
</html>
