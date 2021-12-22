package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Iterator;

public final class viewFlightsG2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Flights</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            List flightList = (List) request.getAttribute("listOfFlights");
        
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"./filterFlights\">\n");
      out.write("              \n");
      out.write("            <h3>Filter flights by</h3>\n");
      out.write("\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Destination</td>\n");
      out.write("                    <td><input type=\"text\" name=\"destination\" value=\"\" /></td>\n");
      out.write("                    <td>Available Day</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"availableDay\">\n");
      out.write("                            <option> </option>\n");
      out.write("                            <option>Sunday</option>\n");
      out.write("                            <option>Monday</option>\n");
      out.write("                            <option>Tuesday</option>\n");
      out.write("                            <option>Wednesday</option>\n");
      out.write("                            <option>Thursday</option>\n");
      out.write("                            <option>Friday</option>\n");
      out.write("                            <option>Saturday</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td><input type=\"submit\" value=\"Filter\" /></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form> \n");
      out.write("        \n");
      out.write("        <form action=\"./viewFlights\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Remove filters\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <th>Flight ID</th>\n");
      out.write("                <th>Destination</th>\n");
      out.write("                <th>Available Day</th>\n");
      out.write("                <th>Time of Departure</th>\n");
      out.write("                <th>Number of Seats</th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

                Iterator it = flightList.iterator();
                while(it.hasNext()) { 
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(it.next());
      out.write("</td>\n");
      out.write("                        \n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"\">\n");
      out.write("                            <input type=\"hidden\" name=\"flightID\" value=\"");
      out.print(it.next());
      out.write("\">\n");
      out.write("                        </form>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"\">\n");
      out.write("                            <input type=\"hidden\" name=\"flightID\" value=\"");
      out.print(it.next());
      out.write("\">\n");
      out.write("                        </form>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("               ");
 }
            
      out.write("\n");
      out.write("            \n");
      out.write("        </table>\n");
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
