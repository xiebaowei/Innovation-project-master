/**
 * 
 */
package com.bw.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
public interface AdminMapper {

		public AdminBean findById(String id);
	
		public AdminBean findByIdpwd(String id);
		
		public AdjuBean FindbyIdAdju(String adju_id);

		public ApplyBean FindbyIdApply(String student_id);
		
	    public ApplyBean FindByID(String studentID );
	    
	    public void  DeleteByStudentId(String student_id);
	    
	    public void DeleteByTeacherId(String teacher_id);
	    
	    public void DeleteByAdjuId(String jury_id);
	    
	    public void DeleteByJudgeId(String judge_id);
	    
	    public List<JudgeBean> alljuryprojectlist();
	    
	    
	    public List <ApplyBean> Search(@Param("studentid") String studentid,@Param("studentname")  String studentname,
				@Param("teacherid") String teacherid, @Param("teachername") String teachername,
				@Param("projectid") String projectid );
	    
	    public int FindbyStudent(String id);
	    
	    public int  FindbyTeacher(String id);
	    
	    public int FindbyAdju(String id);
	    
	    public void updateAdjuNumber(ApplyBean apply);
	    
	    public void updateApply(ApplyBean apply);
	    
		public List<StudentBean> allstudentlist();
		
		public List<TeacherBean> allteacherlist();
		
		public List<AdjuBean> alljurylist();
		
		public List<ApplyBean> allapplylist();
		
		public List<JudgeBean> AddapplyById(String adju_id);
	
		public List<AdminBean> AdminListById(String id);
		
		public void insertstudent(StudentBean stu);
		
		public void insertteacher(TeacherBean tea);
		
		public void insertjury(AdjuBean jury);

		public void insertjudge(JudgeBean jury);
		
		public void updateAdminpwd(AdminBean admin);
		
		public void updateAdmin(AdminBean admin);
	
		public List<JudgeBean> FindbyJudge(@Param("student_id") String student_id,@Param("adju_id")String adju_id);
		
		

	
	
}
