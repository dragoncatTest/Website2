package com.user.check;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.*;

public class UserNameCheck extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username") ;
		response.setCharacterEncoding("UTF-8") ;
		PrintWriter pw = response.getWriter() ;
		if(DAOFactory.getIUserDAOInstance().queryUsername(username))
		{
			pw.println("该用户名已经被使用") ;
		}
		else
		{
			pw.println("该用户名可以被注册") ;
		}
		
	}

}
