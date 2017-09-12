<%--
  Created by IntelliJ IDEA.
  User: qifu
  Date: 17/9/10
  Time: 下午4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
    <title>Page Redirection</title>
</head>
<body>
<center>
    <h1>Page Redirection</h1>
</center>
<%
    // New location to be redirected
    String site = new String(request.getRequestURL() + "/main");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
</body>
</html>