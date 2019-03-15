package com.bank.dao;

import com.bank.beans.Customerdetails;

public interface Registration {
	long Registration(Customerdetails customerDetails);
	public Customerdetails Login(long accountNo,String password);
	//int validation(long mobileno);

}
