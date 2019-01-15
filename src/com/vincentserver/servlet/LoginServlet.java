package com.vincentserver.servlet;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.vincentserver.main.UserDaoImp;  
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.jsp").include(request, response);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(UserDaoImp.findByNameAndPassword(name,password) != 0)
		{
			 out.print("You are successfully logged in!");  
	         out.print("<br>Welcome, "+name);  
		
		
		Cookie loginSession =new Cookie("name",name);  
		loginSession.setMaxAge(5000);
        response.addCookie(loginSession);  
		}
		else
		{
			out.print("Wrong user name or password");  
			request.getRequestDispatcher("login.jsp").include(request, response);  
		}
	}
}
