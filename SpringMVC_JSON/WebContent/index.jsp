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
		function(){	//pre-load function: first load all the html tags, then run this ajax code	
			$("#btn_ajax").click(	//click event on html-tag identified with "btn_ajax"	
				function(){			//function for click event
					$.ajax(
						{
							url:"testJsonController/testJson",
							type:"POST",
							data: {key:"value"},
							dataType:"json",	//expected datatype being sent back from server; also datatype receiving data no matter what is sent back from server
							success:function(resp){
								/* show received json in a table using for-in */
								var table = "<table>"
								table += "<tr><th>id</th><th>first name</th><th>last name</th><th>email</th><th>gender</th><th>department</th></tr>";
								for(var i in resp){
									table += "<tr><td>"+resp[i].id+"</td><td>"+resp[i].firstName+"</td><td>"+resp[i].lastName+"</td><td>"+resp[i].email+"</td><td>"+resp[i].gender+"</td><td>"+resp[i].department.departName+"</td></tr>";
								}
								table += "</table>";
								$(".center").append(table);	//append the table to the html-tag with class "center"
								
								/* Show received json with alert-windows. Alert always run first no matter where the code locates. */
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
	<a href="testJsonController/testJson">Get JSON data from SpringMVC</a>
	<br><br>
	<input type="button" id="btn_ajax" value="Get JSON data from SpringMVC. Show them in a table using AJAX">
	<br><br><br>
</div>
</body>

</html>