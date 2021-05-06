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
		emps.put(1002, new Employee(1002, "Erik", "Bach", "e.bach@hotmail.de", "male", new Department(102, "R&D")));
		emps.put(1003, new Employee(1003, "Jurek", "Janser", "j.janser@hotmail.de", "male", new Department(103, "Logistik")));
		emps.put(1004, new Employee(1004, "Amelie", "Luther", "a.luther@hotmail.de", "female", new Department(104, "Design")));
		emps.put(1005, new Employee(1005, "Iwen", "Hörte", "i.hörte@hotmail.de", "male", new Department(105, "Production")));
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
	public void save(Employee emp){	
		if(emp.getId() == null)	//a new employee that has no id
			emp.setId(idOfNewEmp++);	//assign an id to the new employee, after that id increase itself by one 
		else
			;	//nothing to do because the employee being updated has already an id
		emp.setDepartment(DepartmentDaoSimulation.getDepartment(emp.getDepartment().getId()));
		emps.put(emp.getId(), emp);
	}
	
	
	/**
	 * Get an employee according to his id 
	 * @param id the id of employee
	 * @return Employee an employee
	 */
	public Employee getEmployee(Integer id) {
		return emps.get(id);
	}
	
	
	/**
	 * Remove an employee
	 * @param id - the id of employee being removed
	 */
	public void delEmployee(Integer id) {
		emps.remove(id);
	}

}





