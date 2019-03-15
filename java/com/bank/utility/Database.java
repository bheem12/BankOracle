package com.bank.utility;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Database {
		
		public Connection database() {
			
			Connection connection=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DATABASE","bheem");
				
				if(connection1!=null)
				return connection1;
				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return connection;	
		}
	}


