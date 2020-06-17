<%@ page import="java.util.List" %>
<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/13 0013
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 在页面上对request 中的 customers 属性进行遍历，打印 id，name，age-->
<c:forEach items="${requestScope.customers}" var="customer">
    --${customer.id },${customer.name},${customer.age}<br>
</c:forEach>
<%--
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");

    if (customers != null) {
        for (Customer customer : customers) {
            %>
        <%=customer.getId()%>,<%=customer.getName()%>,<%=customer.getAge()%> <br>
        <%
        }
    }
--%>
</body>
</html>
