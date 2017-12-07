package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserInfo;
import com.factory.DAOFactory;

public class UserLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserInfo user = new UserInfo () ;
		String[] info = request.getParameterValues("info") ;
		response.setCharacterEncoding("UTF-8") ;
		response.setContentType("text/html;charset=UTF-8") ;
		PrintWriter pw = response.getWriter() ;//如果printwriter出现乱码，应该是response输出中文有问题
		user.setUsername(info[0]) ;
		user.setPassword(info[1]) ;
		if(DAOFactory.getIUserDAOInstance().queryUserName_Password(user))
		{
			response.setHeader("refresh", "2;URL='index.jsp'") ;
			pw.println("<html>") ;
				pw.println("<meta charset='UTF-8'>") ;
				pw.println("<title>") ;
					pw.println("登录成功") ;
				pw.println("</title>") ;
				pw.println("<head>") ;
				pw.println("</head>") ;
				pw.println("<body>") ;
					pw.println("<p align='center'>登录成功,将在两秒后跳转到<a href='index.jsp'>主页</a></p>") ;
				pw.println("</body>") ;
			pw.println("</html>") ;
			
			Cookie[] cookies = request.getCookies() ;
			cookies[0].setMaxAge(31104000) ;
			response.addCookie(cookies[0]) ;
			
			Cookie userC = new Cookie("username",user.getUsername()) ;
			userC.setMaxAge(info.length == 3 ? 2592000 : -1) ;
			response.addCookie(userC) ;
			
			ServletContext context = request.getServletContext() ;
			if(context.getAttribute("userlist") == null)
			{
				Vector<String> list = new Vector<String> () ;
				list.add(user.getUsername()) ;
				context.setAttribute("userlist",list) ;
			}
			else
			{
				@SuppressWarnings("unchecked")
				Vector<String> list = (Vector<String>)context.getAttribute("userlist") ;
				list.addElement(user.getUsername()) ;
				context.setAttribute("userlist",list) ;
			}
			
		}
		else
		{
			pw.println("test") ;
		}
	}

}
