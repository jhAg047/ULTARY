/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.53
 * Generated at: 2020-04-22 12:07:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.myUltary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;
import java.util.ArrayList;
import member.model.vo.*;

public final class markMember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/views/myUltary/navaside.jsp", Long.valueOf(1587544472285L));
    _jspx_dependants.put("/views/myUltary/chat.jsp", Long.valueOf(1587544472405L));
    _jspx_dependants.put("/views/myUltary/myUltaryheader.jsp", Long.valueOf(1587544472478L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("member.model.vo");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	Member loginUser = (Member)session.getAttribute("loginUser");
	Media proImg = (Media)session.getAttribute("proImg");
	ArrayList<Member> markList = (ArrayList)request.getAttribute("markList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>관심회원</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/myUltary/markMember.css\">\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/myUltary/chat.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"chatdiv\">\r\n");
      out.write("\t\t<div id=\"chatdivleft\">\r\n");
      out.write("\t\t\t<div id=\"chatdivleft1\">\r\n");
      out.write("\t\t\t\t<img id=\"individualtalk\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/갠톡.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"chatdivleft2\">\r\n");
      out.write("\t\t\t\t<img id=\"grouptalk\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/단체톡.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"chatdivright\">\r\n");
      out.write("\t\t\t<div id=\"chattitle\">울타리 톡</div>\r\n");
      out.write("\t\t\t<div id=\"chatsearch\">\r\n");
      out.write("\t\t\t\t<div id=\"chatsearchdiv\">\r\n");
      out.write("\t\t\t\t\t<img id=\"chatsearchimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/검색.png\">\r\n");
      out.write("\t\t\t\t\t<input id=\"chatsearchtext\" type=\"search\" placeholder=\"검색할 회원이나 채팅방을 입력해주세요.\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"chatcontent\">\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentprofile\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofileimg\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"chatcontentimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofilename\">\r\n");
      out.write("\t\t\t\t\t\t닉네임\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentright\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent1\">대화내용1</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent2\">대화내용2</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent3\">대화내용3</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightR\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentnum\">5</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentfix\">☆</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"chatcontent\">\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentprofile\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofileimg\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"chatcontentimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofilename\">\r\n");
      out.write("\t\t\t\t\t\t닉네임\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentright\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent1\">대화내용1</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent2\">대화내용2</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent3\">대화내용3</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightR\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentnum\">5</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentfix\">☆</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"chatcontent\">\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentprofile\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofileimg\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"chatcontentimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofilename\">\r\n");
      out.write("\t\t\t\t\t\t닉네임\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentright\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent1\">대화내용1</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent2\">대화내용2</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent3\">대화내용3</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightR\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentnum\">5</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentfix\">☆</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"chatcontent\">\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentprofile\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofileimg\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"chatcontentimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofilename\">\r\n");
      out.write("\t\t\t\t\t\t닉네임\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentright\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent1\">대화내용1</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent2\">대화내용2</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent3\">대화내용3</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightR\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentnum\">5</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentfix\">☆</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"chatcontent\">\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentprofile\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofileimg\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"chatcontentimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofilename\">\r\n");
      out.write("\t\t\t\t\t\t닉네임\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentright\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent1\">대화내용1</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent2\">대화내용2</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent3\">대화내용3</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightR\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentnum\">5</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentfix\">☆</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"chatcontent\">\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentprofile\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofileimg\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"chatcontentimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentprofilename\">\r\n");
      out.write("\t\t\t\t\t\t닉네임\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"chatcontentright\">\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent1\">대화내용1</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent2\">대화내용2</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontent3\">대화내용3</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"chatcontentrightR\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentnum\">5</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chatcontentfix\">☆</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(\"body\").click(function(e){\r\n");
      out.write("\t\tif($('#chatdiv').css('display') == 'block'){\r\n");
      out.write("\t\t\tif(!$('#chatdiv').has(e.target).length) {\r\n");
      out.write("\t\t\t\t$('#chatdiv').hide();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else if($('#chatdiv').css('display') == 'none'){\r\n");
      out.write("\t\t\tif($('#chatbtn').has(e.target).length) {\r\n");
      out.write("\t\t\t\t$('#chatdiv').show();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<div id=\"all\">\r\n");
      out.write("\t\t<div id=\"all-wrap\">\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/myUltary/myUltaryheader.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<div id=\"alert-wrap\">\r\n");
      out.write("\t\t\t<div class=\"alert\">\r\n");
      out.write("\t\t\t\t<div id=\"alerttitle\">전체알림</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"alertcontentdiv\">\r\n");
      out.write("\t\t\t\t\t<div class=\"alertcontent\">한호성님의 위탁요청이 전송되었습니다.</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"alertclose\">&nbsp;&nbsp;X</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"alertspace\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(\"body\").click(function(e){\r\n");
      out.write("\t\tif($('.alert').css('display') == 'block'){\r\n");
      out.write("\t\t\tif(!$('.alert').has(e.target).length) {\r\n");
      out.write("\t\t\t\t$('.alert').hide();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else if($('.alert').css('display') == 'none'){\r\n");
      out.write("\t\t\tif($('#alertbuttondiv').has(e.target).length) {\r\n");
      out.write("\t\t\t\t$('.alert').show();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\t\t<div id=\"header-top\">\r\n");
      out.write("\t\t\t<div id=\"chatbtn\"><img class=\"headerimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/메신저.png\"></div>\r\n");
      out.write("\t\t\t<div id=\"alertbuttondiv\"><img class=\"headerimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/알림.png\"></div>\r\n");
      out.write("\t\t\t<a href='");
      out.print( request.getContextPath() );
      out.write("/views/main/main.jsp'><img id=\"logimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/logo.png\"></a>\r\n");
      out.write("\t\t\t<div id=\"header-topR\">\r\n");
      out.write("\t\t\t\t<div id=\"nick\">");
      out.print( loginUser.getNickname() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t<div id=\"nim\">님</div>\r\n");
      out.write("\t\t\t\t<button id=\"logout\" class=\"top-right\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/logout.me'\">로그아웃</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"header-bottom\">\r\n");
      out.write("\t\t\t<img id=\"backimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/1.png\">\r\n");
      out.write("\t\t\t<div id=\"ultaryhost\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"proimgdiv\">\r\n");
      out.write("\t\t\t\t<div id=\"promaindiv\">\r\n");
      out.write("\t\t\t\t\t<img style=\"width: 100%; height: 100%\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/사진변경.png\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
 if(proImg != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<img id=\"proimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/uploadFiles/");
      out.print( proImg.getWebName() );
      out.write("\">\r\n");
      out.write("\t\t\t\t");
 } else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<img id=\"proimg\" src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<div id=\"tlhostdiv\">\r\n");
      out.write("\t\t<div id=\"tlhost\">");
      out.print( loginUser.getNickname() );
      out.write("</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$('#profileimgdiv').hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#promaindiv').hover(function(){\r\n");
      out.write("\t\t\t$('#promaindiv').css(\"opacity\", \"1\");\r\n");
      out.write("\t\t}, function(){\r\n");
      out.write("\t\t\t$('#promaindiv').css(\"opacity\", \"0\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t");
 if(proImg != null){ 
      out.write("\r\n");
      out.write("\t\t$('#promaindiv').click(function(){\r\n");
      out.write("\t\t\twindow.open('");
      out.print( request.getContextPath() );
      out.write("/views/myUltary/profilePOPUP.jsp?originImg=");
      out.print( proImg.getWebName() );
      out.write("', '프로필변경', \"width=500, height=500, top=200, left=300\", true);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t");
 } else{ 
      out.write("\r\n");
      out.write("\t\t$('#promaindiv').click(function(){\r\n");
      out.write("\t\t\twindow.open('");
      out.print( request.getContextPath() );
      out.write("/views/myUltary/profilePOPUP.jsp?', '프로필변경', \"width=500, height=500, top=200, left=300\", true);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/myUltary/navaside.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<div id='cssmenu'>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class='active'>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.print( request.getContextPath() );
      out.write("/post.tl\">내울타리</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"menu1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print( request.getContextPath() );
      out.write("/post.tl\">타임라인</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/views/myUltary/postWrite.jsp\">게시글작성</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/markmember.mem\">관심회원</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/markpost.tl\">게시글 즐겨찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/views/myUltary/trustEvm.jsp\">내 위탁환경</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<a href='#'>커뮤니티</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"menu2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>모아보기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>펫일상</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>펫지식</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>펫리뷰</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>펫분양</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href='#'>위탁매칭</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"menu3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>위탁검색</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>의뢰 관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>내가 남긴 리뷰</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href='#'>마이페이지</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"menu4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>내 정보 관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>비밀번호변경</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>회원 탈퇴</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href='#'>고객센터</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"menu5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>공지 사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>자주하는 질문</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href='#'>1:1 문의</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<aside>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/post.tl\">타임라인</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/views/myUltary/postWrite.jsp\">게시글작성</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/markmember.mem\">관심회원</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/markpost.tl\">게시글 즐겨찾기</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/views/myUltary/trustEvm.jsp\">내 위탁환경</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</aside>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t\t<section>\r\n");
      out.write("\t\t\t\t");
 for(int i=0;i<markList.size();i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"markmember\">\r\n");
      out.write("\t\t\t\t\t<div class=markimg><img src=\"");
      out.print( request.getContextPath() );
      out.write("/image/프로필.png\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"marknick\">");
      out.print( markList.get(i).getNickname() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"marklike\">\r\n");
      out.write("\t\t\t\t\t\t<div>");
      out.print( markList.get(i).getMarkscore() );
      out.write(" MARK</div>\r\n");
      out.write("\t\t\t\t\t\t<button>Cancel</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<footer>제작사:hoseong</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
