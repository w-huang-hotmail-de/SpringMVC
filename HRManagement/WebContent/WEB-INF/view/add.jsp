<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add new employee</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/list.css"/>
</head>

<body>
<div class="center">
	<form action="emp" method="POST">
		<table>
			<tr>
				<th colspan="100">
					Add an new employee
				</th>
			</tr>
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
					<input type="radio" name="department" id="Admin" value="1001">
					<label for="Admin">Administration</label><br>
					<input type="radio" name="department" id="Design" value="1004">
					<label for="Design">Design</label><br>					
					<input type="radio" name="department" id="Logistic" value="1003">
					<label for="Logistic">Logistic</label><br>
					<input type="radio" name="department" id="Production" value="1005">
					<label for="Production">Production</label><br>
					<input type="radio" name="department" id="R&D" value="1002">
					<label for="R&D">Research and Develop</label>
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