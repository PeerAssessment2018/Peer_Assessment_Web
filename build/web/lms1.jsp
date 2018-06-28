<%-- 
    Document   : lms1.jsp
    Created on : 27 Jun, 2018, 2:15:54 PM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lms1</title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
        <SCRIPT LANGUAGE="JavaScript">
        function button1()
        {
            document.form1.buttonName.value = "yes";
            alert("saving")
            lms1_form.submit();
        } 
    </SCRIPT>
    </head>
    <body style="background-color: #a5adba">
        <%!
            class Connector_class
            {
                String URL="jdbc:mysql://localhost:3306/peer_assessment";
                String user="root",password="";
Connection connection;
PreparedStatement ps;
ResultSet rs=null;
int numberof_courses;
                public Connector_class(String user_name)
                {
                    try {
                            connection=DriverManager.getConnection(URL,user,password);
                        System.out.println("Connection Established !");
                        /*int user_id=get_userid(user_name);
                        out.print("user_id : "+user_id);*/
                         ps=connection.prepareStatement("SELECT DISTINCT course_id from student_courseenrollment"); //where user_id=?);
                         //ps.setInt(1, user_id);
                         rs=ps.executeQuery();
                         numberof_courses=0;
                         while(rs.next())
                                numberof_courses++;
                    } 
                         catch (Exception e) 
                        {
                            e.printStackTrace();
                        }
                }
                public ResultSet get_courses()
                {
                    ResultSet resultSet=null;
                    try {
                            resultSet=ps.executeQuery();
                        } catch (Exception e) {
                        }
                    return resultSet;
                }
                public int get_userid(String username)
                {
                    int user_id=0;
                    try {
                           ps=connection.prepareStatement("Select user_id from student_data where username='"+username+"'");
                           ResultSet rs=ps.executeQuery();
                           rs.next();
                           user_id=rs.getInt("user_id");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    return user_id;
                }
            }
            
            %>
            <div class="back_image">
                <div class="box" align="center">
                    <div class="headder" align="center">
                        <h2 class="headder_color">Submit Your Response</h2>
                    </div>
                    <div align="center"  >
                        <form name="lms1_form" method="POST">
                
            
        <table border="1" cellspacing="2" cellpadding="2" align="center">
            <thead>
                <tr>
                    <th>Submit your Response: <%
                    String s1 = (String)session.getAttribute("username"); 
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
                                Connector_class cc=new Connector_class(s1);
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
                    <td><textarea name="prompt" rows="4" cols="20">
                        </textarea></td>
                </tr>
                <tr>
                    <td>Your Response :</td>
                    <td><textarea name="response" rows="4" cols="20">
                        </textarea></td>
                </tr>
                <tr>
                    <% 
                        int submit_response=0;
        if(request.getParameter("save") != null) {
               //session.setAttribute("status", "guest");
               try{
               request.getParameter("dropdown");
               cc.ps=cc.connection.prepareStatement("Insert into courseware_studentmodule(state,course_id) VALUES (?,?) where user_id=?");
               cc.ps.setString(1,request.getParameter("response"));
               cc.ps.setString(2, request.getParameter("dropdown"));
               cc.ps.setString(3, s1);
               submit_response=cc.ps.executeUpdate();
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
        }
        if(submit_response==1)
            out.print("Success response !");
    %>
                    <td align="left"><input type="submit" value="Submit" name="submit" /></td>
                    <td align="right"><input TYPE="BUTTON" VALUE="Save" ONCLICK="button1()" /></td>
                </tr>
            </tbody>
        </table>
           </form> 
                    </div>
            
                </div>
            </div>
    </body>
</html>
