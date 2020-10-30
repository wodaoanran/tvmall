package cn.yunhe.java.dao.inter;

import cn.yunhe.java.pojo.MenuObject;
import cn.yunhe.java.pojo.SysUser;

import java.util.List;
import java.util.Map;

public interface LoginDao {

    /**
     * 登录功能
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
     * @param params
     * @return
     */
    List<MenuObject> queryMenus(Map<String, Object> params);

    /**
     * 查询当前用户所有按钮信息
     * @param userId
     * @return
     */
    List<Map<String,Object>> queryRightsFunc(Integer userId);
}
