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
        <title>Learn to Assess</title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
        <% System.out.println("yaha tak !");
                                    boolean f=false;
                                    if(session.getAttribute("state_learn")==null);
                                        
                                    else if(session.getAttribute("state_learn").equals("1"))
                                    {
                                            response.sendRedirect("lms3.jsp");
                                    }
                                    else if(session.getAttribute("state_learn").equals("0"))
                                    {
                                            f=true;
                                    }
                                    String course_id="Item 1",question_id="15";
                                    DataBase_Handler dbh=new DataBase_Handler();
                                    String answerString=dbh.get_sample_answers("Item 1","15").get(0);
                                    ArrayList ar=dbh.get_sample_criteria(course_id, question_id,answerString);
                                    int n=ar.size(),i=0;
                                    System.out.println(ar);
                                    String cri[]=new String[n];
                                   
        %>
        <script language="javascript">
            
            function check_for_correct()
            {
                        <% for(int k=0;k<cri.length;k++) 
                        {%>
                            
                if(document.querySelector('input[name="<%=cri[i]%>"]:checked').value==)
                <%} %>
        {
            alert("Congrats !");
        }
        else
        {
            alert("try again !");
            }
        }
        </script>
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image">
            <div class="box" align="center">
                <div class="headder" align="center">
                    <h2 class="headder_color">Learn to Assess</h2>
                </div>
                <div align="center"  >
                    <form name="lms2_form" method="POST" action="lms2_back.jsp">
                            <br>
                            <%  %>
                             <div class="input-width form-control prompt_box">
                                 <p><%= dbh.course_question("Item 1") %></p>
                             </div>
                            <br>
                             <div class="input-width form-control prompt_box">
                                 <p><%= answerString %></p>
                             </div>
                            <br>
                            <div class="criterias">
                                <%
                                    
                                    
                                    while(i<n)
                                    {
                                        cri[i]=(String)ar.get(i);
                                        System.out.println("ele :"+cri[i]);
                                %>
                                <div class="criteria_box_header">
                                    <h5 class="headder_color" align="center"><%=ar.get(i).toString().toUpperCase() %></h5>
                                </div>
                                <div style="background: #dbdde0">
                                    <%
                                        ArrayList options=dbh.r_lms3_f1(0, course_id, question_id, cri[i]);
                                        int j=0,m=options.size();
                                        while(j<m)
                                        {
                                            System.out.println(i+"radio");
                                    %>
                                    <input type="radio" class="" name=<%=i+"radio"%> value="<%=options.get(j)%>" ><%=options.get(j) %><br>
                                    <%j++;} %>
                                </div>
                                <div><br></div>
                                <%  
                                    
                                    i++;   }
                                
                                %>
                                
                            </div>
                                <% 
                                    if(f)
                                    {
                                %>
                                <h6>Incorrect Selection</h6>
                                <% } %>
                                <br>
                            <div style="padding: 5px">
                                </div>
                            <input class="form-control buttonstyle_smaller" type="submit" value="Check" name="login" />
                            
                    </form>
                </div>
            </div>
        </div>
                            <script lang="javascript">
                                function butt_click()
                                {
                                    alert("clicked");
                                }
                                </script>
    </body>
</html>
