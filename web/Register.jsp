<%-- 
    Document   : Register
    Created on : 27 Jun, 2018, 11:15:54 AM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register for the course</title>
    </head>
    <body>
        <form name="register" action="index.jsp" method="POST">
        <table border="0">
            <%!
                public class Actor{
            
String URL="jdbc:mysql://localhost:3306/peer_assessment";
String user="root",password="";
Connection connection;
PreparedStatement ps=null;
ResultSet rs=null;
public Actor()
{
try{
    connection=DriverManager.getConnection(URL,user,password);
    System.out.println("Connection Established !");
    ps=connection.prepareStatement("INSERT INTO student_data(username,first_name,last_name,password,email) VALUES(?,?,?,?,?)");
    
    //ps=connection.prepareStatement("Select * from student_data");
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
public int insert(String usernameString,String firstString,String lastString,String passString,String email)
{
int f=0;
try {
        ps.setString(1, usernameString);
        ps.setString(2, firstString);
        ps.setString(3, lastString);
ps.setString(4, passString);
ps.setString(5, email);
f=ps.executeUpdate();
    } catch (Exception e) {
e.getStackTrace();
    }
return f;
}


}
                %>
                
    <%
        int res=0;
        String usernameString,firString,laString,emailString,password;
        usernameString=request.getParameter("username");
        firString=request.getParameter("first");
        laString=request.getParameter("last");
        emailString=request.getParameter("email");
        password=request.getParameter("password");
        
        Actor ar=new Actor();
        int f=ar.insert(usernameString, firString, laString, password, emailString);
        
    %>            
        <tbody>
        	<tr>
        		<td>UserName :</td>
        		<td><input type="text" name="username" value="" size="20" /></td>
        	</tr>
                <tr>
        		<td>First Name :</td>
        		<td><input type="text" name="first" value="" size="20" /></td>
        	</tr>
                <tr>
        		<td>Last Name :</td>
        		<td><input type="text" name="last" value="" size="20" /></td>
        	</tr>
        	<tr>
        		<td>Password :</td>
        		<td><input type="password" name="password" value="" size="20" /></td>
        	</tr>
                <tr>
        		<td>Email :</td>
        		<td><input type="text" name="email" value="" size="20" /></td>
        	</tr>
        	<tr>
        		<td><input type="submit" value="Submit" name="submit_button" /></td>
        		<td><input type="reset" value="Reset" name="reset_button" /></td>
        	</tr>
        </tbody>
        </table>
    </body>
</html>
