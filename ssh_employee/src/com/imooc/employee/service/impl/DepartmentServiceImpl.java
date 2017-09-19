package com.imooc.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.entity.Department;
import com.imooc.employee.entity.PageBean;
import com.imooc.employee.service.DepartmentService;
/**
 * 部门管理业务层实现类
 * @author Wzy
 *
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	//注入部门管理DAO
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//分页查询部门的方法
	public PageBean<Department> findByPage(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数:
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总的页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页的显示的数据
		int begin = (currPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	@Override
	//业务层保存部门的方法
	public void save(Department department){
		departmentDao.save(department);
	}

	@Override
	//业务层根据部门的id查询部门的方法
	public Department findById(int did) {
		return departmentDao.findById(did);
	}

	@Override
	//业务层修改部门信息的方法
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	//业务层删除部门的方法
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	//业务层查找所有部门的方法
	public List<Department> findAll() {
		List<Department> list = departmentDao.findAll();
		return list;
	}
	
}
