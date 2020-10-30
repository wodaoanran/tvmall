package cn.yunhe.java.dao.inter.sysmgr;

import cn.yunhe.java.pojo.SysRoleRights;
import cn.yunhe.java.pojo.SysRoles;

import java.util.List;
import java.util.Map;


public interface SysRolesDao {

    /**
     * 删除
     * @param roleId
     * @return
     */
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRoles record);

    /**
     * 保存
     * @param record
     * @return
     */
    int insertSelective(SysRoles record);

    /**
     * 跳转到修改页面
     * @param roleId
     * @return
     */
    SysRoles selectByPrimaryKey(Integer roleId);

    /**
     * 根据条件查询角色信息
     * @param roleName
     * @return
     */
    List<SysRoles> queryFactor(String roleName);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);


    /**
     * 查询角色对应菜单（全部）信息
     * @param params
     * @return
     */
    List<Map<String, Object>> queryRoleMenus(Map<String, Object> params);

    /**
     * 查询角色对应的功能（全部）项信息
     * @param params
     * @return
     */
    List<Map<String, Object>> queryMenuFunc(Map<String, Object> params);

    /**
     * 批量保存角色权限对应信息
     * @param list
     * @return
     */
    int saveRoleRights(List<SysRoleRights> list);

    /**
     * 删除角色对应权限信息
     * @param roleId
     * @return
     */
    int deleteRightsByRoleId(Integer roleId);

    /**
     * 查询当前角色对应的所有用户id
     * @param roleId
     * @return
     */
    List<Map<String,Object>> queryRoleUsers(Integer roleId);

    /**
     * 查询当前角色的对应的所有按钮信息
     * @param roleId
     * @return
     */
    List<Map<String,Object>> queryRightsFunc(Integer roleId);
}
