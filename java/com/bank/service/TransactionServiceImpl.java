package com.bank.service;

import com.bank.beans.Customerdetails;
import com.bank.beans.TransactionDetails;
import com.bank.dao.Transaction;
import com.bank.daoimpl.TransactionImpl;

public class TransactionServiceImpl implements TransactionService{
	Transaction transdao=new TransactionImpl();

	public int withdrawal(long accountNumber, double amount, double amt) {
		// TODO Auto-generated method stub
		return transdao.withdrawal(accountNumber,amount,amt);
	}

	public int deposit(long accountNumber, double amount, double amt) {
		// TODO Auto-generated method stub
		return transdao.deposit(accountNumber,amount,amt);
	}

	public int fundTransfer(long fromaccountNo, double amount, long toaccountNo, double amt) {
		// TODO Auto-generated method stub
		return transdao.deposit(fromaccountNo,amount,amt);
	}
}

	