<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <a href="<c:url value="/icpas/index"/>">
    <img src="<c:url value='/images/icpas/InvesrClientPerferenceAnalyseSystemLogo.png'/>" width="620" height="75" alt="logo" > <hr color="#6F7DA0"/>
   </a>
   <div id="navhead">
   
   
    <div class="nav">
      <ul>
        <li><a href="<c:url value="/icpas/index/dataCollect" />">数据采集</a></li>   <!--链接到了数据采集主框架-->
        <li><a href="<c:url value="/icpas/index/evaluateRiskPreference" />">评估风险偏好</a></li>
        <li><a href="<c:url value="/icpas/index/BIShow" />">BI展示</a></li>
      </ul>
    
      

    </div> 
   
   
   
   </div>
   
    
    <hr color="#848FAD"/>
    
     </div>