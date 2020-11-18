/**
 * 
 */
package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.model.AdjuBean;
import com.bw.model.ApplyBean;
import com.bw.model.ProjectBean;
import com.bw.model.StudentBean;
import com.bw.model.TeacherBean;

/**
 * @author xiebaowei
 *
 */
public interface TeacherMapper {

	public TeacherBean findById(String teacherID);
	
	public  List<ProjectBean> findByID(String projectID);
	
	public TeacherBean findByIdpwd(String id);
	
	public void DeleteByProjectId(String project_id); 
	
	public List<ApplyBean> FindById(@Param("student_id")String studentID,@Param("teacher_id")String teacherID );
	
	public List<TeacherBean> TeacherListById(String id);
	
	public List<ApplyBean> ApplyListById(String id);
	
	public List<ProjectBean> ProjectlistBytId(String id);
	
	public void insertproject(ProjectBean pro);
	
	public void updateTeacher(TeacherBean tea);
	
	public void updateTeapwd(TeacherBean tea);
	
	public void updateApply(ApplyBean apply1);

	public List <ApplyBean> Search(@Param("studentid") String studentid,@Param("studentname")  String studentname,
			 @Param("projectname") String projectname,@Param("projectid") String projectid ,@Param("teacher_id")String teacher_id);
	
	
}
