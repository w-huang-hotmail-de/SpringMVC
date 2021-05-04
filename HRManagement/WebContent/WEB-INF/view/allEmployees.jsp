<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display all the employees</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/list.css">
</head>

<body>
<div class="center">
<h1 align="center">All employees</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Options<a href="emp">(add)</a></th>
		</tr>
		<c:forEach items="${allEmployees}" var="emp">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.gender}</td>
				<td>${emp.department.departName}</td>
				<td>
					<a href="HRController/emp">Update</a>
					<a href="HRController/emp">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>

</html>