package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                public class Actor{
            
String URL="jdbc:mysql://localhost:3306/peer_assessment";
String user="root",password="";
Connection connection;
PreparedStatement ps=null;
ResultSet rs=null;
public Actor()
{
try{
    connection=DriverManager.getConnection(URL,user,password);
    System.out.println("Connection Established !");
    ps=connection.prepareStatement("INSERT INTO student_data(username,first_name,last_name,password,email) VALUES(?,?,?,?,?)");
    
    //ps=connection.prepareStatement("Select * from student_data");
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
public int insert(String usernameString,String firstString,String lastString,String passString,String email)
{
int f=0;
try {
        ps.setString(1, usernameString);
        ps.setString(2, firstString);
        ps.setString(3, lastString);
ps.setString(4, passString);
ps.setString(5, email);
f=ps.executeUpdate();
    } catch (Exception e) {
e.getStackTrace();
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

      out.write('\n');
      out.write('\n');
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register for the course</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"register\" action=\"index.jsp\" method=\"POST\">\n");
      out.write("        <table border=\"0\">\n");
      out.write("            ");
      out.write("\n");
      out.write("                \n");
      out.write("    ");

        int res=0;
        String usernameString,firString,laString,emailString,password;
        usernameString=request.getParameter("username");
        firString=request.getParameter("first");
        laString=request.getParameter("last");
        emailString=request.getParameter("email");
        password=request.getParameter("password");
        
        Actor ar=new Actor();
        int f=ar.insert(usernameString, firString, laString, password, emailString);
        
    
      out.write("            \n");
      out.write("        <tbody>\n");
      out.write("        \t<tr>\n");
      out.write("        \t\t<td>UserName :</td>\n");
      out.write("        \t\t<td><input type=\"text\" name=\"username\" value=\"\" size=\"20\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("                <tr>\n");
      out.write("        \t\t<td>First Name :</td>\n");
      out.write("        \t\t<td><input type=\"text\" name=\"first\" value=\"\" size=\"20\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("                <tr>\n");
      out.write("        \t\t<td>Last Name :</td>\n");
      out.write("        \t\t<td><input type=\"text\" name=\"last\" value=\"\" size=\"20\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("        \t<tr>\n");
      out.write("        \t\t<td>Password :</td>\n");
      out.write("        \t\t<td><input type=\"password\" name=\"password\" value=\"\" size=\"20\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("                <tr>\n");
      out.write("        \t\t<td>Email :</td>\n");
      out.write("        \t\t<td><input type=\"text\" name=\"email\" value=\"\" size=\"20\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("        \t<tr>\n");
      out.write("        \t\t<td><input type=\"submit\" value=\"Submit\" name=\"submit_button\" /></td>\n");
      out.write("        \t\t<td><input type=\"reset\" value=\"Reset\" name=\"reset_button\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("        </tbody>\n");
      out.write("        </table>\n");
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
