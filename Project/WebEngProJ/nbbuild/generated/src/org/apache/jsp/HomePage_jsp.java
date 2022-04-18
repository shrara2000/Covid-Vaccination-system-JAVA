package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("    <title>Just Vaccine</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <img src=\"icon.jpg\" alt=\"\" width=\"80 px\" height=\"80 px\">\r\n");
      out.write("    <H1 style=\"display: inline;\">Just Vaccine</H1>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"NurseLogin.jsp\"><button class=\"button-33\" style=\"float: right; margin-top: 24px;\">Nurse\r\n");
      out.write("            Login</button></a>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form-center\">\r\n");
      out.write("        <form action=\"CLogin\" method =\"POST\" >\r\n");
      out.write("            <div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div><label for=\"Id\" style=\"color: #009688;font-weight: bold;\">ID number</label></div>\r\n");
      out.write("                <input type=\"text\" name=\"ID\" id=\"Id\" class=\"button-33\" required>\r\n");
      out.write("                <br>\r\n");
      out.write("                <br>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-center\"><input type=\"submit\" value=\"Go --->\" class=\"button-33\"></div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- nursform -->\r\n");
      out.write("    <!-- <div class=\"form-center\">\r\n");
      out.write("        <form action=\"\" class=\"\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div><label for=\"un\" style=\"color: #009688;font-weight: bold;\">Username</label></div>\r\n");
      out.write("                <input type=\"text\" name=\"\" id=\"un\" class=\"button-33\" required>\r\n");
      out.write("                <br>\r\n");
      out.write("                <br>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div><label for=\"pw\" style=\"color: #009688;font-weight: bold;\">Password</label></div>\r\n");
      out.write("            <input type=\"password\" name=\"\" id=\"pw\" class=\"button-33\" required>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"form-center\"><input type=\"submit\" value=\"Login\" class=\"button-33\"></div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
