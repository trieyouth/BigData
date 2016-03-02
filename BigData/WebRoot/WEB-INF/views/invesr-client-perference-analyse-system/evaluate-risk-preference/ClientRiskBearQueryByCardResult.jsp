<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    <title>个人风险承受能力评估结果显示页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/mycss.css" rel="stylesheet" type="text/css">

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
    <div style="height:8px; width:100%;"></div>
<form action="EvaluateClientRiskPreferenceServlet" method="post">
  <div id="lightcolor">
  <div style="padding-left:2%; padding-top:1%">
    <label id="labelhead" ><span class="STYLE1" >评估结果</span><br><br>
    </label>
    <div id="lighttable">
      <table frame="void" width = "100%" height="86" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;">
        <span style="overflow:hidden;height:30"></span>
        <tr>
          <td width="15%" class="cell"><label id="labelhead" >用户：<label name="CardNumber" id="labelbody" ><%=request.getAttribute("CardNumber") %></label> </label></td>  
          <!--此处为前一个页面根据证件号查出的用户名-->
          <td width="25%" class="cell"><label id="labelhead" >类型： <label name="userstatus" id="labelbody" ><%=request.getAttribute("userstatus") %></label> </label></td> 
           <!--此处为根据前一个页面查出的用户的类型-->
        </tr>
      </table>
      <div style="height:8px; width:100%;"></div>
      <button name="btnRecommandProduction" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;margin:10px;">理财产品推荐</button> 
      <!--根据类型跳到理财产品推荐页面-->
<!--       <a href="WebView/InvesrClientPerferenceAnalyseSystem/EvaluateClientRiskPreference/FinancialProductsRecommend.jsp">跳转到推荐理财产品页面</a> -->
    </div>
  </div>
</form>
  </body>
</html>
