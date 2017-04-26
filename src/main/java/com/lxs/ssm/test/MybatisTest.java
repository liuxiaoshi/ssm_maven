package com.lxs.ssm.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxs.ssm.bean.Student;
import com.lxs.ssm.dao.StudentMapper;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MybatisTest {
    
	@Autowired
	StudentMapper  studentMapper;
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public  void  test01(){
		System.out.print(studentMapper);
		Student record =new Student(null,"lxs","lxslxs");
		studentMapper.insert(record);
	}
	
	@Test
	public  void  test02(){
		StudentMapper  studentMapper = sqlSession.getMapper(StudentMapper.class);
		for(int i=11;i<100;i++){
			studentMapper.insert(new Student(null,"lxs"+i,"lxslxs"+i));
			
		}
	}
}
