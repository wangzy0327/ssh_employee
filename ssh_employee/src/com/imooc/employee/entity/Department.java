package com.imooc.employee.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体
 * @author Wzy
 *
 */
public class Department {
	private int did;
	private String dname;
	//部门的描述
	private String ddesc;
	//员工的集合
	private Set<Employee> employees = new HashSet<Employee>();
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
