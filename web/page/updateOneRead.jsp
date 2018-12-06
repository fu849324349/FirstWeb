<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/2
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>修改一条数据</title>


</head>
<body>
<form action="/UpdateOneReadServlet" method="post" >
商品ID：  <input type="text" value="${updateShop.shop_id}" name="Shop_id" readonly="readonly"/><br/>
商品名称：<input type="text" value="${updateShop.shop_Name}" name="Shop_Name"/><br/>
商品描述：<input type="text" value="${updateShop.shop_des}" name="Shop_des"/><br/>
商品图片：<input type="text" value="${updateShop.shop_img}" name="Shop_img"/><br/>
商品价格：<input type="text" value="${updateShop.shop_price}" name="Shop_price"/><br/>
商品类别：<input type="text" value="${updateShop.shop_Cate_id}" name="Shop_Cate_id"/><br/>
商品库存：<input type="text" value="${updateShop.shop_Stock}" name="Shop_Stock"/><br/>
    <input type="submit" value="提交"/>

</form>
</body>
</html>
