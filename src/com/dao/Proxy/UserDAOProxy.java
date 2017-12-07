package com.dao.Proxy;

import java.util.Vector;

import com.bean.UserInfo;
import com.dao.IUserDAO;
import com.dao.Impl.UserDAOImpl;
import com.database.*;

public class UserDAOProxy implements IUserDAO
{
	private DatabaseConnection con ;
	private IUserDAO dao ;
	public UserDAOProxy () //实例化代理类的时候，代理类会打开数据库的连接，实例化真实类，下放connection
	{
		con = new DatabaseConnection () ;
		dao = new UserDAOImpl (con.getConnection()) ;
	}
	public boolean queryUsername(String username) 
	{
		if(dao.queryUsername(username))
		{
			return true ;
		}
		return false ;
	}
	public boolean queryEmail(String email) 
	{
		if(dao.queryEmail(email))
		{
			return true ;
		}
		return false ;
	}
	public boolean createUser(UserInfo userinfo) //代理类外部的判断，这个判断是与数据库有关的，所以判断交给代理类执行
	{
		if(!dao.queryEmail(userinfo.getEmail())&&!dao.queryUsername(userinfo.getUsername()))
		{
			if(dao.createUser(userinfo))
			{
				return true ;
			}//如果代理类的判断通过，就通过接口dao执行真实类的，原子性的只与数据库有关的操作
		}
		return false ;
	}
	@Override
	public boolean queryUserName_Password(UserInfo user_pass) 
	{
		if(dao.queryUserName_Password(user_pass))
		{
			return true ;
		}
		return false;
	}
	@Override
	public UserInfo getUserInfo(String username) 
	{
		return dao.getUserInfo(username) ;
	}
	@Override
	public boolean updateUserInfo(UserInfo userinfo) 
	{
		if(dao.updateUserInfo(userinfo))
		{
			return true ;
		}
		return false;
	}
}
