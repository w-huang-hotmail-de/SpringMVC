<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form action="ParamController/param" method="POST">
		<label for="username">username:</label>	
		<input type="text" name="username" />
		<br>
		<label for="password">password:</label>
		<input type="password" name="password"/>
		<br>
		<label for="age">age:</label>
		<input type="text" name="age" />
		<br>
		<label for="province">province:</label>
		<input type="text" name="province"/>
		<br>
		<label for="city">city</label>
		<input type="text" name="city" />
		<br>
		<label for="conuntry">conuntry</label>
		<input type="text" name="country" />
		<br>
		<input type="submit" value="submit">
	</form>
	<br><br>
	
	<a href="ParamController/ReqHeader">get Request Header</a>
	<br><br>
	
	<a href="ParamController/getCookie">get Request Cookies with @CookieValue</a>
	<br><br>
	
	<a href="ParamController/getCookieAlternativ">get Request Cookie with @RequestHeader </a>
	<br><br>
	
	<form action="ParamController/getParamViaPOJO" method="POST">
		<label for="username">username:</label>
		<input type="text" name="username">
		<label for="password">password:</label>
		<input type="password" name="password">
		<label for="age">age:</label>
		<input type="text" name="age">
		<label for="province">province:</label>
		<input type="text" name="adress.province">
		<label for="city">city:</label>
		<input type="text" name="adress.city">
		<label for="country">country:</label>
		<input type="text" name="adress.country">
		<input type="submit" value="submit">
	</form>
	<br><br>
	
	<a href="ParamController/testDataTransferWithHttpServletRequest">test DataTransfer in SpringMVC with HttpServletRequest</a>
	<br><br>
	
	<a href="ParamController/testDataTransferWithModelAndView">test DataTransfer in SpringMVC with ModelAndView</a>
	<br><br>
	
	<a href="ParamController/testDataTransferWithMap">test DataTransfer in SpringMVC with java.util.Map</a>
	<br><br>
	
	<a href="ParamController/testDataTransferWithModel">test DataTranser in SpringMVC with org.springframework.ui.Model</a>
	
	
</body>
</html>