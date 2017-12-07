<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.factory.DAOFactory" %>
<%@ page import="com.bean.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>


	<%
		Cookie[] cookies = request.getCookies() ;
		UserInfo info = new UserInfo () ;
		for(Cookie c : cookies)
		{
			if(c.getName().equals("username"))
			{
				
				info = DAOFactory.getIUserDAOInstance().getUserInfo(c.getValue()) ;
			}
		}
	%>
	<div align="center">
		<form method="post" action="../UserInfoServlet">
		<table summary="个人信息" cellspacing="10">
			<tr>
				<td><label for="user">用户名</label></td>
				<td>
					<input required placeholder="请输入昵称" type="text" id="user" name="info" value="<%= info.getUsername()%>" onblur="checkUser(this.value)" />
					
					<span id="checkUsername"></span>
				</td>
			</tr>
			<tr>
				<td><label for="eamil">邮箱</label></td>
				<td>
					<input required placeholder="请输入邮箱" type="text" id="eamil" name="info" pattern="[0-9a-zA-Z]+@[a-z]+\.com" value="<%= info.getEmail() %>" onblur="checkEmail(this.value)" />
					<span id="checkEmail"></span>
				</td>
			</tr>
			<tr>
				<td><label for="pass">密码</label></td>
				<td>
					<input required placeholder="请输入密码" type="password" id="pass" name="info" value="<%= info.getPassword() %>" />
				</td>
			</tr>
			<tr>
				<td><label for="question">找回问题</label></td>
				<td>
					<input required placeholder="找回密码的凭证" type="text" id="question" name="info" value="<%= info.getQuestion() %>" />
				</td>
			</tr>
			<tr>
				<td><label for="answer">答案</label></td>
				<td>
					<input required type="text" id="answer" name="info" value="<%= info.getAnswer() %>" />
				</td>
			</tr>
			<tr>
				<td colspan="2" >
				<input type="submit" value="修改" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
</html>