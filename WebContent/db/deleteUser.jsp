<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.vincentserver.main.UserDaoImp,com.vincentserver.bean.User"%>   
<%  
	String id=request.getParameter("id");  
	User u= UserDaoImp.findByID(Integer.parseInt(id));  
	UserDaoImp.delete(u); 
	response.sendRedirect("db/viewusers.jsp");  
%>

</body>
</html>