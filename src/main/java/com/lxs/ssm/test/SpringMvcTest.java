package com.lxs.ssm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.lxs.ssm.bean.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/lxsDispatcherServlet-servlet.xml"})
public class SpringMvcTest {
	@Autowired
	WebApplicationContext context;
	
	 MockMvc mockMvc;
	 
	 @Before
	 public void initMockMvc(){
		 mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	 }
	 
	 @Test
	 public void  testSpringMvc() throws Exception {
		 MvcResult result =mockMvc.perform(
				 MockMvcRequestBuilders.get("/studs")
				 .param("pn", "1"))
		         .andReturn();
		 MockHttpServletRequest  request =result.getRequest();
//		 List<Student> students=(List<Student>)request.getAttribute("studs");
//	     for(Student student:students){
//	    	 System.out.println(student);
//	     }
		 PageInfo  pi =(PageInfo)request.getAttribute("pageInfo");
		 List<Student> students=pi.getList();
	     for(Student student:students){
	    	 System.out.println(student.getStuName()+"----------"+student.getStuAdd());
	     }
	 }

}
