<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<%@page import="com.vincentserver.main.UserDaoImp,com.vincentserver.bean.User"%>  
<%  
	String id=request.getParameter("id");  
	User u= UserDaoImp.findByID(Integer.parseInt(id));  
%>  
<form action="UserEditServlet" method="post">  
<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  
<tr><td>ID: <%= u.getId() %> </td></tr>
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= u.getName()%>"/></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form> 
</body>
</html>