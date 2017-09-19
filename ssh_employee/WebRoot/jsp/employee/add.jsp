<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form id="saveForm" action="employee_save" method="post" namespace="/" theme="simple">
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名：<s:textfield name="ename"/></td>
<td>性别：<s:radio name="sex" list="{'男','女'}"/></td>
</tr>

<tr>

<td>用户名：<s:textfield name="username"/></td>
<td>密码：<s:password name="password"/></td>
</tr>

<tr>

<td>出生日期：<input name="birthday" type="date" value=""/></td>
<td>入职时间：<input name="joinDate" type="date" value=""/></td>
</tr>

<tr>
<td>所属部门：<s:select list="list" name="department.did" listKey="did" listValue="dname" headerKey="" headerValue="-请--选--择-"/></td>
<td>编号：<s:textfield name="eno"/></td>
</tr>
</table>
</s:form>

</body>
</html>