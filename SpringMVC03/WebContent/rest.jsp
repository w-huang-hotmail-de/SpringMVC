<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<!-- The following code is necessary, otherweise JQuery (Ajax) dose not work. -->
<!-- But here it result in the Warning "No mapping for GET /SpringMVC03/js/jquery-1.11.3-min.js", because it is handled as normal GET Request and try to find 
	 the mapping method in controller, of cause no mapping method can be found. 
	 How to solve this problem I don't know yet. The teacher said we will deal with it later.-->
<script type="text/javascript" src="js/jquery-1.11.3-min.js"></script>	
<!-- I try with jsp:include to load jquery-1.11.3-min.js as static resource. That does not work. -->
<%-- <jsp:include page="js/jquery-1.11.3-min.js"></jsp:include> --%>

<script type="text/javascript">	//java script can be written anywhere in the file
	function test(){
		$.ajax({
			url: "RESTController/testAjax_DELETE",	//URI
			type: "DELETE",		//requests method
			data: "id=1001",	//It canbe also {id:1001}
			datatype: "json",	//This is expected datatype of the data returned from server. Ajax receive the data always in expected datatype json, no matter what the server has sent. 
			success: function(obj) {	//obj is the data returned from server
				alert(obj);
			}
		});
	}
</script>

<body>
	<a href="RESTController/testREST/1001"> 测试GET请求方法 </a>
	<br><br>
	
	<form action="RESTController/testREST" method="POST">
		<input type="submit" value="测试POST请求方法">  
	</form>
	<br><br>
	
	<form action="RESTController/testREST" method="POST">
		<input type="hidden" name="_method" value="PUT" />	
		<input type="submit" value="测试PUT请求方法" />
	</form>
	<br><br>
	
	<form action="RESTController/testREST/1001" method="POST">	<!-- delete the user which has ID 1001 -->
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="测试DELETE方法" />
	</form>
	<br><br>
	
	<!-- The following does not work, because the label <a> send the request default with GET, not POST, the filter never handle it. And the method which maps GET in controller cannot handle it correctly. 
	<a href="RESTController/testREST?_method=DELETE&id=1001"></a>
	 -->
	
	<!-- We try Ajax here, because Ajax can direct send eight kinds of http-requests, including PUT, DELETE and so on. -->
	<input type="button" value="testAjax" onclick="test()" >
	
</body>

</html>