<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>商品的增删改查</title>
		<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="/js/menu.js" ></script>
		<script type="text/javascript" src="/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="/css/look.css" />
		<link rel="stylesheet" href="/css/commonTwo.css" />
		<link rel="stylesheet" href="/css/addCommodity.css" />
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
	</head>
	<body>
		<div id="container">
			<div id="manage">
				<div id="userAndManage">
					<span>用户与商品管理</span>
				</div>
				<div id="menu">
					<ul>
						<li><h5>查看商品</h5></li>
						<li><h5>添加商品</h5></li>
						<li><h5>修改商品</h5></li>
						<li><h5>类别管理</h5></li>
						<li><h5>首页类别管理</h5></li>
						<li><h5>订单信息</h5></li>
						<li><h5>关于</h5></li>
					</ul>
				</div>
			</div>
			<div id="">
			</div>


			<%--查看--%>
			<div class="commodity">
				<div id="welcome">
					<span>您好，欢迎您${username}</span>
				</div>

				<table border="1px" cellspacing="0" cellpadding="0" style="width: 100%">
					<tr>
						<th class="commodityId">商品ID</th>
						<th>商品名称</th>
						<th class="commodityId">商品描述</th>
						<th>商品图片</th>
						<th class="dateOne">商品价格</th>
						<th class="dateOne">商品类别ID</th>
						<th class="dateOne">商品库存</th>
						<th></th>
					</tr>
					<c:forEach items="${pageBean.shops}" var="shop">
                        <tr>
                            <td>${shop.shop_id}</td>
							<td>${shop.shop_Name}</td>
                            <td>${shop.shop_des}</td>
                            <td class="imgDetails"><img src="http://localhost:8080/photos/${shop.shop_img}" ></td>
                            <td>
                                <div class="commodityTitle">
										${shop.shop_price}
                                </div>
                            </td>
                            <td>${shop.shop_Cate_id}</td>
                            <td>${shop.shop_Stock}</td>
                            <td>
                                <div class="revamp"><a href="/QueryOneReadServlet?shop_id=${shop.shop_id}">修改</a></div>
                                <div class="delete"><a href="shopServlet1?shop_id=${shop.shop_id}">删除</a></div>
                            </td>
                        </tr>
					</c:forEach>
				</table>
				<div>
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li>
								<c:if test="${pageBean.pagenum>1}">
									<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${pageBean.pagenum-1}" aria-label="Previous">
										<span aria-hidden="true" style="color: black">&laquo;</span>
									</a>
								</c:if>
							</li>
							<c:forEach begin="${pageBean.startPage}" end="${pageBean.endPage}" step="1" var="i">
								<li><a href="${pageContext.request.contextPath}/PageServlet?pageNum=${i}">${i}</a></li>
							</c:forEach>
							<li>
								<c:if test="${pageBean.pagenum < pageBean.allPages}">
									<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${pageBean.pagenum+1}" aria-label="Next">
										<span aria-hidden="true" style="color: black">&raquo;</span>
									</a>
								</c:if>
							</li>
						</ul>
					</nav>
				</div>
			</div>
			<%--添加--%>
			<div class="commodity">
				<div class="jia">
					<div class="outBigDiv">
					<div class="inBigDivOne">
						<div class="outBigDiv1">
							<form id="addShop" action="/AddShopServlet" method="post" style="width: 100%;height: 100%" enctype="multipart/form-data"/>
								<table class="table1">
									<tr>
										<td>
											商品名称
											<br />
											<input type="text" placeholder="商品名称" name="Shop_Name"/>
										</td>
										<td>
											商品描述
											<br />
											<input type="text" placeholder="商品描述" name="Shop_des" />
										</td>
									</tr>
									<tr>
										<td>
											商品图片
											<br />
											<input type="text" name="Shop_img"/>
											<input type="file" name="file1"/><%--file不属于表单域--%>
										</td>
										<td>
											商品价格
											<br />
											<input type="text" placeholder="商品价格" name="Shop_price" /><%--from表单域--%>
										</td>
									</tr>
									<tr>
										<td colspan="2">
											商品类别ID
											<br />
											<input type="text" placeholder="商品类别ID" name="Shop_Cate_id"/>
										</td>
									</tr>
									<tr>
										<td>
											商品库存
											<br>
											<input type="text" placeholder="商品库存" id="shopDetails" name="Shop_Stock">
										</td>
									</tr>
									<tr>

										<td colspan="2">
											<input type="submit" value="提交" >
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
				</div>
			</div>
			<%--修改--%>
			<div class="commodity">
				<div class="jia">
					<div class="outBigDiv">
						<div class="inBigDivOne">
							<div class="outBigDiv1" id="outBigDiv01">
								<div id="outBigDiv01_1">
									<form action="/QueryOneServlet" method="post">
										<input type="text" value="${updateShop.shop_id}" name="shop_id" placeholder="要修改商品的ID"/>
										<input type="submit" value="查询"/>
									</form>
								</div>
								<div id="outBigDiv01_2">
									<form action="/UpdateOneServlet" method="post" >
										<table class="table1">
											<tr>
												<td>
													商品名称
													<br />
													<input type="text" value="${updateShop.shop_Name}" placeholder="商品名称" name="Shop_Name"/>
												</td>
												<td>
													商品描述
													<br />
													<input type="text" value="${updateShop.shop_des}" placeholder="商品描述" name="Shop_des" />
												</td>
											</tr>
											<tr>
												<td>
													商品图片
													<br />
													<input type="text" value="${updateShop.shop_img}" placeholder="商品图片" name="Shop_img"/>
												</td>
												<td>
													商品价格
													<br />
													<input type="text" value="${updateShop.shop_price}" placeholder="商品价格" name="Shop_price" />
												</td>
											</tr>
											<tr>
												<td colspan="2">
													商品类别ID
													<br />
													<input type="text" value="${updateShop.shop_Cate_id}" placeholder="商品类别ID" name="Shop_Cate_id"/>
												</td>
											</tr>
											<tr>
												<td>
													商品库存
													<br>
													<input type="text" value="${updateShop.shop_Stock}" placeholder="商品库存" id="shopDetails" name="Shop_Stock">
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<%--隐藏的提交shop_id的输入框--%>
													<input type="hidden" name="Shop_id" value="${updateShop.shop_id}"/>
													<input type="submit" value="提交" >
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
