package com.atguigu.hrManagement.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.hrManagement.bean.Department;
import com.atguigu.hrManagement.bean.Employee;
import com.atguigu.hrManagement.dao.DepartmentDaoSimulation;
import com.atguigu.hrManagement.dao.EmployeeDaoSimulation;

@Controller
@RequestMapping(value="/HRController")
public class HRController {
	
	@Autowired
	private DepartmentDaoSimulation departDao;
	
	@Autowired
	private EmployeeDaoSimulation empDao;
	
	
	/**
	 * To get all the employees.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emps".
	 */
	@RequestMapping(value="/emps", method=RequestMethod.GET)
	public String getAllEmployee(Map<String, Object> map) {
		Collection<Employee> emps = empDao.getAll();	//get the information of all employees and save it into a Collection object
		map.put("allEmployees", emps);	//create an element named "allEmployees" in request scope, his value is the collection of all employees 
		return "allEmployees";	//return the viewname to viewResolver to determine the jump page
	}
	
	
	/**
	 * To jump to the page adding a new employee.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emp"
	 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String jumpToAddEmployee(Map<String, Object> map) {	
		Collection<Department> departments = departDao.getAll();
		map.put("allDeparts", departments);
		return "add";	//return the viewname "add" to the viewResolver to determine the jump page adding new employee
	}
	
	
	/**
	 * To add a new employee.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emp"
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String addEmployee(Employee newEmp) {
		empDao.save(newEmp);
		return "redirect:emps";
	}
	
	
	/**
	 * To jump to the page updating an employee.
	 * It maps  the request "http://localhost:8080/HRManagement/HRController/emp"
	 * @param id - The id of employee that will be updated.
	 * @param map -	Save data into request scope.
	 * @return A String as viewname with that the viewResolver determine next jump page.
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String jumpToUpdateEmployee(@PathVariable(name="id")Integer id, Map<String, Object> map) {
		Employee updatingEmp = empDao.getEmployee(id);	//get current information of the employee
		Collection<Department> departs = departDao.getAll();	//get all the current departments
		map.put("updatingEmp", updatingEmp);	//save the employee into request scope
		map.put("departs", departs);	//save all the current departments into request scope
		return "updateAlternative";	//return viewname "update" with that the viewResolver determine the jump page
	}
	
	
	/**
	 * To update an employee
	 * @param emp - A POJO object to receive data sent by browser
	 * @return A String as viewname with that the next jump page is determined.
	 */
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String updateEmployee(Employee emp) {	
		empDao.save(emp);	//update the employee
		return "redirect:emps";
	}
	
	
	/**
	 * To remove an employee.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emp/id".
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable(name="id")Integer id) {
		empDao.delEmployee(id);
		return "redirect:../emps";
	}
	
}


