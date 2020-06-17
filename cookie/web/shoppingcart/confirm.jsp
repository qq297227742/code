<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/12 0012
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    String[] books = (String[]) session.getAttribute("books");
%>
    <table>
        <tr>
            <td>顾客姓名</td>
            <td><%=customer.getName()%></td>
        </tr>
        <tr>
            <td>顾客地址</td>
            <td><%=customer.getAddress()%></td>
        </tr>
        <tr>
            <td>顾客卡号</td>
            <td><%=customer.getCard()%></td>
        </tr>
        <tr>
            <td>卡的类型</td>
            <td><%=customer.getCardType()%></td>
        </tr>
        <tr>
            <td>books</td>
            <td>
                <%
                    for (String book : books) {
                        out.print(book);
                        out.print("<br>");
                    }
                %>
            </td>
        </tr>
    </table>
</body>
</html>
