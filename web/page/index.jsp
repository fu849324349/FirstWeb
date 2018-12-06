<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/26
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
    <form action="/CookieServlet" method="post">
      用户名
      <input type="text" name="userName"/>
      <br/>
      密码
      <input type="password" name="password"/>
      <br/>
      <input type="submit" placeholder="登录"/>
    </form>

  </body>
</html>
