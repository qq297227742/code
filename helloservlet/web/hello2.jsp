<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/1 0001
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP语法</title>
</head>
<body>

    <%
        Date date=new Date();
        out.print(date);
    %>

<%--    jsp表达式--%>
    <%=date%>

    <%
        String ageStr = request.getParameter("age");
        Integer age = Integer.parseInt(ageStr);
        if (age > 18) {
            out.print("成年人");
        } else {
            out.print("未成年人");
        }
    %>
</body>
</html>
