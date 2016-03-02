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
    
    <title>查询生成记录详细信息</title>
    <meta charset="utf-8">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css"  href="WebView/css/mycss.css">
  </head>
  
  <body>
     <div style="height:10px; width:100%;"></div>
<div id="lightcolor">
<table frame="void" width = "100%" height="25" >
<tr>
  <td width="20%"  height="25"  ><label id="labelhead" >编号 </label></td>  <!--模板编号-->
  <td width="30%"  height="25"  ><label id="labelhead" >创建时间 </label></td>
<!--   <td width="20%"  height="25"  ><label id="labelhead" >生成数量 </label></td> -->
  <td width="20%"  height="25"  ><label id="labelhead" >创建人 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >详细信息 </label></td>
  <td width="10%"  height="25" ><label id="labelhead" >操作 </label></td>
</tr>
</table>
</div>
<div style="height:4px; width:100%;"></div>
<form >
<div id="lighttable">
  <table frame="void" width = "100%" height="30" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;">
    <span style="overflow:hidden;height:30"></span>
   
    <!--jsp循环此处的tr,在</td>前填数据-->
    <%
      List list;
        if(session.getAttribute("CreditDataTemplate")!=null)
        {
            list=(List)session.getAttribute("CreditDataTemplate");
            if(list.size()>0)
            {
            	CreditDataTemplate cdt;
              for(int i=0;i<list.size();i++)
              {
            	  cdt=new CreditDataTemplate();
                  cdt=(CreditDataTemplate)list.get(i);
     %>
    <tr>
      <td width="20%"  height="30" class="cell" ><label id="labelbody" ><%=cdt.getId() %></label></td>		
      <!--模板编号-->
      <td width="30%"  height="30" class="cell"><label id="labelbody" ><%=cdt.getGenerateTime() %></label></td>		
      <!--生成时间-->
<!--       <td width="20%"  height="30"class="cell"><label id="labelbody" ><%=cdt.getGenerateSum() %> </label></td>		 -->
      <!--生成数量-->
      <td width="20%"  height="30"class="cell"><label id="labelbody" ><%=cdt.getCreator() %></label></td> 
       <!--操作人-->
      <td width="20%"  height="30"><label id="labelbody" ><a href=<%=cdt.getDetailInformation() %> style="color:#09F">查看详情</a></label></td>		
      <!--根据编号去跳转到此模板的相应也页面，yongjsp改href-->
      <td width="10%"  height="30"><label id="labelbody" ><a href=<%=cdt.getUseInformation() %> style="color:#09F">删除</a></label></td> 
       <!--删除该模板-->
    </tr>
    <%
              }
           }
        }     
     %>
    
    
      <!--jsp循环此处的tr,在</td>前填数据-->
<!--     <tr> -->
<!--       <td width="15%"  height="30" class="cell" ><label id="labelbody" >a00001</label></td>		模板编号 -->
<!--       <td width="25%"  height="30" class="cell"><label id="labelbody" >2015-03-01</label></td>		生成时间 -->
<!--       <td width="20%"  height="30"class="cell"><label id="labelbody" >3,000 </label></td>		生成数量 -->
<!--       <td width="15%"  height="30"class="cell"><label id="labelbody" >马可可</label></td>  操作人 -->
<!--       <td width="15%"  height="30"><label id="labelbody" ><a href="WebView/ClientCreditAnalyseSystem/DataCollect/TempletDetial.jsp" style="color:#09F">查看详情</a></label></td>	 -->
      	<!--根据编号去跳转到此模板的相应也页面，yongjsp改href-->
<!--       <td width="10%"  height="30"><label id="labelbody" ><a href="#" style="color:#09F">删除</a></label></td>  删除该模板 -->
<!--     </tr> -->
  </table>
</div>
</form>
</body>
</html>
