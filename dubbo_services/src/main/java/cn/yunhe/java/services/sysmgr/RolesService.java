package cn.yunhe.java.services.sysmgr;

import cn.yunhe.java.pojo.SysRoleRights;
import cn.yunhe.java.pojo.SysRoles;
import cn.yunhe.java.util.objects.Result;
import cn.yunhe.java.util.objects.ZTreeNode;

import java.util.List;
import java.util.Map;

public interface RolesService {

    /**
     * 查询角色列表
     * @param roleName
     * @return
     */
    Result queryList(String roleName, int pageNum, int size);

    /**
     * 添加角色信息
     * @param sysRoles
     * @return
     */
    int addRole(SysRoles sysRoles);

    /**
     * 修改角色信息
     * @param sysRoles
     * @return
     */
    int update(SysRoles sysRoles);

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    int deleteRole(Integer roleId);

    /**
     * 根据用户角色id查询权限信息
     * @param roleId
     * @return
     */
    List<ZTreeNode> queryPopedom(Integer roleId, Integer lev, String pMenuId);

    /**
     * 保存权限信息
     * @param list
     * @return
     */
    int saveRoleRights(List<SysRoleRights> list, Integer roleId);

    /**
     * 查询当前角色对应的所有用户id
     * @param roleId
     * @return
     */
    List<String> queryRoleUser(Integer roleId);


    /**
     * 查询当前角色所有按钮信息
     * @param roleId
     * @return
     */
    Map<String,Integer> queryRightsFunc(Integer roleId);

}
