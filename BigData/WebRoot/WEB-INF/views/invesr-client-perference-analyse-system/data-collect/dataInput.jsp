<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>数据录入</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/mycss.css"/>">
  </head>
  
   <body>
<div style="height:4px; width:60%;"></div>
<form  method="post" action="<c:url value="/icpas/index/dataCollect/dataInput"/>">
 <div id="lightcolor">
<div style="height:35px; width:60%;text-align: center;"><label id="labelhead"  style="font-size: 25px;" >数据录入</label></div>
  </div>
  <div id="lightcolor">
    <div style="height:4px; width:60%;"></div>
    <table frame="void" width = "60%" height="25" >
      <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"   name="age" ></label></td>
        </tr>
      <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 家庭月收入： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"    name="monthlyIncome" ></label></td>
       </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 预计投入占家庭收入的比重： </label></td>
        <td width="70%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="proportionOfIncome" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 历史投资次数： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="historicalInvestment" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 历史投资额度范围： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="historicalInvestmentScope" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 存款剩余额度范围： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="residualScopeOfDeposit" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 投资产品列表： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="listOfInvestmentProducts" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 客户年龄范围： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="customerAgeRange" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 客户收入范围： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="customerIncomeRange" ></label></td>
        </tr>
        <tr>
        <td width="40%"  height="25"  style="text-align:right" ><label id="labelbody" > 客户行业列表： </label></td>
        <td width="60%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth"  placeholder=""  name="listOfCustomersIndustry" ></label></td>
        </tr>
        <tr>
           <td colspan="2" style="height:5px;"></td>
        </tr>
        <tr>
           <td colspan="2" style="height:25px;text-align:center;">${OperateStatus}</td>
        </tr>
        <tr>
           <td colspan="2"  style="height:25px; text-align:center;">
               <input type="submit" id="button1style" value="保存"/>
               <input type="reset" id="button2style" value="重填"/>
           </td>
        </tr>
    </table>
  </div>
</form>
  </body>
</html>
