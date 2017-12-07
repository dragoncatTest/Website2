package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.bean.AlreadyBuy;
import com.bean.GoodsInfo;
import com.dao.IAlreadyBuyDAO;

public class AlreadyBuyDAOImpl implements IAlreadyBuyDAO
{
	private Connection con ;
	private PreparedStatement pres ;
	public AlreadyBuyDAOImpl (Connection con)
	{
		this.con = con ;
	}
	@Override
	public boolean createBuy(String username, String goodname, int num)
	{
		try
		{
			pres = con.prepareStatement("insert into alreadybuy(username,goodname,num) values(?,?,?)") ;
			pres.setString(1, username) ;
			pres.setString(2, goodname) ;
			pres.setInt(3, num) ;
			int i = pres.executeUpdate() ;
			if(i == 1)
			{
				return true ;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Vector<AlreadyBuy> getBuy(String username) 
	{
		Vector<AlreadyBuy> vec = new Vector<AlreadyBuy> () ;
		ResultSet result ;
		try 
		{
			pres = con.prepareStatement("select * from alreadybuy where username=?") ;
			pres.setString(1, username) ;
			result = pres.executeQuery() ;
			while(result.next())
			{
				AlreadyBuy buy = new AlreadyBuy () ;
				buy.setUsername(result.getString(1)) ;
				buy.setGoodname(result.getString(2)) ;
				buy.setNum(result.getInt(3)) ;
				vec.add(buy) ;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vec ;
	}

}
