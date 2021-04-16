package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.Adress;
import com.atguigu.bean.User;


@Controller
@RequestMapping(value="ParamController")
public class ParamController {
	
	@RequestMapping(value="param", method=RequestMethod.POST)
	public String getParameter(@RequestParam(value="usernam", required=false, defaultValue="admin")String name, String password, Integer age, String Province, String city, String conuntry) {	//The name of parameters must be consistent as the name of <form>-element.
		System.out.println("username: " + name);
		return "success";
	}
	
	@RequestMapping(value="ReqHeader", method=RequestMethod.GET)
	public String getRequestHeader (@RequestHeader(value="Accept-Language")String language) {
		System.out.println("Accept-Language: " + language);
		return "success";
	}
	
	@RequestMapping(value="getCookie", method=RequestMethod.GET)
	public String getCookie (@CookieValue(value="JSESSIONID")String jSessionId) {
		System.out.println("JSESSIONID: " + jSessionId);
		return "success";
	}
	
	@RequestMapping(value="getCookieAlternativ", method=RequestMethod.GET)
	public String getCookieAlternativ (@RequestHeader(value="Cookie")String cookie) {
		System.out.println("cookie:" + cookie);
		return "success";
	}
	
	@RequestMapping(value="getParamViaPOJO", method=RequestMethod.POST)
	public String getParamViaPOJO(User user, Adress address) {
		user.setAdress(address);
		System.out.println(user);
		return "success";
	}
	
	@RequestMapping(value="testModelAndView", method=RequestMethod.GET)
	public ModelAndView testModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", "dada");	//encapsulate the method httpServeltRequest.setAttribute().
		mav.setViewName("success");	//set the viewname for the next page just like other methods retun a value of type String 
		return mav;
	}
	
}
