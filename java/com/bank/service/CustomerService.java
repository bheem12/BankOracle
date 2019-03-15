package com.bank.service;

import com.bank.beans.Customerdetails;

public interface CustomerService {
	public long Registration(Customerdetails customerDetails);
	public boolean Login(Long accountNumber,String password);
	
}
