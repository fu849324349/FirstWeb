<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/26
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        System.out.print(cookies);

        //request对象，拿到Cookie的值
        if (cookies ==null)
        {
            Cookie cookie = new Cookie("name","hello");
            cookie.setMaxAge(500);
            response.addCookie(cookie);//向响应头中添加一个Cookie，下次客户端再访问服务端时通过Cookie辨识是否是同一客户端
        }
        if (cookies != null&&cookies.length>0)
        {
            for (Cookie c:cookies)
            {
                out.print(c.getName());
                out.print(c.getValue());
            }
        }
    %>
</body>
</html>
