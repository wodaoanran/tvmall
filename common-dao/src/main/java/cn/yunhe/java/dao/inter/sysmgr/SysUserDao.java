package cn.yunhe.java.dao.inter.sysmgr;

import cn.yunhe.java.pojo.SysRoleUser;
import cn.yunhe.java.pojo.SysUser;
import cn.yunhe.java.pojo.SysUserMap;

import java.util.List;
import java.util.Map;

public interface SysUserDao {

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 保存用户信息
     * @param record
     * @return
     */
    int insert(SysUser record);

    /**
     * 根据封装数据保存用户信息
     * @param record
     * @return
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键ID查询用户信息
     * @param userId
     * @return
     */
    SysUser selectByPrimaryKey(Integer userId);

    /**
     * 根据封装数据更新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 更新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 根据条件查询用户信息
     * @param params
     * @return
     */
    List<SysUserMap> queryByFactory(Map<String, Object> params);

    /**
     * 批量删除用户信息
     * @param params
     * @return
     */
    int deleteSysUserBatch(List<String> params);

    /**
     * 根据用户id查询角色信息
     * @param userId
     * @return
     */
    List<Map<String,Object>> queryRoles(Integer userId);

    /**
     * 设置用户的角色
     * @return
     */
    int addUserRoles(List<SysRoleUser> srrList);

    /**
     * 删除当前用户对应的角色信息
     * @param userId
     * @return
     */
    int deleteUserRoles(Integer userId);
}
