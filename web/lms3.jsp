<%-- 

    Document   : lms2.jsp
    Created on : 27 Jun, 2018, 4:55:10 PM
    Author     : Indranil
--%>
<%@page import="helper_pack.DataBase_Handler" %>
<%@page import="java.util.ArrayList" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peer Assessment</title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
        <script lang="javascript" src="support.js">
        </script>
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image">
            <div class="box" align="center">
                <div class="headder" align="center">
                    <%
                        DataBase_Handler dbh=new DataBase_Handler();
                        //int user_id=Integer.valueOf((String)session.getAttribute("id"));
                        int number_peer=5;//dbh.assessments_done(user_id,"Item 1","15")+1;
                        %>
                        <h2 class="headder_color">Assess Your Peer : <%= number_peer %></h2>
                </div>
                <div align="center"  >
                    <form name="lms3_form" method="POST">
                        <br>
                             <div class="input-width form-control prompt_box">
                                 <p><%= dbh.course_question("Item 1") %></p>
                             </div>
                            <br>
                            <div class="input-width">
                                 <textarea autocomplete="off" placeholder="Response" class="form-control" name="prompt" rows="4" cols="20" ></textarea>
                             </div>
                            <br>
                            <div class="criterias">
                                <%
                                    
                                    String course_id="Item 1",question_id="15";
                                    
                                    ArrayList ar=dbh.criteria(course_id, question_id);
                                    int n=ar.size(),i=0;
                                    System.out.println(ar);
                                    while(i<n)
                                    {
                                        String cri=(String)ar.get(i);
                                        System.out.println("ele :"+cri);
                                %>
                                <div class="criteria_box_header">
                                    <h5 class="headder_color" align="center"><%=ar.get(i).toString().toUpperCase() %></h5>
                                </div>
                                <div style="background: #dbdde0">
                                    <%
                                        ArrayList options=dbh.r_lms3_f1(0, course_id, question_id, cri);
                                        int j=0,m=options.size();
                                        while(j<m)
                                        {
                                    %>
                                    <input type="radio" name=<%=cri+"radio"%> value="radio1" ><%=options.get(j) %><br>
                                    <%j++;} %>
                                </div>
                                <div><br></div>
                                <%  
                                    
                                    i++;   }
                                
                                %>
                                
                            </div>
                                <br>
                            <div style="padding: 5px">
                                </div>
                            <input class="form-control buttonstyle_smaller" type="submit" value="Submit" name="submit" onclick="butt_click()"/>
                            
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>