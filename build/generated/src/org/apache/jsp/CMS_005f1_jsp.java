package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import helper_pack.*;

public final class CMS_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Assessment Init.</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"boot.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\">\n");
      out.write("        <script lang=\"javascript\" src=\"support.js\" ></script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #a5adba\">\n");
      out.write("        <div class=\"back_image\">\n");
      out.write("            <div class=\"box\" align=\"center\">\n");
      out.write("                <div class=\"headder\" align=\"center\">\n");
      out.write("                    <h2 class=\"headder_color\">Self-Assessment</h2>\n");
      out.write("                </div>\n");
      out.write("                <div align=\"center\"  >\n");
      out.write("                    <form name=\"cms1_form\" method=\"POST\">\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"input-width\">\n");
      out.write("                            <h6>Select Course:</h6>\n");
      out.write("                            <select class=\"form-control input-width\" name=\"dropdown\">\n");
      out.write("                                <option class=\"form-control\">Course 1</option>\n");
      out.write("                                <option class=\"form-control\">Course 2</option>\n");
      out.write("                                <option class=\"form-control\">Course 3</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"input-width\">\n");
      out.write("                            <textarea autocomplete=\"off\" placeholder=\"Set Prompt\" class=\"form-control\" name=\"set_prompt\" rows=\"4\" cols=\"20\" ></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"input-width div_outline\">\n");
      out.write("                            <h5 class=\"form-control\">Assignment Details :</h5>\n");
      out.write("                            <br>\n");
      out.write("                            Each Learner Must be graded by : <input  type=\"text\" name=\"set_assignment\" placeholder=\"\" size=\"2\" />\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                           Learner Must grade: <input  type=\"text\" name=\"must_grade\" placeholder=\"\" size=\"2\" />\n");
      out.write("                           <br>\n");
      out.write("                            <br>\n");
      out.write("                            Last Date of Submission <input type=\"date\" name=\"bday\">\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                        <input class=\" form-control buttonstyle_smaller\" type=\"button\" value=\"Next\" name=\"butt1\" onclick=\"butt_click()\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
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
