package cn.yunhe.java.controller;

import cn.yunhe.java.controller.common.BaseController;
import cn.yunhe.java.pojo.MenuObject;
import cn.yunhe.java.pojo.SysUser;
import cn.yunhe.java.services.login.LoginService;
import cn.yunhe.java.util.CommonUtils;
import cn.yunhe.java.util.DateUtils;
import cn.yunhe.java.util.MD5Utils;
import cn.yunhe.java.util.VerifyCodeUtils;
import cn.yunhe.java.util.objects.LoginObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

//    private Logger logger = LoggerFactory.getLogger(BaseController.class);

//    @Autowired
//    private LoginService service;
    @Reference
    private LoginService service;

    /**
     * 处理登录请求
     * @param loginName
     * @param password
     * @return
     */
    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public  String doLogin(String loginName, String password, String verifyCode, ModelMap model,
                           HttpSession session,HttpServletRequest request){
        if(StringUtils.isBlank(loginName)){
            model.addAttribute("msg","请输入用户名！");
            return "../../index";
        }
        if(StringUtils.isBlank(password)){
            model.addAttribute("loginName",loginName);
            model.addAttribute("msg","请输入密码！");
            return "../../index";
        }

        if(StringUtils.isBlank(verifyCode)){
            model.addAttribute("loginName",loginName);
            model.addAttribute("msg","请输入验证码！");
            return "../../index";
        }

        //验证码
        Object sessionVerifyCode = session.getAttribute("verifyCode");
        if(sessionVerifyCode==null){
            model.addAttribute("msg","会话超时，请重新登录！");
            return "../../index";
        }
        if(!verifyCode.equalsIgnoreCase(sessionVerifyCode.toString())){
            model.addAttribute("loginName",loginName);
            model.addAttribute("msg","验证码错误！");
            return "../../index";
        }
        try{
           SysUser su = service.login(loginName);
           //用户验证
           if(su == null){
               model.addAttribute("loginName",loginName);
               model.addAttribute("password",password);
               model.addAttribute("msg","当前用户不存在！");
               return "../../index";
           }

           //用户状态
           if(su.getStatus()==(short)0){
               model.addAttribute("loginName",loginName);
               model.addAttribute("password",password);
               model.addAttribute("msg","当前用户被禁用！");
               return "../../index";
           }

           //密码验证
           if(!MD5Utils.stringToMD5(password).equals(su.getLoginPwd())){
               model.addAttribute("loginName",loginName);
               model.addAttribute("password",password);
               model.addAttribute("msg","密码错误！");
               return "../../index";
           }

           //获取登录的IP地址
            String ip = CommonUtils.getIpAddr(request);
            su.setLastLoginIp(ip);
           //登录次数加1
            int times = su.getLoginTimes();
            su.setLoginTimes(times+1);
           //获取登录时间
            String sysDate = DateUtils.getSystemDate();
            su.setLastLoginTime(sysDate);
           //更新到数据库
            Object obj = session.getAttribute(SESSION_USER_KEY);
            if(obj==null)
                service.updateLogin(su);

            LoginObject login = new LoginObject();
            login.setUserId(su.getUserId());
            login.setUserName(su.getUserName());

            //查询菜单信息然后绑定到页面
            List<MenuObject> level1 = service.queryMenus(su.getUserId(),1);
            model.addAttribute("leavel1Menu",level1);
            List<MenuObject> level2 = service.queryMenus(su.getUserId(),2);
            model.addAttribute("leavel2Menu",level2);
            List<MenuObject> level3 = service.queryMenus(su.getUserId(),3);
            model.addAttribute("leavel3Menu",level3);
            //将对象保存到session
            session.setAttribute(SESSION_USER_KEY,login);

            //将当前用户拥有的按钮保存到session
            Map<String,Integer> rtnMap = service.queryRightsFunc(su.getUserId());
            session.setAttribute(USER_POPEDOM_KEY,rtnMap);

            //获取application
            ServletContext application = session.getServletContext();
            application.setAttribute(String.valueOf(su.getUserId()),session);

        }catch(Exception e){
             e.printStackTrace();
        }
        return  "main";
    }


    /**
     * 输出验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "verifyCode",method = RequestMethod.GET)
    public void  verifyCode( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        HttpSession session = request.getSession();
        session.setAttribute("verifyCode", verifyCode);

        int width = 100;//宽
        int height = 50;//高
        VerifyCodeUtils.outputImage(width, height, response.getOutputStream(), verifyCode);
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "../../index";
    }

}
