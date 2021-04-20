package com;

import java.sql.*;

public class DBConnection {

	public Connection Connect() {

		Connection con = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhoast:3306/paf","root", "root");
			
			//For testing
			System.out.print("Successfully connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	

}
