package cn.yunhe.java.serviceImpl.sysmgr;

import cn.yunhe.java.dao.inter.sysmgr.SysRolesDao;
import cn.yunhe.java.pojo.SysRoleRights;
import cn.yunhe.java.pojo.SysRoles;
import cn.yunhe.java.services.sysmgr.RolesService;
import cn.yunhe.java.util.objects.Result;
import cn.yunhe.java.util.objects.ZTreeNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RolesServiceImpl implements  RolesService {

    @Autowired
    private SysRolesDao dao;

    @Override
    public Result queryList(String roleName,int pageNum,int size) {
        PageHelper.startPage(pageNum,size,true);
        List<SysRoles> roleList = dao.queryFactor(roleName);
        PageInfo<SysRoles> pageInfo = new PageInfo<>(roleList);
        Result rs = new Result();
        rs.setCode("0");
        rs.setCount(pageInfo.getTotal());
        rs.setMsg("OK");
        rs.setData(pageInfo.getList());
        return rs;
    }

    @Override
    public int addRole(SysRoles sysRoles) {
        return dao.insertSelective(sysRoles);
    }

    @Override
    public int update(SysRoles sysRoles) {
        return dao.updateByPrimaryKeySelective(sysRoles);
    }

    @Override
    public int deleteRole(Integer roleId) {
        return dao.deleteByPrimaryKey(roleId);
    }

    @Override
    public List<ZTreeNode> queryPopedom(Integer roleId,Integer lev,String pMenuId) {
        //查询1级菜单
        Map<String,Object> params = new HashMap<>();
        params.put("roleId",roleId);
        params.put("lev",lev);
        params.put("pMenuId",pMenuId);
        List<Map<String,Object>> roleMenusList = dao.queryRoleMenus(params);
        List<ZTreeNode> rtnList = new ArrayList<>();
        for(Map<String,Object> map : roleMenusList){
            ZTreeNode item = new ZTreeNode(map.get("menu_name").toString(),map.get("id").toString());
            //是否拥有权限，有则选中，没有则不选
            Integer isHave = Integer.parseInt(map.get("ishave").toString());
            if(isHave>0){
                item.setChecked(true);
            }
            //是否是父节点，如果有子节点，则一定是父节点
            Integer childNum = Integer.parseInt(map.get("childNum").toString());
            String menuId = String.valueOf(map.get("menu_id")); //获取菜单id
            if(childNum>0){
                item.setIsParent(true);
                item.setOpen(true);
                //查询子节点信息
                item.setChildren(queryPopedom(roleId,lev+1,menuId));
                rtnList.add(item);
                continue;// 如果是父节点，则不需要再去查询页面功能按钮信息
            }

            //查询当前页面对应的功能（按钮）信息
            Map<String,Object> params2 = new HashMap<>();
            params2.put("roleId",roleId);
            params2.put("menuId",menuId);
            List<Map<String,Object>> funcList = dao.queryMenuFunc(params2);
            item.setModel(funcList);
            rtnList.add(item);
        }
        return rtnList;
    }

    @Override
    public int saveRoleRights(List<SysRoleRights> list,Integer roleId) {
        //先删除当前角色的所有权限
        dao.deleteRightsByRoleId(roleId);
        //重新添加选中的权限
        return dao.saveRoleRights(list);
    }

    @Override
    public List<String> queryRoleUser(Integer roleId) {
        List<Map<String,Object>> list = dao.queryRoleUsers(roleId);
        List<String> userIdList = new ArrayList<>();
        for(Map<String,Object> map : list){
            userIdList.add(map.get("user_id").toString());
        }
        return userIdList;
    }

    @Override
    public Map<String, Integer> queryRightsFunc(Integer roleId) {
        List<Map<String,Object>> list = dao.queryRightsFunc(roleId);
        Map<String,Integer> rtnMap = new HashMap<>();
        for(Map<String,Object> map : list){
            rtnMap.put(map.get("item_code").toString(),Integer.parseInt(map.get("flag").toString()));
        }
        return rtnMap;
    }
}
