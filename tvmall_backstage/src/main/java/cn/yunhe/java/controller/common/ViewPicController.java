package cn.yunhe.java.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class ViewPicController {
	@RequestMapping("viewPic")
	public void view(String path, HttpServletRequest request,HttpServletResponse response){
		OutputStream toClient = null;
		FileInputStream is = null;
		if(path==null||"".equals(path)){
			path="images/noPic.png";
		}
		try {

			File file = new File(path);
			if(!file.exists()){
				String noPicPath = "images/noPic.png";
				path = request.getServletContext().getRealPath(noPicPath);
			}
			is = new FileInputStream(path);
			int i = is.available();
			byte data[] = new byte[i];
			is.read(data);
	
			response.setContentType("image/*");
	
			toClient = response.getOutputStream();
			toClient.write(data);
			toClient.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 try {
				if(is!=null)
					is.close();
				} catch (IOException e1) {
					 	e1.printStackTrace();
			 }
			 if(toClient!=null)
				try {
					toClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}	
}
