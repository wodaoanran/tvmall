package cn.yunhe.java.serviceImpl.sysmgr;

import cn.yunhe.java.dao.inter.sysmgr.SysUserDao;
import cn.yunhe.java.pojo.SysRoleUser;
import cn.yunhe.java.pojo.SysUser;
import cn.yunhe.java.pojo.SysUserMap;
import cn.yunhe.java.services.sysmgr.SysUserService;
import cn.yunhe.java.util.DateUtils;
import cn.yunhe.java.util.MD5Utils;
import cn.yunhe.java.util.objects.LoginObject;
import cn.yunhe.java.util.objects.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao dao;

    @Override
    public Result query(String userName, String loginName, Short status, int pageNum, int size) {
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        params.put("loginName",loginName);
        params.put("status",status);
        PageHelper.startPage(pageNum,size,true);

        List<SysUserMap> rtnList= dao.queryByFactory(params);
        PageInfo<SysUserMap> pageInfo = new PageInfo<>(rtnList);
        Result rs = new Result();
        rs.setMsg("OK");
        rs.setCount(pageInfo.getTotal());
        rs.setCode("0");
        rs.setData(pageInfo.getList());
        return rs;
    }

    @Override
    public int addUser(SysUser sysUser) {
        return dao.insertSelective(sysUser);
    }

    @Override
    public int deleteSysUser(Integer userId) {
        return dao.deleteByPrimaryKey(userId);
    }

    @Override
    public int deleteSysUserBatch(String ids) {
        List<String> params = Arrays.asList(ids.split(","));
        return dao.deleteSysUserBatch(params);
    }

    @Override
    public SysUser queryById(Integer userId) {
        return dao.selectByPrimaryKey(userId);
    }

    @Override
    public int updateSysUser(SysUser sysUser) {
        return dao.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int updatePassword(Integer userId, String newPassword) {
        SysUser su = new SysUser();
        su.setUserId(userId);
        su.setLoginPwd(MD5Utils.stringToMD5(newPassword));
        return dao.updateByPrimaryKeySelective(su);
    }

    @Override
    public List<Map<String, Object>> queryRoles(Integer userId) {
        return dao.queryRoles(userId);
    }

    @Override
    public int saveUserRoles(Integer userId, String[] ids, LoginObject login) {
        List<SysRoleUser> srrList = new ArrayList<>();
        for(String roleId : ids){
            SysRoleUser srr = new SysRoleUser();
            srr.setRoleId(Integer.parseInt(roleId));
            srr.setUserId(userId);
            srr.setCreateUserId(login.getUserId());
            srr.setCreateUserName(login.getUserName());
            srr.setCreateTime(DateUtils.getSystemDate());
            srrList.add(srr);
        }
        //先删除原有的角色
        dao.deleteUserRoles(userId);
        int rst = dao.addUserRoles(srrList);
        return rst;
    }

    @Override
    public int updateStatus(Integer userId, Short status) {
        SysUser su = new SysUser();
        su.setUserId(userId);
        su.setStatus(status);
        return dao.updateByPrimaryKeySelective(su);
    }
}
