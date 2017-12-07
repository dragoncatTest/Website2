package com.user;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.DAOFactory;
import com.bean.*;

public class UserInfoServlet extends HttpServlet 
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
		user.setUsername(info[0]) ;
		user.setEmail(info[1]) ;
		user.setPassword(info[2]) ;
		user.setQuestion(info[3]) ;
		user.setAnswer(info[4]) ;
		PrintWriter pw = response.getWriter() ;
		if(DAOFactory.getIUserDAOInstance().updateUserInfo(user))
		{
			pw.println("成功修改") ;
			response.sendRedirect("index.jsp") ;
		}
	}

}
