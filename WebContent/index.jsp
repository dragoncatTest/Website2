<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
	<style>
		p
		{
			display:inline-block ;
		}
		td
		{
			text-align:center ;
		}
	</style>
</head>
<body>
	<h1 align="center">主页</h1>
	<div id="userOperation" align="right">
		<c:choose>
			<c:when test="${empty cookie.username.value}">
				<p align="right"><a href="jsp/Register.jsp">注册</a></p>
				<p align="right"><a href="jsp/Login.jsp">登陆</a></p>
			</c:when>
			<c:when test="${!empty cookie.username.value}">
				<p align="right"><c:out value="${cookie.username.value}"></c:out></p>
			</c:when>
		</c:choose>
		<p><a href="jsp/ShopCart.jsp">购物车</a></p>
		<p><a href="jsp/SelfInfo.jsp">个人信息</a></p>	
		<p><a href="jsp/UserList.jsp">用户在线列表</a></p>	
		<p><a href="UserLogout">点击注销</a></p>	
		<p></p>
		<p></p>
	</div>
	<div id="todayDiscount" align="center">
	</div>
	<script type="text/javascript" src="js/GetIndexGoodsInfo.js"></script>
</body>
</html>


		
			