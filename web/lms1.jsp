<%-- 
    Document   : lm1_back.jsp
    Created on : 27 Jun, 2018, 3:28:32 PM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Your Response</title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
        <script src="support.js"></script>
        <script language="javascript">
            function test_session()
            {   
                        alert("hello! 11");
                        <% session.setAttribute("state_s", "1");
                            //System.out.println(request.getAttribute("response"));%>
                                window.location="lms1_save_1.jsp";
            }
            /*function save_data()
            {
            }*/
           function test_session2()
            {   
                        alert("hello! 22");
                        <% session.setAttribute("state_s", "2"); %>
                                window.location="lms1_save_2.jsp";
            }
        </script>
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image">
            <div class="box" align="center">
                <div class="headder" align="center">
                    <h2 class="headder_color">Submit Your Response</h2>
                </div>
                <div align="center"  >
                     <form name="lms1_form" method="POST" action=""> 
                         <%
                             String s1 = (String)session.getAttribute("username"); 
                             session.setAttribute("username", s1);
                             //session.setAttribute("id", session.getAttribute("id"));
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
                                <textarea placeholder="Response" class="form-control" name="response" value="response" rows="4" cols="20"></textarea>
                                
                                <!-- <input type="text" name="response" placeholder="response" > -->
                             
                             </div>  
                        <br>
                            <div style="padding: 5px">
                                </div>
                        <button class="form-control buttonstyle_smaller" type="button" value="Save" name="submit" onclick="test_session()">Save</button>
                            <br>
                            <button class="form-control buttonstyle_smaller" type="button" value="Submit" name="submit2" onclick="test_session2()">Submit</button>
                </form>
                </div>
               
            </div> 
        </div>
        
    </body>
</html>
