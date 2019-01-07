<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Users</title>
</head>
<body>
<%@page import="com.vincentserver.main.UserDaoImp,com.vincentserver.bean.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<h1>Users List</h1>  
<%  
	List<User> list= UserDaoImp.findAllRecord();  
	request.setAttribute("list",list);  
%>  
<table border="1">  
<tr><th>Id</th><th>Name</th><th>Password</th><th>Data</th>  
<th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getPassword()}</td>  
<td>${u.getData()}</td>  
<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="newUser.jsp">Add New User</a>  
</body>
</html>