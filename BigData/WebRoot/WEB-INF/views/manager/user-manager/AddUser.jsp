<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <title>增加用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<c:url value='/css/mycss.css' />">


	<script type="text/javascript">
		var check = function() {
			var passwd1 = document.forms['testForm'].passwd1;
			var passwd2 = document.forms['testForm'].passwd2;
			if(passwd1.value != passwd2.value) {
				passwd2.setCustomValidity("密码不一致！");
				return false;
			} else {
				passwd2.setCustomValidity("");
			
			}
			return true;
			
		}
		
	</script>


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
#inputwidth1 {
	width: 300px;
	height: 50px;
	background: Transparent;
	border: 1px solid #788587;
	color: #FFF;
}
</style>


	
</head>
  <body>
    <div style="height:10px; width:100%;"></div>
       <%
   String srcpath = "UserManage?DId=2";
   %>
    <form id="testForm" name="testForm" onsubmit="return check();" method="post">
<div id="lightcolor">
  <label id="labelhead">基本信息</label>
</div>
<div style="height:2px; width:100%;"></div>
<div id="lightcolor">

  <table frame="void" width = "100%" height="25" >
    <tr>
      <td width="50%"  height="25"  ><label id="labelbody" >&nbsp用户名 </label></td>
      <td width="50%"  height="25"  ><input  type="text" id="inputwidth" name="username"   required ></td>
    </tr>
    <tr>
      <td width="50%"  height="25"  ><label id="labelbody" >&nbsp职位 </label></td>
      <td width="50%"  height="25"  ><input  type="text" id="inputwidth" name="userback"  required ></td>
    </tr>
    <tr>
      <td width="50%"  height="25"  ><label id="labelbody"  >&nbsp密码 </label></td>
      <td width="50%"  height="25"  ><input  id="inputwidth" type="password" name="passwd1"  required ></td>
    </tr>
    <tr>
      <td width="50%"  height="25"  ><label id="labelbody"  >&nbsp密码确认 </label></td>
      <td width="50%"  height="25"  ><input  id="inputwidth" type="password" name="passwd2"  required ></td>
    </tr>
    
  </table>
</div>
<div style="height:4px; width:100%;"></div>
<div id="lightcolor">
  <label id="labelhead">权限设置</label>
</div>
<div style="height:2px; width:100%;"></div>
<div id="lightcolor" >
  <table frame="void" width = "50%" height="30" style="text-align:center;">
    <tr>
      <td width="33%" height="30"><label id="labelhead" >编号 </label></td>
      <!--模板编号-->
      <td width="33%" height="30"><label id="labelhead" >权限描述 </label></td>
      <!--模板编号-->
      <td width="33%" height="30"><label id="labelhead" >设置 </label></td>
    </tr>
  </table>
</div>
<div style="height:1px; width:100%;"></div>
<div id="lightcolor" >
<table frame="void" width = "50%" height="22px">
  <tr>
    <td width="33%" height="22px"><label id="labelbody" >qx0001 </label></td>
    <!--模板编号-->
    <td width="33%" height="22px"><label id="labelbody" >访问后台管理系统 </label></td>
    <td width="33%" height="30" style="text-align: center;"><label id="labelhead" >
        <input name="qx" type="radio" value="1" >
        <!--checked控制默认是不是打钩--> 
        
      </label></td>
  </tr>
  <tr>
    <td width="33%" height="22px"><label id="labelbody" >qx0002 </label></td>
    <!--模板编号-->
    <td width="33%" height="22px"><label id="labelbody" >访问客户信用分析系统 </label></td>
    <td width="33%" height="30" style="text-align: center;"><label id="labelhead" >
        <input name="qx" type="radio" value="2" >
      </label></td>
  </tr>
  <tr>
    <td width="33%" height="22px"><label id="labelbody" >qx0003 </label></td>
    <!--模板编号-->
    <td width="33%" height="22px"><label id="labelbody" >访问投资客户风险偏好数据分析与推荐系统 </label></td>
    <td width="33%" height="30" style="text-align: center;"><label id="labelhead" >
        <input name="qx" type="radio" value="3"  >
      </label></td>
  </tr>
</table>
</div>
<div style="height:10px; width:100%;"></div>
<!--选择按钮功能-->
<div id="buttoncon">
  <button name="btnGenerate"   type="submit"  style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">增加用户</button>
  </div>
  
  </form>
  </body>
</html>
