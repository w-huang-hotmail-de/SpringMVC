package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="TestControoler")
public class TestController {
	
	@RequestMapping(value="test", method=RequestMethod.GET)
	public String test() {
		
		return "success";
	}
	
}
