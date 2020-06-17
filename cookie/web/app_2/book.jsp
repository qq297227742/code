<%@ page import="java.net.CookieStore" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/8 0008
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书名</title>
</head>
<body>
    Book：<%=request.getParameter("book")%>
    <br>
    <br>
<a href="books.jsp">return</a>

<%
    String book = request.getParameter("book");

    //把书的信息以Cookie 方式传回给浏览器，删除一个Cookie

    //1.确定要被删除的 Cookie：
    // 前提： ATGUIGU_BOOK_ 开头的Cookie数量大于或等于5，
    Cookie[] cookies = request.getCookies();

    List<Cookie> bookCookies=new ArrayList<>();
    Cookie tempCookie = null;

    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("ATGUIGU_BOOK_")) {
                bookCookies.add(cookie);

                if (cookie.getValue().equals(book)) {
                    tempCookie = cookie;
                }
            }
        }
    }
    // 1.1且若从books.jsp 页面传入的book 不在 ATGUIGU_BOOK_ 的Cookie 中则删除较早的那个Cookie
    if (bookCookies.size() >= 5&& tempCookie == null) {
            tempCookie = bookCookies.get(0);
    }

    if (tempCookie!=null) {
        tempCookie.setMaxAge(0);
        response.addCookie(tempCookie);
    }
    //1.2 若在其中，则删除该cookie


    //2. 把从book.jsp 传入的book 作为一个Cookie 返回
    Cookie cookie=new Cookie("ATGUIGU_BOOK_"+book,book);
    response.addCookie(cookie);
%>
</body>
</html>
