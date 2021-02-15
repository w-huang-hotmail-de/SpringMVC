<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--下面的href的最前面没有斜杠，代表TestController在当前目录下，即项目的context path下，整个请求地址应该是http://localhost:8080/SpringMVC02/TestController/test -->
<a href="TestController/test"> 测试 href="TestController/test" </a>

<br><br>
<a href="TestController/test?age=10&name=Michael">测试 href="TestController/test?age=10&name=Michael"</a>

<br><br>
<a href="TestController/test/Michael/10">测试 href="TestController/test/Michael/10"</a>

<br><br>
<!-- 下面的href的最前面有一个斜杆，代表服务器的根目录，即http://localhost:8080/，缺少了项目的context path，所以整个请求地址是http://localhost:8080/TestController/test -->
<a href="/TestController/test">测试 href="/TestController/test"</a> 

</body>
</html>