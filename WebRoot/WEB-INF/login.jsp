<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
    <h1>管理员登录</h1>
    <form action="${pageContext.request.contextPath }/login.do?type=login" method="post">
    	<table border="1px" cellpadding="2px" cellspacing="2px">
    		<tr>
    			<td>id:</td>
    			<td><input type="text" name="id" /></td>
    		</tr>
    		<tr>
    			<td>pw:</td>
    			<td><input type="password" name="password" /></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="登录" /></td>
    			<td><input type="reset" value="重置" /></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
