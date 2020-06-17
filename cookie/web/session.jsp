<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/11 0011
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //
    HttpSession session = request.getSession(false);
    session.setMaxInactiveInterval(5);
    out.print(session.getMaxInactiveInterval());
    out.print(session);
%>
</body>
</html>
