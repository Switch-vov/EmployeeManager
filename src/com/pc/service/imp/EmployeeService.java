package com.pc.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

import com.pc.basic.BasicService;
import com.pc.domain.Department;
import com.pc.domain.Employee;
import com.pc.service.interfaces.EmployeeServiceInter;

/**
 * 
 * @author Switch
 * @function 雇员服务类
 * @description 实现雇员服务接口
 * 
 */

// 配置注解@Transactional用处是让spring的事务管理器接管该Service的事务
public class EmployeeService extends BasicService implements EmployeeServiceInter {
	@Override
	public Employee checkEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where id=? and password=?";
		Object[] parameters = {employee.getId(), employee.getPassword()};
		List list = this.executeQuery(hql, parameters);
		if(list.size() == 0) {
			return null;
		} else {
			return (Employee) list.get(0);
		}
	}

	@Override
	public List<Employee> showEmployeeList(int pageNow, int pageSize) {
		String hql = "from Employee order by id";
		return this.executeQueryByPage(hql, null, pageNow, pageSize);
	}

	@Override
	public int getPageCount(int pageSize) {
		String hql = "select count(*) from Employee";
		return this.queryPageCount(hql, null, pageSize);
	}
	
	
	
}
