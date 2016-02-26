<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通过证件查询客户风险承受能力</title>
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
      <div id="lightcolor" >
      <form action="EvaluateClientRiskPreferenceServlet" method="post">
        <label id="labelhead" >证件类型： </label>
        <select name="cars"  style=" border: 1; background:#4B5C88;color:#FFF;">
          <option value="fiat" selected="selected" style="background: #4B5C88;"> 身份证  </option>
          <option value="volvo" style="background: #4B5C88;"> 护照  </option>
          <option value="saab" style="background: #4B5C88;" > 军官证 </option> 
            <!--证件类型-->
        </select>
        <input name="CardNumber" type="text" style="background-color: transparent; border:#7786A7 soild 1px;" >   <!--证件号码-->
        </div>
        <br/>
        
        <button name="btnQuery"  type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;margin:10px;">查询</button><br><!--下一个页面为根据证件号码查出的客户的风险承受能力评估结果页面-->
      </form>
<!--       <a href="WebView/InvesrClientPerferenceAnalyseSystem/EvaluateClientRiskPreference/ClientRiskBearQueryByCardResult.jsp">查询</a> </div> -->
  </body>
</html>
