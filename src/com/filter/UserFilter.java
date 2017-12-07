package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse response = (HttpServletResponse)resp ;
		HttpServletRequest request = (HttpServletRequest)req ;
		response.setCharacterEncoding("UTF-8") ;
		response.setContentType("text/html;charset=UTF-8") ;
		PrintWriter pw = response.getWriter() ;
		Boolean flag = false ;
		Cookie[] cookies = request.getCookies() ;
		for(int i = 0 ; i < cookies.length ; i ++)
		{
			if(cookies[i].getName().equals("username"))
			{
				flag = true ;
			}
		}
		if(!flag)
		{
			pw.println("<html>") ;
			pw.println("<meta charset='UTF-8'>") ;
			pw.println("请先登录，1秒后跳转") ;
			pw.println("</html>") ;
			response.setHeader("refresh", "1;url=../index.jsp") ;
			return ;
		}
		chain.doFilter(req, resp) ;
	}

}
