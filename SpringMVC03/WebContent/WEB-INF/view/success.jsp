<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
成功！<br><br>
Get attribute with ModelAndView: ${requestScope.user}<br><br>
Get attribute with java.util.Map: ${requestScope.user} | <% out.println(request.getAttribute("user")); %>


<br>
<p>-------------Try the four scopes predefined in EL----------------------------------------------</p>
<%! int speed = 100; %>	<!-- speed is not an attribute in pageScope. It cannot be caught with El. -->
<% 
	request.setAttribute("tempReqAttribute", "temp request attribute"); 
	pageContext.setAttribute("degree", 100);	
%>

Get variable from uncertain scope: ${user} <br>
Get variable from pageScope: ${pageScope.user} <br>		<!-- cannot get attribute in request scope -->
Get variable from requestScope: ${requestScope.user} <br>
Get variable from sessionScope: ${sessionScope.user} <br>	<!-- cannot get attribute in request scope -->
Get variable from applicationScope: ${applicationScope.user} <br>	<!-- cannot get attribute in request scope -->
Get variable starting from pageContext: ${pageContext.request.attributeNames} <br><br>

Get request attribute from unspecified scope: ${tempReqAttribute} <br>
Get request attribute form pageScope: ${pageScope.tempReqAttribute} <br>
Get request attribute from requestScope: ${requestScope.tempReqAttribute} <br>
Get request attribute from sessionScope: ${sessionScope.tempReqAttribute} <br>
Get request attribute from applicationScope: ${applicationScope.tempReqAttribute} <br> <br>

Get variable from pageScope: ${pageScope.degree}<br>
Get variable from unspecified Scope: ${degree}

</body>
</html>   