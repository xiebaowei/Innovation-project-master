package com.bw.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordGenerator {  
    private static Configuration configuration = null;  
    private static Map<String, Template> allTemplates = null;  
      
    static {  
    	 configuration = new Configuration(Configuration.VERSION_2_3_0);
         configuration.setDefaultEncoding("UTF-8");  
        configuration.setClassForTemplateLoading(WordGenerator.class, "/com/bw/tools");  
        allTemplates = new HashMap<String,Template>();
        try {  
            allTemplates.put("teacher_project", configuration.getTemplate("teacher_project.ftl")); 
            allTemplates.put("teacher_project", configuration.getTemplate("teacher_project.ftl"));  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }  
  
    private WordGenerator() {  
        throw new AssertionError();  
    }  
  
    public static File createDoc(Map<?, ?> dataMap, String type) {  
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";  
        File f = new File(name);  
        Template t = allTemplates.get(type);  
        try {  
            // ����ط�����ʹ��FileWriter��Ϊ��Ҫָ���������ͷ������ɵ�Word�ĵ�����Ϊ���޷�ʶ��ı�����޷���  
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");  
            t.process(dataMap, w);  
            w.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw new RuntimeException(ex);  
        }  
        return f;  
    }  
  
}  