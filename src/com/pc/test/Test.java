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
 * @function 测试框架是否正确
 * @description
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 测试Spring框架是否正常工作
		// 获取applicationContext
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取testService
		// TestService testService = (TestService) applicationContext.getBean("testService");
		// System.out.println(testService.getName());
		
		// 测试Spring配置Hibernate是否正常工作
		// 获取SessionFactory
		// SessionFactory sessionFactory = (SessionFactory)
		// applicationContext.getBean("sessionFactory");
		// Session session = sessionFactory.openSession();
		// Employee employee = new Employee("张三", "zhangsan@switch.com", new Date(), 10000F, 1, "123456");
		// 事务处理
		// Transaction transaction = session.beginTransaction();
		// session.save(employee);
		// transaction.commit();
		
		// 测试EmployeeService接口
		EmployeeServiceInter employeeServiceInter = (EmployeeServiceInter) applicationContext.getBean("employeeService");
		
		// 创建雇员对象
		Employee employee1 = new Employee("张三", "zhangsan@switch.com", new Date(), 10000F, 1, "123456");
		Employee employee2 = new Employee("李四", "lisi@switch.com", new Date(), 20000F, 1, "123456");
		Employee employee3 = new Employee("王五", "wangwu@switch.com", new Date(), 30000F, 1, "123456");
		Employee employee4 = new Employee("Switch", "q547550831@outlook.com", new Date(), 40000F, 3, "123456");
		
		// 添加雇员
		employeeServiceInter.add(employee1);
		employeeServiceInter.add(employee2);
		employeeServiceInter.add(employee3);
		employeeServiceInter.add(employee4);
		
		// 创建雇员set集合
		Set<Employee> emps1 = new HashSet<Employee>();
		Set<Employee> emps2 = new HashSet<Employee>();
		
		// 添加进set集合
		emps1.add(employee1);
		emps1.add(employee2);
		emps2.add(employee3);
		emps2.add(employee4);
		
		// 创建部门
		Department department1 = new Department("开发部", emps1);
		Department department2 = new Department("营销部", emps2);
		
		// 添加部门
		DepartmentServiceInter departmentServiceInter = (DepartmentServiceInter) applicationContext.getBean("departmentService");
		departmentServiceInter.add(department1);
		departmentServiceInter.add(department2);
		
	}

}
