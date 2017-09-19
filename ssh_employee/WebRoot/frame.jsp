<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工管理系统</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<frameset rows="80,*">
   <frame name="top" src="${basePath} frame/top.jsp">
   <frameset cols="150,*" id="main">

      <frame src="${basePath} frame/left.jsp"> 
     <frame name="right" src="${basePath} frame/right.jsp">
   </frameset>
</frameset>
</html>
