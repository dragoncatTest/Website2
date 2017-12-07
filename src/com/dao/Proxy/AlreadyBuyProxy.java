package com.dao.Proxy;

import java.util.Vector;

import com.bean.AlreadyBuy;
import com.dao.IAlreadyBuyDAO;
import com.dao.Impl.AlreadyBuyDAOImpl;
import com.database.DatabaseConnection;

public class AlreadyBuyProxy implements IAlreadyBuyDAO
{
	private DatabaseConnection con ;
	private IAlreadyBuyDAO dao ;
	public AlreadyBuyProxy () //实例化代理类的时候，代理类会打开数据库的连接，实例化真实类，下放connection
	{
		con = new DatabaseConnection () ;
		dao = new AlreadyBuyDAOImpl (con.getConnection()) ;
	}
	@Override
	public boolean createBuy(String username, String goodname, int num) 
	{
		dao.createBuy(username, goodname, num) ;
		return false;
	}
	@Override
	public Vector<AlreadyBuy> getBuy(String username)
	{
		return dao.getBuy(username) ;
	}

	
}
