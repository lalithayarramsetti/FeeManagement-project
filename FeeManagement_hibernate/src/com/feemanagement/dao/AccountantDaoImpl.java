package com.feemanagement.dao;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.feemanagement.Bean.AccountantBean;
import com.feemanagement.Listener.HibernateUtil;
@Repository("AccountantDao")
public class AccountantDaoImpl implements AccountantDao {
	@Autowired
	private SessionFactory sessionFactory;
	 
	
	

	 public boolean validate(String email, String password) {
	        AccountantBean user = getUserByUserId(email);         
	        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)){
	            return true;
	        }else{
	            return false;
	        }
	    }
	public AccountantBean getUserByUserId(String email)
	{
		Session session = HibernateUtil.openSession();
        Transaction tx = null;
        AccountantBean user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from com.feemanagement.Bean.AccountantBean where email='"+email+"'");
            user = (AccountantBean)query.uniqueResult();
            if (!tx.wasCommitted())
                tx.commit();
            
        } catch (Exception e) {
        	e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
           // e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
	}
	
	
	    public AccountantBean getRecordById(int id) {
	    	Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        AccountantBean user = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from com.feemanagement.Bean.AccountantBean where id='"+id+"'");
	            user = (AccountantBean)query.uniqueResult();
				

	            if (!tx.wasCommitted())
	                tx.commit();
	            session.flush();
	            
	        } catch (Exception e) {
	        	e.printStackTrace();
	            if (tx != null) {
	                tx.rollback();
	            }
	           // e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return user;
	    }
	    
	    public int update(AccountantBean updatedBean)
	    {
	    	int status=0;
	    	Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	    	try
	    	{
	    		tx=session.getTransaction();
	    		tx.begin();
	    		AccountantBean bean = (AccountantBean)session.get(AccountantBean.class, updatedBean.getId()); 
	            bean.setName(updatedBean.getName());
	            bean.setAddress(updatedBean.getAddress());
	            bean.setContact(updatedBean.getContact());
	            bean.setEmail(updatedBean.getEmail());
	    		session.update(bean); 
	    		//Query query=session.createQuery("update com.feemanagement.Bean.AccountantBean set name='"+bean.getName()+"',email='"+bean.getEmail()+"',password='"+bean.getPassword()+"',address='"+bean.getAddress()+"',contact='"+bean.getContact()+"' where id='"+bean.getId()+"'");
	    		//status = query.executeUpdate();
	    		 if (!tx.wasCommitted())
		                tx.commit();
		            
		        
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	            if (tx != null) {
	                tx.rollback();
	            }
	    	}
	    	 finally {
		            session.close();
		        }
	    	return status;
	    }
	   
	    public int save(AccountantBean bean)
	    {
	    	int status=0;
	    	//Session session = HibernateUtil.openSession();
	    	 Session session = sessionFactory.openSession();
	        
	        System.out.println("into insert method");
	        System.out.println(bean.getEmail());
	        try
	        {
	        	  session.beginTransaction();
	    		System.out.println("into try block");
	    		status = (Integer) session.save(bean); 
	    		

	        }
	        catch (HibernateException e) {
	              e.printStackTrace();
	              session.getTransaction().rollback();
	        }
	            
	            finally {
		            session.close();
		        }
	        session.getTransaction().commit();
	    	return status;
	    }
	 
	    			
	    	 
	    
	  
	    public List<AccountantBean> getAllRecords()
	    {
	    	Session session = sessionFactory.openSession();

			try {
				
				 @SuppressWarnings("unchecked")
				List<AccountantBean> list = session.createQuery("FROM com.feemanagement.Bean.AccountantBean").list(); 
				return list;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				session.close();
			}

	    }
	 
	    public  int delete(int id) {
			Session session = HibernateUtil.openSession();
			Transaction tr = null;
			try {
				tr = session.beginTransaction();
				AccountantBean record = (AccountantBean) session.get(AccountantBean.class, id);
				
				session.delete(record);
				tr.commit();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				session.close();

			}
			
			
		}

}
