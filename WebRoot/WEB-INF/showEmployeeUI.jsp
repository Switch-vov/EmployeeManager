<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>用户列表</title>
<script type="text/javascript" language="javascript" src="/MySSH/js/jquery-1.3.1.js"></script>
<script type="text/javascript" language="javascript" src="/MySSH/js/my.js"></script>
</head>

<body>
	<h1>用户列表</h1>
	<table border="1px" cellpadding="2px" cellspacing="0px" style="border-collapse: collapse;">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>email</td>
			<td>grade</td>
			<td>salary</td>
			<td>hiredate</td>
			<td>department</td>
			<td>修改用户</td>
			<td>删除用户</td>
		</tr>
		<c:forEach var="emp" items="${empList }">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.email }</td>
				<td>${emp.grade }</td>
				<td>${emp.salary }</td>
				<td>${emp.hiredate }</td>
				<td>${emp.department.name }</td>
				<td><a href="${pageContext.servletContext.contextPath }/employee.do?type=goToUpdateEmployeeUI&id=${emp.id }">修改用户</a></td>
				<td><a href="${pageContext.servletContext.contextPath }/employee.do?type=deleteEmployee&id=${emp.id }">删除用户</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${pageCount }">
		<a href="${pageContext.servletContext.contextPath }/employee.do?type=goToShowEmployeeUI&pageNow=${i }">[${i }]</a>
	</c:forEach>
</body>
</html>
