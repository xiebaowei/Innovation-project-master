/**
 * 
 */
package com.bw.controller;

/**
 * @author xiebaowei
 *
 */
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bw.mapper.FileInfoMapper;
import com.bw.mapper.StudentMapper;
import com.bw.model.ApplyBean;
import com.bw.model.FileInfo;
import com.bw.model.JudgeBean;
import com.bw.tools.FileUtil;


/**
 * 处理文件的类
 * @author Administrator
 *
 */
@Controller
public class FileController {
	
	@Autowired
	private FileInfoMapper fileinfomapper;
	
	
	
	/****************（学生上传）上传文档至本项目服务器，文件路径保存至数据库*****************/
	@RequestMapping("/studentdoUpload")
	public String upload(MultipartFile uploadFile,HttpServletRequest request,Model model) throws IOException{
		System.out.println("uploadFile = " + uploadFile);
		//获得文件
		byte[] buf = uploadFile.getBytes();
		System.out.println("文件长度" + buf.length);
		//文件名
		System.out.println("文件名getName = " + uploadFile.getName());
		System.out.println("文件名getOriginalFilename = " + uploadFile.getOriginalFilename());
		
		//文件名    a.txt
		String FileName = uploadFile.getOriginalFilename();
		//时间戳
		String time = FileUtil.createFileTimestamp();
		//文件url		/upload/1231231231231a.txt
		String fileUrl = "/upload/" + time + FileName;
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("fileUrl = " + fileUrl);
		//向url地址存储文件
		FileUtil.writeFileToUrl(uploadFile, fileUrl);

		//向数据库中保存文件信息
		String student_id = request.getParameter("username");
		int project_content = Integer.parseInt(fileinfomapper.ApplyByStudentId(student_id));
	
		if(project_content==0) {
			
			model.addAttribute("error", "申报信息不能为空!");
			return "student_project_edit";
		
		}
		List<FileInfo> fileInfo = fileinfomapper.findFileByStudentid(student_id);
		System.out.println(fileInfo);

		if(fileInfo==null || fileInfo.isEmpty() ) {
		
		FileInfo fileInfo1 = new FileInfo(FileName,fileUrl,student_id);
  
		fileinfomapper.addFileInfo(fileInfo1);
		 
		
		model.addAttribute("successerror", "文件上传成功!");
		return "student_project_edit";
		}else{
			
			FileInfo fileInfo2 = fileinfomapper.findFilebyStudentid(student_id);
			System.out.println("888888"+fileInfo2);
			String teacherid = fileInfo2.getTeacher_id();
			System.out.println(teacherid);
			if(teacherid==null) {
		   FileInfo fileInfo1 = new FileInfo(FileName,fileUrl,student_id);
		   fileinfomapper.updateFileInfo(fileInfo1);
		    
			}
			model.addAttribute("successerror", "文件上传成功!");
			return "student_project_edit";
		}
		
	}
	
