package com.bank.ui;

import java.util.Scanner;

import com.bank.beans.Customerdetails;

import com.bank.dao.Registration;

import com.bank.daoimpl.RegistrationImpl;
import com.bank.daoimpl.TransactionImpl;
import com.bank.service.CustomerService;
import com.bank.service.CustomerServiceImpl;
import com.bank.service.TransactionServiceImpl;

public class Menu {
	static Scanner s=new Scanner(System.in);
	static Customerdetails cust=new Customerdetails();
	static CustomerService customerservice=new CustomerServiceImpl();
	static TransactionImpl transdao=new TransactionImpl();
	static TransactionServiceImpl transserv=new TransactionServiceImpl();
	static Registration r=new RegistrationImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		System.out.println("Enter your choice :");
		System.out.println("1.Registration \n 2.Login\n 3.exit");
		
		int ch=s.nextInt();
		
		switch(ch) {
		
		case 1 : 
			
		System.out.println("Enter First Name :");
		cust.setFirstname(s.next());		
		System.out.println("Enter Last Name :");
		cust.setLastname(s.next());
		System.out.println("enter email id");
		cust.setEmailid(s.next());
		System.out.println("Enter password :");
		cust.setPassword(s.next());
		
		System.out.println("Enter PAN Number :");
		cust.setPancardno(s.next());
		System.out.println("Enter Aadhar Card Number :");
		cust.setAadharnoo(s.nextLong());
		System.out.println("Enter Address :");
		cust.setAddress(s.next());
		System.out.println("enter phone number");
		cust.setMobileno(s.nextLong());
		
		
		long accountno=customerservice.Registration(cust);
		System.out.println("Account registerd successfully.your accno is: "+accountno);
		
		break;
		
		case 2 :// Login 
			System.out.println("Enter accno and password");
			long accountNo=s.nextLong();
			String password=s.next();
		cust=r.Login( accountNo,  password);
			if(cust!=null)
				{System.out.println("yes");
				System.out.println("Enter the choice 1:withdraw  2:deposit  3:fundtransfer 4:show balance ");
				int ch2=s.nextInt();
				switch(ch2)
				{
				case 1: //withdraw
					
					System.out.println("enter amount to withdraw");
					int j=transserv.withdrawal(accountNo,cust.getBalance(),s.nextDouble());
					if(j==1) System.out.println("successfully withdrawl");
					else System.out.println("Insufficient bal");
					break;
				case 2: //deposit
					System.out.println("enter amount to deposit");
					int k=transserv.deposit(accountNo,cust.getBalance(),s.nextDouble());
					if(k==1) System.out.println("successfully deposited");
					else System.out.println("error in depositing");
					
					break;
					
				case 3: //fund transfer
					System.out.println("enter amount to transfer");
					double amt=s.nextDouble();
					System.out.println("enter To_account no");
					long toaccountNo=s.nextLong();
					int l=transserv.fundTransfer(accountNo,cust.getBalance(),toaccountNo,amt);
					if(l==1)
						System.out.println("sucessfully transferred");
					else
						System.out.println("failed to transfer");
					break;
				case 4: //show balance
					System.out.println("your current account balance is"+cust.getBalance());
				break;
				}
				
				}
				
			else
			{
				System.out.println("Wrong credentials");
			}
		//l.Login();
		break;
		case 3: System.out.println("exit");
		    System.exit(0);
		break;
		default : System.out.println("Wrong Choice");
		}

	}
	
	}
}

		

	


