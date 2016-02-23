<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header"> <a href="<c:url value="/ccas/index"/>"> <img src="<c:url value='/images/ccas/logouser.png'/>" width="620" height="75" alt="logo" > </a>
    <hr color="#6F7DA0"/>
    <div id="navhead">
      <div class="nav">
      <ul>
        <li><a href=<c:url value="/ccas/index/dataCollect" />>数据采集</a></li> 
          <!--链接到了数据采集主框架-->
        <li><a href=<c:url value="/ccas/index/clientPortray" />>客户画象</a></li>
        <li><a href=<c:url value="/ccas/index/BIShow" />>BI展示</a></li>
      </ul>
      </div>
    </div>
    <hr color="#848FAD"/>
  </div>