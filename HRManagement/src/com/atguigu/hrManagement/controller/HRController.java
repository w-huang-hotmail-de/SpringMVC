package com.atguigu.hrManagement.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * To add a new employee.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emp"
	 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String addEmployee() {	
		return "add";	//return the viewname "add" to the viewResolver to determine the jump page adding new employee
	}
	
	/**
	 * To add a new employee with request method POST.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emp"
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String addEmployeeWithPOST(Employee newEmp) {
		return "allEmployees";
	}
	
	/**
	 * To remove an employee.
	 * It maps the request "http://localhost:8080/HRManagement/HRController/emp/id".
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable(name="id")int id) {
		return "succeeded";
	}
	
	/**
	 * To update the information of an employee.
	 * It maps  the request "http://localhost:8080/HRManagement/HRController/emp"
	 */
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String updateEmployee(Employee updateEmp) {
		return "allEmployees";
	}
}


