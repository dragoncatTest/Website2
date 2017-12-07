<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/RegisterLogin.css">
</head>
<c:if test="${!empty cookie.username.value}">
	<c:redirect url="../index.jsp"></c:redirect>
</c:if>
<body>
	<div>
	<form method="post" action="../UserLogin">
		<table summary="登录" cellspacing="10">
		<caption>登录</caption>
			<tr>
				<td><label for="user">用户名</label></td>
				<td><input required placeholder="请输入邮箱" type="text" id="user" placeholder="请输入有效邮箱" name="info" /></td>
			</tr>
			<tr>
				<td><label for="pass">密码</label></td>
				<td><input required placeholder="请输入密码" type="password" id="pass" name="info" /></td>
			</tr>
			<tr>
				<td colspan="2"><label for="reme">记住我，30天内免登陆</label><input type="checkbox" id="reme" value="1" name="info" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="登录" />
				</td>
			</tr>
				
		</table>
	</form>
	</div>
</body>
</html>