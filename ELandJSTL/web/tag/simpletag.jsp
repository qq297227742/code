<%@ page import="java.util.List" %>
<%@ page import="domain.Customer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/13 0013
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>simpletag</title>
</head>
<body>

<%

    //模拟Servlet 中的操作
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1, "AA", 12));
    customers.add(new Customer(2, "BB", 13));
    customers.add(new Customer(3, "CC", 14));
    customers.add(new Customer(4, "DD", 15));
    customers.add(new Customer(5, "EE", 16));

    request.setAttribute("customers",customers);
%>


<jsp:forward page="testtag.jsp"></jsp:forward>



</body>
</html>
