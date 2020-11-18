/**
 * 
 */
package com.bw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.mapper.AdminMapper;
import com.bw.model.AdjuBean;
import com.bw.model.AdminBean;
import com.bw.model.ApplyBean;
import com.bw.model.JudgeBean;
import com.bw.model.StudentBean;
import com.bw.model.TeacherBean;

/**
 * @author xiebaowei
 *
 */
@Controller
	
public class AdminController {

	@Autowired
	private AdminMapper adminmapper;
	
	@RequestMapping("adminlist")
	public String listadmin( Model model, HttpServletRequest request){
		System.out.println("adminid:"+request.getParameter("username"));
		List<AdminBean> adminlist = adminmapper.AdminListById(request.getParameter("username"));
		model.addAttribute("AdminList", adminlist);

		return "manager_list";
		
		
	}
	@RequestMapping("admineditpassword")
	public String editpassword(String oldpassword, String newpassword,String repassword,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("adminid:"+request.getParameter("username"));
		AdminBean admin = new AdminBean();
		admin = adminmapper.findByIdpwd(request.getParameter("username"));
		
		
		
		if(!oldpassword.equals(admin.getAdmin_password())){
			model.addAttribute("error", "旧密码错误！");
			return "admin_password";
		}
		
		if(!newpassword.equals(repassword)){
			model.addAttribute("error", "两次密码不一致！");
			return "admin_password";
		}
		admin.setAdmin_password(newpassword);
		adminmapper.updateAdminpwd(admin);
		
		System.out.println(admin+"**********************");
		List<AdminBean> adminlist = adminmapper.AdminListById(admin.getAdmin_id());
		System.out.println(adminlist.toString());
		AdminBean admin1 = adminlist.get(0);
		System.out.println(adminlist.toString()+"************************************");
		model.addAttribute("admin", admin1);
		return "login";
		
		
	}
	@RequestMapping("manageredit")
	public String manageredit(String admin_name, Model model,HttpServletRequest request) {
		System.out.println("adminid:"+request.getParameter("username"));
		AdminBean admin = new AdminBean();
		admin = adminmapper.findByIdpwd(request.getParameter("username"));
		admin.setAdmin_name(admin_name);
		adminmapper.updateAdmin(admin);
		System.out.println(admin+"**********************");
		List<AdminBean> adminlist = adminmapper.AdminListById(admin.getAdmin_id());
//		System.out.println(adminlist.toString());
		AdminBean admin1 = adminlist.get(0);
//		System.out.println(adminlist.toString()+"************************************");
		model.addAttribute("admin", admin1);
		return "forward:adminlist.do";
		
		
	}

	@RequestMapping("studentlist")
	public String studentlist(String username, Model model){
		
		List<StudentBean> student = adminmapper.allstudentlist();
		model.addAttribute("student", student);
			return "student_information_list";
		
		
	}
	@RequestMapping("deletestudent")
	public String deltestudent( HttpServletRequest request,Model model){
		String student_id = request.getParameter("student_id");
		adminmapper.DeleteByStudentId(student_id);

		return "forward:studentlist.do";
		
		
	}
	@RequestMapping("teacherlist")
	public String teacherlist(String username, Model model){
		
		List<TeacherBean> teacher = adminmapper.allteacherlist();
		model.addAttribute("teacher", teacher);

			return "teacher_information_list";
		
		
	}
	@RequestMapping("deleteteacher")
	public String deleteteacher(HttpServletRequest request, Model model){
		String teacher_id = request.getParameter("teacher_id");
		 adminmapper.DeleteByTeacherId(teacher_id);
		

			return "forward:teacherlist.do";
		
		
	}
	@RequestMapping("jurylist")
	public String jurylist(String username, Model model){
		
		List<AdjuBean> jury = adminmapper.alljurylist();
		model.addAttribute("jury", jury);

			return "jury_information_list";
		
		
	}
	
	@RequestMapping("deletejury")
	public String deletejury(HttpServletRequest request, Model model){
		String jury_id = request.getParameter("jury_id");
		 adminmapper.DeleteByAdjuId(jury_id);

			return "forward:jurylist.do";
		
		
	}
	
	@RequestMapping("deletejuryproject")
	public String deletejuryproject(HttpServletRequest request, Model model){
		String judge_id = request.getParameter("judge_id");
		
		adminmapper.DeleteByJudgeId(judge_id);

			return "forward:juryprojectlist.do";
		
		
	}
	
