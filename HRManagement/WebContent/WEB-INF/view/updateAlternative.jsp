<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%-- This file has the same function as update.jsp. In this file, the <form:> tag of SpringMVC framework is used, 
  -- to realize the automatic echo of the current information of the being updated employee. 
  --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update an employee</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/list.css">
</head>

<body>
<div class="center">
	<h2>Update an employee</h2>
	<form:form action="../emp" method="POST" modelAttribute="updatingEmp">
		<input type="hidden" name="_method" value="PUT">
		<table>
			<tr>
				<td>Id:</td>
				<td>
					<form:input path="id" readonly="true"/>
				</td>
			</tr>
			<tr>
				<td>First name</td>
				<td>
					<form:input path="firstName"/>
				</td>
			</tr>
			<tr>
				<td>Last name</td>
				<td>
					<form:input path="lastName"/>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<form:input path="email"/>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<form:radiobutton path="gender" value="female" label="female"/>
					<form:radiobutton path="gender" value="male" label="male"/>
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>
					<form:select path="department.id" items="${departs}"  itemValue="id" itemLabel="departName"></form:select>
				</td>
			</tr>
			<tr >
				<td colspan="2" align="center">
					<input type="submit" value="Update">
				</td>
			</tr>
		</table>
<%-- 	</form> --%>
	</form:form>
</div>
</body>
</html>