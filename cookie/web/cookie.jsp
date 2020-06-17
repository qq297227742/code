<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/6 0006
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //在Javaweb 规范中使用 cookie 类 代表cookie

        //1. 创建一个 Cookie 对象
       // Cookie cookie = new Cookie("name", "weiwei");

        //2. 调用 response 的一个方法把 Cookie 传给客户端。
//        response.addCookie(cookie);

        //1. 获取Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie1 : cookies) {
                out.print(cookie1.getName() + ":" + cookie1.getValue());
                out.print("<br>");
            }
        } else {
            out.print("没有一个Cookie，正在创建并返回");
            Cookie cookie = new Cookie("name", "weiwei");
            cookie.setMaxAge(30);

            response.addCookie(cookie);
        }
    %>
</body>
</html>
