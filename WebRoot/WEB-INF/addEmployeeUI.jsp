<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>My JSP 'addEmployeeUI.jsp' starting page</title>
</head>

<body>
	<h1>添加雇员</h1>
	<form action="${pageContext.request.contextPath }/employee.do?type=addEmployee" method="post">
		<table border="1" cellpadding="2px" cellspacing="0px">
			<tr>
				<td>name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>grade</td>
				<td><input type="text" name="grade" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>department</td>
				<td>
					<select name="departmentId">
						<option value="5">开发部 </option>
						<option value="6">营销部</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="添加" /></td>
				<td><input type="reset" value="重新填写" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
