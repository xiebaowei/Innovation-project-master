/**
 * 
 */
package com.bw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bw.mapper.TeacherMapper;
import com.bw.model.AdjuBean;
import com.bw.model.AdminBean;
import com.bw.model.ApplyBean;
import com.bw.model.FileInfo;
import com.bw.model.ProjectBean;
import com.bw.model.StudentBean;
import com.bw.model.TeacherBean;

/**
 * @author xiebaowei
 *
 */
@Controller
public class TeacherController {

	@Autowired
	private TeacherMapper teachermapper;
	
	
	@RequestMapping("tealist")
	public String listadmin(Model model, HttpServletRequest request){
		

		System.out.println("teaid:"+request.getParameter("username"));
		List<TeacherBean> tea = teachermapper.TeacherListById(request.getParameter("username"));
		model.addAttribute("TeacherList", tea);

		return "teacher_list";
		
		
	}
	@RequestMapping("teaeditpassword")
	public String editpassword(String oldpassword, String newpassword,String repassword,Model model,HttpServletRequest request) {
		
		System.out.println("teacherid:"+request.getParameter("username"));
		TeacherBean admin = new TeacherBean();
		admin = teachermapper.findByIdpwd(request.getParameter("username"));
		
		
		
		if(!oldpassword.equals(admin.getTeacher_password())){
			model.addAttribute("error", "旧密码错误！");
			return "teacher_password";
		}
		
		if(!newpassword.equals(repassword)){
			model.addAttribute("error", "两次密码不一致！");
			return "teacher_password";
		}
		admin.setTeacher_password(newpassword);
		teachermapper.updateTeapwd(admin);
		
		System.out.println(admin+"**********************");
		
		return "login";
		
		
	}
	
	@RequestMapping("teaproject")
	public String teaproject(Model model, HttpServletRequest request){
		
		System.out.println("teaid:"+request.getParameter("username"));
		List<ProjectBean> pro = teachermapper.ProjectlistBytId(request.getParameter("username"));
		
		System.out.println(pro.toString());
		
		model.addAttribute("Teaproject", pro);

		return "teacher_project_list";
		
		
	}
	@RequestMapping("addproject")
	public String addproject(String projectid, String project_name, String project_info,Model model, HttpServletRequest request){
		
		System.out.println("teaid:"+request.getParameter("username"));
		String teacher_id = request.getParameter("username");
		if(!projectid.matches("^[0-9]*$")){
			model.addAttribute("error", "ID只能为数字");
			return "teacher_add_project";
		}
		List<ProjectBean> project1 = teachermapper.findByID(projectid);
		System.out.println("888888"+project1);
      
		if(project1==null || project1.isEmpty()){
			
			

			TeacherBean teacher =new TeacherBean();
			
			teacher = teachermapper.findById(teacher_id);
			
			String teacher_name = teacher.getTeacher_name();
			
			ProjectBean project = new ProjectBean(projectid,project_name,project_info,teacher_id,teacher_name);
			
			teachermapper.insertproject(project);

			return "forward:teaproject.do";
		}
		else {
			
			model.addAttribute("error", "该编号存在!");
			return "teacher_add_project";
		
		
		}
		
	}
	@RequestMapping("teaedit")
	public String teacheredit(String teachername, String teachercollege,String teacherphonenumber,Model model,HttpServletRequest request) {
		System.out.println("techerid:"+request.getParameter("username"));
		TeacherBean admin = new TeacherBean();
		admin = teachermapper.findById(request.getParameter("username"));
		admin.setTeacher_name(teachername);
		admin.setTeacher_college(teachercollege);
		admin.setTeacher_phonenumber(teacherphonenumber);
		teachermapper.updateTeacher(admin);
		System.out.println(admin+"**********************");

		return "forward:tealist.do";
	
	}
	@RequestMapping("deleteproject")
	public String deltestudent( HttpServletRequest request,Model model){
		String project_id = request.getParameter("project_id");
		teachermapper.DeleteByProjectId(project_id);

		return "forward:teaproject.do";
		
		
	}
	@RequestMapping("projectlist")
	public String applyprojectlist(Model model, HttpServletRequest request){
		
	//	System.out.println("adminid:"+request.getParameter("id"));

		System.out.println("teaid:"+request.getParameter("username"));
		List<ApplyBean> applylist = teachermapper.ApplyListById(request.getParameter("username"));
		System.out.println(applylist);
		model.addAttribute("StuprojectList", applylist);

		return "teacher_stuproject_list";
		
		
	}
	@RequestMapping("teachproject")
	public String teachproject(String project_teach,Model model, HttpServletRequest request){
		
	//	System.out.println("adminid:"+request.getParameter("id"));
         String teacher_id = request.getParameter("teacher_id");
         String student_id = request.getParameter("student_id");
		System.out.println("teaid:"+teacher_id);
		System.out.println("stuid:"+student_id);
		List<ApplyBean> apply =  teachermapper.FindById(student_id,teacher_id);
		
		    ApplyBean apply1 =  apply.get(0);
		    apply1.setProject_teach(project_teach);//获取到的project_teach值
		    apply1.setProject_progress("已辅导，未评分，未通过");
		    System.out.println("777"+project_teach);
		    teachermapper.updateApply(apply1);
		    System.out.println(apply1+"**********************");
		    
		
		model.addAttribute("successerror", "辅导信息保存成功!");
		return "teacher_teach_project";
		
		
	}
	@RequestMapping("teacherserch")
	public String teacherserch(@Param("studentid") String studentid,@Param("studentname")  String studentname,
			 @Param("projectname") String projectname,@Param("projectid") String projectid, Model model,@Param("teacher_id")String teacher_id,HttpServletRequest request){
		
		teacher_id =request.getParameter("username");
		System.out.println(teacher_id);
		List<ApplyBean> app = teachermapper.Search( studentid,  studentname,projectname,projectid,teacher_id);
		System.out.println(app);
		model.addAttribute("StuprojectList", app);
		
	   return "teacher_stuproject_list";
		
		
	}
	
}
