<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		Vector<String> list = (Vector<String>)application.getAttribute("userlist") ;
	%>
	<div align="left">
		<table border="1">
			<tr><td>用户名</td></tr>
			<%
				for(String s : list)
				{
			%>
					<tr><td><%=s%></td></tr>	
			<%
				}
			%>
			
		</table>
	</div>
</body>
</html>