package com.imooc.employee.service;

import java.util.List;

import com.imooc.employee.entity.Department;
import com.imooc.employee.entity.PageBean;

/**
 * 部门管理业务层接口
 * @author Wzy
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(int currPage);

	void save(Department department);

	Department findById(int did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
