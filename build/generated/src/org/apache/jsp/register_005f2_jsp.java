package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
 Class.forName("com.mysql.cj.jdbc.Driver"); 
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"boot.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #a5adba\">\n");
      out.write("        <div class=\"back_image\" >\n");
      out.write("        <div class=\"box_login\" align=\"center\">\n");
      out.write("        <div class=\"headder\" align=\"center\">\n");
      out.write("            <h2 class=\"headder_color\">Register</h2>\n");
      out.write("        </div>\n");
      out.write("        <div align=\"center\" >\n");
      out.write("            \n");
      out.write("            <form autocomplete=\"off\" name=\"registration_form\" action=\"register_back.jsp\" method=\"POST\" align=\"center\">\n");
      out.write("                <br>\n");
      out.write("                <h5 class=\"text_color\">Fill up the following to Register :</h5>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"input-width\"><input class=\"form-control\" type=\"text\" placeholder=\"User Name\" name=\"username\" size=\"10\" /></div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"input-width\"><input class=\"form-control\" type=\"password\" placeholder=\"Password\" name=\"password\"  size=\"10\" /></div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"input-width\"><input class=\"form-control\" type=\"text\" placeholder=\"First Name\" name=\"first\" size=\"10\" /></div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"input-width\"><input class=\"form-control\" type=\"text\" placeholder=\"Last Name\" name=\"last\" size=\"10\" /></div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"input-width\"><input class=\"form-control\" type=\"text\" placeholder=\"Email\" name=\"email\"  size=\"10\" /></div>\n");
      out.write("                <br>\n");
      out.write("                <div>\n");
      out.write("                <input class=\"form-control buttonstyle\" type=\"submit\" value=\"Register\" name=\"register\" /></div>\n");
      out.write("                <!--<table>\n");
      out.write("                    <thead>\n");
      out.write("                    <th colspan=\"2\" align=\"center\">Fill up the following to Register :</th>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("        \t\t<td>UserName :</td>\n");
      out.write("        \t\t<td><input class=\"form-control\" type=\"text\" name=\"username\" value=\"\" size=\"20\" /></td>\n");
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
      out.write("        \t\t<td></td>\n");
      out.write("        \t\t<td><input type=\"submit\" value=\"Submit\" name=\"submit_button\"  /><input align=\"right\" type=\"reset\" value=\"Reset\" name=\"reset_button\" /></td>\n");
      out.write("        \t</tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table> -->\n");
      out.write("            </form>\n");
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
