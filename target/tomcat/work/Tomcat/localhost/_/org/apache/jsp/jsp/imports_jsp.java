/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-03-17 16:02:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class imports_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<script>let contextPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";</script>\r\n");
      out.write("<script>let letterList = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.letterListString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";</script>\r\n");
      out.write("<script>let nameLength = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.nameLength}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";</script>\r\n");
      out.write("<script>let vowels = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.vowels}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";</script>\r\n");
      out.write("<script>let consonants = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.consonants}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";</script>\r\n");
      out.write("<script>let generateLastName = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.generateLastName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";</script>\r\n");
      out.write("<script src=\"../static/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<script src=\"../static/js/bootstrap.bundle.js\"></script>\r\n");
      out.write("<link href=\"../static/css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../static/css/bootstrap-select.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"../static/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"../static/js/clipboard.min.js\"></script>\r\n");
      out.write("<script src=\"../static/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<link href=\"../static/css/jquery.dataTables.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../static/css/simple-sidebar.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../static/css/namesTable.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../static/css/page-pattern.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../static/css/output.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../static/css/slider.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script src=\"../static/js/nameGeneration.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../static/js/auth.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Lobster&display=swap\" rel=\"stylesheet\">\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
