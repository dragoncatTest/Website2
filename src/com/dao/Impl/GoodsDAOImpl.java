package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.bean.GoodsInfo;
import com.dao.IGoodsDAO;

public class GoodsDAOImpl implements IGoodsDAO
{
	private Connection con ;
	private PreparedStatement pres ;
	public GoodsDAOImpl (Connection con)
	{
		this.con = con ;
	}
	@Override
	public Vector<GoodsInfo> getAllInfo()
	{
		Vector<GoodsInfo> vec = new Vector<GoodsInfo> () ;
		ResultSet result ;
		try 
		{
			pres = con.prepareStatement("select * from goodsinfo") ;
			result = pres.executeQuery() ;
			while(result.next())
			{
				GoodsInfo info = new GoodsInfo() ;
				info.setName(result.getString(1)) ;
				info.setGoodid(result.getString(2)) ;
				info.setDescription(result.getString(3)) ;
				info.setPrice(result.getInt(4)) ;
				info.setPicture(result.getString(5)) ;
				vec.add(info) ;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vec ;
	}

	@Override
	public GoodsInfo getOneInfo(String goodid) 
	{
		GoodsInfo info = new GoodsInfo () ;
		ResultSet result ;
		try 
		{
			pres = con.prepareStatement("select * from goodsinfo where goodid = ?") ;
			pres.setString(1,goodid) ;
			result = pres.executeQuery() ;
			if(result.next())
			{
				info.setName(result.getString(1)) ;
				info.setGoodid(result.getString(2)) ;
				info.setDescription(result.getString(3)) ;
				info.setPrice(result.getInt(4)) ;
				info.setPicture(result.getString(5)) ;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return info ;
	}
	
}
