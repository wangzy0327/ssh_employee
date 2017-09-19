package com.imooc.employee.action;

import java.util.List;

import com.imooc.employee.entity.Department;
import com.imooc.employee.entity.Employee;
import com.imooc.employee.entity.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.imooc.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动使用对象
	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {
		return employee;
	}

	//注入业务层类
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//当前的页数，默认为首页
	private int currPage =1;
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	/**
	 * 登录执行方法
	 */
	public String login(){
		System.out.println("login ...");
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else{
			//登录成功
			//将用户的信息存入session中
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	//查询所有员工的方法
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//跳转到添加员工页面的方法
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	//保存员工信息
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	//修改员工信息
	public String edit(){
		employee = employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	//更新员工的信息
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	//删除员工的方法
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

}
