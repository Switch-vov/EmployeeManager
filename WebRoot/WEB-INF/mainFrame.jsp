<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'mainFrame.jsp' starting page</title>
  </head>
  
  <body>
    <h2>欢迎${loginuser.name}，你所在的部门名称 ${loginuser.department.name }，请选择您要的操作</h2>
    <a href="${pageContext.request.contextPath }/employee.do?type=goToAddEmployeeUI">添加雇员</a><br />
    <a href="${pageContext.request.contextPath }/employee.do?type=goToShowEmployeeUI">显示雇员</a><br />
    <a href="#">查询雇员</a><br />
    <a href="#">退出系统</a><br />
  </body>
</html>
