package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="RESTController")
public class RESTController {
	
	@RequestMapping(value="testREST/{id}")	//{id} is here a placeholder. It take the value at the corresponding location of access address.
	public String getUserById(@PathVariable(name="id", required=false)int id) {	//The value of placeholder {id} is transported as parameter into the method, with help of the annotation @PathVariable. 
		System.out.println("Get the user Id: " + id);
		return "success";
	}
	
	@RequestMapping(value="testREST", method=RequestMethod.POST)	//The placeholder {xxx} does not apply here, because the parameters will be transfered through form, not via the access address. 
	public String insertUser() {
		System.out.println("POST");
		return "success";
	}
	
	@RequestMapping(value="testREST", method=RequestMethod.PUT)
	public String updateUser() {
		System.out.println("PUT");
		return "success";	//Here will result in Error 405 - Method Not Allowed, because since JSP 2.3 (Tomcat 8) only the request method GET, POST and HEAD are supported.
	}
	
//	@RequestMapping(value="testREST", method=RequestMethod.PUT)
//	public String updateUser(@PathVariable(name="_method")String method) {	//You cannot get the value of the element _method with @PathVariable, because the element _method is transferred via form, not URI. 
//		System.out.println("the Method from parameter _method: " + method);
//		return "success";
//	}

}
