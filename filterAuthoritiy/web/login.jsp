<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/17 0017
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

    <form action="LoginServlet?method=login" method="post">
        name<input type="text" name="name"><br>
        <input type="submit" value="submit">
    </form>

</body>
</html>
