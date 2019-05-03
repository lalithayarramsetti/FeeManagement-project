package com.feemanagement.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import com.feemanagement.Bean.*;
import com.feemanagement.Listener.HibernateUtil;
import com.feemanagement.dao.AccountantDao;
import com.feemanagement.dao.AccountantDaoImpl;
@Service
@Transactional
public class AccountantServiceImpl implements AccountantService{
	@Autowired
	private AccountantDao accdao;
	
	@Override
	public boolean validate(String email,String password)
	{
	return accdao.validate(email, password);
	}
	     //public 
	@Transactional
	@Override
	public int update(AccountantBean bean)
	{
		return accdao.update(bean);
	}
	
	@Override
	public List<AccountantBean> getAllRecords(){
		return accdao.getAllRecords();
	}
	public AccountantBean getRecordById(int id) {
		return accdao.getRecordById(id);
	}
	@Override
	@Transactional
	public int delete(int id) {
		return accdao.delete(id);
	}
	@Override
	@Transactional
	public int save(AccountantBean bean) {
		// TODO Auto-generated method stub
		return accdao.save(bean);
	}
}
