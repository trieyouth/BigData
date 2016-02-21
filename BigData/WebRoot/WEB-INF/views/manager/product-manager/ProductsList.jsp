<%@page import="com.zero.entity.Finaproduct"%>
<%@page import="java.text.*"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="utf-8">
<title>理财产品列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="<c:url value="/css/mycss.css" />" rel="stylesheet">
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
	<div style="height: 4px; width: 100%;"></div>


	<div id="lightcolor">

		<table frame="void" width="90%" height="30">
			<tr>
				<td width="20%" height="30"><label id="labelhead">&nbsp产品编号
				</label></td>
				<!--模板编号-->
				<td width="20%" height="30"><label id="labelhead">&nbsp产品名
				</label></td>
				<td width="20%" height="30"><label id="labelhead">&nbsp上市时间
				</label></td>
				<td width="20%" height="30"><label id="labelhead">&nbsp详细信息
				</label></td>
				<td width="20%" height="30"><label id="labelhead">&nbsp操作
				</label></td>
			</tr>
		</table>
	</div>
	<div style="height: 1px; width: 100%;"></div>
	<div id="lightcolor">

		<table frame="void" width="90%" height="22px">
		
		<c:forEach var="product" items="${products}">
			<tr>
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<c:out value="${product.prodCode}"/></label></td>
				<!--产品编号-->
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<c:out value="${product.prodName}"/></label></td>
				<td width="20%" height="22px"><label id="labelbody">&nbsp<c:out value="${product.issueDate}"/></label></td>

				<!-- 作为参数传到第二个页面 -->
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<a
						href="<c:url value="/manager/product/detail/" /><c:out value='${product.prodId}'/>">查看详情</a>
				</label></td>
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<a href="<c:url value="/manager/product/delete/" /><c:out value='${product.prodId}'/>">删除</a>
				</label> <a
					href="<c:url value="/manager/product/update/没写" />">更改</a>
					</label></td>
			</tr>
		
		</c:forEach>


			<%-- <!--jsp循环此处的tr,在</td>前填数据-->
			<%
				ProductService products = new ProductService(); //新建一个产品服务对象
				List<FinaProduct> pro = products.findAllProduct(); //获得所有的产品
				for (int i = 0; i < pro.size(); i++) //依次输出每个产品信息
				{
					String riqi = new SimpleDateFormat("yyyy-MM-dd").format(pro.get(i).getIssueDate());
					String srcpath = "DeleteProduct?proid=" + pro.get(i).getProdId() + "&DId=2";
			%>

			<tr>
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<%=pro.get(i).getProdCode()%></label></td>
				<!--产品编号-->
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<%=pro.get(i).getProdName()%></label></td>
				<td width="20%" height="22px"><label id="labelbody">&nbsp<%=riqi%></label></td>

				<!-- 作为参数传到第二个页面 -->
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<a
						href="WebView\SystemManage\ProductManage\ProductsMessageDetial.jsp?proid=<%=pro.get(i).getProdId()%>">查看详情</a>
				</label></td>
				<td width="20%" height="22px"><label id="labelbody">&nbsp
						<a href=<%=srcpath%>>删除</a>
				</label> <a
					href="WebView/SystemManage/ProductManage/AlterProductsMessage.html">更改</a>
					</label></td>
			</tr>
 --%>





<%-- 
			<%
				}
			%> --%>






		</table>
	</div>


	<div style="height: 8px; width: 100%;"></div>
	<div id="buttoncon">
		<a href="<c:url value='manager/product/add'/>">
			<button name="btnGenerate"
				style="width: 150px; height: 25px; background: #2976BE; border: 0; color: #FFF; font-family: Microsoft YaHei;">增加产品</button>
			<!--根据条件查询出客户组,下一个页面为ClientRiskQueryResult-->
		</a>
	</div>

</body>
</html>
