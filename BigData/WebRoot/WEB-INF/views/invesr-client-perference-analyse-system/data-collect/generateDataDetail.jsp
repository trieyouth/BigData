<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>生成数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/mycss.css"/>'>
  </head>
  
   <body>
   <div style="height:4px; width:100%;"> </div>
 <form name="frm" method="post" action="/icpas/index/dataCollect/generateDataAgain">
   <div style="height:35px; width:70%; text-align: center;"><label id="labelbody" style="font-size: 25px;">基本信息参数设置</label></div>
  <div id="lightcolor">
    <table frame="void" width="70%" height="25">
      <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 年龄： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minAge" value=${rptc.minAge}  ></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxAge" value=${rptc.maxAge}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody1">*</label></td>
      </tr>
      <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 家庭月收入： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minMonthlyIncome"  value=${rptc.minMonthlyIncome}>  </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth"  name="maxMonthlyIncome"  value=${rptc.maxMonthlyIncome}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody1">*</label></td>
      </tr>
      <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 预计投入占家庭收入的比重： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minProportionOfIncome"  value=${rptc.minProportionOfIncome}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxProportionOfIncome"  value=${rptc.maxProportionOfIncome}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody1">*</label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 历史投资次数： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minHistoricalInvestment"  value=${rptc.minHistoricalInvestment}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxHistoricalInvestment"  value=${rptc.maxHistoricalInvestment}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody1">*</label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 历史投资额度范围： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minHistoricalInvestmentScope"  value=${rptc.minHistoricalInvestmentScope}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxHistoricalInvestmentScope"  value=${rptc.maxHistoricalInvestmentScope}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody1">*</label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 存款剩余额度范围： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minResidualScopeOfDeposit"  value=${rptc.minResidualScopeOfDeposit}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxResidualScopeOfDeposit"  value=${rptc.maxResidualScopeOfDeposit}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody1">*</label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 投资产品列表： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minListOfInvestmentProducts" value=${rptc.minListOfInvestmentProducts}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxListOfInvestmentProducts" value=${rptc.maxListOfInvestmentProducts}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"></label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 客户年龄范围： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minCustomerAgeRange" value=${rptc.minCustomerAgeRange}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxCustomerAgeRange" value=${rptc.maxCustomerAgeRange}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"></label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 客户收入范围： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minCustomerIncomeRange" value=${rptc.minCustomerIncomeRange}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxCustomerIncomeRange" value=${rptc.maxCustomerIncomeRange}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> </label></td>
      </tr>
       <tr>
        <td width="30%" height="25" style="text-align:right"><label id="labelbody"> 客户行业列表： </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="minListOfCustomersIndustry" value=${rptc.minListOfCustomersIndustry}></label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> 至 </label></td>
        <td width="25%" height="25"><label id="labelbody">
            <input type="text" id="inputwidth" name="maxListOfCustomersIndustry" value=${rptc.maxListOfCustomersIndustry}> </label></td>
        <td width="10%" height="25" style="text-align:center"><label id="labelbody"> </label></td>
      </tr>
      <tr>
      <td colspan="5" style="height:5px"></td>
      </tr>
      <tr>
      <td colspan="5" style="height:20px"> <label id="labelhead">生成模拟数据记录数</label></td>
      </tr>
      <tr>
        <td style="width:60%;height:25px;text-align:center;" colspan="5"><label id="labelbody"><label id="labelbody"> 共生成： </label>
            <input type="text" id="inputwidth" name="gerenalRecord" value=${rptc.gerenalRecord}></label></td>
        </tr>
      <tr>
      <td colspan="5" style="height:5px"></td>
      </tr>
       <tr>
      <td colspan="5" style="height:30px">${OperateStatus}</td>
      </tr>
      <tr>
      <td colspan="5" style="height:30px">
      <button id="button1style" type="submit" onclick="ClickGenerateData()">生成数据</button>
    <!--点击此按钮后台获得参数-->
    <button type="submit" id="button2style"  onclick="ClickBack()">返回</button>
      </td>
      </tr>
    </table>
  </div>
</form>
<script src='<c:url value="/js/system1formchick.js"/>'></script>
  </body>
  <script language="javascript" type="text/javascript">
  function ClickGenerateData(){
        document.frm.action="<c:url value="/icpas/index/dataCollect/generateDataDetail"/>";
        document.frm.submit();
   }
   function ClickBack(){
        document.frm.action="<c:url value="/icpas/index/dataCollect/collectingRecord"/>";
        document.frm.submit();
   }
  </script>
</html>
