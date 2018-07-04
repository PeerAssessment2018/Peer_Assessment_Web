<%-- 
    Document   : lms1_save.jsp
    Created on : 4 Jul, 2018, 11:23:14 AM
    Author     : Indranil
--%>
<%@page import="helper_pack.DataBase_Handler" %>
<%@page  import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lms1_save_1</h1>
        <p>
            <%= session.getAttribute("state_s") %> 
            <%= request.getParameter("response") %>
            <% //String res=request.getParameter("response");
               DataBase_Handler dbh=new DataBase_Handler();
               //String userString=session.getAttribute("username");
               dbh.insert_courseware_studentmodule(15, request.getParameter("response"), "15", "walla", 0);
               // dbh.insert_courseware_studentmodule(5, "gand", "walla", "habibi", 1);
               response.sendRedirect("lms1.jsp");
            %>
        </p>
    </body>
</html>
