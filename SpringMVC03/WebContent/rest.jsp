<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<a href="RESTController/testREST/1001"> 测试GET请求方法 </a>
	<br><br>
	
	<form action="RESTController/testREST" method="POST">
		<input type="submit" value="测试POST请求方法">  
	</form>
	<br><br>
	
	<form action="RESTController/testREST" method="POST">
		<input type="hidden" name="_method" value="PUT" />	
		<input type="submit" value="测试PUT请求方法" />  
	</form>
	
</body>

</html>