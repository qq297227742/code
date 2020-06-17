<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/15 0015
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page errorPage="test.jsp" %>
<html>
<head>
    <title>dispatcher</title>
</head>
<body>

<%--
    <jsp:forward page="test.jsp"></jsp:forward>

    <jsp:include page="test.jsp"></jsp:include>
    --%>
<%
    int i=10/0;
%>
</body>
</html>
