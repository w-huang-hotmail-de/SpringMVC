package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public String updateUser(String _method) {	//Make the method parameter having same name as element in form, then he can take his value.
		System.out.println("the real request method: " + _method);
//		return "success";	//page-forward cannot be used here, because since Tomcat 8 (JSP 2.3) only support jsp-request with RequestMethod.GET or RequestMethod.POST
		return "redirect:/RESTController/forPageForward";
	}
	
	@RequestMapping(value="testREST/{id}", method=RequestMethod.DELETE)
	public String deleteUser(String _method, @PathVariable(name="id", required=false)Integer id) {
		System.out.println("the real request method: " + _method);
		System.out.println("the being deleted User has ID: " + id);
//		return "success";	//page-forward cannot be used here, because since Tomcat 8 (JSP 2.3) only support jsp-request with RequestMethod.GET or RequestMethod.POST
		return "redirect:/RESTController/forPageForward";
	}
	
	@RequestMapping(value="testAjax_DELETE")
	@DeleteMapping
	public void testAjax(Integer id) {	//For Ajax it must be returned void, because Ajax's purpose is to achieve data interaction between client and server without page jump.
		System.out.println("testAjax_DELETE, id = " + id);
	}
	
	/**
	 * Do nothing, but only forward to the next page. 
	 * Since Tomcat 8 (JSP 2.3) only suport jsp-request with RequestMethod.GET and RequestMethod.POST, therefore it cannot be 
	 * successed to make page-forward from a request with PUT or DELETE Method. So at first redirect to here and then forward.
	 * @return viewname for ViewResolver for page-forward.
	 */
	@RequestMapping(value="forPageForward")
	public String forPageForward() {
		return "success";
	}

}
