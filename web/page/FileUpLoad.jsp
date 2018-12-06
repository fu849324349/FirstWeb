<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
</head>
<body>                                              <!--传一个文件,让文件以二进制传输-->
    <form action="/ImgUploadServlet" method="post" enctype="multipart/form-data"><!--用了enctype属性，所有的input都会被认为是fileitem
    就是把输入域所有input都封装到一个对象中-->
        <input type="text" name="username"/>
        <input type="password" name="psw"/>
        <input type="file" name="file1"/><span>${message}</span>
        <input type="submit" value="commit"/>
    </form>
</body>
</html>
