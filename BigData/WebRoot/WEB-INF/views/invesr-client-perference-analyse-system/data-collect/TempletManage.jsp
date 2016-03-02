<%@page import="java.sql.Date"%>
<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="com.zero.entity.*" %>
<%@ page import="com.zero.service.*" %>
<%@ page import="java.text.*"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
        <meta charset="utf-8">
<title>生成数据模板管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >

  </head>
  
  <body>
  <form action="EvaluateClientRiskPreferenceDataCollectServlet" method="post">
 <div style="height:10px; width:100%;"></div>
<div id="lightcolor">
<table frame="void" width = "100%" height="25" >
<tr>
  <td width="15%"  height="25"  ><label id="labelhead" >&nbsp编号 </label></td> 
  <td width="25%"  height="25"  ><label id="labelhead" >&nbsp创建时间 </label></td>
<!--   <td width="20%"  height="25"  ><label id="labelhead" >&nbsp生成数量 </label></td>
 -->  
 <td width="15%"  height="25"  ><label id="labelhead" >&nbsp创建人 </label></td>
 <td width="15%"  height="25"  ><label id="labelhead" >&nbsp详细信息 </label></td>
 <td width="10%"  height="25" ><label id="labelhead" >&nbsp操作 </label></td>
</tr>
<%
        List list;
        UserService userS=new UserService();
        if(request.getAttribute("TemplateManage")!=null)
        {
            list=(List)request.getAttribute("TemplateManage");
            if(list.size()>0)
            {
            	Secondtemplatedata std;
              for(int i=0;i<list.size();i++)
              {
            	  std=new Secondtemplatedata();
                  std=(Secondtemplatedata)list.get(i);
                  
                  String date = new SimpleDateFormat("yyyy-MM-dd") .format(std.getTempDate());
     %>
    <tr>
      <td width="15%"  height="30" class="cell" ><label id="labelbody" ><%=std.getTempId() %></label></td>		
      <!--模板编号-->
      
      <td width="25%"  height="30" class="cell"><label id="labelbody" ><%=date %>&nbsp&nbsp<%-- <%=std.getTempTime() %> --%></label></td>		
      <!--生成时间-->
      <td width="20%"  height="30"class="cell"><label id="labelbody" ><%=userS.findAdminName(std.getAdminId()) %> </label></td>		
      <!--生成数量-->
       <!--操作人-->
       <td width="15%"  height="30"><label id="labelbody" ><a href=EvaluateClientRiskPreferenceDataCollectServlet?s=2&tempId=<%=std.getTempId()%> style="color:#09F">查看详情</a></label></td>
      <!--根据编号去跳转到此模板的相应也页面，yongjsp改href-->
  		<td width="10%"  height="30"><label id="labelbody" ><a href=EvaluateClientRiskPreferenceDataCollectServlet?s=3&tempId=<%=std.getTempId()%> style="color:#09F" style="color:#09F">删除</a></label></td> 
      <!--删除该模板-->
    </tr>
    <%
              }
           }
        }     
     %>

</table>
</form>
  </body>
</html>
