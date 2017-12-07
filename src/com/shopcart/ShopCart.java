package com.shopcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.GoodsInfo;
import com.factory.DAOFactory;
/**
 * Servlet implementation class ShopCart
 */
public class ShopCart extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie[] cookies = request.getCookies() ;
		String str = null ;
		boolean flag = false ;
		for(Cookie o : cookies)
		{
			if(o.getName().equals("username"))
			{
				flag = true ;
				str = o.getValue() ;
				String[] info = request.getParameterValues("info") ;
				DAOFactory.getIAlreadyBuyDAOInstance().createBuy(str, info[0], Integer.valueOf(info[1])) ;
				response.sendRedirect("index.jsp") ;
			}
		}
		if(!flag)
		{
			response.sendRedirect("index.jsp") ;
		}
	}

}
