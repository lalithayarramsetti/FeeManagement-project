package com.feemanagement.dao;
import java.util.List;

import com.feemanagement.Bean.*;
public interface AccountantDao {
	public boolean validate(String email,String password);
	public int update(AccountantBean bean);
	public int save(AccountantBean bean);
	public  List<AccountantBean> getAllRecords();
		// TODO Auto-generated method stub
	public AccountantBean getRecordById(int id);
		public int delete(int id);
	
}
