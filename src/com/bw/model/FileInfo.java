/**
 * 
 */
package com.bw.model;

/**
 * @author xiebaowei
 *
 */
public class FileInfo {

	private Integer file_id;
	private String file_name;
	private String file_url;
	private String student_id;
	private String teacher_id;
	private String jury_id;
	private String manager_id;
	
	
	
	
	public FileInfo() {
		super();
	}
	
	
	
	
	public FileInfo(String file_name, String file_url, String student_id) {
		super();
		this.file_name = file_name;
		this.file_url = file_url;
		this.student_id = student_id;
	}
    



	public Integer getFileId() {
		return file_id;
	}
	public void setFileId(Integer file_id) {
		this.file_id = file_id;
	}
	public String getFileName() {
		return file_name;
	}
	public void setFileName(String file_name) {
		this.file_name = file_name;
	}
	public String getFileUrl() {
		return file_url;
	}
	public void setFileUrl(String file_url) {
		this.file_url = file_url;
	}
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}




	public String getJury_id() {
		return jury_id;
	}




	public void setJury_id(String jury_id) {
		this.jury_id = jury_id;
	}




	public String getFile_name() {
		return file_name;
	}




	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}




	public Integer getFile_id() {
		return file_id;
	}




	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}




	@Override
	public String toString() {
		return "FileInfo [file_id=" + file_id + ", file_name=" + file_name + ", file_url=" + file_url + ", student_id="
				+ student_id + ", teacher_id=" + teacher_id + ", jury_id=" + jury_id + ", manager_id=" + manager_id
				+ "]";
	}




	
	
}
