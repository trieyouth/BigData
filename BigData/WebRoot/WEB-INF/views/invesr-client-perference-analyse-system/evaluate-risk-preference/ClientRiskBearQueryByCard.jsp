<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>通过证件查询客户风险承受能力</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<c:url value="/css/mycss.css"/>" rel="stylesheet" type="text/css">

  </head>
  <body>
    <div style="height:8px; width:100%;"></div>
      <form method="post"  action="<c:url value="/icpas/index/evaluateRiskPreference/clientRiskBearQueryByCard"/>" >
       <div id="lightcolor" >
        <label id="labelhead" >证件： </label>
        <select name="cars"  style=" border: 1; background:#4B5C88;color:#FFF;">
          <option value="fiat" selected="selected" style="background: #4B5C88;"> 身份证  </option>
          <option value="volvo" style="background: #4B5C88;"> 护照  </option>
          <option value="saab" style="background: #4B5C88;" > 军官证 </option> 
            <!--证件类型-->
        </select>
        <input name="Id" type="text" id="inputwidth">   <!--证件号码-->
       </div>
       <div height="20px"><a>${OperateStatus}</a></div>
        <br/>
        <button type="submit" id="button1style">评估风险偏好</button><br>
      </form>
  </body>
</html>
