package com.bw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.mapper.StudentMapper;
import com.bw.model.ProjectBean;
import com.bw.tools.WordGenerator;

/**
 * @author xiebaowei
 *
 */
@Controller
public class DownloadController {


	
	@RequestMapping("download")
	public void Download (HttpServletRequest request, HttpServletResponse response) throws IOException {
	//	System.out.println(project_id);
		  request.setCharacterEncoding("utf-8");
		/*ProjectBean project = studentmapper.FindById(project_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(project_id, project.getProject_id());
		map.put(project_name, project.getProject_name());
		map.put(project_info, project.getProject_info());
		map.put(teacher_id, project.getTeacher_id());
		map.put(teacher_name,project.getTeacher_name());
		System.out.println(project);*/
		 Map<String, Object> map = new HashMap<String, Object>();  
     Enumeration<String> paramNames = request.getParameterNames(); 
     
     // ͨ��ѭ���������������ֵ��ӳ����  
     while(paramNames.hasMoreElements()) {  
         String key = paramNames.nextElement();  
         String value = request.getParameter(key); 
         System.out.println(key+"1***********1"+value);
         map.put(key, value);  
     }  
	
     	// ��ʾ���ڵ��ù���������Word�ĵ�֮ǰӦ����������ֶ��Ƿ�����  
        // ����Freemarker��ģ�������ڴ���ʱ���ܻ���Ϊ�Ҳ���ֵ������ ������ʱ�������������  
        File file = null;  
        InputStream fin = null;  
        ServletOutputStream out = null;  
        try {  
            // ���ù�����WordGenerator��createDoc��������Word�ĵ�  
            file = WordGenerator.createDoc(map, "teacher_project");  
            fin = new FileInputStream(file);  
              
            response.setCharacterEncoding("utf-8");  
            response.setContentType("application/msword");  
            // ��������������صķ�ʽ������ļ�Ĭ����Ϊteacher_project.doc  
            response.addHeader("Content-Disposition", "attachment;filename=teacher_project.doc");  
              
            out = response.getOutputStream();  
            byte[] buffer = new byte[512];  // ������  
            int bytesToRead = -1;  
            // ͨ��ѭ���������Word�ļ�������������������  
            while((bytesToRead = fin.read(buffer)) != -1) {  
                out.write(buffer, 0, bytesToRead);  
            }  
        } finally {  
            if(fin != null) fin.close();  
            if(out != null) out.close();  
            if(file != null) file.delete(); // ɾ����ʱ�ļ�  
        }  
     } 
 
	
	
}
