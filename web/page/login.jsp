<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>登录</title>
		<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>--%>
		<link rel="stylesheet" type="text/css" href="/css/login.css"/>
		<link rel="stylesheet" type="text/css" href="/css/common.css"/>
        <script ></script>
	</head>
	<body>
		<div id="container">
			<div id="loginTitle">
				<span>登录</span>
			</div>
			<div id="logininput">
				<div>
					<form action="/CookieServlet" method="post">
						<table cellpadding="0px" cellspacing="0px">
							<tr>
								<td width="90px">
									<span>用户名:</span>
								</td>
								<td><input type="text" id="username" placeholder="请输入用户名" name="username"/></td>
							</tr>
							<tr>
								<td>
									<span>密码:</span>
								</td>
								<td>
									<input type="password" id="passW" placeholder="请输入密码" name="psw"/>
								</td>
							</tr>
							<tr id="buttonOne">
								<td colspan="2">
									<input type="submit" id="loginButton" value="点击登录" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
