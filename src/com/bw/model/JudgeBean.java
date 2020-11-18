package com.bw.model;

/**
 * Created by xiebaowei on 2020/4/7.
 */
public class JudgeBean {
	private String judge_id;
    private String student_id;
    private String project_id;
    private String adju_id;
    private String student_name;
    private String adju_name;
    private String project_name;
    private String project_score;
    
    public JudgeBean() {
    }

	

	
	




	public JudgeBean(String student_id, String project_id, String adju_id, String adju_name,String student_name, 
			String project_name) {
		super();
		this.student_id = student_id;
		this.project_id = project_id;
		this.adju_id = adju_id;
		this.adju_name = adju_name;
		this.student_name = student_name;
		this.project_name = project_name;
		
	}









	public JudgeBean(String student_id, String project_id, String adju_id) {
		super();
		this.student_id = student_id;
		this.project_id = project_id;
		this.adju_id = adju_id;
	}

	
	public String getJudge_id() {
		return judge_id;
	}









	public void setJudge_id(String judge_id) {
		this.judge_id = judge_id;
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

	public String getAdju_id() {
		return adju_id;
	}

	public void setAdju_id(String adju_id) {
		this.adju_id = adju_id;
	}

	public String getProject_score() {
		return project_score;
	}

	public void setProject_score(String project_score) {
		this.project_score = project_score;
	}

	public String getAdju_name() {
		return adju_name;
	}




	public void setAdju_name(String adju_name) {
		this.adju_name = adju_name;
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

	@Override
	public String toString() {
		return "JudgeBean [student_id=" + student_id + ", project_id=" + project_id + ", adju_id=" + adju_id
				+ ", student_name=" + student_name + ", adju_name=" + adju_name + ", project_name=" + project_name
				+ ", project_score=" + project_score + "]";
	}




	

	
   
}
