<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/10 0010
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--读取一个 name 为 cookiePath的 Cookie--%>

<%
    String cookieValue = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookiePath")) {
                cookieValue = cookie.getValue();
            }
        }
    }

    if (cookieValue != null) {
        out.print(cookieValue);
    } else {
        out.print("没有指定的Cookie。");
    }
%>

</body>
</html>
