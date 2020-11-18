package com.bw.model;


/**
 * @author xiebaowei
 *
 */
public class ApplyBean {
    private String student_id;
    private String project_id;
    private String teacher_id;
    
    private String student_name;
    private String project_name;
    private String teacher_name;
    private String project_content;
    private String project_info;
    private String project_progress;
    private String project_teach;
    private String pass_status; 
    private String project_total_score;
    private int has_scored_adju_number;
    private int adju_number;


    public ApplyBean() {
    }


	public ApplyBean(String student_id, String project_id, String teacher_id, String student_name, String project_name,
			String teacher_name, String project_info,String project_content) {
		super();
		this.student_id = student_id;
		this.project_id = project_id;
		this.teacher_id = teacher_id;
		this.student_name = student_name;
		this.project_name = project_name;
		this.teacher_name = teacher_name;
		this.project_info = project_info;
		this.project_content = project_content;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getProject_id() {
		return project_id;
	}


	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}


	public String getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public String getProject_name() {
		return project_name;
	}


	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public String getProject_content() {
		return project_content;
	}


	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}


	public String getProject_progress() {
		return project_progress;
	}


	public void setProject_progress(String project_progress) {
		this.project_progress = project_progress;
	}


	public String getProject_teach() {
		return project_teach;
	}


	public void setProject_teach(String project_teach) {
		this.project_teach = project_teach;
	}


	public String getPass_status() {
		return pass_status;
	}


	public void setPass_status(String pass_status) {
		this.pass_status = pass_status;
	}


	public String getProject_total_score() {
		return project_total_score;
	}


	public void setProject_total_score(String project_total_score) {
		this.project_total_score = project_total_score;
	}


	

	public int getHas_scored_adju_number() {
		return has_scored_adju_number;
	}


	public void setHas_scored_adju_number(int has_scored_adju_number) {
		this.has_scored_adju_number = has_scored_adju_number;
	}


	public int getAdju_number() {
		return adju_number;
	}


	public void setAdju_number(int adju_number) {
		this.adju_number = adju_number;
	}


	public String getProject_info() {
		return project_info;
	}


	public void setProject_info(String project_info) {
		this.project_info = project_info;
	}


	@Override
	public String toString() {
		return "ApplyBean [student_id=" + student_id + ", project_id=" + project_id + ", teacher_id=" + teacher_id
				+ ", student_name=" + student_name + ", project_name=" + project_name + ", teacher_name=" + teacher_name
				+ ", project_content=" + project_content + ", project_info=" + project_info + ", project_progress="
				+ project_progress + ", project_teach=" + project_teach + ", pass_status=" + pass_status
				+ ", project_total_score=" + project_total_score + ", has_scored_adju_number=" + has_scored_adju_number
				+ ", adju_number=" + adju_number + "]";
	}


	

    
 
}
