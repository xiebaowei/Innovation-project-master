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

import com.bw.mapper.AdjuMapper;
import com.bw.model.AdjuBean;
import com.bw.model.AdminBean;
import com.bw.model.ApplyBean;


/**
 * @author xiebaowei
 *
 */
@Controller
public class AdjuController {

	@Autowired
	private AdjuMapper adjumapper;
	
	
	@RequestMapping("adjulist")
	public String listadmin(Model model, HttpServletRequest request){
		
	//	System.out.println("adminid:"+request.getParameter("id"));

		System.out.println("adjuid:"+request.getParameter("username"));
		List<AdjuBean> adju = adjumapper.AdjuListById(request.getParameter("username"));
		
		model.addAttribute("AdjuList", adju);

		return "jury_list";
		
		
	}
	
	@RequestMapping("juryeditpassword")
	public String editpassword(String oldpassword, String newpassword,String repassword,Model model,HttpServletRequest request) {
		
		System.out.println("juryid:"+request.getParameter("username"));
		AdjuBean admin = new AdjuBean();
		admin = adjumapper.findByIdpwd(request.getParameter("username"));
		
		
		
		if(!oldpassword.equals(admin.getAdjudicator_password())){
			model.addAttribute("error", "���������");
			return "jury_password";
		}
		
		if(!newpassword.equals(repassword)){
			model.addAttribute("error", "�������벻һ�£�");
			return "jury_password";
		}
		admin.setAdjudicator_password(newpassword);
		adjumapper.updateAdjupwd(admin);
		
		System.out.println(admin+"**********************");
		
		return "login";
		
		
	}
	
	@RequestMapping("juryedit")
	public String teacheredit(String juryname,Model model,HttpServletRequest request) {
		System.out.println("juryid:"+request.getParameter("username"));
		AdjuBean adju = new AdjuBean();
		adju = adjumapper.findById(request.getParameter("username"));
		adju.setAdjudicator_name(juryname);;
		adjumapper.updateJury(adju);
		System.out.println(adju+"**********************");

		return "forward:adjulist.do";
	
	}
	@RequestMapping("juryproject")
	public String juryproject(String juryname,Model model,HttpServletRequest request) {
		System.out.println("juryid:"+request.getParameter("username"));
		List<ApplyBean> apply = adjumapper.findByIdPro(request.getParameter("username"));
		if(null == apply || apply.size() ==0) {
			
			model.addAttribute("error", "��û��Ϊ��������Ŀ�������֣���ȴ�����Ա��ӣ�");
			return "jury_project_list";

		}else {
		
		System.out.println(apply+"**********************");
		model.addAttribute("ApplyproList", apply);
		return "jury_project_list";
		}
	}

	@RequestMapping("commitscore")
	public String commitscore(String number,Model model, HttpServletRequest request){
		
	
		String teacher_id = request.getParameter("teacher_id");
        String student_id = request.getParameter("student_id");
		System.out.println("teaid:"+teacher_id);
		System.out.println("stuid:"+student_id);
		
		List<ApplyBean> apply =  adjumapper.FindById(student_id,teacher_id);
		
	    ApplyBean apply1 =  apply.get(0);
	    
		int adjunumber = apply1.getAdju_number();
		int has_scored_adju_number = apply1.getHas_scored_adju_number();
		float project_total_score = Float.parseFloat(apply1.getProject_total_score());
		has_scored_adju_number=has_scored_adju_number+1;
		project_total_score += Float.parseFloat(number);
		project_total_score /= has_scored_adju_number;
		apply1.setHas_scored_adju_number(has_scored_adju_number);
		System.out.println(has_scored_adju_number+"**********************");
		apply1.setProject_total_score(Float.toString(project_total_score));
		apply1.setProject_progress("�Ѹ����������֣�δͨ��");
	    
	    adjumapper.updateApply(apply1);
	    System.out.println("777"+apply1);

	    model.addAttribute("successerror", "������Ϣ����ɹ�!");
	    return "jury_project_score";


		
	}
	
	
	
	
}
