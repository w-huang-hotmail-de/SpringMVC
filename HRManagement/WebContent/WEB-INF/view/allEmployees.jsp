<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%-- Show all the employees. --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display all the employees</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/list.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.11.3-min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".del").click(	<%-- define the behavior once the tag with class "del" is being clicked --%>
			function(){
				if(confirm("Are you sure to delete the employee?")){
					$("form").attr("action", $(this).attr("href")).submit();	<%-- Bind the tag "this" with a <from> tag to reach two requirements of DispatcherServelet: POST-request method and attribute _method=DELETE. Tansfer the value of attribute "href" of "this" to the atrribute "action" of <form> tag and then submit this request. --%>
					return false;	<%-- ignore the default behavior of "this" --%>
				}
				return false;
			}
		);
	});
</script>
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
					<a href="emp/${emp.id}">Update</a>
					<a class="del" href="emp/${emp.id}">Delete</a>	
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<form method="post">
	<input type="hidden" name="_method" value="DELETE">
</form>

</body>

</html>





