<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/12 0012
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4> step2：请输入寄送地址和信用卡信息</h4>

    <form action="<%=request.getContextPath()%>/processStep2" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td colspan="2">寄送信息</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td colspan="2">信用卡信息</td>
        </tr>
        <tr>
            <td>种类：</td>
            <td>
                <input type="radio" name="cardType" value="Visa"/>Visa
                <input type="radio" name="cardType" value="Master"/>Master
            </td>
        </tr>
        <tr>
            <td>卡号：</td>
            <td><input type="text" name="card"/></td>
        </tr>
        <tr>

            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
    </form>
</body>
</html>
