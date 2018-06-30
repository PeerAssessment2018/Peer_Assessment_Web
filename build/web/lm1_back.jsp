<%-- 
    Document   : lm1_back.jsp
    Created on : 27 Jun, 2018, 3:28:32 PM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Your Response</title>
        
    </head>
    <body>
        <div class="box" >
           <div align="center">
            <form name="lms1_form" method="POST" action="lm1_submit.jsp">
        <table border="1" cellspacing="2" cellpadding="2" align="center">
            <thead>
                <tr>
                    <th>Submit your Response: <%
                    String s1 = (String)session.getAttribute("username"); 
                    session.setAttribute("username", s1);
                    out.print(s1);
                %></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Select Course:</td>
                    <td>
                        <select name="dropdown">
                            <%
                                Data_handler cc=new Data_handler(s1);
                                ResultSet rs=cc.get_courses();
                                while(rs.next())
                                {
                                   
                                %>
                                <option><%=rs.getString("course_id") %></option>
                            <%} %>
                        </select></td>
                </tr>
                <tr>
                    <td>Prompt :</td>
                    <td><textarea name="prompt" rows="4" cols="20" placeholder="">
                        </textarea></td>
                </tr>
                <tr>
                    <td>Your Response :</td>
                    <td><textarea name="response" rows="4" cols="20" placeholder="">
                        </textarea></td>
                </tr>
                <tr>
                    <td align="left"><input type="submit" value="Submit" name="submit" /></td>
                    <td align="right"><input TYPE="BUTTON" VALUE="Save" ONCLICK="button1()" /></td>
                </tr>
            </tbody>
        </table>
                </form>
            </div> 
        </div>
    </body>
</html>
