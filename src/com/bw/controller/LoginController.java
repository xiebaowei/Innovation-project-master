package com.bw.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.mapper.AdjuMapper;
import com.bw.mapper.AdminMapper;
import com.bw.mapper.StudentMapper;
import com.bw.mapper.TeacherMapper;
import com.bw.model.AdjuBean;
import com.bw.model.AdminBean;
import com.bw.model.StudentBean;
import com.bw.model.TeacherBean;

@Controller
public class LoginController {

	
	@Autowired
	private AdjuMapper adjumapper;
	
	@Autowired
	private AdminMapper adminmapper;
	
	@Autowired
	private StudentMapper studentmapper;
	
	@Autowired
	private TeacherMapper teachermapper;
	
	
	
	@RequestMapping("login")
	public String  login(String username,String password,Model model) {
		
		
		AdjuBean adju = new AdjuBean();
		adju= adjumapper.findById(username);
		
		AdminBean admin = new AdminBean();
		admin = adminmapper.findById(username);
		
		
		StudentBean stu = new StudentBean();
		stu = studentmapper.findById(username);
		
		TeacherBean tea = new TeacherBean();
		tea = teachermapper.findById(username);
		
		
		if(adju!=null && username != null && username.length()==6 ){
			
			if(password != null && adju.getAdjudicator_password().equals(password)){
				List<AdjuBean> adjulist = adjumapper.AdjuListById(adju.getAdjudicator_id());
				System.out.println(adjulist.toString());
				AdjuBean adju1 = adjulist.get(0);
				System.out.println(adjulist.toString()+"************************************");
				model.addAttribute("adju", adju1);
				return "jury_index";
			}else{

				model.addAttribute("error", "用户名或密码错误!");
				return "login";
			}
		}else if( admin!=null && username != null && username.length()==8   ) {
			
			if( password != null && admin.getAdmin_password().equals(password)){
				List<AdminBean> adminlist = adminmapper.AdminListById(admin.getAdmin_id());
				System.out.println(adminlist.toString());
				AdminBean admin1 = adminlist.get(0);
				System.out.println(adminlist.toString()+"************************************");
				model.addAttribute("admin", admin1);
				//return "redirect:/manager_index.jsp?id="+admin1.getAdmin_id();
				return "manager_index";
			}else{
				model.addAttribute("error", "用户名或密码错误!");
				return "login";
			}
	
		}else if( stu!=null &&  username != null && username.length()==12  ) {
			
			if(password != null && stu.getStudent_password().equals(password)){
				
				stu = studentmapper.findById(stu.getStudent_id());
				model.addAttribute("student", stu);
				return "student_index";
			}else{
				model.addAttribute("error", "用户名或密码错误!");
				return "login";
			}
	
		}else if(tea!=null &&  username != null && username.length()==10  ) {
			
			if(password != null && tea.getTeacher_password().equals(password)){
				
				tea = teachermapper.findById(tea.getTeacher_id());
			
				model.addAttribute("teacher", tea);
				
				return "teacher_index";
			}else{
				model.addAttribute("error", "用户名或密码错误!");
				return "login";
			}
			
		}else{
			
			model.addAttribute("error", "用户名或密码错误");
			return "login";
		}
			
	
  
	  }
   
	
}
