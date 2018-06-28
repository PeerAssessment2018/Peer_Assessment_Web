package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;
import helper_pack.*;

public final class login_005fpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
   }     
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("         <link rel=\"stylesheet\" href=\"boot.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #a5adba\">\n");
      out.write("        <div class=\"back_image\" >\n");
      out.write("        <div class=\"box_login\" align=\"center\">\n");
      out.write("            \n");
      out.write("<div class=\"headder\" align=\"center\">\n");
      out.write("            <h2 class=\"headder_color\">Login</h2>\n");
      out.write("            <h6 style=\"color: white\">(for peer assessment)</h6>\n");
      out.write("        </div>\n");
      out.write("       ");
      out.write("\n");
      out.write("   <div align=\"center\">\n");
      out.write("   \n");
      out.write("   \n");
      out.write("        <form autocomplete=\"off\" name=\"login\" action=\"login_page.jsp\" method=\"POST\" align=\"center\" >\n");
      out.write("        <br>\n");
      out.write("        <div class=\"input-width\">\n");
      out.write("            <input autocomplete=\"off\" class=\"form-control\" type=\"text\" placeholder=\"User Name\" name=\"username\" size=\"10\" />\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"input-width\">\n");
      out.write("            <input autocomplete=\"off\" class=\"form-control\" type=\"password\" placeholder=\"Password\" name=\"password\" size=\"10\" />\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <input class=\"form-control buttonstyle\" type=\"submit\" value=\"Login\" name=\"login\" />\n");
      out.write("                \n");
      out.write("        </form>\n");
      out.write("   </div>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("           ");

               String userString=request.getParameter("username");
               String passwordString=request.getParameter("password");
               
               Actor ar=new Actor();
               int t=ar.check_valid_login(userString, passwordString);
               if(t==1)
               {
                   out.print("Succeccful login!");
                   String redirectURL = "http://localhost:8080/Peer_assessment/lm1_back.jsp";
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
                      redirectURL="http://localhost:8080/Peer_assessment/lms2.jsp";
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
               out.print("Login unsuccessful!"+t+ar.get_password(userString));
               
      out.write("\n");
      out.write("        </div>\n");
      out.write("         </div>   \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
