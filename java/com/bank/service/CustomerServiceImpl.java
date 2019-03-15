package com.bank.service;

import com.bank.beans.Customerdetails;
import com.bank.dao.Registration;
import com.bank.daoimpl.RegistrationImpl;

public class CustomerServiceImpl implements CustomerService{
	Registration customerDao=new RegistrationImpl();
     

	public long Registration(Customerdetails customerDetails) {
		// TODO Auto-generated method stub
		long accountno=customerDao.Registration(customerDetails);
		return accountno ;
	}

	public boolean Login(Long accountNumber, String password) {
		// TODO Auto-generated method stub
		boolean b=customerDao.Login(accountNumber, password);
		return b;
	}

	
}
