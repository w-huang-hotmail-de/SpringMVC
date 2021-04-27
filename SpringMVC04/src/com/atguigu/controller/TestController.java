package com.atguigu.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="TestController")
public class TestController {
	
	@RequestMapping(value="test/{id}", method=RequestMethod.GET)
	public String test(@PathVariable(name="id")String id) {
		System.out.println("the id sent by request address: " + id);
		return "success";								//Succeeded, this is forward by default, not redirect.
//		return "redirect:../../newIndex.jsp";			//Succeeded to get the jump page Http://localhost:8080/SpringMVC04/newIndex.jsp.
//		return "redirect:/newIndex.jsp";				//Succeeded to get the jump page Http://localhost:8080/SpringMVC04/newIndex.jsp.
	
//		return "redirect:/SpringMVC04/newIndex.jsp";	//HTTP Status 404-nicht gefunden. It refers to http://localhost:8080/SpringMVC04/SpringMVC04/newIndex.jsp.
//		return "redirect: success";	  					//HTTP Status 400-Bad Request. It refers to the jump page http://localhost:8080/SpringMVC04/TestController/test/success. 
//		return "redirect: /WEB-INF/view/success.jsp";	//HTTP Status 404-nicht gefunden. It refers to http://localhost:8080/WEB-INF/view/success.jsp.
//		return "redirect:/WEB-INF/view/success.jsp";	//HTTP Status 404-nicht gefunden. It refers to http://localhost:8080/SpringMVC04/WEB-INF/view/success.jsp
//		return "redirect: /SpringMVC04/WEB-INF/view/success.jsp";   //HTTP Status 404-nicht gefunden. It refers to the jump page http://localhost:8080/SpringMVC04/WEB-INF/view/success.jsp.
//		return "redirect: /newIndex.jsp";	//HTTP Status 404-nicht gefunden. It refers to the jump page: http://localhost:8080/newIndex.jsp.	
//		return "redirect:newIndex.jsp";		//HTTP Status 404-nicht gefunden. It refers to the jump page http://localhost:8080/SpringMVC04/TestController/test/newIndex.jsp. 
	}
	
	@RequestMapping(value="test2", method=RequestMethod.POST)
	public String test2(String username) throws UnsupportedEncodingException {
		System.out.println("username: " + new String(username.getBytes("ISO-8859-1"), "UTF-8"));
		return "success";
	}
	
}
