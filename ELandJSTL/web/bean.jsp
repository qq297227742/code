<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/13 0013
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bean</title>
</head>
<body>

<jsp:useBean id="customer" class="domain.Customer" scope="session"/>
<%--
    //1. 从scope（session） 中获取id（customer） 属性值， 赋给 class（domain.Customer） 类型的id（customer） 变量
    Customer customer = session.getAttribute("customer");

    // 2. 若属性值为 null，则利用反射创建一个新的对象，把该对象赋给id（customer）， 并以 id（customer）为属性名放入到 scope（session） 中，
    if (customer == null) {
        customer = (Customer) Class.forName("domain.Customer").newInstance();
        session.setAttribute("customer",customer);
    }
--%>




<jsp:setProperty name="customer" property="age" value="10"/>

<%--
    customer.setAge(10);
--%>
<jsp:getProperty name="customer" property="age"/>
<%--
<%=customer.getAge()%>
--%>

<br>
<%--若property 的值为*，省略value属性值，则将自定为所有属性赋值为对应的请求参数的值。--%>
<%--
http://localhost:8080/ELandJSTL_war_exploded/bean.jsp?age=10&id=10&name=weiwei
--%>
<jsp:setProperty name="customer" property="*"/>

    age:<jsp:getProperty name="customer" property="age"/>
<br>
    name:<jsp:getProperty name="customer" property="name"/>
<br>
    id:<jsp:getProperty name="customer" property="id"/>


<jsp:useBean id="customer2" beanName="domain.Customer" type="java.lang.Object" scope="request"/>
<%--
    Object customer2 = request.getAttribute("customer2");
    if (customer2 == null) {
        customer2 = Class.forName("domain.Customer").newInstance();
        request.setAttribute("customer2",customer2);
    }
--%>
</body>
</html>
