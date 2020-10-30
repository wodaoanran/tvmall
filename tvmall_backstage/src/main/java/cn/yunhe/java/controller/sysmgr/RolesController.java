package cn.yunhe.java.controller.sysmgr;

import cn.yunhe.java.controller.common.BaseController;
import cn.yunhe.java.pojo.SysRoleRights;
import cn.yunhe.java.pojo.SysRoles;
import cn.yunhe.java.services.sysmgr.RolesService;
import cn.yunhe.java.util.DateUtils;
import cn.yunhe.java.util.objects.AjaxDone;
import cn.yunhe.java.util.objects.Result;
import cn.yunhe.java.util.objects.ZTreeNode;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***********************************************************
 * auth: 薛建玉
 * date: 2020-08-11 9:47
 * version: 1.0
 ***********************************************************/

@Controller
@RequestMapping("roles")
public class RolesController extends BaseController {
    private static final Logger logger = LogManager.getLogger(RolesController.class);
//    @Autowired
//    private RolesService service;
    @Reference
    private RolesService service;

    /**
     * 跳转到角色列表页面
     * @return
     */
    @RequestMapping("toRoleList")
    public String toList(){
      return "sysmgr/roles/rolesList";
    }


    /**
     * 查询角色列表
     * @param roleName
     * @return
     */
    @RequestMapping(value = "query",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result queryList(String roleName,int page,int limit){
        Result rs = service.queryList(roleName,page,limit);
        return rs;
    }

    /**
     * 到添加角色页面
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "sysmgr/roles/toAdd";
    }

    /**
     * 添加角色
     * @param sysRoles
     * @param request
     * @return
     */
    @RequestMapping(value = "addRole",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone addRole(SysRoles sysRoles, HttpServletRequest request){
        try{
             sysRoles.setCreateUser(getLoginObject(request).getUserName());
             sysRoles.setCreateTime(DateUtils.getSystemDate());
             int rst = service.addRole(sysRoles);
             if(rst>0){
                 return new AjaxDone("200","添加角色成功！");
             }else{
                 return new AjaxDone("300","添加角色失败！");
             }
        }catch(Exception e){
            logger.debug(e.getMessage());
        }
        return new AjaxDone("300","系统繁忙,请稍后重试！");
    }

    /**
     * 到修改页面
     * @param roleId
     * @return
     */
    @RequestMapping("toUpd/{roleId}/{roleName}/{status}")
    public String toUpd(@PathVariable("roleId") @ModelAttribute Integer roleId,
                        @PathVariable("roleName") @ModelAttribute String roleName,
                        @PathVariable("status") @ModelAttribute Integer status){
        return "sysmgr/roles/toUpd";
    }

    /**
     * 修改角色信息
     * @param sysRoles
     * @param request
     * @return
     */
    @RequestMapping(value = "updateRole",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone update(SysRoles sysRoles,HttpServletRequest request){
       try{
           int rst = service.update(sysRoles);
           if(rst>0){
               return new AjaxDone("200","修改角色成功！");
           }else{
               return new AjaxDone("300","修改角色失败！");
           }
       }catch(Exception e){
        e.printStackTrace();
    }
        return new AjaxDone("300","系统繁忙,请稍后重试！");
    }

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    @RequestMapping(value = "delete/{roleId}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone delete(@PathVariable("roleId") Integer roleId){
        try{
            int rst = service.deleteRole(roleId);
            if(rst>0){
                return new AjaxDone("200","删除角色成功！");
            }else{
                return new AjaxDone("300","删除角色失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxDone("300","系统繁忙,请稍后重试！");
    }

    /**
     * 到设授权页面
     * @param roleId
     * @return
     */
    @RequestMapping(value = "toSetRights/{roleId}",method = RequestMethod.GET)
    public String toSetRights(@PathVariable("roleId") @ModelAttribute Integer roleId){
        return "sysmgr/roles/toSetRights";
    }

    /**
     * 查询权限信息
     * @param roleId
     * @return
     */
    @RequestMapping(value = "queryPopedom/{roleId}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<ZTreeNode> queryPopedom(@PathVariable("roleId") Integer roleId){
        List<ZTreeNode> rtnList = service.queryPopedom(roleId,1,"0");
        return rtnList;
    }

    @RequestMapping(value = "saveRoleRights",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxDone saveRoleRights(Integer roleId,String ids,HttpServletRequest request){
       try{
           String [] idArr = ids.split(",");
           List<SysRoleRights> pList = new ArrayList<>();
           for(String id : idArr){
               SysRoleRights srr = new SysRoleRights();
               srr.setCreateTime(DateUtils.getSystemDate());
               srr.setCreateUserName(getLoginObject(request).getUserName());
               srr.setCreateUserId(getLoginObject(request).getUserId());
               srr.setPopedomId(Integer.parseInt(id));
               srr.setRoleId(roleId);
               pList.add(srr);
           }

           int rst = service.saveRoleRights(pList,roleId);

           if(rst>0){
               //刷新session
               //1.获取当前角色对应的所有用户
               List<String> userIdList = service.queryRoleUser(roleId);

               //2. 刷新所有当前角色对应的用户的session
               //3. 获取当前角色所有按钮权限
                Map<String,Integer> rtnMap = service.queryRightsFunc(roleId);
               for(String userId : userIdList){
                   ServletContext application = request.getServletContext();
                   HttpSession session =  (HttpSession) application.getAttribute(userId);
                   if(session==null) continue;
                   session.setAttribute(USER_POPEDOM_KEY,rtnMap);
               }

               return new AjaxDone("200","保存权限成功！");
           }else
               return new AjaxDone("300","保存权限失败！");
       }catch (Exception e){
           logger.debug(e.getMessage());
       }
        return new AjaxDone("300","系统繁忙，请稍后重试！");
    }

}
