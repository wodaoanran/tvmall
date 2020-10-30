package cn.yunhe.java.services.login;

import cn.yunhe.java.pojo.MenuObject;
import cn.yunhe.java.pojo.SysUser;

import java.util.List;
import java.util.Map;

public interface LoginService {

    /**
     * 登录
     * @param loginName
     * @return
     */
    SysUser login(String loginName);

    /**
     * 更新登录信息
     * @param su
     * @return
     */
    int updateLogin(SysUser su);

    /**
     * 查询菜单信息
     * @return
     */
    List<MenuObject> queryMenus(Integer userId, Integer lev);

    /**
     * 查询当前用户所有按钮信息
     * @param userId
     * @return
     */
   Map<String,Integer> queryRightsFunc(Integer userId);

}
