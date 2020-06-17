<%@ page import="domain.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/14 0014
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="atguigu" uri="http://www.atguigu.com/mytag/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <atguigu:testJspFragment>Hello World</atguigu:testJspFragment>


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

<atguigu:forEach items="${requestScope.customers}" var="cus">
    ${cus.id}--${cus.name}--${cus.age}
</atguigu:forEach>

    <!--父标签打印name 到控制台-->
<atguigu:parentTag>
<%--  子标签以父标签的标签体存在，  子标签把父标签的 name 属性 打印到 JSP 页面上--%>
    <atguigu:sonTag/>
</atguigu:parentTag>
<c:choose>
    <c:when test="${param.age>24}">大学毕业</c:when>
    <c:when test="${param.age>20}">高学毕业</c:when>
    <c:otherwise>高中以下。。。</c:otherwise>
</c:choose>

<atguigu:chooseTag>
    <atguigu:whenTag test="${param.age>24}">大学毕业</atguigu:whenTag>
    <atguigu:whenTag test="${param.age>20}">高中毕业</atguigu:whenTag>
    <atguigu:otherWiseTag>高中以下</atguigu:otherWiseTag>
</atguigu:chooseTag>

<!-- 使用EL 的自定义函数-->
${fn:length(param.name)}

<!--测试自定义的 EL 函数-->

${atguigu:concat(param.name1,param.name2 )}
</body>
</html>
