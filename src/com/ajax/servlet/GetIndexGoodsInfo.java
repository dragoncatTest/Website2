package com.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.*;
import com.google.gson.Gson;


import java.util.Vector;
import com.bean.GoodsInfo;

public class GetIndexGoodsInfo extends HttpServlet 
{
	private static final long serialVersionUID = 1L ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("UTF-8") ;
		PrintWriter pw = response.getWriter() ;
		Vector<GoodsInfo> vec ;
		vec = DAOFactory.getIGoodsDAOInstance().getAllInfo() ;
		Gson son = new Gson() ;
		String s = son.toJson(vec) ;
		pw.println(s) ;
	}

}
