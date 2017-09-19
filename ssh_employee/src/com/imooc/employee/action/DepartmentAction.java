package com.imooc.employee.action;

import com.imooc.employee.entity.Department;
import com.imooc.employee.entity.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 部门管理Action类
 * @author Wzy
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//模型驱动使用的对象
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	private int currPage=1;
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	//注入部门管理service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	//提供一个查询方法
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//跳转到添加部门的页面的方法
	public String saveUI(){
		return "saveUI";
	}
	//添加部门的执行方法
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门的执行方法
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	//更新部门的执行方法
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//删除部门的执行方法
	public String delete(){
		department = departmentService.findById(department.getDid());
		//删除对象这种方式可以进行级联删除
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
