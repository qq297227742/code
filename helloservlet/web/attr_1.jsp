<%--
  Created by IntelliJ IDEA.
  User: weiwei
  Date: 2020/6/1 0001
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>attr_1</title>
</head>
<body>
<%
    pageContext.setAttribute("pageContextAttr","pageContextValue");
    request.setAttribute("requestAttr","requestValue");
    session.setAttribute("sessionAttr","sessionValue");
    application.setAttribute("applicationAttr","applicationtValue");
%>

<br><br>
pageContextAttr<%=pageContext.getAttribute("pageContextAttr")%>
<br><br>
requestAttr<%=request.getAttribute("requestAttr")%>
<br><br>
sessionAttr<%=session.getAttribute("sessionAttr")%>
<br><br>
applicationAttr<%=application.getAttribute("applicationAttr")%>
<br><br>
<a href="attr_2.jsp">to Attr_2 page</a>
</body>
</html>
