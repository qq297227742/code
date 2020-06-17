<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/8 0008
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>books page</title>
</head>
<body>
    <h4>Books page</h4>

    <a href="book.jsp?book=JavaWeb">Java Web</a><br><br>
    <a href="book.jsp?book=Java">Java </a><br><br>
    <a href="book.jsp?book=Oracle">Oracle</a><br><br>
    <a href="book.jsp?book=Ajax">Ajax</a><br><br>
    <a href="book.jsp?book=JavaScript">JavaScript</a><br><br>
    <a href="book.jsp?book=Android">Android</a><br><br>
    <a href="book.jsp?book=Jbpm">Jbpm</a><br><br>
    <a href="book.jsp?book=Structs">Structs</a><br><br>
    <a href="book.jsp?book=Hibernate">Hibernate</a><br><br>
    <a href="book.jsp?book=Spring">Spring</a><br><br>

    <br><br>

    <%
        Cookie[] cookies = request.getCookies();
        List<Cookie> bookCookies=new ArrayList<>();

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.startsWith("ATGUIGU_BOOK_")) {
                    bookCookies.add(cookie);
                }
            }
        }

        for (Cookie cookie : bookCookies) {
            out.print(cookie.getValue());
            out.print("<br>");
        }
    %>
</body>
</html>
