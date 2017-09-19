package com.imooc.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.dao.EmployeeDao;
import com.imooc.employee.entity.Employee;
import com.imooc.employee.entity.PageBean;
import com.imooc.employee.service.EmployeeService;
/**
 * 员工管理业务层实现类
 * @author Wzy
 *
 */
@Transactional
//事务
public class EmployeeServiceImpl implements EmployeeService{
	//注入DAO类
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	/**
	 * 业务层登录的方法
	 */
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findAll(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装数据
		//设置当前页数
		pageBean.setCurrPage(currPage);
		//设置每页查询大小
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//查询总的记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总的页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页的展示数据
		int begin = (currPage-1)*pageSize;
		List<Employee> list = employeeDao.findAll(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//业务层保存员工信息
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	//根据员工的id查找员工的信息
	public Employee findById(int eid) {
		Employee employee = employeeDao.findById(eid);
		return employee;
	}

	@Override
	//业务层更新员工的信息
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
	
}
