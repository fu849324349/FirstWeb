<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--<link rel="stylesheet" type="text/css" href="css/signIn.css"/>-->
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/signIn.css"/>
    <script type="text/javascript" src="js/Sign_in.js" ></script>
</head>
<body>
    <form id="signIn" action="signIn"><!--action是决定那个服务器（servlet）处理这个请求-->
        <h2>欢迎注册！</h2>
        <br />
        <table>
            <tr>
                <td>
                    用户名
                </td>
                <td>
                    <input type="text"  placeholder="请输入用户名" id="userName" name="username" required autofocus/>
                </td>
                <td>
                    <span id="span1"></span>
                </td>
            </tr>
            <tr>
                <td>
                    密码
                </td>
                <td>
                    <input type="password" placeholder="请输入密码" id="password1" name="psw" required autofocus/>
                </td>
                <td>
                    <span id="span2"></span>
                </td>
            </tr>
            <tr>
                <td>
                    邮箱
                </td>
                <td>
                    <input type="email" placeholder="请输入邮箱" id="email1" name="email1"/>
                </td>
                <td>
                    <span id="span3"></span>
                </td>
            </tr>
            <tr>
                <td>
                    手机号
                </td>
                <td>
                    <input type="text" placeholder="请输入手机号" id="iphone" name="telPhone"/>
                </td>
                <td>
                    <span id="span4"></span>
                </td>
            </tr>
            <tr>
                <td rowspan="3">
                    <input type="submit" value="提交" id="button1"/>
                </td>
            </tr>
        </table>
        <%= request.getAttribute("message")%>
    </form>
</body>
</html>

