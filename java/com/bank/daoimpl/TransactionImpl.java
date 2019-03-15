package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bank.beans.TransactionDetails;
import com.bank.dao.Transaction;
import com.bank.ui.Menu;

public class TransactionImpl implements Transaction {
	Scanner sc=new Scanner(System.in);

	Menu m=new Menu();
	public int deposit(long accountNumber, double amount,double amt) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DATABASE","bheem");
		
			PreparedStatement ps = connection.prepareStatement("update customer_details set balance=? where account_no=?");
			ps.setDouble(1,amount+amt);
			ps.setLong(2, accountNumber);
			
			i=ps.executeUpdate();
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}

	
	//withdraw
	public int withdrawal(long accountNumber, double amount ,double amt) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DATABASE","bheem");
			if(amt<amount) {
			
			PreparedStatement ps = connection.prepareStatement("update customer_details set balance=? where account_no=?");
			ps.setDouble(1,amount-amt);
			ps.setLong(2, accountNumber);
			
			i=ps.executeUpdate();
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return i;
	}


	

	public int fundTransfer(long fromaccountNo,double amount,long toaccountNo,double amt) {
		int i=0;
		double toamount=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DATABASE","bheem");
			if(amt<amount) {
			
			PreparedStatement ps = connection.prepareStatement("update customer_details set balance=? where account_no=?");
			ps.setDouble(1,amount-amt);
			ps.setLong(2, fromaccountNo);
			ps.executeUpdate();
			
			
			PreparedStatement ps1 = connection.prepareStatement("select * from customer_details where account_no=? ");
			ps1.setLong(1, toaccountNo);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				 toamount=rs.getDouble(10);
			
			
			PreparedStatement ps2 = connection.prepareStatement("update customer_details set balance=? where account_no=?");
			ps2.setDouble(1,toamount+amt);
			ps2.setLong(2, toaccountNo);
			ps2.executeUpdate();
			}
			
			
			
			PreparedStatement ps3 = connection.prepareStatement("insert into transaction_deatils values(trans_seq.nextval,?,?,?)");
			ps3.setLong(1, fromaccountNo);
			ps3.setLong(2, toaccountNo);
			ps3.setDouble(3, amt);
			i=ps3.executeUpdate();
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}


	}


