<%-- 
    Document   : register_back.jsp
    Created on : 27 Jun, 2018, 5:13:14 PM
    Author     : Indranil
--%>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registering !</title>
    </head>
    <body>
        <%
            String useString,first_string,LastString,passwordString,email;
            useString=request.getParameter("username");
            first_string=request.getParameter("first");
            LastString=request.getParameter("last");
            passwordString=request.getParameter("password");
            email=request.getParameter("email");
            out.print(useString+":user "+first_string+":first "+LastString+":last "+passwordString+":pass "+email+":email\n");
            Data_handler dbh=new Data_handler();
            int f=dbh.register_Student(useString, first_string, LastString, email, passwordString);
            
            if(f==1)
            {
                out.print("registered !");
                response.sendRedirect("LMS_login.jsp");
            }
            else
                out.print("unsuccessfull  :(!"+f);
            
        %>
    </body>
</html>
