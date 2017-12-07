package com.user.check;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.*;

public class EmailCheck extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email") ;
		response.setCharacterEncoding("UTF-8") ;
		PrintWriter pw = response.getWriter() ;
		if(DAOFactory.getIUserDAOInstance().queryEmail(email))
		{
			pw.println("该email已经被使用") ;
		}
		else
		{
			pw.println("该email可以被注册") ;
		}
		
	}

}
