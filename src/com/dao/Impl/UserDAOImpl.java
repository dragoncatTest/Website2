package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.bean.UserInfo;
import com.dao.IUserDAO;

public class UserDAOImpl implements IUserDAO
{
	private Connection con ;
	private PreparedStatement pres ;
	public UserDAOImpl (Connection con)
	{
		this.con = con ;
	}
	public boolean queryUsername(String username) 
	{
		ResultSet result ;
		try
		{
			pres = con.prepareStatement("select * from userinfo where username=?") ;
			pres.setString(1,username) ;
			result = pres.executeQuery() ;
			if(result.next())
			{
				return true ;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false ;
	}
	public boolean queryEmail(String email) 
	{
		ResultSet result ;
		try
		{
			pres = con.prepareStatement("select * from userinfo where email=?") ;
			pres.setString(1,email) ;
			result = pres.executeQuery() ;
			if(result.next())
			{
				return true ;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false ;
	}
	public boolean createUser(UserInfo userinfo) 
	{
//		insert into userinfo(user,password,question,answer) values(?,?,?,?)
		try
		{
			pres = con.prepareStatement("insert into userinfo(username,email,password,question,answer) values(?,?,?,?,?)") ;
			pres.setString(1,userinfo.getUsername()) ;
			pres.setString(2,userinfo.getEmail()) ;
			pres.setString(3,userinfo.getPassword()) ;
			pres.setString(4,userinfo.getQuestion()) ;
			pres.setString(5,userinfo.getAnswer()) ;
			int i = pres.executeUpdate() ;
			if(i == 1)
			{
				return true ;
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false ;
	}
	@Override
	public boolean queryUserName_Password(UserInfo user_pass)
	{
		ResultSet result ;
		try 
		{
			pres = con.prepareStatement("select * from userinfo where username=? and password=?") ;
			pres.setString(1,user_pass.getUsername()) ;
			pres.setString(2,user_pass.getPassword()) ;
			result = pres.executeQuery() ;
			if(result.next())
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
	public UserInfo getUserInfo(String username) 
	{
		UserInfo info = new UserInfo () ;
		ResultSet result ;
		try 
		{
			pres = con.prepareStatement("select * from userinfo where username=?") ;
			pres.setString(1, username) ;
			result = pres.executeQuery() ;
			while(result.next())
			{
				info.setUsername(result.getString(1)) ;
				info.setPassword(result.getString(2)) ;
				info.setEmail(result.getString(3)) ;
				info.setQuestion(result.getString(4)) ;
				info.setAnswer(result.getString(5)) ;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return info ;
	}
	@Override
	public boolean updateUserInfo(UserInfo info) 
	{
		int i = 0 ;
		try
		{
			pres = con.prepareStatement("update userinfo set username=?,password=?,email=?,question=?,answer=? where username=? ") ;
			pres.setString(1, info.getUsername()) ;
			pres.setString(2, info.getPassword()) ;
			pres.setString(3, info.getEmail()) ;
			pres.setString(4, info.getQuestion()) ;
			pres.setString(5, info.getAnswer()) ;
			pres.setString(6, info.getUsername()) ;
			i = pres.executeUpdate() ;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(i == 1)
		{
			return true ;
		}
		return false;
	}
}
