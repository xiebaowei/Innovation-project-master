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
	 * ����ļ�
	 * @param fileInfo
	 */
//ѧ���ϴ�
	public void addFileInfo(FileInfo fileInfo) ;
	
	public void updateFileInfo(FileInfo fileInfo) ;
	
	//��ʦ�ϴ�
	public void addTeacherFileInfo(FileInfo fileInfo) ;
	
	public void updateTeacherFileInfo(FileInfo fileInfo) ;
	
	//����Ա�ϴ�
	public void addJuryFileInfo(FileInfo fileInfo) ;
	
	public void updateJuryFileInfo(FileInfo fileInfo) ;
	
	//����Ա�ϴ�
	public void addManagerFileInfo(FileInfo fileInfo) ;
	/**
	 * ��ѯ���е��ļ�
	 * @return
	 */
	public List<FileInfo> findFiles() ;
	/**
	 * ����id��ѯ�ļ�
	 * @param fileId
	 * @return
	 */
	public FileInfo findFileById(String fileId);
	
	
	public String ApplyByStudentId(String student_id);
	
	public List<ApplyBean> ApplyById(@Param("student_id")String student_id,@Param("teacher_id")String teacher_id);
	
	public ApplyBean ApplyByteacherId(String teacher_id);
	//��ʦ�ϴ�
	
	public List<FileInfo> findFileByid(String teacher_id);
	
	public FileInfo findFileByTeacherid(String teacher_id);
	//ѧ�����ز���
	public FileInfo findFileByName(String  FileName);
	
//ѧ���ϴ��ļ�
	public List<FileInfo> findFileByStudentid(String student_id);
	
	public FileInfo findFilebyStudentid(String student_id);
//����Ա����
	public List<FileInfo> findFileByTeacherId(@Param("student_id")String student_id,@Param("teacher_id")String teacher_id);
	//����Ա�ϴ�
	public List<FileInfo> findFileByJuryId(String jury_id);
	
	public FileInfo findFileByJuryid(String jury_id);

	//
	public List<FileInfo> findAllFile();
}
