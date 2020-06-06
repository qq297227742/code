<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/1 0001
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        Date date=new Date();
        System.out.println("-->"+date);
    %>

    <%
        String str = date.toString();
        //隐含对象
        //没有声明就可以使用的对象

        String name = request.getParameter("name");
        System.out.println(name);

        //
        Class<? extends HttpServletResponse> aClass = response.getClass();
        System.out.println(aClass);

        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
        System.out.println(req==request);

        System.out.println(session.getId());

        System.out.println(application.getInitParameter("driver"));

        System.out.println(config.getInitParameter("test"));

        out.print(name);

        out.println(this);
        out.println(page);
    %>

</body>
</html>
