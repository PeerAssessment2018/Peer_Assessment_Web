package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import helper_pack.*;

public final class lms1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Submit Your Response</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"boot.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\">\n");
      out.write("        <script src=\"support.js\"></script>\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            function test_session()\n");
      out.write("            {   \n");
      out.write("                        alert(\"hello! 11\");\n");
      out.write("                        ");
 session.setAttribute("state_s", "1");
                            //System.out.println(request.getAttribute("response"));
      out.write("\n");
      out.write("                                window.location=\"lms1_save.jsp\";\n");
      out.write("            }\n");
      out.write("           function test_session2()\n");
      out.write("            {   \n");
      out.write("                        alert(\"hello! 22\");\n");
      out.write("                        ");
 //session.setAttribute("state_s", "2"); 
      out.write("\n");
      out.write("                                window.location=\"lms1_save.jsp\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #a5adba\">\n");
      out.write("        <div class=\"back_image\">\n");
      out.write("            <div class=\"box\" align=\"center\">\n");
      out.write("                <div class=\"headder\" align=\"center\">\n");
      out.write("                    <h2 class=\"headder_color\">Submit Your Response</h2>\n");
      out.write("                </div>\n");
      out.write("                <div align=\"center\"  >\n");
      out.write("                     <form name=\"lms1_form\" method=\"POST\" action=\"lms1_save.jsp\"> \n");
      out.write("                         ");

                             String s1 = (String)session.getAttribute("username"); 
                             session.setAttribute("username", s1);
                             //session.setAttribute("id", session.getAttribute("id"));
                             DataBase_Handler dbh=new DataBase_Handler();
                             String s=dbh.course_question("Item 1");
                             System.out.println(s);
                         
      out.write("\n");
      out.write("                         <br>\n");
      out.write("                             <div class=\"input-width form-control prompt_box\">\n");
      out.write("                                 <p>");
      out.print( dbh.course_question("Item 1") );
      out.write("</p>\n");
      out.write("                             </div>\n");
      out.write("                         <br>\n");
      out.write("                             <div class=\"input-width\">\n");
      out.write("                                <textarea placeholder=\"Response\" class=\"form-control\" name=\"response\" value=\"response\" rows=\"4\" cols=\"20\"></textarea>\n");
      out.write("                                \n");
      out.write("                                <!-- <input type=\"text\" name=\"response\" placeholder=\"response\" > -->\n");
      out.write("                             \n");
      out.write("                             </div>  \n");
      out.write("                        <br>\n");
      out.write("                            <div style=\"padding: 5px\">\n");
      out.write("                                </div>\n");
      out.write("                            <button class=\"form-control buttonstyle_smaller\" type=\"submit\" value=\"Save\" name=\"submit\" onclick=\"test_session()\"/>\n");
      out.write("                            <br>\n");
      out.write("                            <button class=\"form-control buttonstyle_smaller\" type=\"submit\" value=\"Submit\" name=\"submit\" onclick=\"test_session2()\"/>\n");
      out.write("                </form>\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("        \n");
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
