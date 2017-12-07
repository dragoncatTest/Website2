<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.factory.DAOFactory" %>
<%@ page import="com.bean.*" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>

	<table align="center">
		<tr>
			<td>名称</td><td>数量</td>
		</tr>
		<%
		Cookie[] cookies = request.getCookies() ;
		Vector<AlreadyBuy> vec = null ;
		for(Cookie c : cookies)
		{
			if(c.getName().equals("username"))
			{
				vec = DAOFactory.getIAlreadyBuyDAOInstance().getBuy(c.getValue()) ;
			}
		}
		for(int i = 0 ; i < vec.size() ; i ++)
		{
			AlreadyBuy buy = vec.get(i) ;
		%>
			<tr>
				<td><%=buy.getGoodname() %></td>
				<td><%=buy.getNum() %></td>
			</tr>
		<%
		}
	%>
	</table>

</body>
</html>