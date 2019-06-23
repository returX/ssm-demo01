<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/6/17
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <h1><%=session.getAttribute("USER_INF")%></h1>
    <a href="/comment">评论区</a>
</body>
</html>
