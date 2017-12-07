package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
	private final String Scon = "jdbc:mysql://localhost/homework?characterEncoding=utf8" ;
	private final String DBusername = "root" ;
	private final String DBpassword = "linzihao" ;
	private Connection con ;
	public DatabaseConnection ()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver") ;
			con = DriverManager.getConnection(Scon,DBusername,DBpassword) ;
		} catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public Connection getConnection ()
	{
		return con ;
	}
	public void close()
	{
		if(con != null)
		{
			try 
			{
				con.close() ;
			} catch (SQLException e)
			{
				e.printStackTrace();
			} 
		}
	}
}
