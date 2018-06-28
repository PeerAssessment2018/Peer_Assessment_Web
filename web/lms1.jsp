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
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image">
            <div class="box" align="center">
                <div class="headder" align="center">
                    <h2 class="headder_color">Submit Your Response</h2>
                </div>
                <div align="center"  >
                     <form name="lms1_form" method="POST" action="lm1_submit.jsp"> 
                         <%
                             String s1 = (String)session.getAttribute("username"); 
                             session.setAttribute("username", s1);
                             DataBase_Handler dbh=new DataBase_Handler();
                             String s=dbh.course_question("Item 1");
                             System.out.println(s);
                         %>
                         <br>
                             <div class="input-width form-control prompt_box">
                                 <p><%= dbh.course_question("Item 1") %></p>
                             </div>
                         <br>
                             <div class="input-width">
                                 <textarea class="form-control" autocomplete="off" placeholder="Response" class="form-control" name="response" rows="4" cols="20"></textarea>
                             </div>  
                        </select>
                        <br>
                            <div style="padding: 5px">
                                </div>
                            <input class="form-control buttonstyle_smaller" type="" value="Save" name="login" onclick="butt_click()"/>
                            <br>
                            <input class="form-control buttonstyle_smaller" type="" value="Submit" name="login" onclick="butt_click()"/>
                            
                            
                </form>
                </div>
               
            </div> 
        </div>
        </div>
        
    </body>
</html>
