package com.imooc.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.entity.Department;
/**
 * 部门管理DAO实现类
 * @author Wzy
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	/**
	 * 分页查询部门
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria deCriteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(deCriteria, begin, pageSize);
		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	//根据部门的id查询部门的方法
	public Department findById(int did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO中修改部门的方法
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	//删除部门的方法
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@Override
	//DAO中查询所有部门的方法
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

}
