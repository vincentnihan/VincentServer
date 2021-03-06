package com.vincentserver.servlet;
import java.io.IOException;  

import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet(name = "DatabaseServlet", urlPatterns = "/DatabaseServlet")
public class DatabaseServlet extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException 
	{  
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        Cookie loginSession[]=request.getCookies();  
        if(loginSession!=null){  
         String name=loginSession[0].getValue();  
        if(!name.equals("")||name!=null){  
            out.print("<b>Welcome to Database</b>");  
            out.print("<br>Welcome, "+name);  
            request.getRequestDispatcher("db/viewUsers.jsp").include(request, response);
            //Feature Update start here!
        }  
        }else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }  
        out.close();  
        
	}
}
