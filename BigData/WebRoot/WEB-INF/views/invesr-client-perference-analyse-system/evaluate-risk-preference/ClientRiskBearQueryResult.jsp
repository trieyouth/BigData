<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.zero.entitylib.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>风险承受能力条件人群查询结果</title>
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
   
       <table frame="void" width = "100%" height="30">
<tr>
  <td width="18%" height="30">编号</td>  <!--模板编号-->
  <td width="20%" height="30"><label id="labelhead" >所属年龄区间 </label></td>
  <td width="10%" height="30"><label id="labelhead" >投股 </label></td>
  <td width="18%" height="30">情况</td>
  <td width="18%" height="30">状况</td>
  <td width="14%" height="30">类型</td>
</tr>
</table>
</div></div>
   <div style="height:4px; width:100%;"></div>
   <div id="lighttable">
   <table frame="void" width = "100%" height="30" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse; text-align:center;"><span style="overflow:hidden;height:30"></span>
   
   <!--jsp循环此处的tr-->
   <%
       List list;
       if(request.getAttribute("ClientRiskBearQuery")!=null)
       {
          list=(List)request.getAttribute("ClientRiskBearQuery");
          if(list.size()>0)
          {
          for(int i=0;i<list.size();i++)
          {
             RiskBear rb=(RiskBear)list.get(i);
    %>
    <tr>
      <td width="18%" class="cell" height="20"><label id="labelbody" ><%=rb.getId() %> </label> </td>  
      <!--用户编号-->
      <td width="20%" class="cell" height="30"><label id="labelbody" ><%=rb.getAge() %></label></td>
      <td width="10%" class="cell" height="30"><label id="labelbody" ><%=rb.getStocks() %> </label></td>
      <td width="18%" class="cell" height="30"><label id="labelbody" ><%=rb.getCondition() %> </label></td>
      <td width="18%" class="cell" height="30"><label id="labelbody" ><%=rb.getState() %></label></td>
      <td width="14%" class="cell" height="30"><label id="labelbody" ><%=rb.getAccount() %></label></td> 
      <!--根据前面的用户编号去生成href内容-->
     </tr>
   <%
         }
       }
   }
    %>   
</table>
   </div>
  </body>
</html>
