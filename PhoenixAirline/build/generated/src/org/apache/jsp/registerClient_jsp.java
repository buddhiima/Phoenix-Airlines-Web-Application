package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerClient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Join Us</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <form action=\"./registerClient\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("            \n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Full Name (as per passport)</td>\n");
      out.write("                        <td><input type=\"text\" name=\"clientName\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Date Of Birth</td>\n");
      out.write("                        <td><input type=\"date\" name=\"clientDOB\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Gender</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"radio\" name=\"clientGender\" value=\"Male\" /> Male\n");
      out.write("                            <input type=\"radio\" name=\"clientGender\" value=\"Female\" /> Female\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email</td>\n");
      out.write("                        <td><input type=\"email\" name=\"clientEmail\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Contact</td>\n");
      out.write("                        <td><input type=\"text\" name=\"clientTel\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>House No</td>\n");
      out.write("                        <td><input type=\"text\" name=\"clientHouseNo\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Street Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"clientStreetName\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>City</td>\n");
      out.write("                        <td><input type=\"text\" name=\"clientCity\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Province</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"clientProvince\">\n");
      out.write("                                <option>Western</option>\n");
      out.write("                                <option>North Western</option>\n");
      out.write("                                <option>Central</option>\n");
      out.write("                                <option>Eastern</option>\n");
      out.write("                                <option>Southern</option>\n");
      out.write("                                <option>Northern</option>\n");
      out.write("                                <option>North Central</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>New Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"clientPassword\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Retype Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"RetypeClientPassword\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Profile Photo</td>\n");
      out.write("                        <td><input type=\"file\" name=\"profilePhoto\" accept=\"image/png,image/jpeg\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Security Question</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"clientSecurityQuestion\">\n");
      out.write("                                <option>What is the name of your first pet?</option>\n");
      out.write("                                <option>What was your childhood nickname?</option>\n");
      out.write("                                <option>What is your maternal grandmother's maiden name?</option>\n");
      out.write("                                <option>In which city/town was your first job?</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Answer</td>\n");
      out.write("                        <td><input type=\"text\" name=\"clientAnswer\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"checkbox\" name=\"agreeToTerms\" value=\"ON\" />\n");
      out.write("                            I agree to the <a href=\"\">Terms of Service and Privacy Policy</a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" value=\"Sign Up\" /></td>\n");
      out.write("                        <td><input type=\"reset\" value=\"Cancel\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
