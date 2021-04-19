package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/TestController")
public class TestController {
	@RequestMapping(value="test")
	public String test(String name, Integer age) {
		System.out.println("success non-RESTful URI! name=" + name + ", age=" + age);
		return "success";
	}
	
	@RequestMapping(value="test/{name}/{age}")
	public String testRESTful(@PathVariable("name")String name, @PathVariable("age")Integer age) {
		System.out.println("success RESTful URI! name=" + name + ", age=" + age);
		return "success";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String jumpGET() {
		return "home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String jumpPOST() {
		return "home";
	}
	
}
