package com.user;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Logout
 */
public class UserLogout extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie[] cookies = request.getCookies() ;//如果第一次访问这个页面，这段代码不会生效；如果浏览器中已经存在这个名为username的cookie，就不会
		if(cookies != null)
		{
			for(int i = 0 ; i < cookies.length ; i ++)
			{
				if(cookies[i].getName().equals("username"))
				{
					cookies[i].setMaxAge(0) ;
					response.addCookie(cookies[i]) ;
					ServletContext context = request.getServletContext() ;
					@SuppressWarnings("unchecked")
					Vector<String> list = (Vector<String>)context.getAttribute("userlist") ;
					list.remove(cookies[i].getValue()) ;
					break ;
				}
			}
		}
		response.sendRedirect("index.jsp") ;
//		HttpSession session = request.getSession() ;
//		if(session.getAttribute("username") != null)
//		{
//			session.removeAttribute("username") ;
//			response.sendRedirect("http://localhost:8080/First/RegisterLogin.jsp") ;
//		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response) ;
	}

}
