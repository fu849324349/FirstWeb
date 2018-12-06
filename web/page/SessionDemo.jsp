<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/27
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
<h1>欢迎来到登录页面</h1>
    <%
        out.print("sessionID"+session.getId());
        out.print("<br/>");
        out.print("session创建时间"+session.getLastAccessedTime());
        out.print("<br/>");
        out.print("sessionz最后访问时间"+session.getLastAccessedTime());
        out.print("<br/>");
        out.print("session最大的有效时间"+session.getMaxInactiveInterval());
        out.print("<br/>");
        out.print("是不是新创建的session:"+session.isNew());
    %>
<form action="SessionServlet" method="post">
    用户名：<input type="text" name="username"required autofocus/>
    <br/>
    密码：<input type="password" name="password" required autofocus/>
    <br/>
    <input type="submit" value="commit">
</form>
</body>
</html>
