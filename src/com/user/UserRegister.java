package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.UserInfo;
import com.factory.DAOFactory;

public class UserRegister extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response) ;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UserInfo user = new UserInfo () ;
		String[] info = request.getParameterValues("info") ;
		response.setCharacterEncoding("UTF-8") ;
		response.setContentType("text/html;charset=UTF-8") ;
		PrintWriter pw = response.getWriter() ;//如果printwriter出现乱码，应该是response输出中文有问题
		user.setUsername(info[0]) ;
		user.setEmail(info[1]) ;
		user.setPassword(info[2]) ;
		user.setQuestion(info[3]) ;
		user.setAnswer(info[4]) ;
		if(DAOFactory.getIUserDAOInstance().createUser(user))//调用工厂类创建代理类，并把代理类变成dao接口类，下传装载着数据的bean
		{
			response.setHeader("refresh", "3;URL='index.jsp'") ;
			pw.println("<html>") ;
				pw.println("<meta charset='UTF-8'>") ;
				pw.println("<title>") ;
					pw.println("注册成功") ;
				pw.println("</title>") ;
				pw.println("<head>") ;
				pw.println("</head>") ;
				pw.println("<body>") ;
					pw.println("<p align='center'>注册成功,将在三秒后跳转到<a href='index.jsp'>主页</a></p>") ;
				pw.println("</body>") ;
			pw.println("</html>") ;
			
			Cookie[] cookies = request.getCookies() ;
			cookies[0].setMaxAge(31104000) ;
			response.addCookie(cookies[0]) ;
			
			Cookie userC = new Cookie("username",user.getUsername()) ;
			userC.setMaxAge(-1) ;
			response.addCookie(userC) ;
		}
	}

}
