package com.atguigu.hrManagement.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.atguigu.hrManagement.bean.Department;

@Repository
public class DepartmentDaoSimulation {
	
	private static Map<Integer, Department> departments = null;
	
	static {
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(1001, "Administration"));
		departments.put(102, new Department(1002, "R&D"));
		departments.put(103, new Department(1003, "Logistic"));
		departments.put(104, new Department(1004, "Design"));
		departments.put(105, new Department(1005, "Porduction"));
	}
	
}
