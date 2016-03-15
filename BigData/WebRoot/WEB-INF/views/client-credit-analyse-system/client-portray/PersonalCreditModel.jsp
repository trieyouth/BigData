<i><%@page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>个人信用模型</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href='<c:url value="/css/mycss.css"/>' rel="stylesheet" type="text/css">
  </head>
  
<body>
<div style="height:8px; width:100%;"></div>
<div id="lightcolor">
  <label id="labelhead"><a style="text-align:center;">查询结果 </a></label>
</div>
<div style="height:4px; width:100%;"></div>
<form method="POST">
<div id="lighttable">
  <table frame="void" width="100%" height="86" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;">
    <span style="overflow:hidden;height:30"></span>
    <tr>
      <td width="50%">
      <h3><br>尊敬的${ Id}用户</h3><br>
      <h3>您的信用得分为：${level }</h3><br>
      <h3>信用等级为：${ss}</h3><br>
      <h3>最高贷款金额为：${loan}元</h3><br>
      </td>
      <td width="50%">   <img src="<c:url value="${picUrl}"/>"></td> 
    </tr>
  </table> 
</div>
<div id="buttoncon">
<div style="height:10px; width:100%;"></div>
  <button type="submit" id="ReportInfo" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;"><a href="<c:url value="/ccas/index/clientPortray/personalCreditModelDetail"/>">个人信用报告详情</a></button> 
</div>
  </form>
  </body>
</html>
</i>