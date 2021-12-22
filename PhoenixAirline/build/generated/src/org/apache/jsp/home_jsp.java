package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/clientSession.jsp");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            HttpSession session1 = request.getSession(false);
            
            if(session1.getAttribute("clientEmail") != null) {
                String clientEmail = (String)session1.getAttribute("clientEmail");
                request.setAttribute("clientEmail", clientEmail);
            }
            else {
                response.sendRedirect("loginClient.jsp");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <a href=\"loginClient.jsp\">Login Client</a>\n");
      out.write("        <a href=\"registerClient.jsp\">Join Us </a>\n");
      out.write("        <a href=\"loginStaff.jsp\">Login Staff</a>\n");
      out.write("        \n");
      out.write("        <h1>welcome</h1>\n");
      out.write("       \n");
      out.write("        <h3>Find my flight</h3>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("        ");

            if(request.getParameter("flightAvailability").equals("notAvailable")) {
                List availableFlightsList = (List) request.getAttribute("listOfAvailableFlights");
            Iterator it = availableFlightsList.iterator();
            while(it.hasNext()) {
        
      out.write("    \n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1>footer</h1>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
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
