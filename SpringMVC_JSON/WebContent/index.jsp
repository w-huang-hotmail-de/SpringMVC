<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/list.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.11.3-min.js"></script>
<script type="text/javascript">
	$(
		function(){	//pre-load function: at first to load all the html tags, then run this ajax code	
			$("#btn_ajax").click(	//click event of html-tag identified with "btn_ajax"	
				function(){	//function for click event
					$.ajax(
						{
							url:"testJsonController/testJson",
							type:"POST",
							data: {running:"every day"},
							dataType:"json",	//expected type of data sent back from server; data type to receive data no matter what is sent back from server
							success:function(resp){
								/* show received json in a table using javascript for-in */
								var table = "<table>"
								table += "<tr><th>id</th><th>first name</th><th>last name</th><th>email</th><th>gender</th><th>department</th></tr>";
								for(var i in resp){
									table += "<tr><td>"+resp[i].id+"</td><td>"+resp[i].firstName+"</td><td>"+resp[i].lastName+"</td><td>"+resp[i].email+"</td><td>"+resp[i].gender+"</td><td>"+resp[i].department.departName+"</td></tr>";
								}
								table += "</table>";
								$(".center").append(table);	//get html-tag with class "center" and append the table into it	
								
								/* show received json with alert-windows */
								for(var i in resp){
									alert(resp[i].id + ", " + resp[i].firstName + ", " + resp[i].lastName + ", " + resp[i].email + ", " + resp[i].gender + ", " + resp[i].department.departName);
								}
							}
						}	
					);		
				}
			);
		}
	);	
</script>
</head>

<body>
<div class="center">
	<a href="testJsonController/testJson">test json</a>
	<br><br>
	<input type="button" id="btn_ajax" value="test Ajax">
	<br><br><br>
</div>
</body>

</html>