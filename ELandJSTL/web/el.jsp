<%@ page import="domain.Customer" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/13 0013
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>

    <form action="el.jsp" method="post">
        username:<input type="text" name="username"
    value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>">
        username:<input type="text" name="username"
    value="${param.username}"/>
        <input type="submit" value="submit">
    </form>

    <br>
    username:<%=request.getParameter("username")%>

    <br><br>
    <jsp:useBean id="customer" class="domain.Customer" scope="session"/>
    <jsp:setProperty name="customer" property="age" value="12"/>

    age:
<%
    Customer customer2 = (Customer) session.getAttribute("customer");
    out.print(customer2.getAge());
%>
    <br>
    age:<jsp:getProperty name="customer" property="age"/>

    <%
        application.setAttribute("time",new Date());
    %>

<a href="el2.jsp?score=89&name=A&name=B&name=C">To EL2 Page</a>
</body>
</html>
