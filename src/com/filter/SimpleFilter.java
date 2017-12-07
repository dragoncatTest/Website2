package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter
{
	String str ;
	public void init(FilterConfig config)
	{
		str = config.getInitParameter("charset") ;
	}
	public void doFilter(ServletRequest req , ServletResponse resp , FilterChain chain) throws IOException, ServletException
	{
		req.setCharacterEncoding(str) ;
		chain.doFilter(req,resp) ;
	}
}
