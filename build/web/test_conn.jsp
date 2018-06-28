<%-- 
    Document   : test_conn
    Created on : 27 Jun, 2018, 2:02:58 PM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test_conn</title>
    </head>
    <body>
        <%!
            class Connector_class   
            {
                String URL="jdbc:mysql://localhost:3306/peer_assessment";
String user="root",password="";
Connection connection;
PreparedStatement ps;
ResultSet rs=null;
               
                public Connector_class()
                {
                    try {
                            connection=DriverManager.getConnection(URL,user,password);
                        System.out.println("Connection Established !");
                         ps=connection.prepareStatement("SELECT * from student_data");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
                public ResultSet get_Results()
                {
                    ResultSet rs=null;
                    try{
                    rs=ps.executeQuery();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    return rs;
                }
            }
        %>
        <table>
            <tbody>
                <% Connector_class connector_class=new Connector_class();
                ResultSet rs=connector_class.get_Results();
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
