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
import com.atguigu.hrManagement.dao.DepartmentDao;
import com.atguigu.hrManagement.dao.EmployeeDao;

/**
 * Controller of DespatcherServlet to process the request from client in according to @RequestMapping,
 * which maps the annotated method to a request.
 */
@Controller
@RequestMapping(value="/HRController")
public class HRController {
	
	@Autowired	//automatically wire an Object of type DepartmentDao 
	private DepartmentDao departDao;
	
	@Autowired	//automatically wire an Object of type EmployeeDao 
	private EmployeeDao empDao;
	
	
	/**
	 * Get all the employees. 
	 * Map the request http://localhost:8080/HRManagement/HRController/emps with request method GET.
	 * @param map - attribute in request scope to transfer data between different pages under a same http-address (page Forward)
	 * @return viewname being transfered to viewResolver to determine next page (page forward)
	 */
	@RequestMapping(value="/emps", method=RequestMethod.GET)
	public String getAllEmployee(Map<String, Object> map) {
		Collection<Employee> emps = empDao.getAll();	//get all employees 
		map.put("allEmployees", emps);	 
		return "allEmployees";	
	}
	
	
	/**
	 * Jump to the page adding new employee. 
	 * Map the request http://localhost:8080/HRManagement/HRController/emp with request method GET.
	 * @param map - attribute in request scope to transfer data between different pages under a same http-address (page Forward)
	 * @return viewname being transfered to viewResolver to determine next page (page forward)
	 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String jumpToAddEmployee(Map<String, Object> map) {	
		Collection<Department> departments = departDao.getAll();	//get all departments
		map.put("allDeparts", departments);
		return "add";	
	}
	
	
	/**
	 * Add a new employee. 
	 * Map the request http://localhost:8080/HRManagement/HRController/emp with request method POST.
	 * @param newEmp - a POJO object of type Employee receiving the data from client
	 * @return request address for redirecting page (page redirect)
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String addEmployee(Employee newEmp) {
		empDao.save(newEmp);
		return "redirect:emps";
	}
	
	
	/**
	 * Jump to the page updating an employee. 
	 * Map the request http://localhost:8080/HRManagement/HRController/emp/id with request method GET.
	 * @param id - id of the employee being updated.
	 * @param map - attribute in request scope to transfer data between different pages under a same http-address (page Forward)
	 * @return viewname being transfered to viewResolver to determine next page (page forward)
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String jumpToUpdateEmployee(@PathVariable(name="id")Integer id, Map<String, Object> map) {
		Employee updatingEmp = empDao.getById(id);	//get the employee being updated
		Collection<Department> departs = departDao.getAll();	//get all departments
		map.put("updatingEmp", updatingEmp);	//the key name "updatingEmp" is set in tab <form: modelAttribute> in updateAlternative.jsp, should not be changed
		map.put("departs", departs);	
		return "updateAlternative";	
	}
	
	
	/**
	 * Update an employee. 
	 * Map the request http://localhost:8080/HRManagement/HRController/emp with request method PUT.
	 * @param emp - a POJO object of type Employee receiving the data from client
	 * @return request address for redirecting page (page redirect)
	 */
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String updateEmployee(Employee emp) {	
		System.out.println("hier is updateEmployee");
		empDao.update(emp);	//update the employee
		return "redirect:emps";
	}
	
	
	/**
	 * Delete an employee. 
	 * Map the request http://localhost:8080/HRManagement/HRController/emp/id with request method DELETE.
	 * @param id - id of the employee being deleted
	 * @return request address for redirecting page (page redirect)
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable(name="id")Integer id) {
		System.out.println("hier is deleteEmployee");
		empDao.deleteById(id);
		return "redirect:../emps";
	}
	
}


