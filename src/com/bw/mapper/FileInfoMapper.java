/**
 * 
 */
package com.bw.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.model.ApplyBean;
import com.bw.model.FileInfo;

/**
 * @author xiebaowei
 *
 */
public interface FileInfoMapper {

	/**
	 * 添加文件
	 * @param fileInfo
	 */
//学生上传
	public void addFileInfo(FileInfo fileInfo) ;
	
	public void updateFileInfo(FileInfo fileInfo) ;
	
	//教师上传
	public void addTeacherFileInfo(FileInfo fileInfo) ;
	
	public void updateTeacherFileInfo(FileInfo fileInfo) ;
	
	//评审员上传
	public void addJuryFileInfo(FileInfo fileInfo) ;
	
	public void updateJuryFileInfo(FileInfo fileInfo) ;
	
	//管理员上传
	public void addManagerFileInfo(FileInfo fileInfo) ;
	/**
	 * 查询所有的文件
	 * @return
	 */
	public List<FileInfo> findFiles() ;
	/**
	 * 根据id查询文件
	 * @param fileId
	 * @return
	 */
	public FileInfo findFileById(String fileId);
	
	
	public String ApplyByStudentId(String student_id);
	
	public List<ApplyBean> ApplyById(@Param("student_id")String student_id,@Param("teacher_id")String teacher_id);
	
	public ApplyBean ApplyByteacherId(String teacher_id);
	//教师上传
	
	public List<FileInfo> findFileByid(String teacher_id);
	
	public FileInfo findFileByTeacherid(String teacher_id);
	//学生下载查找
	public FileInfo findFileByName(String  FileName);
	
//学生上传文件
	public List<FileInfo> findFileByStudentid(String student_id);
	
	public FileInfo findFilebyStudentid(String student_id);
//评审员下载
	public List<FileInfo> findFileByTeacherId(@Param("student_id")String student_id,@Param("teacher_id")String teacher_id);
	//评审员上传
	public List<FileInfo> findFileByJuryId(String jury_id);
	
	public FileInfo findFileByJuryid(String jury_id);

	//
	public List<FileInfo> findAllFile();
}
