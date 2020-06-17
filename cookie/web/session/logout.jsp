<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/11 0011
  Time: 19:22
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



Bye:<%=session.getAttribute("username")%>
<br>
<a href="login.jsp">重新登陆</a>
<%
    session.invalidate();
%>
</body>
</html>
