<%-- 
    Document   : lms2_back
    Created on : 5 Jul, 2018, 11:32:24 AM
    Author     : Indranil
--%>
<%@page import="helper_pack.DataBase_Handler" %>
<%@page import="java.util.ArrayList" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lms back</title>
    </head>
    <body>
        <h1>LMs back</h1>
        <p>
            <% 
                DataBase_Handler dbh=new DataBase_Handler();
                    String course_id="Item 1",question_id="15";
                                    String answerString=dbh.get_sample_answers("Item 1","15").get(0);
                                    ArrayList ar=dbh.get_sample_criteria(course_id, question_id,answerString);
                                    ArrayList ar2=dbh.get_correct_option(course_id, question_id, answerString);
                                    int n=ar.size(),i=0;
                                    out.println(ar);
                                    out.println(ar2);
                                    String cri[]=new String[n];
                                    String opt[]=new String[n];
                                    while(i<n)
                                    {
                                        cri[i]=(String)ar.get(i);
                                        opt[i]=(String)ar2.get(i++);
                                    }
                                    
                                    i=0;
                                    boolean f=false;
                                    while(i<n)
                                    { %>
                                    <% 
                                        String str=request.getParameter(i+"radio");
                                        out.print(str+" "+opt[i]+"\n"); 
                                        if(str.equals(opt[i]))
                                            f=true;
                                        else
                                            break;
                                        
                                    %>
                                   <% i++;} 
                                   
                                   
                                   if(f)
                                    {    
                                        out.print("Correct !");
                                        session.setAttribute("state_learn", "1");
                                    }
                                    else
                                    {
                                        out.print("In-Correct !");
                                        session.setAttribute("state_learn", "0");
                                    }
                                    response.sendRedirect("lms2.jsp");
                                   %>
        </p>
    </body>
</html>