	@RequestMapping("/studentlistdoUpload")
	public String studentlistdoUpload(MultipartFile uploadFile,HttpServletRequest request,Model model) throws IOException{
		System.out.println("uploadFile = " + uploadFile);
		//获得文件
		byte[] buf = uploadFile.getBytes();
		System.out.println("文件长度" + buf.length);
		//文件名
		System.out.println("文件名getName = " + uploadFile.getName());
		System.out.println("文件名getOriginalFilename = " + uploadFile.getOriginalFilename());
		
		//文件名    a.txt
		String FileName = uploadFile.getOriginalFilename();
		//时间戳
		String time = FileUtil.createFileTimestamp();
		//文件url		/upload/1231231231231a.txt
		String fileUrl = "/upload/" + time + FileName;
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("fileUrl = " + fileUrl);
		//向url地址存储文件
		FileUtil.writeFileToUrl(uploadFile, fileUrl);

		//向数据库中保存文件信息
		String student_id = request.getParameter("username");
		
		List<FileInfo> fileInfo = fileinfomapper.findFileByStudentid(student_id);
		System.out.println(fileInfo);

		if(fileInfo==null || fileInfo.isEmpty() ) {
		
		FileInfo fileInfo1 = new FileInfo(FileName,fileUrl,student_id);
  
		fileinfomapper.addFileInfo(fileInfo1);
		 
		
		model.addAttribute("successerror", "文件上传成功!");
		return "student_project_list";
		}else{
			
			FileInfo fileInfo2 = fileinfomapper.findFilebyStudentid(student_id);
			System.out.println("888888"+fileInfo2);
			String teacherid = fileInfo2.getTeacher_id();
			System.out.println(teacherid);
			if(teacherid==null) {
		   FileInfo fileInfo1 = new FileInfo(FileName,fileUrl,student_id);
		   fileinfomapper.updateFileInfo(fileInfo1);
		    
			}
			model.addAttribute("successerror", "文件上传成功!");
			return "student_project_list";
		}
		
	}
	/*************************（学生下载）根据数据库文件路径，下载文档***************************/
	@RequestMapping("/studentdownload")
	public ResponseEntity<byte[]> download(Integer fileId,String FileName,HttpServletResponse response){
		    FileName = "创新创业项目论文模板.doc";
		try {
			FileInfo fileInfo = fileinfomapper.findFileByName(FileName);
			String fileUrl = fileInfo.getFileUrl();
			String fileName = fileInfo.getFileName();
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
			//filename = URLEncoder.encode(file_name,"UTF-8");
			HttpHeaders headers=new HttpHeaders();
		//	headers.setContentDispositionFormData("attachment", fileName);// aatachment  附件
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
			headers.setContentType(MediaType.IMAGE_PNG);
			ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)), headers,HttpStatus.CREATED);
			return entity;
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}

			
			return null;
		
	}
	/****************(教师上传)上传文档至本项目服务器，文件路径保存至数据库*****************/
	@RequestMapping("/teacherdoUpload")
	public String teacherdoUpload(MultipartFile uploadFile,HttpServletRequest request,Model model) throws IOException{
		System.out.println("uploadFile = " + uploadFile);
		//获得文件
		byte[] buf = uploadFile.getBytes();
		System.out.println("文件长度" + buf.length);
		//文件名
		System.out.println("文件名getName = " + uploadFile.getName());
		System.out.println("文件名getOriginalFilename = " + uploadFile.getOriginalFilename());
		
		//文件名    a.txt
		String FileName = uploadFile.getOriginalFilename();
		//时间戳
		String time = FileUtil.createFileTimestamp();
		//文件url		/upload/1231231231231a.txt
		String fileUrl = "/upload/" + time + FileName;
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("fileUrl = " + fileUrl);
		//向url地址存储文件
		FileUtil.writeFileToUrl(uploadFile, fileUrl);
		
		//向数据库中保存文件信息
		String student_id = request.getParameter("student_id");
		String teacher_id = request.getParameter("username");
		System.out.println(student_id+teacher_id);
		List <ApplyBean> apply = fileinfomapper.ApplyById(student_id,teacher_id);
		
		for (int i = 0; i < apply.size(); i++) {//for循环将数据逐一获取到
		    ApplyBean apply1 =  apply.get(i);
		    String project_teach = apply1.getProject_teach();//获取到的project_teach值
		    System.out.println("777"+project_teach);
		    
         if(project_teach.equals("未指导")) {
		    model.addAttribute("error", "辅导信息不能为空!");
			return "teacher_teach_project"; 
         	}

			}
		
		List<FileInfo> fileInfo = fileinfomapper.findFileByid(teacher_id);
		System.out.println("888888"+fileInfo);
		
		if(fileInfo==null || fileInfo.isEmpty() ) {
			
			FileInfo fileInfo1 = new FileInfo();
			fileInfo1.setFileName(FileName);
			fileInfo1.setFileUrl(fileUrl);
			fileInfo1.setTeacher_id(teacher_id);
			fileInfo1.setStudent_id(student_id);
			System.out.println(fileInfo1);
			fileinfomapper.addTeacherFileInfo(fileInfo1);

			model.addAttribute("successerror", "文件上传成功!");
			return "teacher_teach_project";
			}else{
				
				
			   FileInfo fileInfo1 = new FileInfo();
			    fileInfo1.setFileName(FileName);
				fileInfo1.setFileUrl(fileUrl);
				fileInfo1.setTeacher_id(teacher_id);
				fileInfo1.setStudent_id(student_id);
			   fileinfomapper.updateTeacherFileInfo(fileInfo1);

				model.addAttribute("successerror", "文件上传成功!");
				return "teacher_teach_project";
			}

		
	}
	
	/*************************(教师下载)根据数据库文件路径，下载文档***************************/
	@RequestMapping("/teacherdownload")
	public String teacherfile(HttpServletRequest request,Model model) {
		
		String student_id = request.getParameter("student_id");		
		List<FileInfo> fileInfo = fileinfomapper.findFileByStudentid(student_id);
		System.out.println(fileInfo);

		if(fileInfo==null || fileInfo.isEmpty() ) {

		model.addAttribute("error", "该学生还没有提交项目申报文档，不能下载文件！");
		return "teacher_teach_project";
		}else{
			
			return "forward:teacherfile.do";
	     }
	}	
	@RequestMapping("/teacherfile")
	public ResponseEntity<byte[]> teacherdownload(Integer fileId, HttpServletRequest request,HttpServletResponse response){
		
		String student_id = request.getParameter("student_id");
		try {

			FileInfo fileInfo2 = fileinfomapper.findFilebyStudentid(student_id);
			System.out.println("888888"+fileInfo2);
			String fileUrl = fileInfo2.getFileUrl();
			String fileName = fileInfo2.getFileName();
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
				HttpHeaders headers=new HttpHeaders();
			//	headers.setContentDispositionFormData("attachment", fileName);// aatachment  附件
				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
				headers.setContentType(MediaType.IMAGE_PNG);
				ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)), headers,HttpStatus.CREATED);
				
				return entity;

		} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}

			
			return null;
		
	}
	
	/****************(评审员上传)上传文档至本项目服务器，文件路径保存至数据库*****************/
	@RequestMapping("/jurydoUpload")
	public String jurydoUpload(MultipartFile uploadFile,HttpServletRequest request,Model model) throws IOException{
		System.out.println("uploadFile = " + uploadFile);
		//获得文件
		byte[] buf = uploadFile.getBytes();
		System.out.println("文件长度" + buf.length);
		//文件名
		System.out.println("文件名getName = " + uploadFile.getName());
		System.out.println("文件名getOriginalFilename = " + uploadFile.getOriginalFilename());
		
		//文件名    a.txt
		String FileName = uploadFile.getOriginalFilename();
		//时间戳
		String time = FileUtil.createFileTimestamp();
		//文件url		/upload/1231231231231a.txt
		String fileUrl = "/upload/" + time + FileName;
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("fileUrl = " + fileUrl);
		//向url地址存储文件
		FileUtil.writeFileToUrl(uploadFile, fileUrl);
		
		//向数据库中保存文件信息
		String student_id = request.getParameter("student_id");
		String teacher_id = request.getParameter("teacher_id");
		String jury_id = request.getParameter("username");
		System.out.println(student_id+teacher_id);
		List <ApplyBean> apply = fileinfomapper.ApplyById(student_id,teacher_id);
		
		for (int i = 0; i < apply.size(); i++) {//for循环将数据逐一获取到
		    ApplyBean apply1 =  apply.get(i);
		    String project_total_score = apply1.getProject_total_score();//获取到的project_teach值
		    System.out.println("777"+project_total_score);
		    
         if(project_total_score.equals("0")) {
		    model.addAttribute("error", "评审信息不能为空!");
			return "jury_project_score"; 
         	}

		}
		
		List<FileInfo> fileInfo = fileinfomapper.findFileByJuryId(jury_id);
		System.out.println("888888"+fileInfo);
		
		if(fileInfo==null || fileInfo.isEmpty() ) {
			
			FileInfo fileInfo1 = new FileInfo();
			fileInfo1.setFileName(FileName);
			fileInfo1.setFileUrl(fileUrl);
			fileInfo1.setJury_id(jury_id);
			System.out.println(fileInfo1);
			fileinfomapper.addJuryFileInfo(fileInfo1);

			model.addAttribute("successerror", "文件上传成功!");
			return "jury_project_score"; 
			}else{
				
				
			   FileInfo fileInfo1 = new FileInfo();
			    fileInfo1.setFileName(FileName);
				fileInfo1.setFileUrl(fileUrl);
				fileInfo1.setJury_id(jury_id);
			   fileinfomapper.updateJuryFileInfo(fileInfo1);

				model.addAttribute("successerror", "文件上传成功!");
				return "jury_project_score"; 
			}

		
	}
	
	/*************************(评审员下载)根据数据库文件路径，下载文档***************************/
	@RequestMapping("/jurydownload")
	public String jurydownload(HttpServletRequest request,Model model) {
		
		String teacher_id = request.getParameter("teacher_id");
		String student_id = request.getParameter("student_id");
		List<FileInfo> fileInfo = fileinfomapper.findFileByTeacherId(student_id,teacher_id);
		System.out.println(fileInfo);

		if(fileInfo==null || fileInfo.isEmpty() ) {

			 model.addAttribute("error", "该教师还没有提交项目评述，不能下载文件！");
			return "jury_project_score";
		}else{
			
			return "forward:juryfile.do";
	     }
	}	
	@RequestMapping("/juryfile")
	public ResponseEntity<byte[]> juryfile(Integer fileId, HttpServletRequest request,HttpServletResponse response){
		
		String teacher_id = request.getParameter("teacher_id");
		try {

			FileInfo fileInfo2 = fileinfomapper.findFileByTeacherid(teacher_id);
			System.out.println("888888"+fileInfo2);
			String fileUrl = fileInfo2.getFileUrl();
			String fileName = fileInfo2.getFileName();
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
				HttpHeaders headers=new HttpHeaders();
				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
				//headers.setContentDispositionFormData("attachment", fileName);// aatachment  附件
				headers.setContentType(MediaType.IMAGE_PNG);
				ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)), headers,HttpStatus.CREATED);
				
				return entity;

		} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}

			
			return null;
		
	}
	
	/****************(管理员上传)上传文档至本项目服务器，文件路径保存至数据库*****************/
	@RequestMapping("/managerdoUpload")
	public String managerdoUpload(MultipartFile uploadFile,HttpServletRequest request,Model model) throws IOException{
		System.out.println("uploadFile = " + uploadFile);
		//获得文件
		byte[] buf = uploadFile.getBytes();
		System.out.println("文件长度" + buf.length);
		//文件名
		System.out.println("文件名getName = " + uploadFile.getName());
		System.out.println("文件名getOriginalFilename = " + uploadFile.getOriginalFilename());
		
		//文件名    a.txt
		String FileName = uploadFile.getOriginalFilename();
		//时间戳
		String time = FileUtil.createFileTimestamp();
		//文件url		/upload/1231231231231a.txt
		String fileUrl = "/upload/" + time + FileName;
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("fileUrl = " + fileUrl);
		//向url地址存储文件
		FileUtil.writeFileToUrl(uploadFile, fileUrl);
		
		//向数据库中保存文件信息
	
		String manager_id = request.getParameter("username");

			FileInfo fileInfo1 = new FileInfo();
			fileInfo1.setFileName(FileName);
			fileInfo1.setFileUrl(fileUrl);
			fileInfo1.setManager_id(manager_id);
			System.out.println(fileInfo1);
			fileinfomapper.addManagerFileInfo(fileInfo1);

			model.addAttribute("successerror", "文件上传成功!");
			return "manager_file_upload"; 
			

		
	}
	
	/*************************(管理员下载)根据数据库文件路径，下载文档***************************/
	@RequestMapping("/projectfile")
	public String managerdownload(HttpServletRequest request,Model model) {
		
				
		List<FileInfo> fileInfo = fileinfomapper.findAllFile();
		System.out.println(fileInfo);
			model.addAttribute("FileList", fileInfo);
			return "manager_file_download";
			
	     
	}	
	@RequestMapping("/managerdownload")
	public ResponseEntity<byte[]> managerfile( HttpServletRequest request,HttpServletResponse response){
		
		String fileId = request.getParameter("file_id");
		try {

			FileInfo fileInfo2 = fileinfomapper.findFileById(fileId);
			System.out.println("888888"+fileInfo2);
			String fileUrl = fileInfo2.getFileUrl();
			String fileName = fileInfo2.getFileName();
			/*实际开发中遇到了中文名不显示的问题,原来是Header中只支持ASCII，传输的文件名必须是ASCII
			为什么用ISO-8859-1，看度娘的解释:
			ISO-8859-1编码是单字节编码，向下兼容ASCII，
			其编码范围是0x00-0xFF，0x00-0x7F之间完全和ASCII一致，
			0x80-0x9F之间是控制字符，0xA0-0xFF之间是文字符号。*/
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
				HttpHeaders headers=new HttpHeaders();
				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
			//	headers.setContentDispositionFormData("attachment", fileName);// aatachment  附件
				headers.setContentType(MediaType.IMAGE_PNG);
				ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)), headers,HttpStatus.CREATED);
				
				return entity;

		} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}

			
			return null;
		
	}
}
