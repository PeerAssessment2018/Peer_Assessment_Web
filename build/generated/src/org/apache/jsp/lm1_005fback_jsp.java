package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import helper_pack.*;

public final class lm1_005fback_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Submit Your Response</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"box\" >\n");
      out.write("           <div align=\"center\">\n");
      out.write("            <form name=\"lms1_form\" method=\"POST\" action=\"lm1_submit.jsp\">\n");
      out.write("        <table border=\"1\" cellspacing=\"2\" cellpadding=\"2\" align=\"center\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Submit your Response: ");

                    String s1 = (String)session.getAttribute("username"); 
                    session.setAttribute("username", s1);
                    out.print(s1);
                
      out.write("</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Select Course:</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"dropdown\">\n");
      out.write("                            ");

                                Data_handler cc=new Data_handler(s1);
                                ResultSet rs=cc.get_courses();
                                while(rs.next())
                                {
                                   
                                
      out.write("\n");
      out.write("                                <option>");
      out.print(rs.getString("course_id") );
      out.write("</option>\n");
      out.write("                            ");
} 
      out.write("\n");
      out.write("                        </select></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Prompt :</td>\n");
      out.write("                    <td><textarea name=\"prompt\" rows=\"4\" cols=\"20\" placeholder=\"\">\n");
      out.write("                        </textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Your Response :</td>\n");
      out.write("                    <td><textarea name=\"response\" rows=\"4\" cols=\"20\" placeholder=\"\">\n");
      out.write("                        </textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align=\"left\"><input type=\"submit\" value=\"Submit\" name=\"submit\" /></td>\n");
      out.write("                    <td align=\"right\"><input TYPE=\"BUTTON\" VALUE=\"Save\" ONCLICK=\"button1()\" /></td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("                </form>\n");
      out.write("            </div> \n");
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
