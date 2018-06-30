package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import helper_pack.DataBase_Handler;
import java.util.ArrayList;

public final class lms3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Peer Assessment</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"boot.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\">\n");
      out.write("        <script lang=\"javascript\" src=\"support.js\">\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #a5adba\">\n");
      out.write("        <div class=\"back_image\">\n");
      out.write("            <div class=\"box\" align=\"center\">\n");
      out.write("                <div class=\"headder\" align=\"center\">\n");
      out.write("                    ");

                        DataBase_Handler dbh=new DataBase_Handler();
                        //int user_id=Integer.valueOf((String)session.getAttribute("id"));
                        int number_peer=5;//dbh.assessments_done(user_id,"Item 1","15")+1;
                        
      out.write("\n");
      out.write("                        <h2 class=\"headder_color\">Assess Your Peer : ");
      out.print( number_peer );
      out.write("</h2>\n");
      out.write("                </div>\n");
      out.write("                <div align=\"center\"  >\n");
      out.write("                    <form name=\"lms3_form\" method=\"POST\">\n");
      out.write("                        <br>\n");
      out.write("                             <div class=\"input-width form-control prompt_box\">\n");
      out.write("                                 <p>");
      out.print( dbh.course_question("Item 1") );
      out.write("</p>\n");
      out.write("                             </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"input-width\">\n");
      out.write("                                 <textarea autocomplete=\"off\" placeholder=\"Response\" class=\"form-control\" name=\"prompt\" rows=\"4\" cols=\"20\" ></textarea>\n");
      out.write("                             </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"criterias\">\n");
      out.write("                                ");

                                    
                                    String course_id="Item 1",question_id="15";
                                    
                                    ArrayList ar=dbh.criteria(course_id, question_id);
                                    int n=ar.size(),i=0;
                                    System.out.println(ar);
                                    while(i<n)
                                    {
                                        String cri=(String)ar.get(i);
                                        System.out.println("ele :"+cri);
                                
      out.write("\n");
      out.write("                                <div class=\"criteria_box_header\">\n");
      out.write("                                    <h5 class=\"headder_color\" align=\"center\">");
      out.print(ar.get(i).toString().toUpperCase() );
      out.write("</h5>\n");
      out.write("                                </div>\n");
      out.write("                                <div style=\"background: #dbdde0\">\n");
      out.write("                                    ");

                                        ArrayList options=dbh.r_lms3_f1(0, course_id, question_id, cri);
                                        int j=0,m=options.size();
                                        while(j<m)
                                        {
                                    
      out.write("\n");
      out.write("                                    <input type=\"radio\" name=");
      out.print(cri+"radio");
      out.write(" value=\"radio1\" >");
      out.print(options.get(j) );
      out.write("<br>\n");
      out.write("                                    ");
j++;} 
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div><br></div>\n");
      out.write("                                ");
  
                                    
                                    i++;   }
                                
                                
      out.write("\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                                <br>\n");
      out.write("                            <div style=\"padding: 5px\">\n");
      out.write("                                </div>\n");
      out.write("                            <input class=\"form-control buttonstyle_smaller\" type=\"submit\" value=\"Submit\" name=\"submit\" onclick=\"butt_click()\"/>\n");
      out.write("                            \n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
