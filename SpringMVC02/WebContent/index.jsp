<%@page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% String myString = "TestController/test?age=10&name=Michael"; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- href的最前面没有斜杠，代表TestController在当前目录下，即项目的context path下，整个请求地址应该是http://localhost:8080/SpringMVC02/TestController/test -->
<a href="TestController/test"> 测试 href="TestController/test" </a>
<!-- href的访问方法默认只能是GET，是不可改变的。 -->

<br><br>
<!-- href的最前面有一个斜杆，代表服务器的根目录，即http://localhost:8080/，缺少了项目的context path，所以整个请求地址是http://localhost:8080/TestController/test。访问将返回错误信息。-->
<a href="/TestController/test">测试 href="/TestController/test"</a> 

<br><br>
<a href="TestController/test?age=10&name=Michael">
测试2.A  href="<c:out value="TestController/test?age=10&name=Michael" escapeXml="true"></c:out>"
</a>

<br><br>
<a href="TestController/test?age=10&name=Michael">
测试2.B  href="<% out.print(myString); %>"
</a>

<br><br>
<a href="TestController/test?age=10&name=Michael">
测试2.C  href="<c:out value="${myString}" escapeXml="true"></c:out>"
</a>

<br><br>
<a href="TestController/test?age=10&name=Michael">
测试2.D  href="${fn:escapeXml(myString) }"
</a>

<br><br>
<a href="TestController/test/Michael/10">测试 href="TestController/test/Michael/10"</a>

</body>
</html>