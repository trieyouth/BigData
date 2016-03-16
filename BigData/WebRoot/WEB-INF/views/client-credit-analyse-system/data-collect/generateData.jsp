<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
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
<form name="frm" method="POST" action="<c:url value="/ccas/index/dataCollect/generateData"/>">
  
 <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "70%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
           <input  type="text" id="inputwidth" name="minAge"  onblur="agelowchick()" onClick="clearagelow()">
           <span class="tips" id="divagelow"></span>
          </label></td>
        <!--那么属性为参数名-->
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxAge" onBlur="agehighchick()" onClick="clearagehigh()" >
            <span class="tips" id="divagehigh"></span>
          </label></td>
        <td width="10%"  height="25" ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 月收入： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minMonthlyIncome" onBlur="minMonthlyIncomechick()" onClick="minMonthlyIncomeclear()">
            <span class="tips" id="divminMonthlyIncome"></span>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxMounthlyIncome"  onBlur="maxMounthlyIncomechick()" onClick="maxMounthlyIncomeclear()">
            <span class="tips" id="divmaxMounthlyIncome"></span>
          </label></td>
        <td width="10%"  height="25" ><label id="labelbody1" >*</label></td>
      </tr>
      
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">信贷记录参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "70%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 信用卡账户数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minCreditNum" onBlur="minCreditNumchick()" onClick="minCreditNumclear()" >
             <span class="tips" id="divminCreditNum"></span>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxCreditNum"  onBlur="maxCreditNumchick()" onClick="maxCreditNumclear()">
             <span class="tips" id="divmaxCreditNum"></span>
          </label></td>
        <td width="10%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 住房贷款账户数：</label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minHouseLoan"  onBlur="minHouseLoanchick()" onClick="minHouseLoanclear()">
             <span class="tips" id="divminHouseLoan"></span>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxHouseLoan"  onBlur="maxHouseLoanchick()" onClick="maxHouseLoanclear()">
             <span class="tips" id="divmaxHouseLoan"></span>
          </label></td>
        <td width="10%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" >其它贷款账户数：</label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minLoansNum" onBlur="minLoansNumchick()" onClick="minLoansNumclear()">
            <span class="tips" id="divminLoansNum"></span>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxLoansNum"  onBlur="maxLoansNumchick()" onClick="maxLoansNumclear()">
            <span class="tips" id="divmaxLoansNum"></span>
          </label></td>
        <td width="10%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">公共记录</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "70%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 欠税记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minOwingTaxes" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxOwingTaxes" >
          </label></td>
         <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td>
         </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 民事判断记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minCivilJudgmentRecord" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxCivilJudgmentRecord" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 强制执行记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minEnforcement" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxEnforcement" >
          </label></td>
         <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 行政记录处罚： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minAdministrativerPunishment" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxAdministrativerPunishment" >
          </label></td>
         <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td> 
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 电费欠费记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minElectricityArrears" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxmElectricityArrears" >
          </label></td>
         <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td> 
      </tr>
    </table>
  </div>
  
    <i><div style="height:4px; width:100%;"></div>
    <div id="lightcolor">
    <label id="labelhead">查询记录</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width="70%" height="25">
      <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody">欠税记录： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minSelectOwingTaxes"></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxSelectOwingTaxes"> </label></td>
         <td width="10%" height="25" style="text-align:center"><label id="labelbody"> </label></td> 
      </tr>
    </table>
  </div></i>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">生成模拟数据记录数</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "70%" height="25" >
      <tr>
        <td width="23%"  height="25"  style="text-align:right" ><label id="labelbody" > 共生成： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="generateRecordNum"  onBlur="generateRecordNumchick()" onClick="generateRecordNumclear()">
             <span class="tips" id="divgenerateRecordNum"></span></label></td>
        <td width="52%"  height="25"    ><label id="labelbody" style="text-align:left"> 条</label></td>
      </tr>
    </table><br>
  </div>
<div style="height:25px; width:100%;padding-left:5px;ling-height:25px;">${OperateStatus }</div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button  id="button1style" type="submit" onclick="ClickGenerateData()" >生成数据</button>
    <!--点击此按钮后台获得参数-->
    <button  type="Reset" id="button2style">重设参数</button>
    <button  type="submit" id="button3style" onclick="ClickSaveForTemplate()" >保存模板</button>
    <!-- <button  type="Reset" id="button2style">设置生成字段</button> -->
  </div>
  <div style="height:10px; width:100%;"></div>
</form>

<script src="<c:url value="/js/system1formchick.js"/>"></script>
  </body>
  <script language="javascript" type="text/javascript">
  function ClickGenerateData(){
        document.frm.action="<c:url value="/ccas/index/dataCollect/generateData"/>";
        document.frm.submit();
   }
  function ClickSaveForTemplate(){
      document.frm.action="<c:url value="/ccas/index/dataCollect/saveAsTemplate"/>";
      document.frm.submit();
 }
  </script>
</html>
