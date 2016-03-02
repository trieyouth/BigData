<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
<title>生成模拟数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
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

  </head>
  
  <body>
<div style="height:4px; width:100%;"></div>
<form  method="get"  name="simulationDataService" action="EvaluateClientRiskPreferenceDataCollectServlet">
  
  <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minAge" >
          </label></td>
        <!--那么属性为参数名-->
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxAge" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >岁 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 投资占总资产比： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minInvestAssetRate" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxInvestAssetRate" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 投资资金稳定时间段： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minInvestStabilizePeriod" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxInvestStabilizePeriod" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >年 </label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">投资类型偏好参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 股票、基金： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minStockFundNum" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxStockFundNum" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 房地产： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minEstateNum" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxEstateNum" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 保险： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="minInsuranceNum" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="maxInsuranceNum" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >百分之 </label></td>
      </tr>
    </table>
  </div>
 
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">生成模拟数据记录数</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 共生成： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="generateNums" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 条 </label></td>
        <td width="25%"  height="25"  ></label></td>
        <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
    </table>
  </div>
  <div style="height:10px; width:100%;"></div>
  <!--选择按钮功能-->
   
  <div id="buttoncon">
    <button name="btnGenerate" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">生成模拟数据</button>
    <!--点击此按钮后台获得参数-->
    <button  type="reset" style="width:150px ;height:25px;background:#A74544;border:0;color:#FFF;font-family: Microsoft YaHei;">重新设置参数</button>
    <button name="btnSave"  type="submit" style="width:150px ;height:25px;background:#4F8553;border:0;color:#FFF;font-family: Microsoft YaHei;">保存为模板</button>
  </div>
</form>
  </body>
</html>
