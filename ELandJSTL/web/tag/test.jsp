<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/13 0013
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导入标签库-->
<%@ taglib prefix="atguigu" uri="http://www.atguigu.com/mytag/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <atguigu:hello value="${param.name}" count="${param.count}"/>

</body>
</html>
