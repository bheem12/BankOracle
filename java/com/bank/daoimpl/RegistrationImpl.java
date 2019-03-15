package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bank.beans.Customerdetails;
import com.bank.dao.Registration;
import com.bank.utility.Database;

public class RegistrationImpl implements Registration {
	static Customerdetails cust=new Customerdetails();
	Database d=new Database();

	Scanner s=new Scanner(System.in);
	

	
		public long Registration(Customerdetails cust) {
		// TODO Auto-generated method stub
		long accountno=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DATABASE","bheem");
			
			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into customer_details values(acc_no_seq.nextval,?,?,?,?,?,?,?,?,?)");
           preparedStatement.setString(1,cust.getFirstname());
			preparedStatement.setString(2, cust.getLastname());
			preparedStatement.setString(3, cust.getEmailid());
			
			preparedStatement.setString(4,cust.getPassword());
			
			//preparedStatement.setString(5, cust.getAccountType());
			preparedStatement.setString(5, cust.getPancardno());
			preparedStatement.setLong(6, cust.getAadharnoo());
			preparedStatement.setString(7, cust.getAddress());
			preparedStatement.setLong(8,cust.getMobileno());
			
			preparedStatement.setInt(9,0);
			int i=preparedStatement.executeUpdate();
			System.out.println(i);
			PreparedStatement ps2 = connection.prepareStatement("select * from customer_details where aadhaar_no=?");
			//Customerdetails cust=null;
			ps2.setLong(1, cust.getAadharnoo());
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				accountno = rs.getLong(1);
				System.out.println(rs.getString(2));
		
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	
	return accountno;
		
	}
		
		
	public Customerdetails Login(long accountNo, String password) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection connection=d.database();
			PreparedStatement ps=connection.prepareStatement("select * from customer_details where account_no=? and password=?");
			ps.setLong(1,accountNo);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				cust.setBalance(rs.getDouble(10));
					count++;
			
			}
			
		
			connection.close();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count==0) {
			return null;
		}
		else 
			return cust;
		
	
}
}