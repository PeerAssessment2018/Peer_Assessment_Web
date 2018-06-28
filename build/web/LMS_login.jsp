<%-- 
    Document   : login_page
    Created on : 27 Jun, 2018, 10:56:42 AM
    Author     : Indranil
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*" %>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
         <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image" >
        <div class="box_login" align="center">
            
<div class="headder" align="center">
            <h2 class="headder_color">Login</h2>
            <h6 style="color: white">(for peer assessment)</h6>
        </div>
       <%!
            public class Actor{
            
String URL="jdbc:mysql://localhost:3306/peer_assessment";
String user="root",password="";
Connection connection;
PreparedStatement ps;
ResultSet rs=null;
public Actor()
{
try{
    connection=DriverManager.getConnection(URL,user,password);
    System.out.println("Connection Established  !");
    //ps=connection.prepareStatement("Select * from student_data");
ps=connection.prepareStatement("SELECT password from student_data where username=?");
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
public ResultSet get_result()
{
try{
    rs=ps.executeQuery();
    
}
catch(Exception ex)
{
ex.printStackTrace();
}
return rs;
}

public String get_password(String username)
{
String pass="";
    try {
            ps.setString(1,username.trim());
        ResultSet rs=ps.executeQuery();
        rs.next();
        pass=rs.getString("password");
        } catch (Exception e) {
        }
return pass;
}

public int check_valid_login(String usernameString,String passwordS)
{
int f=0;
try {
        String s1=get_password(usernameString);
        if(s1.equals(passwordS))
            f=1; 
    } catch (Exception e) {
    }
return f;
}
   }     %>
   <div align="center">
   
   
        <form autocomplete="off" name="login" action="LMS_login.jsp" method="POST" align="center" >
        <br>
        <div class="input-width">
            <input autocomplete="off" class="form-control" type="text" placeholder="User Name" name="username" size="10" />
        </div>
        <br>
        <div class="input-width">
            <input autocomplete="off" class="form-control" type="password" placeholder="Password" name="password" size="10" />
        </div>
        <br>
        <input class="form-control buttonstyle" type="submit" value="Login" name="login" />
                
        </form>
   </div>
            <br>
            <br>
            <br>
            <p>New to portal ? <a href="register_LMS.jsp">Sign Up</a>!</p>
            <br>
           <%
               String userString=request.getParameter("username");
               String passwordString=request.getParameter("password");
               
               Actor ar=new Actor();
               int t=ar.check_valid_login(userString, passwordString);
               if(t==1)
               {
                   out.print("Succeccful login!");
                   String redirectURL = "lm1_back.jsp";
                   session.setAttribute("username", userString);
                  // session.setAttribute("id", value);
                  DataBase_Handler dbh=new DataBase_Handler();
                  int user_id=dbh.username_to_id(userString);
                  System.out.println("id"+user_id);
                  ArrayList course=dbh.courses_enrolled(user_id);
                  
                  //selecting the first course only
                  String question_id="15";
                  
                  int n=dbh.response_submitted(user_id,(String)course.get(0));
                  String s="",s2="";
                  System.out.println("n:"+n);
                  if(n==0)
                  {
                      s=dbh.response_for_id(user_id, (String)course.get(0), question_id);
                  }
                  else if(n==1)
                  {
                      redirectURL="";
                      redirectURL="lms2.jsp";
                      System.out.println(redirectURL);
                  }
                  else
                  {
                      s="";
                  }
                    session.setAttribute("set_answer",s);
                    response.sendRedirect(redirectURL);
               }
               
               else
                System.out.print("Login unsuccessful!"+t+ar.get_password(userString));
               %>
        </div>
         </div>   
        </div>
    </body>
</html>
