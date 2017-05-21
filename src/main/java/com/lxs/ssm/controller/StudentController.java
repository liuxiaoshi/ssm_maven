package com.lxs.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxs.ssm.bean.Student;
import com.lxs.ssm.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	IStudentService  studService ;
	
	@RequestMapping("/studs")
	public  String  getAllStudents(
			@RequestParam(value="pn",defaultValue="1")Integer pn,
			Model model){
    //在查询之前使用分页   pn第几页 每页10条
	PageHelper.startPage(pn, 10);	
	List<Student> students=studService.getAllStudents();
	//可以使用PageInfo对结果集合进行包装 直接把pageInfo交给前端页面
	//第二个参数表示连续显示的页数 5页
	PageInfo pageInfo = new PageInfo(students,5);
	//model.addAttribute("studs", students);
	model.addAttribute("pageInfo", pageInfo);
	return "list" ;
	}
}
