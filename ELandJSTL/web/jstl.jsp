<%@ page import="domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/14 0014
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>c:out</h4>
<%
    request.setAttribute("book", "<<java>>");
%>
book:${requestScope.book}
<br><br>
book:<c:out value="${requestScope.book}"></c:out>

<br><br>
<br><br>
<br><br>
<br><br>
<h4>c:set</h4>
<c:set value="atguigu" var="name" scope="page"></c:set>
<%
    pageContext.setAttribute("name", "atguigu");
%>
name:${pageScope.name}
<%
    Customer customer = new Customer();
    customer.setId(1001);
    request.setAttribute("cust", customer);
%>
ID:${requestScope.cust.id}
<c:set target="${requestScope.cust}" property="id" value="${param.id}"></c:set>
<br>
ID:${requestScope.cust.id}
<br><br>
<br><br>
<br><br>

<h4>c:remove</h4>
<c:set value="1997-09-01" var="date" scope="session"></c:set>
date:${sessionScope.date}
<br><br>
<c:remove var="date" scope="session"></c:remove>
date:--${sessionScope.date}--
<br><br>
<h4>c:if</h4>
<c:set value="20" var="age" scope="request"></c:set>
<c:if test="${requestScope.age>19}" >成年了</c:if>
<c:if test="${param.age> 18}" var="isAdult" scope="request"></c:if>
isAdult:<c:out value="${requestScope.isAdult}"></c:out>

<br><br>
<br><br>

<h4>c:choose,c:when,c:otherwise: 可以实现if...else if...else if...else效果 </h4>
<c:choose>
    <c:when test="${param.age>60}">老年</c:when>
    <c:when test="${param.age>40}">中年</c:when>
    <c:when test="${param.age>18}">成年</c:when>
    <c:otherwise>未成年</c:otherwise>
</c:choose>

<br><br>
<br><br>
<br><br>

<h4>c:forEach:可以对集合，Map进行遍历</h4>
<c:forEach begin="1" end="10" step="3" var="i">
    ${i} --
</c:forEach>
<br>
<%
    List<Customer> customers=new ArrayList<>();
    customers.add(new Customer(1,"AA",1));
    customers.add(new Customer(2,"BB",2));
    customers.add(new Customer(3,"CC",3));
    customers.add(new Customer(4,"DD",4));
    customers.add(new Customer(5,"EE",5));
    request.setAttribute("customers",customers);
%>
<c:forEach items="${requestScope.customers}" var="customer1">
    ${customer1.id} -- ${customer1.name} -- ${customer1.age}<br>
</c:forEach>


<br>
<!--遍历Map-->
<%
    Map<String,Customer> customersMap=new HashMap();
    customersMap.put("A",new Customer(1,"AA",1));
    customersMap.put("B",new Customer(2,"BB",2));
    customersMap.put("C",new Customer(3,"CC",3));
    customersMap.put("D",new Customer(4,"DD",4));
    customersMap.put("E",new Customer(5,"EE",5));

    request.setAttribute("customersMap",customersMap);
%>
<c:forEach items="${requestScope.customersMap}" var="cust">
    ${cust.key} - ${cust.value.id}- ${cust.value.name}- ${cust.value.age}
</c:forEach>

<br><br>
<br><br>
<h4>c:import 可以包含任何页面到当前页面</h4>
<c:import url="http://www.baidu.com"></c:import>
<br><br>
<h4>c:redirect 使当前 JSP 页面重定向到指定的页面</h4>
<%--<c:redirect url="index.jsp"></c:redirect>--%>
<br><br>
<h4>c:url 产生一个url地址 ，可以根据cookie 是否可用来只能进行URL ，对GET请求参数进行编码</h4>
<c:url value="index.jsp" var="testurl">
    <c:param name="name" value="尚硅谷"></c:param>
</c:url>
url:${testurl}





</body>
</html>
