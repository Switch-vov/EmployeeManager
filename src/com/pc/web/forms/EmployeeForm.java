package com.pc.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;
/**
 * 
 * @author Switch
 * @function πÕ‘±±Ìµ•
 * @description
 *
 */
public class EmployeeForm extends ActionForm {
	private String id;
	private String name;
	private String email;
	private String salary;
	private String password;
	private String grade;
	private String departmentId;
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
