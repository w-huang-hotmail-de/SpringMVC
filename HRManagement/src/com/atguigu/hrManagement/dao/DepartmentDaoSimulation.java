package com.atguigu.hrManagement.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.atguigu.hrManagement.bean.Department;


/**
 * Simulate the behavior of accessing the schema table department, actually no access to the database.
 */
@Repository
public class DepartmentDaoSimulation {
	
	private static Map<Integer, Department> departments = null;
	
	static {
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "Administration"));
		departments.put(102, new Department(102, "R&D"));
		departments.put(103, new Department(103, "Logistic"));
		departments.put(104, new Department(104, "Design"));
		departments.put(105, new Department(105, "Porduction"));
	}
	
	
	/**
	 * Get all the Departments
	 * @return Collection<Department>
	 */
	public Collection<Department> getAll(){
		return departments.values();
	}
	
	
	/**
	 * Get the corresponding department according to its id
	 * @param derpartId id of department
	 * @return Department the corresponding department
	 */
	public static Department getDepartment(Integer derpartId) {
		return departments.get(derpartId);
	}
	
}









