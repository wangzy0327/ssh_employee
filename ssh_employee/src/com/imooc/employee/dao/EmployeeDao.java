package com.imooc.employee.dao;

import java.util.List;

import com.imooc.employee.entity.Employee;

/**
 * 员工Dao接口
 * @author Wzy
 *
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findAll(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);

}
