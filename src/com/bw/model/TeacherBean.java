package com.bw.model;

/**
 * Created by DroidEye on 2017/6/9.
 */
public class TeacherBean {

	  private String teacher_id;
	  private String teacher_password;
	  private String teacher_name;
	  private String teacher_college;
	  private String teacher_phonenumber;

    public TeacherBean() {
    
	}

	public TeacherBean(String teacher_id, String teacher_name, String teacher_college,
			String teacher_phonenumber) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_college = teacher_college;
		this.teacher_phonenumber = teacher_phonenumber;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_password() {
		return teacher_password;
	}

	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_college() {
		return teacher_college;
	}

	public void setTeacher_college(String teacher_college) {
		this.teacher_college = teacher_college;
	}

	public String getTeacher_phonenumber() {
		return teacher_phonenumber;
	}

	public void setTeacher_phonenumber(String teacher_phonenumber) {
		this.teacher_phonenumber = teacher_phonenumber;
	}

    
	
}