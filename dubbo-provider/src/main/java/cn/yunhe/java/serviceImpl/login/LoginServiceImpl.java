package cn.yunhe.java.serviceImpl.login;

import cn.yunhe.java.dao.inter.LoginDao;
import cn.yunhe.java.pojo.MenuObject;
import cn.yunhe.java.pojo.SysUser;
import cn.yunhe.java.services.login.LoginService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService  {

    @Autowired
    private LoginDao dao;

    @Override
    public SysUser login(String loginName) {
        return dao.login(loginName);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateLogin(SysUser su) {
        return dao.updateLogin(su);
    }

    @Override
    public List<MenuObject> queryMenus(Integer userId,Integer lev) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("lev",lev);
        return dao.queryMenus(params);
    }

    @Override
    public Map<String, Integer> queryRightsFunc(Integer userId) {
        List<Map<String,Object>> list = dao.queryRightsFunc(userId);
        Map<String,Integer> rtnMap = new HashMap<>();
        for(Map<String,Object> map : list){
            rtnMap.put(map.get("item_code").toString(),Integer.parseInt(map.get("flag").toString()));
        }
        return rtnMap;
    }
}
