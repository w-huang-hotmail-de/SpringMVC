<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%-- The page updating an employee. --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update an employee</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/list.css">
</head>

<body>
<div class="center">
	<h2>Update an employee</h2>
	<form action="../emp" method="POST">
		<input type="hidden" name="_method" value="PUT">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="id" value="${updatingEmp.id}" readonly="readonly" ></td>
			</tr>
			<tr>
				<td>First name</td>
				<td>
					<input type="text" name="firstName" value="${updatingEmp.firstName}">
				</td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><input type="text" name="lastName" value="${updatingEmp.lastName}"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type="text" name="email" value="${updatingEmp.email}">
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<input type="radio" name="gender" value="female" ${updatingEmp.gender.equals("female") ? "checked" : ""}>femal
					<input type="radio" name="gender" value="male" ${updatingEmp.gender.equals("male") ? "checked" : ""}>male
<%-- 				<input type="radio" name="gender" value="female" <c:if test="${updatingEmp.gender.equals('femal')}">checked="checked"</c:if>>femal --%>
<%-- 				<input type="radio" name="gender" value="male" <c:if test="${updatingEmp.gender.equals('male')}">checked="checked"</c:if>>male --%>
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>
					<select name="department.id">
						<c:forEach items="${departs}" var="depart">
							<option value="${depart.id}" ${updatingEmp.department.id==depart.id ? "selected" : ""}>${depart.departName}</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr >
				<td colspan="2" align="center">
					<input type="submit" value="Update">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>