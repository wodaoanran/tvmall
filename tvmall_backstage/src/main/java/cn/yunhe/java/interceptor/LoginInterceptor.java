package cn.yunhe.java.interceptor;

import cn.yunhe.java.util.objects.LoginObject;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(); //获取session
        LoginObject stu = (LoginObject) session.getAttribute("userinfo");
        //取到X-Requested-With 判断是否是异步请求
        String xhr = request.getHeader("X-Requested-With");
        if(stu==null){
            if("XMLHttpRequest".equals(xhr)){
                response.setContentType("application/json;charset=utf-8");
                // 第一种方式，直接返回json数据
                response.getWriter().append("{\"statusCode\":\"300\",\"message\":\""+ URLEncoder.encode("会话超时，请重新登录","utf-8")+"\",\"location\":\""+request.getContextPath()+"/login/toLogin\"}");

                //第二种方式，在响应头中添加会话超时的信息
                //response.setHeader("msg","timeOut");
                //response.setHeader("location",request.getContextPath()+"/login/toLogin");
            }else{
                response.getWriter().append("<script>window.top.location.href='"+request.getContextPath()+"/login/exit'</script>");
            }
            return false;
        }
        return true;
    }
}
