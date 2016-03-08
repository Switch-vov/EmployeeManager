<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>My JSP 'updateEmployeeUI.jsp' starting page</title>
</head>

<body>
	<h1>修改员工</h1>
	<form action="${pageContext.servletContext.contextPath }/employee.do?type=updateEmployee" method="post">
		<table border="1" cellpadding="2px" cellspacing="0px">
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="${updateEmployee.id }" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${updateEmployee.name }" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" value="${updateEmployee.email }" /></td>
			</tr>
			<tr>
				<td>grade</td>
				<td><input type="text" name="grade" value="${updateEmployee.grade }" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="${updateEmployee.password }" /></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><input type="text" name="salary" value="${updateEmployee.salary }" /></td>
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
				<td><input type="submit" value="修改" /></td>
				<td><input type="reset" value="重新填写" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