	@RequestMapping("addprojury")
	public String addprojury(String username, Model model){
		
		List<ApplyBean> apply = adminmapper.allapplylist();
		model.addAttribute("ApplyList", apply);
		
		return "distribution_syndic_list";
	}
	
	
	@RequestMapping("studentadd")
	public String studentadd(String student_id,String student_name, String student_sex,
			String student_class, String student_college, String student_phonenumber,Model model){
		
		
		StudentBean student = new StudentBean(student_id, student_name, student_sex, student_class, student_college, student_phonenumber);
		int studentid =Integer.valueOf(adminmapper.FindbyStudent(student_id)) ;
		if(studentid==0)  {
			
			adminmapper.insertstudent(student);
		    
			return "forward:studentlist.do";
			
		}else {
			
			
			model.addAttribute("error", "此账号已存在，请重新添加！");
			
			return"student_information_add";
			
		}
	
		
		
		
	}
	@RequestMapping("teacheradd")
	public String teacheradd(String teacher_id, String teacher_name, String teacher_college,
			String teacher_phonenumber,Model model){
		
		
		TeacherBean teacher = new TeacherBean(teacher_id,teacher_name, teacher_college, teacher_phonenumber);
		int teacherid =Integer.valueOf(adminmapper.FindbyTeacher(teacher_id)) ;
		if(teacherid==0)  {
			
			adminmapper.insertteacher(teacher);
		    
			return "forward:teacherlist.do";
			
		}else {
			
			
			model.addAttribute("error", "此账号已存在，请重新添加！");
			
			return"teacher_information_add";
			
		}
	
		
		
	}
	@RequestMapping("juryadd")
	public String juryadd(String adjudicator_id,  String adjudicator_name,Model model){
		
		
		AdjuBean jury = new AdjuBean(adjudicator_id,adjudicator_name);
		
		int adjuid =Integer.valueOf(adminmapper.FindbyAdju(adjudicator_id)) ;
		if(adjuid==0)  {
			
			adminmapper.insertjury(jury);
		    
			return "forward:jurylist.do";
			
		}else {
			
			
			model.addAttribute("error", "此账号已存在，请重新添加！");
			
			return"jury_information_add";
			
		}
	
	}
	@RequestMapping("add_jury_forproject")
	public String add_jury_forproject(String username, Model model){
		
		List<AdjuBean> jury = adminmapper.alljurylist();
		model.addAttribute("jury", jury);

			return "add_jury_forproject";
		
		
	}
	@RequestMapping("addjury")
	public String addjury(@Param("student_id") String student_id,@Param("adju_id")String adju_id,Model model, HttpServletRequest request){
		
		System.out.println("stuid:"+request.getParameter("sid"));
		System.out.println("proid:"+request.getParameter("pid"));
		System.out.println("adjuid:"+request.getParameter("adjuid"));
		 student_id = request.getParameter("sid");
		 adju_id = request.getParameter("adjuid");
		 
		String project_id = request.getParameter("pid");
		
		
		AdjuBean  adju  = new AdjuBean();
		adju = adminmapper.FindbyIdAdju(adju_id);
		String adju_name = adju.getAdjudicator_name();
		
		ApplyBean app = new ApplyBean();
		app = adminmapper.FindbyIdApply(student_id);
		
		String student_name = app.getStudent_name();
		String project_name = app.getProject_name();
		
		List<JudgeBean> jud = adminmapper.FindbyJudge(student_id,adju_id);
		
                
       		 
        		System.out.println(jud+"**********************************************");
        	if(null == jud || jud.isEmpty()) {
        	JudgeBean judge = new JudgeBean(student_id,project_id,adju_id,adju_name,student_name,project_name);
        	adminmapper.insertjudge(judge); 
        	System.out.println(judge+"***********");
        	
        	ApplyBean apply = new ApplyBean();
        	apply = adminmapper.FindByID(student_id);
        	int adjunumber = apply.getAdju_number();
        	apply.setAdju_number(adjunumber+1);
        	adminmapper.updateAdjuNumber(apply);
        	
        	List<JudgeBean> applylist =  adminmapper.AddapplyById(adju_id);
        	System.out.println(applylist+"*******************************");
        	
        	model.addAttribute("Apply", applylist);
        	 
        	return "add_jury_list";
        	}else {
        		
        		model.addAttribute("error", "已经添加该评审员！");
        		
        		return "forward:add_jury_forproject.do";
        	}
     
        	
        
       
	
	}
	@RequestMapping("auditprojectlist")
	public String auditprojectlist( Model model, HttpServletRequest request){
		
 
		List<ApplyBean> apply =  adminmapper.allapplylist();
		 System.out.println(apply+"88888888888888888888888888888888888888");
		 
		 model.addAttribute("ApplyList",apply);
		 
		return "project_audit_list";
	}
	
	
	
	
	@RequestMapping("auditproject")
	public String auditproject(String username, Model model, HttpServletRequest request){
		
        System.out.println("stuid:"+request.getParameter("student_id"));
		
		ApplyBean apply = new ApplyBean();
		apply = adminmapper.FindbyIdApply(request.getParameter("student_id"));
		
		apply.setPass_status("已通过");
		apply.setProject_progress("已辅导，已评分，已通过");
		adminmapper.updateApply(apply);
		System.out.println(apply+"**********************");
		return "forward:auditprojectlist";
	}
	
	@RequestMapping("juryprojectlist")
	public String juryprojectlist(String username, Model model){
		
		List<JudgeBean> jury = adminmapper.alljuryprojectlist();
		model.addAttribute("alljury", jury);

			return "all_jury_project";
		
		
	}
	
	
	@RequestMapping("serch")
	public String serch(@Param("studentid") String studentid,@Param("studentname")  String studentname,
			@Param("teacherid") String teacherid, @Param("teachername") String teachername,
			@Param("projectid") String projectid, Model model){
		
		
		List<ApplyBean> app = adminmapper.Search( studentid,  studentname,teacherid,  teachername,projectid);
		
		model.addAttribute("ApplyList", app);
		
	   return "project_audit_list";
		
		
	}
	
	
}
