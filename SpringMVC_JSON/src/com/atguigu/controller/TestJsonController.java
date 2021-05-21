package com.atguigu.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeDaoSimulation;

@Controller
@RequestMapping(value="testJsonController")
public class TestJsonController {
	
	@Autowired
	EmployeeDaoSimulation empDao;
	
	/**
	 * Transform a POJO to JSON data and send it back to client.
	 * @param running - the variable having the same name as the parameter sent by client 
	 * @return collection of employees as response body
	 */
	@RequestMapping(value="testJson")
	@ResponseBody	//set the return value as response body, not viewname any more
	public Collection<Employee> testJson(String running) {	//receive data from client
		System.out.println("running: " + running);
		Collection<Employee> emps = empDao.getAll();
		return emps;	//two requirements for automatic transformation from POJO to JSON: jackson's jar files, activate springmvc annotation driver using <mvc:annotation-driven/>  
	}
}
