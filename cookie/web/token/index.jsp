<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/12 0012
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String tokenValue = new Date().getTime() + "";
    session.setAttribute("token",tokenValue);
%>
    <form action="<%=request.getContextPath()%>/tokenServlet" method="post">
        <input type="hidden" name="token" value="<%=tokenValue%>" >

        name:<input type="text" name="name">
        <input type="submit" value="submit">
    </form>
</body>
</html>
