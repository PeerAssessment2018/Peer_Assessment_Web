<%-- 
    Document   : test2.jsp
    Created on : 27 Jun, 2018, 4:10:23 PM
    Author     : Indranil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helper_pack.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test conn</title>
    </head>
    <body>
        <table>
            <tbody>
                <% Data_handler connector_class=new Data_handler();
                ResultSet rs=connector_class.get_all_studentData();
                while(rs.next())
                {
                %>  
                <tr>
                    <td>
                        <%= rs.getString("id") %>
                    </td>
                    <td>
                        <%= rs.getString("username") %>
                    </td>
                    <td>
                        <%= rs.getString("password") %>
                    </td>
                    <td>
                        <%= rs.getString("first_name") %>
                    </td>
                    <td>
                        <%= rs.getString("last_name") %>
                    </td>
                    <td>
                        <%= rs.getString("password") %>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
