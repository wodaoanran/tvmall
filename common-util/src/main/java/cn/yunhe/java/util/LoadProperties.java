package cn.yunhe.java.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class LoadProperties {

	public static String findValue(String key) throws IOException {
		//读取配置文件 
        Properties properties = new Properties();
        FileInputStream inputFile = null;
		try{  
			// 获取classes路径
			String classPath = CommonUtils.getClassesPath();
			// 打开文件
			inputFile = new FileInputStream(classPath + "config.properties");
			// 加载资源文件
			properties.load(new InputStreamReader(inputFile, "UTF-8"));
			String value = properties.getProperty(key);
			return value;
        }catch (Exception e){  
        	e.printStackTrace();  
        }finally{
        	 if(inputFile!=null)				
        		 // 关闭文件流
				inputFile.close();				
        }
		return null;
	} 
}
