package com.imooc.employee.dao;

import java.util.List;

import com.imooc.employee.entity.Department;

/**
 * 部门管理DAO接口
 * @author Wzy
 *
 */
public interface DepartmentDao {

	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	void save(Department department);

	Department findById(int did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();


}
