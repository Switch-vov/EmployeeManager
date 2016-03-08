package com.pc.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pc.domain.Employee;
import com.pc.service.interfaces.EmployeeServiceInter;
import com.pc.web.forms.EmployeeForm;

/**
 * 
 * @author Switch
 * @function 登录Action
 * @description 管理用户登录登出类操作
 * 
 */
public class LoginAction extends DispatchAction {
	EmployeeServiceInter employeeServiceInter;
	
	public void setEmployeeServiceInter(EmployeeServiceInter employeeServiceInter) {
		this.employeeServiceInter = employeeServiceInter;
	}

	// 登录
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 取出表单
		EmployeeForm employeeForm = (EmployeeForm) form;
		
		// 通过该语句，可以直接获取Spring容器，即applicationContext
		// WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());

		// 从Spring容器中获取bean
		// EmployeeServiceInter employeeServiceInter = (EmployeeServiceInter) webApplicationContext.getBean("employeeService");
		
		
		// 构建一个Employee对象
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(employeeForm.getId()));
		employee.setPassword(employeeForm.getPassword());
		
		// 测试表单数据是否填入表单对象
		// System.out.println(employeeForm.getId() + " " + employeeForm.getPassword());
		if((employee = employeeServiceInter.checkEmployee(employee)) != null) {
			// 把雇员信息放入session
			request.getSession().setAttribute("loginuser", employee);
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("error");
		}
	}

	// 返回主菜单
	public ActionForward goMainFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(request.getSession().getAttribute("loginuser") != null) {
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("error");
		}
	}
	
	
	// 退出
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return super.execute(mapping, form, request, response);
	}
}
