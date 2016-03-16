<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>生成模拟数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
 </head>
  
<body>
<div style="height:4px; width:100%;"></div>
<form  method="post"  action="/icpas/index/dataCollect/saveAsTemplate">
  <div id="lightcolor">
    <div style="height:25px; width:60%; text-align:center; font-size: 25px;"> <label id="labelhead"><a>另存为模板</a></label></div>
   
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "60%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 模板名称： </label></td>
        <td width="70%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" style="width:300px;" name="templateName" >  </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 模板描述： </label></td>
        <td width="70%"  height="25" rowspan="2" ><label id="labelbody" >
            <textarea  id="inputwidth" style="width:300px; height:300px;" name="templateDescribr" > </label></td>
      </tr>
      <tr>
         <td style="height:300px;"></td>
      </tr>
      <tr style="text-align:center;">
        <td colspan="2" style="height:30px">
        <input type="submit" id="button1style" value="确定">
        <input type="reset" id="button3style" value="重填">
        </td>
      </tr>
    </table>
  </div>
</form>
  </body>
</html>
