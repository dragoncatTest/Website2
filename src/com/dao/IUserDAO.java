package com.dao;
import com.bean.*;
public interface IUserDAO 
{
	public boolean queryUsername(String username) ;
	public boolean queryEmail(String email) ;
	public boolean createUser(UserInfo userinfo) ;
	public boolean queryUserName_Password(UserInfo password) ;
	public UserInfo getUserInfo (String username) ;
	public boolean updateUserInfo(UserInfo userinfo) ;
}
