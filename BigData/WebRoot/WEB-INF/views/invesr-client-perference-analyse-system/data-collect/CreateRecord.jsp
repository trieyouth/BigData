<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询生成记录</title>
     <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css">
	

  </head>
  
  <body>
    <div style="height:8px; width:100%;"></div>
      <form action="EvaluateClientRiskPreferenceDataCollectServlet" method="post">
        <div id="lightcolor" >
        <label id="labelbody" >证件类型： </label>
        <select name="cars"  style=" border: 1; background:#4B5C88;color:#FFF; width:90px;">
          <option value="fiat" selected="selected" style="background: #4B5C88;"> 身份证</option>
          <option value="volvo" style="background: #4B5C88;"> 护照  </option>
          <option value="saab" style="background: #4B5C88;" > 军官证</option>  
           <!--证件类型-->
        </select>
        <input name="ID" type="text" style="background-color: transparent; border:#7786A7 soild 1px;" >  
         <!--证件号码-->
         </div>
        <br/>
        <%
           if(request.getAttribute("IndividualCustomerAnalysis")!=null)
           {
              out.println(request.getAttribute("IndividualCustomerAnalysis"));
           }
         %>
        <input name="query"  type="submit" style="width:150px ;height:30px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;margin:10px;" value="查询"/>  
         <!--点击此按钮后查询生成记录，根据前面的证件号码，跳到生成模板生成详情页面，即TempletCreateRecordDetial-->
  
      </form>
  </body>
</html>
