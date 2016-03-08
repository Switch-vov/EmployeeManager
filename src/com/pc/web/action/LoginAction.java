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
 * @function ��¼Action
 * @description �����û���¼�ǳ������
 * 
 */
public class LoginAction extends DispatchAction {
	EmployeeServiceInter employeeServiceInter;
	
	public void setEmployeeServiceInter(EmployeeServiceInter employeeServiceInter) {
		this.employeeServiceInter = employeeServiceInter;
	}

	// ��¼
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ȡ����
		EmployeeForm employeeForm = (EmployeeForm) form;
		
		// ͨ������䣬����ֱ�ӻ�ȡSpring��������applicationContext
		// WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());

		// ��Spring�����л�ȡbean
		// EmployeeServiceInter employeeServiceInter = (EmployeeServiceInter) webApplicationContext.getBean("employeeService");
		
		
		// ����һ��Employee����
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(employeeForm.getId()));
		employee.setPassword(employeeForm.getPassword());
		
		// ���Ա������Ƿ����������
		// System.out.println(employeeForm.getId() + " " + employeeForm.getPassword());
		if((employee = employeeServiceInter.checkEmployee(employee)) != null) {
			// �ѹ�Ա��Ϣ����session
			request.getSession().setAttribute("loginuser", employee);
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("error");
		}
	}

	// �������˵�
	public ActionForward goMainFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(request.getSession().getAttribute("loginuser") != null) {
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("error");
		}
	}
	
	
	// �˳�
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return super.execute(mapping, form, request, response);
	}
}
