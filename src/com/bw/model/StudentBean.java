package com.bw.model;

/**
 * Created by DroidEye on 2017/6/4.
 */
public class StudentBean {

	private String  student_id;
	private String  student_password;
	private String  student_name ;
	private String  student_sex;
	private String  student_class;
	private String  student_college;
	private String  student_phonenumber;
	
	
	
    public StudentBean() {
    	
    }



	public StudentBean(String student_id,  String student_name, String student_sex,
			String student_class, String student_college, String student_phonenumber) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_sex = student_sex;
		this.student_class = student_class;
		this.student_college = student_college;
		this.student_phonenumber = student_phonenumber;
	}



	public String getStudent_id() {
		return student_id;
	}



	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}



	public String getStudent_password() {
		return student_password;
	}



	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}



	public String getStudent_name() {
		return student_name;
	}



	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}



	public String getStudent_sex() {
		return student_sex;
	}



	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}



	public String getStudent_class() {
		return student_class;
	}



	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}



	public String getStudent_college() {
		return student_college;
	}



	public void setStudent_college(String student_college) {
		this.student_college = student_college;
	}



	public String getStudent_phonenumber() {
		return student_phonenumber;
	}



	public void setStudent_phonenumber(String student_phonenumber) {
		this.student_phonenumber = student_phonenumber;
	}




    
    
    
    
    
}