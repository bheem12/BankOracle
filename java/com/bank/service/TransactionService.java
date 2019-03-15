package com.bank.service;

import com.bank.beans.Customerdetails;
import com.bank.beans.TransactionDetails;

public interface TransactionService {
	public int deposit(long accountNumber,double amount,double amt);
	public int withdrawal(long accountNumber,double amount,double amt);
	
	public int fundTransfer(long fromaccountNo,double amount,long toaccountNo,double amt);

}
