package com.pc.domain;

import java.util.Set;

/**
 * 
 * @author Switch
 * @function ≤ø√≈¿‡
 * @description
 *
 */
public class Department{
	private Integer id;
	private String name;
	// 1:n
	private Set<Employee> emps;
	
	public Department(String name, Set<Employee> emps) {
		this.name = name;
		this.emps = emps;
	}
	public Department() {
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
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	
}