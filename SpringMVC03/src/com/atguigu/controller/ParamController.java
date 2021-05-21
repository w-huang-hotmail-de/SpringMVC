package com.atguigu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.User;


@Controller
@RequestMapping(value="ParamController")
public class ParamController {
	
	@RequestMapping(value="param", method=RequestMethod.POST)
	public String getParameter(@RequestParam(value="username", required=false, defaultValue="admin")String name, String password, Integer age, String Province, String city, String conuntry) {	//The name of parameters must be consistent as the name of <form>-element.
		System.out.println("username: " + name);
		return "success";	//return view name to the ViewResolver
	}
	
	@RequestMapping(value="ReqHeader", method=RequestMethod.GET)
	public String getRequestHeader (@RequestHeader(value="Accept-Language")String language) {
		System.out.println("Accept-Language: " + language);
		return "success";	//return view name to the ViewResolver
	}
	
	@RequestMapping(value="getCookie", method=RequestMethod.GET)
	public String getCookie (@CookieValue(value="JSESSIONID")String jSessionId) {
		System.out.println("JSESSIONID: " + jSessionId);
		return "success";	//return view name to the ViewResolver
	}
	
	@RequestMapping(value="getCookieAlternativ", method=RequestMethod.GET)
	public String getCookieAlternativ (@RequestHeader(value="Cookie")String cookie) {
		System.out.println("cookie:" + cookie);
		return "success";	//return view name to the ViewResolver
	}
	
	@RequestMapping(value="getParamViaPOJO", method=RequestMethod.POST)
	public String getParamViaPOJO(User user) {	
		System.out.println(user);
		return "success";	//return view name to the ViewResolver
	}
	
	/**
	 * Transfer data to the next page with HttpServletRequest
	 */
	@RequestMapping(value="testDataTransferWithHttpServletRequest", method=RequestMethod.GET)
	public String testDataTransferWithHttpServletRequest(HttpServletRequest request) {
		request.setAttribute("user", "root");
		return "success";
	}
	
	
	@RequestMapping(value="testDataTransferWithModelAndView", method=RequestMethod.GET)
	public ModelAndView testModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", "dada");	//encapsulate the method httpServeltRequest.setAttribute().
		mav.setViewName("success");	//set the viewname for the next page just like other methods retun a value of type String 
		return mav;
	}
	
	@RequestMapping(value="testDataTransferWithMap", method=RequestMethod.GET)
	public String testDataTransfer_no_ModelAndView(Map<String,Object> map) {
		map.put("user", "admin");	//add a attribute into the current httpServletRequest
		return "success";	//return view name to the ViewResolver
	}
	
	@RequestMapping(value="testDataTransferWithModel", method=RequestMethod.GET)
	public String testDataTransferWithModel(Model model) {
		model.addAttribute("user", "Berlin");	//add a attribute into the current httpServletRequest
		System.out.println("柏林");	//just to test the garbled problem by displaying non-letter text
		return "success";	//return view name to the ViewResolver
	}
	
}
