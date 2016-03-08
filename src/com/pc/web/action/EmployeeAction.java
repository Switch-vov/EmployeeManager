package com.pc.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.pc.domain.Department;
import com.pc.domain.Employee;
import com.pc.service.interfaces.DepartmentServiceInter;
import com.pc.service.interfaces.EmployeeServiceInter;
import com.pc.utils.MyTools;
import com.pc.web.forms.EmployeeForm;
/**
 * 
 * @author Switch
 * @function ��ԱAction
 * @description �����Ա��ϢCRUD����
 *
 */
public class EmployeeAction extends DispatchAction {
	private DepartmentServiceInter departmentServiceInter;
	private EmployeeServiceInter employeeServiceInter;

	
	public DepartmentServiceInter getDepartmentServiceInter() {
		return departmentServiceInter;
	}

	public void setDepartmentServiceInter(
			DepartmentServiceInter departmentServiceInter) {
		this.departmentServiceInter = departmentServiceInter;
	}

	public EmployeeServiceInter getEmployeeServiceInter() {
		return employeeServiceInter;
	}

	public void setEmployeeServiceInter(EmployeeServiceInter employeeServiceInter) {
		this.employeeServiceInter = employeeServiceInter;
	}

	
	// ȥ��ӹ�ԱUI
	public ActionForward goToAddEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("goToAddEmployeeUI");
		
	}
	
	// ������ӹ�Ա
	public ActionForward addEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// �����Ƿ��ܹ��õ��û��ύ�ı�����
		EmployeeForm employeeForm = (EmployeeForm) form;
		// System.out.println(employeeForm.getDepartmentId() + " " + employeeForm.getEmail());
		
		// ����һ��Employee����
		Employee employee = new Employee();
		employee.setEmail(employeeForm.getEmail());
		employee.setName(employeeForm.getName());
		// �����Ƿ�Ϊ����
		if(MyTools.checkNum(employeeForm.getGrade())) {
			employee.setGrade(Integer.parseInt(employeeForm.getGrade()));
		} else {
			System.out.println("�ȼ��������");
			return mapping.findForward("goToAddEmployeeUI");
		}
		employee.setHiredate(new Date());
		employee.setPassword(employeeForm.getPassword());
		employee.setSalary(Float.parseFloat(employeeForm.getSalary()));
		
		// ��ѯ��Ա�������Ĳ���,����Ա����������
		employee.setDepartment((Department)departmentServiceInter.findById(Department.class ,Integer.parseInt(employeeForm.getDepartmentId())));
		
		// ����Ա��
		try{
			employeeServiceInter.add(employee);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("opererr");
		}
		return mapping.findForward("operok");
	}
	
	// ȥ��ʾ��ԱUI
	public ActionForward goToShowEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ��ȡpageNow
		String s_pageNow = request.getParameter("pageNow");
		int pageNow = 1;
		if(s_pageNow != null) {
			pageNow = Integer.parseInt(s_pageNow);
		}
		
		// ���ù�Ա�б�����
		request.setAttribute("empList", employeeServiceInter.showEmployeeList(pageNow, 3));
		// ����ҳ������
		request.setAttribute("pageCount", employeeServiceInter.getPageCount(3));
		return mapping.findForward("goToShowEmployeeUI");
	}
	
	// ɾ����Ա
	public ActionForward deleteEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ����û�ID
		String id = request.getParameter("id");
		// ɾ���û�
		try{
			employeeServiceInter.deleteById(Employee.class, Integer.parseInt(id));
		} catch (Exception e) {
			return mapping.findForward("opererr");
		}
		return mapping.findForward("operok");
	}
	
	// ȥ�޸Ĺ�ԱUI
	public ActionForward goToUpdateEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ��ȡ�û�ID
		String id = request.getParameter("id");
		
		// ��ȡ��Ա
		Employee employee = (Employee) employeeServiceInter.findById(Employee.class, Integer.parseInt(id));
		
		// ����һ��ҳ����ʾ��Ա��Ϣ���ѹ�Ա����request��
		request.setAttribute("updateEmployee", employee);
		
		return mapping.findForward("goToUpdateEmployeeUI");
	}
	
	// �޸Ĺ�Ա
	public ActionForward updateEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ��ȡ��
		EmployeeForm employeeForm = (EmployeeForm)form;
		
		// ��ȡEmployee����
		Employee employee = (Employee) employeeServiceInter.findById(Employee.class, Integer.parseInt(employeeForm.getId()));
		
		employee.setEmail(employeeForm.getEmail());
		// ����Ƿ�Ϊ����
		if(MyTools.checkNum(employeeForm.getId())){
			employee.setGrade(Integer.parseInt(employeeForm.getGrade()));
		} else {
			System.out.println("�ȼ��������");
			return mapping.findForward("goToUpdateEmployeeUI");
		}
		employee.setName(employeeForm.getName());
		employee.setPassword(employeeForm.getPassword());
		employee.setSalary(Float.parseFloat(employeeForm.getSalary()));
		employee.setDepartment((Department)departmentServiceInter.findById(Department.class, Integer.parseInt(employeeForm.getDepartmentId())));

		try{
			employeeServiceInter.update(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("opererr");
		}
		return mapping.findForward("operok");
	}
}
