<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/11 0011
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SessionID:<%=session.getId()%>
    <br><br>

    isNew:<%=session.isNew()%>
    <br><br>

    MaxInactiveInterval:<%=session.getMaxInactiveInterval()%>
    <br><br>

    CreateTIme <%=session.getCreationTime()%>
    <br><br>

    LastAccessTime:<%=session.getLastAccessedTime()%>
    <br><br>


    <%
        Object username = session.getAttribute("username");
        if (username == null) {
            username = "";
        }
    %>
    <form action="hello.jsp" method="post">
        username:<input type="text" name="username" value="<%=username%>">
        <input type="submit" value="submit">

    </form>
</body>
</html>
