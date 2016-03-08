package com.pc.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pc.domain.Department;
import com.pc.domain.Employee;
import com.pc.service.interfaces.DepartmentServiceInter;
import com.pc.service.interfaces.EmployeeServiceInter;
/**
 * 
 * @author Switch
 * @function ���Կ���Ƿ���ȷ
 * @description
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����Spring����Ƿ���������
		// ��ȡapplicationContext
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��ȡtestService
		// TestService testService = (TestService) applicationContext.getBean("testService");
		// System.out.println(testService.getName());
		
		// ����Spring����Hibernate�Ƿ���������
		// ��ȡSessionFactory
		// SessionFactory sessionFactory = (SessionFactory)
		// applicationContext.getBean("sessionFactory");
		// Session session = sessionFactory.openSession();
		// Employee employee = new Employee("����", "zhangsan@switch.com", new Date(), 10000F, 1, "123456");
		// ������
		// Transaction transaction = session.beginTransaction();
		// session.save(employee);
		// transaction.commit();
		
		// ����EmployeeService�ӿ�
		EmployeeServiceInter employeeServiceInter = (EmployeeServiceInter) applicationContext.getBean("employeeService");
		
		// ������Ա����
		Employee employee1 = new Employee("����", "zhangsan@switch.com", new Date(), 10000F, 1, "123456");
		Employee employee2 = new Employee("����", "lisi@switch.com", new Date(), 20000F, 1, "123456");
		Employee employee3 = new Employee("����", "wangwu@switch.com", new Date(), 30000F, 1, "123456");
		Employee employee4 = new Employee("Switch", "q547550831@outlook.com", new Date(), 40000F, 3, "123456");
		
		// ��ӹ�Ա
		employeeServiceInter.add(employee1);
		employeeServiceInter.add(employee2);
		employeeServiceInter.add(employee3);
		employeeServiceInter.add(employee4);
		
		// ������Աset����
		Set<Employee> emps1 = new HashSet<Employee>();
		Set<Employee> emps2 = new HashSet<Employee>();
		
		// ��ӽ�set����
		emps1.add(employee1);
		emps1.add(employee2);
		emps2.add(employee3);
		emps2.add(employee4);
		
		// ��������
		Department department1 = new Department("������", emps1);
		Department department2 = new Department("Ӫ����", emps2);
		
		// ��Ӳ���
		DepartmentServiceInter departmentServiceInter = (DepartmentServiceInter) applicationContext.getBean("departmentService");
		departmentServiceInter.add(department1);
		departmentServiceInter.add(department2);
		
	}

}
