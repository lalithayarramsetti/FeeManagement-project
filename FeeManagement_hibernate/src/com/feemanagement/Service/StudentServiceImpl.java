package com.feemanagement.Service;

import java.util.List;

import com.feemanagement.Bean.StudentBean;


import com.feemanagement.dao.StudentDao;
import com.feemanagement.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService{
	private StudentDao accdao=new StudentDaoImpl();
	@Override
	public int save(StudentBean bean)
	{
		return accdao.save(bean);
	}
	@Override
	public List<StudentBean> getAllRecords() {
		// TODO Auto-generated method stub
		return accdao.getAllRecords();
	}
	@Override
	public int update(StudentBean bean) {
		// TODO Auto-generated method stub
		return accdao.update(bean);
	}
	@Override
	public StudentBean getRecordByRollNo(int rollno) {
		// TODO Auto-generated method stub
		return accdao.getRecordByRollNo(rollno);
	}
	@Override
	public List<StudentBean> getDues() {
		// TODO Auto-generated method stub
		return accdao.getDues();
	}
	@Override
	public int delete(int rollno) {
		// TODO Auto-generated method stub
		return accdao.delete(rollno);
	}

}
