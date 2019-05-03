package com.feemanagement.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.feemanagement.Bean.AccountantBean;
import com.feemanagement.Bean.StudentBean;
import com.feemanagement.Listener.HibernateUtil;

public class StudentDaoImpl implements StudentDao{

	

	@Override
	public int save(StudentBean bean) {
		// TODO Auto-generated method stub
		int status=0;
    	Session session = HibernateUtil.openSession();
        Transaction tx = null;
        System.out.println("into insert method");
        System.out.println(bean.getEmail());
        try
        {
        	 tx = session.beginTransaction();
    		System.out.println("into try block");
    		status = (Integer) session.save(bean); 
    		System.out.print(status+"in dao class");
    				        tx.commit();

        }
    			    catch(Exception e)
    			    {
    			    	if (tx!=null) tx.rollback();
    			    	System.out.println("exception");
    			                             
    			    }
    			  
    			
    	 finally {
	            session.close();
	        }
    	return status;
	}

	@Override
	public List<StudentBean> getAllRecords() {
		Session session = HibernateUtil.openSession();

		try {
			System.out.println("in dao class");
			
			 List<StudentBean> list = session.createQuery("FROM com.feemanagement.Bean.StudentBean").list(); 
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("exception");
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public int update(StudentBean updatedBean) {
		int status=0;
    	Session session = HibernateUtil.openSession();
        Transaction tx = null;
    	try
    	{
    		tx=session.getTransaction();
    		tx.begin();
    		StudentBean bean = (StudentBean)session.get(StudentBean.class, updatedBean.getRollno()); 
            bean.setName(updatedBean.getName());
            bean.setEmail(updatedBean.getEmail());
            bean.setCourse(updatedBean.getCourse());
            bean.setFee(updatedBean.getFee());
            bean.setPaid(updatedBean.getPaid());
            bean.setDue(updatedBean.getDue());
            bean.setAddress(updatedBean.getAddress());
            bean.setContact(updatedBean.getContact());
            
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

	@Override
	public StudentBean getRecordByRollNo(int rollno) {
		Session session = HibernateUtil.openSession();
        Transaction tx = null;
      StudentBean user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from com.feemanagement.Bean.StudentBean where rollno='"+rollno+"'");
            user = (StudentBean)query.uniqueResult();
			

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

	@Override
	
	public List<StudentBean> getDues() {
		Session session = HibernateUtil.openSession();

		try {
			System.out.println("in dao class");
			
			 List<StudentBean> list = session.createQuery("FROM com.feemanagement.Bean.StudentBean where due>0").list(); 
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("exception");
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public int delete(int rollno) {
		Session session = HibernateUtil.openSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			StudentBean record = (StudentBean) session.get(StudentBean.class,rollno);
			
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

