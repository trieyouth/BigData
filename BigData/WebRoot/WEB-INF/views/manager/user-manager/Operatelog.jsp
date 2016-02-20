<%@page import="com.zero.entity.self.LogModel"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>操作日志</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
  </head>
  
  <body>
    <div style="height:10px; width:100%;"></div>
<div id="lightcolor">



<table frame="void" width = "100%" height="25" style="text-align:center;">
<tr>
  <td width="33%"  height="25"  ><label id="labelhead" >时间 </label></td> 
   <!--模板编号-->
  <td width="33%"  height="25"  ><label id="labelhead" >用户名 </label></td>
  <td width="33%"  height="25"  ><label id="labelhead" >操作明细 </label></td>
</tr>
</table>
</div>

 <div style="height:4px; width:100%;"></div>


<div id="lighttable">
  <table frame="void" width = "100%" height="30" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse; text-align:center;">
    <span style="overflow:hidden;height:30"></span> 
    
    <!--jsp循环此处的tr,在</td>前填数据-->
    
<%-- <% 
   LogService logService=new LogService();
	List<Logweb> log = logService.selectAllLog();

	String username = new String();
	int j= log.size();
	for(int i=0;i<log.size();i++){
		UserService uService = new UserService();
		username = "未知";
		int  id =0;
		id=log.get(i).getAdminId();
		if(id!=0){//System.out.println("00");
		username = uService.findAdminName(log.get(i).getAdminId());
		}
		else{System.out.println(log.get(i).getAdminId());}
		int k=j-i-1;
		
%> --%>
    
    <c:forEach var="log" items="${logList}">
    <tr>
      <td width="33%"  height="30" class="cell"><label id="labelbody" ><c:out value="${log.logDate}" /> </label></td>
      <!--生成时间-->
      <td width="33%"  height="30"class="cell"><label id="labelbody" ><c:out value="${log.username}" /> </label></td>
      <!--操作人-->
      <td width="33%"  height="30"class="cell"><label id="labelbody" ><c:out value="${log.logContent} }" /></label></td>
      <!--根据操作人去选择href-->
    </tr>
    </c:forEach>
    
   <%--  <tr>
      <td width="33%"  height="30" class="cell"><label id="labelbody" ><%=log.get(k).getLogDate() %> </label></td>
      <!--生成时间-->
      <td width="33%"  height="30"class="cell"><label id="labelbody" ><%=username %> </label></td>
      <!--操作人-->
      <td width="33%"  height="30"class="cell"><label id="labelbody" ><%=log.get(k).getLogConten() %></label></td>
      <!--根据操作人去选择href-->
    </tr> --%>
  <%--   <%
    } 
    %> --%>
  </table>
</div>
  </body>
</html>
