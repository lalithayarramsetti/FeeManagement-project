package com.feemanagement.Service;

import java.util.List;

import com.feemanagement.Bean.AccountantBean;

public interface AccountantService {
	public boolean validate(String email,String password) ;
		
	public int update(AccountantBean bean);
	public int save(AccountantBean bean);
	public List<AccountantBean> getAllRecords();
	public AccountantBean getRecordById(int id);
	public int delete(int id);
}
