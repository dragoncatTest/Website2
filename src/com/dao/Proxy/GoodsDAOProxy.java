package com.dao.Proxy;

import java.util.Vector;

import com.bean.GoodsInfo;
import com.dao.IGoodsDAO;
import com.dao.Impl.GoodsDAOImpl;
import com.database.DatabaseConnection;

public class GoodsDAOProxy implements IGoodsDAO
{
	private DatabaseConnection con ;
	private IGoodsDAO dao ;
	public GoodsDAOProxy ()
	{
		con = new DatabaseConnection () ;
		dao = new GoodsDAOImpl (con.getConnection()) ;
	}
	@Override
	public Vector<GoodsInfo> getAllInfo()
	{
		return dao.getAllInfo() ;
	}
	@Override
	public GoodsInfo getOneInfo(String goodid) 
	{
		if(goodid != null)
		{
			return dao.getOneInfo(goodid) ;
		}
		return null ;
	}
}
