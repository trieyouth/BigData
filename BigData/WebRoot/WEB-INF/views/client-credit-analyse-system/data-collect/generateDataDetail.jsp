<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.zero.entity.Creditanalysistemplatecontext" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
<form name="frm" method="get" action="<c:url value="/ccas/index/dataCollect/generateData"/>">
  
  <!--基本参数设置区域-->
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"> </div>
    <table frame="void" width = "70%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody">
            <input  type="text" id="inputwidth"  name="minAge" value=${catc.minAge}></label></td>
        <!--那么属性为参数名-->
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxAge" value=${catc.maxAge}></label></td>
        <td width="10%"  height="25" ><label id="labelbody1" >* </label></td>
      </tr>
      
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 月收入： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minMonthlyIncome" value=${catc.minMonthlyIncome} > </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxMounthlyIncome" value=${catc.maxMounthlyIncome}></label></td>
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
            <input  type="text" id="inputwidth" name="minCreditNum" value=${catc.minCreditNum}></label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxCreditNum" value=${catc.maxCreditNum}></label></td>
        <td width="10%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 住房贷款账户数：</label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minHouseLoan" value=${catc.minHouseLoan}>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxHouseLoan" value=${catc.maxHouseLoan}> </label></td>
        <td width="10%"  height="25"  ><label id="labelbody1" >* </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" >其它贷款账户数：</label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minLoansNum" value=${catc.minLoansNum}> </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxLoansNum"  value=${catc.maxLoansNum}></label></td>
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
            <input  type="text" id="inputwidth" name="minOwingTaxes" value=${catc.minOwingTaxes}></label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxOwingTaxes"  value=${catc.maxOwingTaxes}></label></td>
         <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td>
         </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 民事判断记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minCivilJudgmentRecord" value=${catc.minCivilJudgmentRecord}>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxCivilJudgmentRecord" value=${catc.maxCivilJudgmentRecord}>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 强制执行记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minEnforcement" value=${catc.minEnforcement}>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxEnforcement"  value=${catc.maxEnforcement}>
          </label></td>
         <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 行政记录处罚： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minAdministrativerPunishment" value=${catc.minAdministrativerPunishment}>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxAdministrativerPunishment" value=${catc.maxAdministrativerPunishment}>
          </label></td>
         <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > </label></td> 
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 电费欠费记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minElectricityArrears" value=${catc.minElectricityArrears}>
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxmElectricityArrears"  value=${catc.maxmElectricityArrears}>
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
            <input type="text" id="inputwidth" name="minSelectOwingTaxes" value=${catc.minSelectOwingTaxes}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxSelectOwingTaxes"  value=${catc.maxSelectOwingTaxes}> </label></td>
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
            <input  type="text" id="inputwidth" name="generateRecordNum" value=${catc.generateRecordNum}></label></td>
        <td width="52%"  height="25"    ><label id="labelbody" style="text-align:left"> 条</label></td>
      </tr>
    </table><br>
  </div>
  
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button  id="button1style" type="submit" onclick="ClickGenerateData()" >生成模拟数据</button>
    <!--点击此按钮后台获得参数-->
    <button  type="submit" id="button2style" onclick="ClickBackToList()">返 回</button>
    <!-- <button  type="Reset" id="button2style">设置生成字段</button> -->
  </div>
  <div style="height:10px; width:100%;"></div>
</form>


  </body>
  <script language="javascript" type="text/javascript">
  function ClickGenerateData(){
        document.frm.action="<c:url value="/ccas/index/dataCollect/generateDataAgain"/>";
        document.frm.submit();
   }
  function ClickBackToList(){
      document.frm.action="<c:url value="/ccas/index/dataCollect/collectingRecord"/>";
      document.frm.submit();
 }
  </script>
</html>
