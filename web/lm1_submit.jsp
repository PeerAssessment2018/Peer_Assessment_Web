<%-- 
    Document   : lm1_submit.jsp
    Created on : 27 Jun, 2018, 4:42:55 PM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<%@page  import="java.util.Date" %>
<%@page import="helper_pack.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submitting response...</title>
    </head>
    <body>
        <%
            Date date=new Date();
            String responseString=request.getParameter("response");
            String course_id=request.getParameter("dropdown");
            String username=(String)session.getAttribute("username");
            String question_id="15";
            DataBase_Handler dbh=new DataBase_Handler();
            int user_id=dbh.username_to_id(username);
            int i=dbh.insert_courseware_studentmodule(user_id, responseString, question_id, course_id, 1);
            if(i==1)
            {    
                out.print("Successfully saved response !");
                response.sendRedirect("http://localhost:8080/Peer_assessment/lm2.jsp");
            }
            
            else
                out.print("Oh crap!"+i);
            %>
    </body>
</html>
