<%@ page import="mvcapp.domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/4 0004
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%=request.getAttribute("msg")==null? "":request.getAttribute("msg")%>
<form action="update.do" method="post">
    <input type="hidden" name="id" value="<%=((Customer)request.getAttribute("customer")).getId()%>">
    <input type="hidden" name="oldName" value="<%=((Customer)request.getAttribute("customer")).getName()%>">
    <table>
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name" value="<%=((Customer)request.getAttribute("customer")).getName()%>"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="<%=((Customer)request.getAttribute("customer")).getAddress()%>"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="<%=((Customer)request.getAttribute("customer")).getPhone()%>"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="submit"></td>

        </tr>
    </table>
</form>
</body>
</html>
