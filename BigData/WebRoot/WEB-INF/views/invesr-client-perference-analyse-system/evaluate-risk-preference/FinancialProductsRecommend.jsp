<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.zero.entitylib.*" %>
<%@ page import="com.zero.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>理财产品推荐页面</title>
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
    <div style="height:4px; width:100%;"></div>
<form  method="post" action="">
  
  <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">用户
    <label id="labelhead">"<%=request.getAttribute("CardNumber") %>"</label>
    <!--为用户名，要查询得知-->
          属于
    <label id="labelhead">"<%=request.getAttribute("userstatus") %>"</label>
    <!--为用户类型，要查询得知-->
          投资人
    </label>
     <div style="height:4px; width:100%;"></div>
    <label id="labelhead">建议购买以下产品：</label><!--为用户名，要查询得知-->
    </div> 
    <div style="height:4px; width:100%;"></div>
   <div id="lightcolor" >
   
<table frame="void" width = "70%" height="30">
<tr>
  <td width="25%" height="30"><label id="labelhead" >&nbsp编号 </label></td>  <!--模板编号-->
  <td width="25%" height="30"><label id="labelhead" >&nbsp名字 </label></td>
  <td width="25%" height="30"><label id="labelhead" >&nbsp起投金额 </label></td>
  <td width="25%" height="30"><label id="labelhead" >&nbsp详细信息 </label></td>
</tr>
</table>


</div>
    <div style="height:1px; width:100%;"></div>  
    <div id="lightcolor" >
   
<table frame="void" width = "70%" height="22px" style="text-align:center;">

<%
   List list;
   if(request.getAttribute("Productions")!=null)
   {
       list=new ArrayList<RecommendProduction>();
       list=(List)request.getAttribute("Productions");
       RecommendProduction p;
       if(list.size()>0)
       {
         for(int i=0;i<list.size();i++)
         {
            p=new RecommendProduction();
            p=(RecommendProduction)list.get(i);
    %>
      <tr>
        <td width="25%" height="22px"><label id="labelbody" ><%=p.getProduction().getProdCode() %> </label></td> 
        <!--模板编号-->
        <td width="25%" height="22px"><label id="labelbody" ><%=p.getProduction().getProdName() %> </label></td>
        <td width="25%" height="22px"><label id="labelbody" ><%=p.getProduction().getMiniMoney() %>万元 </label></td>
        <td width="25%" height="22px"><label id="labelbody" > <a href=<%=p.getDetail() %>>查看详情</a> </label></td>
       <!-- 跳转界面 ProductsMessageDetial.jsp -->
     </tr>

     <%
         }
       }
   }
 %>
</table>
</div>  
</form>
  </body>
</html>
