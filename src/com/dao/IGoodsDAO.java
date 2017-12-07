package com.dao;

import java.util.Vector;

import com.bean.GoodsInfo;

public interface IGoodsDAO 
{
	public Vector<GoodsInfo> getAllInfo () ;
	public GoodsInfo getOneInfo (String goodid) ;
}
