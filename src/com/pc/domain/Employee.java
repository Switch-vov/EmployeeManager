package com.pc.domain;

import java.util.Date;

/**
 * 
 * @author Switch
 * @function πÕ‘±¿‡
 * @description
 * 
 */
public class Employee {
	private Integer id;
	private String name;
	private String email;
	private Date hiredate;
	private Float salary;
	private String password;
	private Integer grade;
	// n:1
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public Employee(String name, String email, Date hiredate,
			Float salary, Integer grade, String password) {
		this.name = name;
		this.email = email;
		this.hiredate = hiredate;
		this.salary = salary;
		this.grade = grade;
		this.password = password;
	}

	public Employee() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
}
