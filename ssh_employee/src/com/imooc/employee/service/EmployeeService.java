package com.imooc.employee.service;

import com.imooc.employee.entity.Employee;
import com.imooc.employee.entity.PageBean;

/**
 * 员工管理的业务层接口
 * @author Wzy
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findAll(int currPage);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);

}
