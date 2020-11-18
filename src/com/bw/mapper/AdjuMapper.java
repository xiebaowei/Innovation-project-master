package com.bw.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.model.AdjuBean;
import com.bw.model.AdminBean;
import com.bw.model.ApplyBean;
import com.bw.model.JudgeBean;

/**
 * Created by DroidEye on 2017/6/11.
 */
public interface AdjuMapper {

	public AdjuBean findById(String id);
	
	public List<ApplyBean> FindById(@Param("student_id")String studentID,@Param("teacher_id")String teacherID );
	
	public AdjuBean findByIdpwd(String id);
	
	public List <ApplyBean> findByIdPro(String id);
	
	public List<AdjuBean> AdjuListById(String id);
	
	public List<ApplyBean> ProjectListById(String id);
	
    public AdjuBean queryAdjuAccount(String adjuID);

    public boolean changeAdjuPassword(String adjuID, String newAdjuPassword);

    public void updateJury(AdjuBean adju);

    public void updateApply(ApplyBean apply);
    
    public void updateAdjupwd(AdjuBean admin);
    
    public List<JudgeBean> queryAllNeededAdjuProject(String adjuID);

}
