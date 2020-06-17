<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/10 0010
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 向客户端浏览器写入一个Cookie：cookiePath,cookiePathValue-->
<%
    Cookie cookie = new Cookie("cookiePath", "cookiePathValue");
    //设置Cookie的作用范围：
    cookie.setPath(request.getContextPath());

    response.addCookie(cookie);
%>

<a href="../cookie2.jsp"> To Read Cookie</a>
</body>
</html>
</body>