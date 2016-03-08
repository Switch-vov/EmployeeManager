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
 * @function ���ŷ�����
 * @description ʵ�ֲ��ŷ���ӿ�
 * 
 */


public class DepartmentService extends BasicService implements DepartmentServiceInter {
	// ����ĳ������������@Resource��spring������byName�ķ�ʽע������ֵ
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
