package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import helper_pack.*;

public final class CMS_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Initialize Ruberics </title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"boot.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\">\n");
      out.write("        <script lang=\"javascript\" src=\"support.js\" ></script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #a5adba\">\n");
      out.write("       <div class=\"back_image\">\n");
      out.write("            <div class=\"box\" align=\"center\">\n");
      out.write("                <div class=\"headder\" align=\"center\">\n");
      out.write("                    <h2 class=\"headder_color\">Self-Assessment</h2>\n");
      out.write("                </div>\n");
      out.write("                <div align=\"center\"  >\n");
      out.write("                    <form name=\"cms2_form\" method=\"POST\">\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"input-width text_color\">\n");
      out.write("                            Enter the number of Criteria for Evaluation : <input type=\"number\" name=\"no_cri\" min=\"1\" max=\"10\">\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                           \n");
      out.write("                            Select Criteria :\n");
      out.write("                            <select>\n");
      out.write("                                <option>Criteria 1</option>\n");
      out.write("                                <option>Criteria 2</option>\n");
      out.write("                                <option>Criteria 3</option>\n");
      out.write("                            </select>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"input-width_2\">\n");
      out.write("                            <h6 class=\"form-control headder headder_color\">Criteria Details</h6>\n");
      out.write("                            <br>\n");
      out.write("                            <input class=\"form-control\"  type=\"text\" name=\"set_cri_name\" placeholder=\"Set Criteria name\" size=\"10\" />\n");
      out.write("                            <br>\n");
      out.write("                            <textarea autocomplete=\"off\" placeholder=\"Criteria Prompt\" class=\"form-control\" name=\"set_prompt\" rows=\"2\" cols=\"20\" ></textarea>\n");
      out.write("                            <br>\n");
      out.write("                            <div style=\"padding: 15px ; align-content: center ; border: solid ; border-color: black ;\">\n");
      out.write("                                <h6>Feedback</h6>\n");
      out.write("                                <input type=\"radio\" name=\"feed_radio\" value=\"feedback\" />None<input type=\"radio\" name=\"feed_radio\" value=\"feedback\" />Optional \n");
      out.write("                                    <input type=\"radio\" name=\"feed_radio\" value=\"feedback\" />Required \n");
      out.write("                                  \n");
      out.write("                               \n");
      out.write("                                  \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"input-width text_color\">\n");
      out.write("                            Enter the number of Criteria for Evaluation : <input type=\"number\" name=\"no_cri\" min=\"1\" max=\"10\">\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                           \n");
      out.write("                            Select Option :\n");
      out.write("                            <select>\n");
      out.write("                                <option>Option 1</option>\n");
      out.write("                                <option>Option 2</option>\n");
      out.write("                                <option>Option 3</option>\n");
      out.write("                            </select>\n");
      out.write("                            <div class=\"input-width_2\">\n");
      out.write("                            <h6 class=\"form-control headder headder_color\">Option Details</h6>\n");
      out.write("                            <br>\n");
      out.write("                            <input class=\"form-control\"  type=\"text\" name=\"set_opt_name\" placeholder=\"Set Option name\" size=\"10\" />\n");
      out.write("                            <br>\n");
      out.write("                            <textarea autocomplete=\"off\" placeholder=\"Description\" class=\"form-control\" name=\"set_prompt\" rows=\"2\" cols=\"20\" ></textarea>\n");
      out.write("                            <br>\n");
      out.write("                            Number of Points : <input type=\"number\" name=\"points\" min=\"1\" max=\"10\" size=\"2\">\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            Please note that after filling details of each option press \"Done\" button and once pressed no changes would be allowed for the option.\n");
      out.write("                            <br>\n");
      out.write("                            So please carefully fill in the details !\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <input class=\" form-control buttonstyle_smaller\" type=\"button\" value=\"Done\" name=\"butt1\" onclick=\"butt_click()\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("       </div>\n");
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
