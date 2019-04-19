<%@page import="com.vincentserver.main.UserDaoImp"%>  
<jsp:useBean id="u" class="com.vincentserver.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%
    int i= UserDaoImp.save(u); 
    if(i>0){  
    response.sendRedirect("addSuccess.jsp");  
    }else{  
    response.sendRedirect("addFail.jsp");  
    }
%>  