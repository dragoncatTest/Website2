<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="../css/RegisterLogin.css">
</head>
<body>
<c:if test="${!empty cookie.username.value}">
	<c:redirect url="../index.jsp"></c:redirect>
</c:if>
<div>
	<form method="post" action="../UserRegister">
		<table summary="登录" cellspacing="10">
		<caption>登录</caption>
			<tr>
				<td><label for="user">用户名</label></td>
				<td>
					<input required placeholder="请输入昵称" type="text" id="user" name="info" onblur="checkUser(this.value)" />
					<span id="checkUsername"></span>
				</td>
			</tr>
			<tr>
				<td><label for="eamil">邮箱</label></td>
				<td>
					<input required placeholder="请输入邮箱" type="text" id="eamil" name="info" pattern="[0-9a-zA-Z]+@[a-z]+\.com" onblur="checkEmail(this.value)" />
					<span id="checkEmail"></span>
				</td>
			</tr>
			<tr>
				<td><label for="pass">密码</label></td>
				<td><input required placeholder="请输入密码" type="password" id="pass" name="info" /></td>
			</tr>
			<tr>
				<td><label for="question">找回问题</label></td>
				<td><input required placeholder="找回密码的凭证" type="text" id="question" name="info" /></td>
			</tr>
			<tr>
				<td><label for="answer">答案</label></td>
				<td><input required type="text" id="answer" name="info" /></td>
			</tr>
			<tr>
				<td colspan="2" >
				<input type="submit" value="注册" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	<script type="text/javascript" src="../js/checkUser_Email.js"></script>
</body>
</html>