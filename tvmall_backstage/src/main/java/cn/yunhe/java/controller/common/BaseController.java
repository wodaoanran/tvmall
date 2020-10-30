package cn.yunhe.java.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.yunhe.java.util.objects.LoginObject;

public class BaseController {

	public static final String SESSION_USER_KEY = "userinfo";

	public static final String USER_POPEDOM_KEY = "userpopedom";
	
	public HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
	public LoginObject getLoginObject(HttpServletRequest request){
		return (LoginObject)request.getSession().getAttribute(SESSION_USER_KEY);
	}
}
