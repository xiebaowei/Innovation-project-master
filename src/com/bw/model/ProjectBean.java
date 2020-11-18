package com.bw.model;

/**
 * Created by DroidEye on 2017/6/9.
 */
public class ProjectBean {

    private String project_id;
    private String project_name;
    private String project_info;
    private String teacher_id;
    private String teacher_name;
    public ProjectBean() {
    }

    
    
	public ProjectBean(String project_id, String project_name, String project_info, String teacher_id,String teacher_name) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_info = project_info;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
	}



	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_info() {
		return project_info;
	}

	public void setProject_info(String project_info) {
		this.project_info = project_info;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}



	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}



	@Override
	public String toString() {
		return "ProjectBean [project_id=" + project_id + ", project_name=" + project_name + ", project_info="
				+ project_info + ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + "]";
	}





    
}
