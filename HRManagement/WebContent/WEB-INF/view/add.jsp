<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add new employee</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/list.css"/>
</head>

<body>
<div class="center">
	<h1>Add an new employee</h1>
	<form action="emp" method="POST">
		<table>
			<tr>	
				<td>
					First name
				</td>
				<td>
					<input type="text" id="firstName" name="firstName">
				</td>
			</tr>
			<tr>	
				<td>
					Last name
				</td>
				<td>
					<input type="text" id="lastName" name="lastName">
				</td>
			</tr>
			<tr>	
				<td>
					Email
				</td>
				<td>
					<input type="text" id="email" name="email" />
				</td>
			</tr>
			<tr>	
				<td>
					Gender
				</td>
				<td> 
					<input type="radio" id="female" name="gender" value="0">
					<label for="female">female</label>
					<input type="radio" id="male" name="gender" value="1">
					<label for="male">male</label>
				</td>
			</tr>
			<tr>	
				<td>
					Department
				</td>
				<td>
					<select name="department.id">
						<c:forEach items="${allDeparts}" var="depart">
							<option value="${depart.getId()}">${depart.getDepartName()}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>	
 				<td colspan="100" align="center">	
					<input type="submit" value="add"/>	
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>