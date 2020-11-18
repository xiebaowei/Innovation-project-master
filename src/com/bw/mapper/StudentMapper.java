/**
 * 
 */
package com.bw.mapper;

import java.util.List;

import com.bw.model.AdjuBean;
import com.bw.model.ApplyBean;
import com.bw.model.ProjectBean;
import com.bw.model.StudentBean;


/**
 * @author xiebaowei
 *
 */
public interface StudentMapper {

	public StudentBean findById(String studentID );
	
	public  ApplyBean  findByID(String studentID);
	
	public StudentBean findByIdpwd(String id);
	
	public  ProjectBean FindById(String studentID);

	public List<StudentBean> StudentListById(String id);
	
	public void updateStudent(StudentBean stu);
	
	public void updateStupwd(StudentBean stu);
	
	public List<ProjectBean> Projectlist();
	
	public List<ApplyBean> ApplyListById(String id);
	
	public String ApplyById(String id);
	
	public void InsertApply(ApplyBean stu);
	
}
