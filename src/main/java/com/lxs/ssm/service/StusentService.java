package com.lxs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxs.ssm.bean.Student;
import com.lxs.ssm.dao.StudentMapper;

@Service
public class StusentService {

	@Autowired
	StudentMapper studentMapper;
	
	public List<Student> getAllStudents() {
		return studentMapper.selectByExample(null);
	}

}
