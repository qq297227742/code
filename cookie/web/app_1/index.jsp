<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/8 0008
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        if (name != null && !name.trim().equals("")) {
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(30);
            response.addCookie(cookie);
        } else{
            Cookie[] cookieNames=request.getCookies();
            if (cookieNames != null && cookieNames.length > 0) {
                for (Cookie cookie : cookieNames) {
                    if (cookie.getName().equals("name")) {
                        name = cookie.getValue();
                    }
                }
            }
        }

        if (name != null && !name.trim().equals("")) {
            out.print("hello:" + name);
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>
