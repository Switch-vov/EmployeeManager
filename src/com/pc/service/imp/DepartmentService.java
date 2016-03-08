package com.pc.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

import com.pc.basic.BasicService;
import com.pc.domain.Department;
import com.pc.domain.Employee;
import com.pc.service.interfaces.DepartmentServiceInter;
import com.pc.service.interfaces.EmployeeServiceInter;

/**
 * 
 * @author Switch
 * @function 部门服务类
 * @description 实现部门服务接口
 * 
 */


public class DepartmentService extends BasicService implements DepartmentServiceInter {
	// 当给某个属性增加了@Resource后，spring会启用byName的方式注入属性值
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
