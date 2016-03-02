<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String PersonalCreditModel="";
if(request.getAttribute("PersonalCreditModel")!=null)
{
    PersonalCreditModel="最高贷款金额为："+request.getAttribute("PersonalCreditModel") +"元";
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
      <form action="ClientPortrayServlet" method="get">
        <label id="labelbody" >证件类型： </label>
        <select name="cars"  style=" border: 1; background:#4B5C88;color:#FFF;">
          <option value="fiat" selected="selected" style="background: #4B5C88;"> 身份证  </option>
          <option value="volvo" style="background: #4B5C88;"> 护照 </option>
          <option value="saab" style="background: #4B5C88;" > 军官证  </option>   <!--证件类型-->
        </select>
        <input name="txtFeeID" type="text" style="background-color: transparent; border:#7786A7 soild 1px;" >   <!--证件号码-->
        </div>
        <button name="btnQueryFee"  type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;margin:10px;">查询</button>  
         <!--点击此按钮后查询生成记录，根据前面的证件号码，跳到生成模板生成详情页面，即TempletCreateRecordDetial-->
      </form>
  


<div id="lightcolor">
<form  method="get" action="">
  <div id="lightcolor">
  <div style="padding-left:2%; padding-top:1%">
    <label id="labelhead"  style="font-size:18px">
    <span class="STYLE1"><h3><br><%=PersonalCreditModel %></h3><br></span> </label>
    <!--此处的贷款额度为根据前面的身份证号码查询后显示的-->
    <img  src=<%= request.getAttribute("PersonalCreditSrc")%>>
  </div>
</form>
  </body>
</html>
