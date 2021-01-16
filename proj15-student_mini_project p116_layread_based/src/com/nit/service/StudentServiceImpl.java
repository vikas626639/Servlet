package com.nit.service;

import com.nit.bo.StudentBO;
import com.nit.dao.StudentDao;
import com.nit.dao.StudentDaoImple;
import com.nit.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String GenerateResult(StudentDTO dto) {
		Integer total;
		float avg;
		String status;
		String result = null;
		StudentDao dao=null;
		
		//get data from dto class
		total=dto.getMark1()+dto.getMark2()+dto.getMark3();
		avg=total/3.0f;
		status=(avg<=35)?"FAIL":"PASS";
		
		//set data to bo class
		//creating object of bo class
		StudentBO bo=null;
		bo=new StudentBO();
		bo.setNo(dto.getNo());
		bo.setName(dto.getName());
		bo.setMark1(dto.getMark1());
		bo.setMark2(dto.getMark2());
		bo.setMark3(dto.getMark3());
		bo.setTotal(total);
		bo.setPersent(avg);
		bo.setStatus(status);
		
		//use dao method for result
		dao=new StudentDaoImple();
		int count=dao.insertStudentRecord(bo);
		return result=(count==1)?"RAGISTRATION SUCCESSFULL AND RESULT "+status:"RAGISTRATION FAILED";
	}

	
}
