<%@ page import="domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/13 0013
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el2</title>
</head>
<body>
<!-- EL 的关系运算符 -->
${param.score >60 ? "及格":"不及格"}
<br>
<%
    List<String> names = new ArrayList<>();
    names.add("abc");
    request.setAttribute("names",names);
%>

<!--  empty 可以作用于一个集合，若该集合不存在或集合中没有元素，其结果都为true-->
name is empty:${empty requestScope.names}


<br>
<!--  其它隐含对象：pageContext 等(cookie、header、initParam 只需要了解) -->
pageContext:pageContext 即为 PageContext 类型，但只能读取属性。
<br>
contextPath：${pageContext.request.contextPath}
<br>
SessionId：${pageContext.session.id}
<br>

sessionAttributeNames:${pageContext.session.attributeNames}
<br>





initParam:${initParam.iniName}
<br>
Accept-Language:${header["Accept-Language"]}
<br>
JSESSIONID:${cookie.JSESSIONID.name} -- ${cookie.JSESSIONID.value}
<br>


<!-- 与输入有关的隐含对象：param，paramValues -->
score:${param.score}
<%=request.getParameter("score")%>
<br>
names:${paramValues.name[0]}
<br>


<!--隐含对象之与范围相关的：pageScope、requestScope、sessionScope、applicationScope  -->
    time:${applicationScope.time}
<%=application.getAttribute("time")%>
<br>


<!-- El 可以进行自动的类型转换 -->
score:${param.score+10}
<br>
score:<%=request.getParameter("score")+11%>
<br>
<%--EL 中的隐含对象--%>
<%
    Customer customer2=new Customer();
    customer2.setAge(28);
    request.setAttribute("customer",customer2);
%>


<%--EL的 . 或 []  运算符--%>
age:${customer.age}
<br>
age:${sessionScope.customer["age"]}
<%--
    Customer customer = (Customer) session.getAttribute("customer");
    out.print(customer.getAge());
--%>

<%
    Customer customer=new Customer();
    customer.setName("weiwei");
    session.setAttribute("com.customer",customer);
%>
<br>
<%--如果域对象的属性名带有特殊字符，则使用[] 运算符会很方便。--%>
name:${sessionScope["com.customer"].name }
</body>
</html>
</body>