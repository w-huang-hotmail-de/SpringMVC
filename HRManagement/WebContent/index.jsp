<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>

<body>
<a href="HRController/emps">Get all the employees.</a>
<br><br>

<p>Add a new employee with request method GET</p>
<form action="HRController/" method="GET">
<label id="id">id:</label>
<input type="text" name="id" />
<br>
<label id="firstName">first name:</label>
<input type="text" name="firstName" />
<br>
<label id="lastName">last name:</label>
<input type="text" name="lastName" />
<br>
</form>

</body>

</html>