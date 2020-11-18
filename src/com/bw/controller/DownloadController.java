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
     
     // 通过循环将表单参数放入键值对映射中  
     while(paramNames.hasMoreElements()) {  
         String key = paramNames.nextElement();  
         String value = request.getParameter(key); 
         System.out.println(key+"1***********1"+value);
         map.put(key, value);  
     }  
	
     	// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整  
        // 否则Freemarker的模板引擎在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了  
        File file = null;  
        InputStream fin = null;  
        ServletOutputStream out = null;  
        try {  
            // 调用工具类WordGenerator的createDoc方法生成Word文档  
            file = WordGenerator.createDoc(map, "teacher_project");  
            fin = new FileInputStream(file);  
              
            response.setCharacterEncoding("utf-8");  
            response.setContentType("application/msword");  
            // 设置浏览器以下载的方式处理该文件默认名为teacher_project.doc  
            response.addHeader("Content-Disposition", "attachment;filename=teacher_project.doc");  
              
            out = response.getOutputStream();  
            byte[] buffer = new byte[512];  // 缓冲区  
            int bytesToRead = -1;  
            // 通过循环将读入的Word文件的内容输出到浏览器中  
            while((bytesToRead = fin.read(buffer)) != -1) {  
                out.write(buffer, 0, bytesToRead);  
            }  
        } finally {  
            if(fin != null) fin.close();  
            if(out != null) out.close();  
            if(file != null) file.delete(); // 删除临时文件  
        }  
     } 
 
	
	
}
