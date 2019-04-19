<%@page import="com.vincentserver.main.UserDaoImp,com.vincentserver.bean.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<h1>Users List</h1>  
<%  
	List<User> list= UserDaoImp.findAllRecord();  
	request.setAttribute("list",list);  
%>  
<table border="1">  
<tr><th>Id</th><th>Name</th><th>Password</th>  
<th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.isComplete()}</td>   
<td><a href="db/editForm.jsp?id=${u.getId()}">Edit</a></td>  
<td><a href="db/deleteUser.jsp?id=${u.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/>
<a href="db/newUser.jsp">Add New User</a>  

