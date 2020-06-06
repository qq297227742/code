<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/4 0004
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<%=request.getAttribute("msg")==null ? "":request.getAttribute("msg")%>
<form action="add.do" method="post">
    <table>
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name" value="<%=request.getParameter("name")==null ?  "":request.getParameter("name")%>"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="submit"></td>

        </tr>
    </table>
</form>
</body>
</html>
