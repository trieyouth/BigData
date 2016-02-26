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
    
<title>个人信用查询条件查出</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
  </head>
  
  <body>

     <div style="height:8px; width:100%;"></div>
   <div id="lightcolor" >
   
 <table frame="void" width = "100%" height="20" >
<tr>
  <td width="20%"  height="25"  ><label id="labelhead" >用户编号 </label></td>  <!--模板编号-->
  <td width="20%"  height="25"  ><label id="labelhead" >身份ID </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >年龄 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >等级 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >详细信息 </label></td>
</tr>
</table>
</div>  </div>
   <div style="height:4px; width:100%;"></div>
   <div id="lighttable">
   <table frame="void" width = "100%" height="20" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;"><span style="overflow:hidden;height:20"></span>
   <!--jsp循环此处的tr-->
   <%
       List list=null;
       if(request.getAttribute("PersonalCreditQuery")!=null)
       {
             PersonalCredit pc;
           list=(List)request.getAttribute("PersonalCreditQuery");
           for(int i=0;i<list.size();i++)
           {
               pc=new PersonalCredit();
               pc=(PersonalCredit)list.get(i);
               %>
      <tr>
         <td width="20%" class="cell"><label id="labelbody"><%=pc.getId() %></label> </td> 
           <!--用户编号-->
         <td width="20%" class="cell"><label id="labelbody"><%=pc.getPId() %> </label></td>
         <td width="20%" class="cell"><label id="labelbody"><%=pc.getAge() %> </label></td>
         <td width="20%" class="cell"><label id="labelbody"><%=pc.getLevel() %> </label></td>
         <td width="20%" class="cell"><label id="labelbody"><a href=<%=pc.getDetailInfo() %>>详细信息 </a></label></td> 
          <!--根据前面的用户编号去生成href内容-->
          </tr>
              <%
           }
       }
   %>     
</table>
 </i></div>
  </body>
</html>
