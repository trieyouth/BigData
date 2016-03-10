<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据录入 </title>
    
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
     <link href="<c:url value="/css/mycss.css"/>" rel="stylesheet" type="text/css">
 
  </head>
  
  <body>
<div style="height:4px; width:100%;"></div>
<form method="POST" action="<c:url value="/ccas/index/dataCollect/dataInput"/>">
  
  <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "50%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="age" ></label></td>
        <td width="30%"  height="25" ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 月收入： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="monthlyIncome" > </label></td>
        <td width="30%"  height="25" ><label id="labelbody1" >*</label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">信贷记录参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "50%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 信用卡账户数： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="creditNum" ></label></td>
        <td width="30%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 住房贷款账户数：</label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="houseLoan" ></label></td>
        <td width="30%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" >其它贷款账户数：</label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="loansNum" > </label></td>
        <td width="30%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">公共记录</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "50%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 欠税记录： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="owingTaxes" ></label></td>
         <td width="30%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td>
         </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 民事判断记录： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="civilJudgmentRecord" ></label></td>
        <td width="30%"  height="25"  style="text-align:center"  ></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 强制执行记录： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="enforcement" ></label></td>
         <td width="30%"  height="25"  style="text-align:center"  ></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 行政记录处罚： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="administrativerPunishment" ></label></td>
         <td width="30%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td> 
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 电费欠费记录： </label></td>
        <td width="40%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="electricityArrears" ></label></td>
         <td width="30%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td> 
      </tr>
    </table>
  </div>
  
    <i><div style="height:4px; width:100%;"></div>
    <div id="lightcolor">
    <label id="labelhead">查询记录</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width="50%" height="25">
      <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody">欠税记录： </label></td>
        <td width="40%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="selectOwingTaxes"> </label></td>
         <td width="30%" height="25" style="text-align:center"><label id="labelbody"> </label></td> 
      </tr>
    </table>
  </div></i>
  
  <div style="height:20px; width:100%;">${OperateStatus }</div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button  id="button1style" type="submit">保存</button>
    <!--点击此按钮后台获得参数-->
    <button  type="Reset" id="button2style">重设</button>
  
    <!-- <button  type="Reset" id="button2style">设置生成字段</button> -->
  </div>
</form>
  </body>
</html>
