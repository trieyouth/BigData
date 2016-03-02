<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
<title>创建模板</title>
    
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
<form  method=POST>
  
  <!--基本参数设置区域-->
  
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">基本信息参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 年龄： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="nl1" >
          </label></td>
        <!--那么属性为参数名-->
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="nl2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >岁 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 月收入： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="ysr1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="ysr2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >元 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 工作年限： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="gznx1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="gznx2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >年 </label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">信贷记录参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 信用卡账户数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="xykzhs1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="xykzhs2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >个 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 银行贷款笔数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="yhdkbs1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="yhdkbs2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >笔 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 银行消费类贷款笔数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="yhxfldkbs1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="yhxfldkbs2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >笔 </label></td>
      </tr>
    </table>
  </div>
  
  <!--开始下一个参数组-->
  <div style="height:4px; width:100%;"></div>
  <div id="lightcolor">
    <div style="height:4px; width:100%;"></div>
    <label  id="labelhead">贷款参数设置</label>
    <div style="height:4px; width:100%;"></div>
    <table frame="void" width = "47%" height="25" >
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 贷款总额度： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="dkzed1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="dkzed2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >元 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 申请贷款次数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="sqdkcs1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="sqdkcs2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >次 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 原贷款逾期次数： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="ydkyqcs1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="ydkyqcs2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >次 </label></td>
      </tr>
      <tr>
        <td width="30%"  height="25"  style="text-align:right" ><label id="labelbody" > 征信查询记录： </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="zxcxjl1" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 至 </label></td>
        <td width="25%"  height="25"  ><label id="labelbody" >
            <input  type="text" id="inputwidth" name="zxcxjl2" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" >条 </label></td>
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
            <input  type="text" id="inputwidth" name="gsc" >
          </label></td>
        <td width="10%"  height="25"  style="text-align:center"  ><label id="labelbody" > 条 </label></td>
        <td width="25%"  height="25"  ></label></td>
        <td width="10%"  height="25"  style="text-align:center"  ></td>
      </tr>
    </table><br>
    <%
       if(request.getAttribute("GenerateOrSave")!=null)
       {
          out.println("状态："+ request.getAttribute("GenerateOrSave"));
       }
     %>
  </div>
  <div style="height:10px; width:100%;"></div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button name="btnGenerateSimulateData" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">生成模拟数据</button>
    <!--点击此按钮后台获得参数-->
    <button  type="Reset" style="width:150px ;height:25px;background:#A74544;border:0;color:#FFF;font-family: Microsoft YaHei;">重新设置参数</button>
    <button name="btnSaveSimulate"  type="submit" style="width:150px ;height:25px;background:#4F8553;border:0;color:#FFF;font-family: Microsoft YaHei;">保存为模板</button>
    <button  type="Reset" style="width:150px ;height:25px;background:#A74544;border:0;color:#FFF;font-family: Microsoft YaHei;">设置生成字段</button>
  </div>
</form>
  </body>
</html>
