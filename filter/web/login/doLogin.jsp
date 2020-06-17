<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/16 0016
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doLogin</title>
</head>
<body>

<%
    //1. 获取用户的登录信息
    String username = request.getParameter("username");

    //2.若登录信息完整，则把登录信息放到 HttpSession
    if (username != null && !username.trim().equals("")) {
        session.setAttribute("USERSESSIONKEY", username);
        response.sendRedirect("list.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }

    //3.重定向到list。jsp

%>

</body>
</html>
