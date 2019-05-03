package com.feemanagement.dao;

import java.util.List;

import javax.sql.DataSource;

import com.feemanagement.Bean.AccountantBean;
import com.feemanagement.Bean.StudentBean;

public interface StudentDao {

	// public void setDataSource(DataSource ds);
	public int save(StudentBean bean);
	public  List<StudentBean> getAllRecords();
	public int update(StudentBean bean);
	public StudentBean getRecordByRollNo(int rollno);
	public  List<StudentBean> getDues();
	public int delete(int rollno);
}
