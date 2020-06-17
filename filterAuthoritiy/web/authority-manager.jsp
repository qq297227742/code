<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/17 0017
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <br><br>
    <form action="AuthorityServlet?method=getAuthorities" method="post">
        name: <input name="username" type="text">
        <input type="submit" value="submit">
    </form>

    <c:if test="${requestScope.user !=null}">
        <br>
        ${requestScope.user.username}的权限是：<br>
        <br>

        <form action="AuthorityServlet?method=updateAuthority" method="post">
            <input type="hidden" name="username" value="${requestScope.user.username}"><br>

            <c:forEach items="${authorities}" var="auth">
                <c:set var="falg" value="false"></c:set>
                    <c:forEach items="${user.authorities}" var="ua">
                    <c:if test="${ua.url == auth.url}">
                        <c:set var="falg" value="true"></c:set>
                    </c:if>
                </c:forEach>
                <c:if test="${falg==true}">
                    <input type="checkbox" name="authority" value="${auth.url}" checked="checked">${auth.displayName}
                </c:if>
                <c:if test="${falg==false}">
                    <input type="checkbox" name="authority" value="${auth.url}" >${auth.displayName}
                </c:if>

                <br>

            </c:forEach>

            <input type="submit" value="uptade">
        </form>
    </c:if>
</center>
</body>
</html>
