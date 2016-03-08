package com.pc.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.pc.basic.BasicServiceInter;
import com.pc.domain.Employee;

/**
 * 
 * @author Switch
 * @function 雇员服务接口
 * @description
 *
 */
public interface EmployeeServiceInter extends BasicServiceInter{
	/**
	 * 验证,该雇员存在，则返回该雇员的完整信息，否则返回空
	 * @param employee 表单填入的只带雇员账号密码的雇员对象
	 * @return 带基本信息的员工对象
	 */
	public Employee checkEmployee(Employee employee);
	
	/**
	 * 显示雇员列表，考虑分页
	 * @return 雇员列表
	 */
	public List<Employee> showEmployeeList(int pageNow, int pageSize);
	
	/**
	 * 通过页长获取页数
	 * @param pageSize 页长
	 * @return 页数
	 */
	public int getPageCount(int pageSize);
	
}
