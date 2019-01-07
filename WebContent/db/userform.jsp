<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<a href="viewUser.jsp">View All Records</a><br/> 
	<form action="submitResult.jsp" method="post">
	<table>
	<tr><td>ID:</td><td><input type="number" name="id"/></td></tr>  
	<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>  
	<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>  
	<tr><td>data:</td><td><input type="text" name="data"/></td></tr>  
	<tr><td colspan="2"><input type="submit" value="Submit new user form"/></td></tr>  
	</table>
	</form>
</html>