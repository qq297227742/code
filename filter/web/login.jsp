<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/15 0015
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<font color="red">${msg}</font><br>
    <form action="hello.jsp" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="submit" value="submit">
    </form>

</body>
</html>
