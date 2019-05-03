package com.feemanagement.Service;

import java.util.List;


import com.feemanagement.Bean.StudentBean;

public interface StudentService {
public int save(StudentBean bean);
public List<StudentBean> getAllRecords();
public int update(StudentBean bean);
public StudentBean getRecordByRollNo(int rollno);
public  List<StudentBean> getDues();
public int delete(int rollno);
}
