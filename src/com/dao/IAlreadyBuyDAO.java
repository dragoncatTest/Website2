package com.dao;

import java.util.Vector;

import com.bean.AlreadyBuy;

public interface IAlreadyBuyDAO 
{
	public boolean createBuy (String username , String goodid , int num) ;
	public Vector<AlreadyBuy> getBuy (String username) ;
}
