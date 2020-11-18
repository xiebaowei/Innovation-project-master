/**
 * 
 */
package com.bw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bw.mapper.StudentMapper;
import com.bw.mapper.TeacherMapper;
import com.bw.model.AdjuBean;
import com.bw.model.ApplyBean;
import com.bw.model.ProjectBean;
import com.bw.model.StudentBean;
import com.bw.model.TeacherBean;

/**
 * @author xiebaowei
 *
 */
@Controller
public class StudentController {

	@Autowired
	private StudentMapper studentmapper;
	
	
	@RequestMapping("stulist")
	public String listadmin(Model model, HttpServletRequest request){
		
	//	System.out.println("adminid:"+request.getParameter("id"));

		System.out.println("stuid:"+request.getParameter("username"));
		List<StudentBean> stu = studentmapper.StudentListById(request.getParameter("username"));
		model.addAttribute("StudentList",stu);

		return "student_list";
		
		
	}
	
	@RequestMapping("stueditpassword")
	public String editpassword(String oldpassword, String newpassword,String repassword,Model model,HttpServletRequest request) {
		
		System.out.println("studentid:"+request.getParameter("username"));
		StudentBean admin = new StudentBean();
		admin = studentmapper.findByIdpwd(request.getParameter("username"));
		
		
		
		if(!oldpassword.equals(admin.getStudent_password())){
			model.addAttribute("error", "旧密码错误！");
			return "student_password";
		}
		
		if(!newpassword.equals(repassword)){
			model.addAttribute("error", "两次密码不一致！");
			return "student_password";
		}
		admin.setStudent_password(newpassword);
		studentmapper.updateStupwd(admin);
		
		System.out.println(admin+"**********************");
		
		return "login";
		
		
	}
	
	@RequestMapping("stuedit")
	public String teacheredit(String studentname, String studentsex,String studentclass,String studentcollege,String studentphonenumber,Model model,HttpServletRequest request) {
		System.out.println("studentid:"+request.getParameter("username"));
		StudentBean stu = new StudentBean();
		stu = studentmapper.findById(request.getParameter("username"));
		stu.setStudent_name(studentname);
		stu.setStudent_sex(studentsex);
		stu.setStudent_class(studentclass);
		stu.setStudent_college(studentcollege);
		stu.setStudent_phonenumber(studentphonenumber);
		studentmapper.updateStudent(stu);
		System.out.println(stu+"**********************");

		return "forward:stulist.do";
		
	}
	@RequestMapping("applyprojectlist")
	public String applyprojectlist(Model model,HttpServletRequest request){
		System.out.println("studentid:"+request.getParameter("username"));
		
		int studentid = Integer.parseInt(studentmapper.ApplyById(request.getParameter("username")));
	
	
		if(studentid!=0) {
			
		 return "forward:stuapplyprojectlist.do";
			
		}else {
		List<ProjectBean> prolist = studentmapper.Projectlist();
		System.out.println(prolist);
		model.addAttribute("ProjectList", prolist);
		
		return "student_declare_project";
		}
	}
	
	@RequestMapping("applyproject")
	public String applyproject(String project_content,Model model,HttpServletRequest request){
		System.out.println("studentid:"+request.getParameter("username"));
		StudentBean stu = new StudentBean();
		stu = studentmapper.findById(request.getParameter("username"));
		System.out.println("projectid:"+request.getParameter("project_id"));
		ProjectBean project = new ProjectBean();
		project = studentmapper.FindById(request.getParameter("project_id"));
		String project_id = project.getProject_id();
		String teacher_id = project.getTeacher_id();
		String project_name = project.getProject_name();
		String teacher_name = project.getTeacher_name();
		String project_info = project.getProject_info();
		String student_id = request.getParameter("username");
		String student_name = stu.getStudent_name(); 
		ApplyBean apply = new ApplyBean(student_id,project_id,teacher_id,student_name,project_name,teacher_name,project_info,project_content);
		studentmapper.InsertApply(apply); 
		model.addAttribute("successerror", "申报信息保存成功!");
		
		return "student_project_edit";
	
	}
	@RequestMapping("stuapplyprojectlist")
	public String stuapplyproject(Model model,HttpServletRequest request){
		System.out.println("studentid:"+request.getParameter("username"));
		
		
		List<ApplyBean> applylist = studentmapper.ApplyListById(request.getParameter("username"));
		System.out.println(applylist);
		model.addAttribute("ApplystuList", applylist);
		
		return "student_project_list";
	
	}
	/*@RequestMapping("project_download")
	public String project_download(Model model,HttpServletRequest request){
		System.out.println("projectid:"+request.getParameter("project_id"));
		ProjectBean project = new ProjectBean();
		project = studentmapper.FindById(request.getParameter("project_id"));
		System.out.println(project);
		model.addAttribute("project", project);
		
		return "teacher_download";
	
	}*/
	@RequestMapping("project_download")
	 public ModelAndView project_download(Model model,HttpServletRequest request) {
		
		System.out.println("projectid:"+request.getParameter("project_id"));
		ProjectBean project = new ProjectBean();
		project = studentmapper.FindById(request.getParameter("project_id"));
		System.out.println(project);

	    	ModelAndView modelAndView = new ModelAndView("/teacher_download");
	        model.addAttribute("project", project);
	        return modelAndView;
	    }

	
}
