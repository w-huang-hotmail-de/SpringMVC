package com.atguigu.test;

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
	 * 
	 * @return
	 */
	@RequestMapping(value="testJson")
	@ResponseBody	//with this annotation the return value is not viewname for ViewResolver any more, but response body.
	public Collection<Employee> testJson(String running) {
		System.out.println("running: " + running);
		Collection<Employee> emps = empDao.getAll();
		return emps;	//First copy jackson's jar files to project, activate the springmvc driver <mvc:annotation-driven/>, after that springmvc can automatically convert java object into json data.  
	}
}
