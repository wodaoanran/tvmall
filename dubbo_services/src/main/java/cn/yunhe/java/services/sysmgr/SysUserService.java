package cn.yunhe.java.services.sysmgr;

import cn.yunhe.java.pojo.SysUser;
import cn.yunhe.java.util.objects.LoginObject;
import cn.yunhe.java.util.objects.Result;

import java.util.List;
import java.util.Map;

public interface SysUserService {
    /**
     * 查询用户信息
     * @param userName
     * @param status
     * @param pageNum
     * @param size
     * @return
     */
    Result query(String userName, String loginName, Short status, int pageNum, int size);

    /**
     * 保存用户信息
     * @param sysUser
     * @return
     */
    int addUser(SysUser sysUser);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    int deleteSysUser(Integer userId);

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    int deleteSysUserBatch(String ids);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    SysUser queryById(Integer userId);

    /**
     * 修改管理用户信息
     * @param sysUser
     * @return
     */
    int updateSysUser(SysUser sysUser);

    /**
     * 修改用户密码
     * @param userId
     * @param newPassword
     * @return
     */
    int updatePassword(Integer userId, String newPassword);

    /**
     * 查询角色信息
     * @param userId
     * @return
     */
    List<Map<String, Object>> queryRoles(Integer userId);

    /**
     * 设置用户角色
     * @param userId
     * @param ids
     * @return
     */
    int saveUserRoles(Integer userId, String[] ids, LoginObject login);

    /**
     * 修改用户状态
     * @param userId
     * @param status
     * @return
     */
    int updateStatus(Integer userId, Short status);
}
