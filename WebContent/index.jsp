<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VincentServerMain</title>
</head>
<body>
<h1>Main Page</h1>  
<%@ page import = "java.io.*,java.util.*" %> 
<%
	Cookie loginSession[]=request.getCookies();  
	if(loginSession==null)
	{  
		%>
		<a href="login.jsp">Login</a>|  
		<%
	}
	else
	{
 		String name=loginSession[0].getValue();  
		if(!name.equals("")||name!=null)
		{
			%>
			<a href="LogoutServlet">Logout</a>|
			<a href="DatabaseServlet">Database</a>
			<%
		}
	}
%>
</body>
</html>