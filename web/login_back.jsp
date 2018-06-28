<%-- 
    Document   : login_back
    Created on : 27 Jun, 2018, 11:07:26 AM
    Author     : Indranil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Back</title>
    </head>
    <body>
        <%= request.getParameter("name") %>
        <%= request.getParameter("password") %>
    </body>
</html>
