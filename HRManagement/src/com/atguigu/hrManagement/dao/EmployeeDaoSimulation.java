package com.atguigu.hrManagement.dao;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.atguigu.hrManagement.bean.Department;
import com.atguigu.hrManagement.bean.Employee;

@Repository
public class EmployeeDaoSimulation {
	
	private static HashMap<Integer, Employee> emps = null;
	
	static {
		emps = new HashMap<>();
		
		emps.put(1001, new Employee(1001, "Martha", "Albers", "m.albers@hotmail.de", "female", new Department(101, "Administration")));
		emps.put(1002, new Employee(1002, "Martha", "Albers", "m.albers@hotmail.de", "female", new Department(101, "Administration")));
		emps.put(1003, new Employee(1003, "Martha", "Albers", "m.albers@hotmail.de", "female", new Department(101, "Administration")));
		emps.put(1004, new Employee(1004, "Martha", "Albers", "m.albers@hotmail.de", "female", new Department(101, "Administration")));
		emps.put(1005, new Employee(1005, "Martha", "Albers", "m.albers@hotmail.de", "female", new Department(101, "Administration")));
	}
	
	private static Integer idOfNewEmp = 1006;	//Store id of the next new employee
	
	/**
	 * Get the information of all the employees
	 * @return Collection<Employee>
	 */
	public Collection<Employee> getAll(){
		return emps.values();
	}
	
	/**
	 * Save the new employee into HashMap emps
	 */
	public void save(Employee newEmp){	
		newEmp.setId(idOfNewEmp);	//the new employee id sent by the browser has been null until this statement is executed
		idOfNewEmp++;	//update idOfNewEmp for the next new employee
		newEmp.setDepartment(DepartmentDaoSimulation.getDepartment(newEmp.getDepartment().getId()));
		emps.put(newEmp.getId(), newEmp);
	}
	
}





