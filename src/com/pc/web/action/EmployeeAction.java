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
 * @function 雇员Action
 * @description 管理雇员信息CRUD操作
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

	
	// 去添加雇员UI
	public ActionForward goToAddEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("goToAddEmployeeUI");
		
	}
	
	// 处理添加雇员
	public ActionForward addEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 测试是否能够得到用户提交的表单数据
		EmployeeForm employeeForm = (EmployeeForm) form;
		// System.out.println(employeeForm.getDepartmentId() + " " + employeeForm.getEmail());
		
		// 创建一个Employee对象
		Employee employee = new Employee();
		employee.setEmail(employeeForm.getEmail());
		employee.setName(employeeForm.getName());
		// 检验是否为整数
		if(MyTools.checkNum(employeeForm.getGrade())) {
			employee.setGrade(Integer.parseInt(employeeForm.getGrade()));
		} else {
			System.out.println("等级输入错误");
			return mapping.findForward("goToAddEmployeeUI");
		}
		employee.setHiredate(new Date());
		employee.setPassword(employeeForm.getPassword());
		employee.setSalary(Float.parseFloat(employeeForm.getSalary()));
		
		// 查询该员工所属的部门,设置员工所属部门
		employee.setDepartment((Department)departmentServiceInter.findById(Department.class ,Integer.parseInt(employeeForm.getDepartmentId())));
		
		// 保存员工
		try{
			employeeServiceInter.add(employee);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("opererr");
		}
		return mapping.findForward("operok");
	}
	
	// 去显示雇员UI
	public ActionForward goToShowEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取pageNow
		String s_pageNow = request.getParameter("pageNow");
		int pageNow = 1;
		if(s_pageNow != null) {
			pageNow = Integer.parseInt(s_pageNow);
		}
		
		// 设置雇员列表属性
		request.setAttribute("empList", employeeServiceInter.showEmployeeList(pageNow, 3));
		// 设置页数属性
		request.setAttribute("pageCount", employeeServiceInter.getPageCount(3));
		return mapping.findForward("goToShowEmployeeUI");
	}
	
	// 删除雇员
	public ActionForward deleteEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获得用户ID
		String id = request.getParameter("id");
		// 删除用户
		try{
			employeeServiceInter.deleteById(Employee.class, Integer.parseInt(id));
		} catch (Exception e) {
			return mapping.findForward("opererr");
		}
		return mapping.findForward("operok");
	}
	
	// 去修改雇员UI
	public ActionForward goToUpdateEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取用户ID
		String id = request.getParameter("id");
		
		// 获取雇员
		Employee employee = (Employee) employeeServiceInter.findById(Employee.class, Integer.parseInt(id));
		
		// 在下一个页面显示雇员信息，把雇员放入request中
		request.setAttribute("updateEmployee", employee);
		
		return mapping.findForward("goToUpdateEmployeeUI");
	}
	
	// 修改雇员
	public ActionForward updateEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取表单
		EmployeeForm employeeForm = (EmployeeForm)form;
		
		// 获取Employee对象
		Employee employee = (Employee) employeeServiceInter.findById(Employee.class, Integer.parseInt(employeeForm.getId()));
		
		employee.setEmail(employeeForm.getEmail());
		// 检查是否为整数
		if(MyTools.checkNum(employeeForm.getId())){
			employee.setGrade(Integer.parseInt(employeeForm.getGrade()));
		} else {
			System.out.println("等级输入错误");
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
