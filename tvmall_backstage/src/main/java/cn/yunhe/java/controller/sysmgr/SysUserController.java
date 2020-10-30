package cn.yunhe.java.controller.sysmgr;

import cn.yunhe.java.controller.common.BaseController;
import cn.yunhe.java.pojo.SysUser;
import cn.yunhe.java.services.sysmgr.SysUserService;
import cn.yunhe.java.util.DateUtils;
import cn.yunhe.java.util.MD5Utils;
import cn.yunhe.java.util.objects.AjaxDone;
import cn.yunhe.java.util.objects.LoginObject;
import cn.yunhe.java.util.objects.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class SysUserController extends BaseController {
    private static final Logger logger = LogManager.getLogger(RolesController.class);

//    @Autowired
//    private SysUserService service;
    @Reference
    private SysUserService service;
    /**
     * 跳转到用户列表页面
     * @return
     */
    @RequestMapping("toUserList")
    public String toSysUserList(){
        return "sysmgr/sysuser/userList";
    }

    /**
     * 查询用户列表信息
     * @return
     */
    @RequestMapping(value = "query",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result query(String userName,String loginName,Short status,int page,int limit){
        Result rs = service.query(userName,loginName,status,page,limit);
        return rs;
    }

    /**
     * 到添加用户页面
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "sysmgr/sysuser/toAdd";
    }


    /**
     * 保存用户信息
     * @param sysUser
     * @return
     */
    @RequestMapping(value="addSysUser",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone addUser(SysUser sysUser){
        try{
            String password = MD5Utils.stringToMD5(sysUser.getLoginPwd());
            sysUser.setLoginPwd(password);
            sysUser.setLoginTimes(0);
           int rst = service.addUser(sysUser);
           if(rst>0){
               return new AjaxDone("200","添加管理用户成功");
           }else{
               return new AjaxDone("300","添加管理用户失败");
           }
        }catch(Exception e){
           logger.debug(e.getMessage());
        }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "deleteSysUser",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone deleteSysUser(Integer userId){
        try{
           int rst = service.deleteSysUser(userId);
            if(rst>0){
                return new AjaxDone("200","删除管理用户成功！");
            }else{
                return new AjaxDone("300","删除管理用户失败！");
            }
        }catch(Exception e){
            logger.debug("删除失败："+e.getMessage());
        }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "delSysUserBatch",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone deleteSysUserBatch(String ids){
        try{
            int rst = service.deleteSysUserBatch(ids);
            if(rst>0){
                return new AjaxDone("200","批量删除管理用户成功！");
            }else{
                return new AjaxDone("300","批量删除管理用户失败！");
            }
        }catch(Exception e){
            logger.debug("删除失败："+e.getMessage());
        }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

    /**
     * 到修改页面
     * @return
     */
    @RequestMapping("toUpdate")
    public String toUpdate(Integer userId, Model model){
        SysUser sysUser = service.queryById(userId);
        model.addAttribute("sysUser",sysUser);
        return "sysmgr/sysuser/toUpdate";
    }

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "updateSysUser",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone updateSysUser(SysUser sysUser, HttpServletRequest request){
        try{
            LoginObject login = getLoginObject(request);
            sysUser.setUpdateUserId(login.getUserId());
            sysUser.setUpdateUserName(login.getLoginName());
            sysUser.setUpdateTime(DateUtils.getSystemDate());
            int rst = service.updateSysUser(sysUser);
            if(rst>0){
                return new AjaxDone("200","修改管理用户成功！");
            }else{
                return new AjaxDone("300","修改管理用户失败！");
            }
        }catch(Exception e){
            logger.debug("删除失败："+e.getMessage());
        }

        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

    /**
     * 到修改密码页面
     * @return
     */
    @RequestMapping("toUpdPwd/{userId}")
    public String  toSetPassword(@PathVariable("userId")  @ModelAttribute  Integer userId){
        return "sysmgr/sysuser/toSetPwd";
    }

    /**
     * 修改密码
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    @RequestMapping(value = "updateUserPassword",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone updatePassword(Integer userId,String newPassword,String confirmPassword){
        try{
            if(StringUtils.isBlank(newPassword)){
                return new AjaxDone("300","请输入新密码！");
            }
            if(StringUtils.isBlank(confirmPassword)){
                return new AjaxDone("300","请输入确认密码！");
            }

            if(!newPassword.equals(confirmPassword)){
                return new AjaxDone("300","两次输入密码不一致！");
            }

            int rst = service.updatePassword(userId,newPassword);
            if(rst>0){
                return new AjaxDone("200","修改成功！");
            }else{
                return new AjaxDone("300","修改失败！");
            }
        }catch(Exception e){
            logger.debug("修改密码失败："+e.getMessage());
        }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

    /**
     * 到设置角色页面
     * @param userId
     * @return
     */
    @RequestMapping("toSetRoles/{userId}")
    public String toSetRoles(@PathVariable("userId") @ModelAttribute Integer userId,Model model){
        List<Map<String,Object>> rtnList = service.queryRoles(userId);
        model.addAttribute("roles",rtnList);
        return "sysmgr/sysuser/toSetRoles";
    }

    /**
     * 设置用户角色
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping(value = "setUserRoles",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone setRoles(Integer userId,String[] roleIds,HttpServletRequest request){
        try{
            int rst = service.saveUserRoles(userId,roleIds,getLoginObject(request));
            if(rst>0){
                return new AjaxDone("200","设置角色成功！");
            }else{
                return new AjaxDone("300","设置角色失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.debug("修改密码失败："+e.getMessage());
        }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

    /**
     * 修改状态
     * @param userId
     * @param status
     * @return
     */
    @PostMapping(value = "updateStatus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone updateStatus(Integer userId,Short status){
        try{
          int rst = service.updateStatus(userId,status);
            if(rst>0){
                return new AjaxDone("200","状态修改成功！");
            }else{
                return new AjaxDone("300","状态修改失败！");
            }
        }catch(Exception e){
            logger.debug("修改状态失败："+e.getMessage());
        }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }
}
