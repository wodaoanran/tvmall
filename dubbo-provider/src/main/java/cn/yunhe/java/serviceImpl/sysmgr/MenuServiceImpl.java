package cn.yunhe.java.serviceImpl.sysmgr;

import cn.yunhe.java.dao.common.CommonDao;
import cn.yunhe.java.pojo.SysMenu;
import cn.yunhe.java.pojo.SysPopedom;
import cn.yunhe.java.services.sysmgr.MenuService;
import cn.yunhe.java.util.objects.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
   private CommonDao commonDao;

    @SuppressWarnings("unchecked")
	@Override
    public Result query(int page, int limit) throws Exception {
    	PageHelper.startPage(page, limit, true);

        List<Map<String,Object>> data = (List<Map<String,Object>>) commonDao.findForList("menuMapper.queryMenu",null);

        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(data);

		Result rs = new Result();
		rs.setCode("0");
		rs.setCount(pageInfo.getTotal());
        rs.setData(data);		
		return rs;       
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Map<String, Object>> querySelect() throws Exception {
        List<Map<String,Object>> data = (List<Map<String,Object>>) commonDao.findForList("menuMapper.queryMenuSelect", null);
        for (Map<String, Object> map : data){
            String s = (String) map.get("menu_name");
            Integer lev =  Integer.parseInt(map.get("lev").toString());
            for(int i = 0;i < lev;i++){
                s = "&nbsp;&nbsp;&nbsp;├&nbsp;&nbsp;" + s;
            }
            map.put("menu_name", s);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lev", 0);
        map.put("menu_name", "顶级菜单");
        map.put("menu_id", "");
        data.add(0, map);
        return data;
    }



	@Override
    @SuppressWarnings("unchecked")
    public void addMenu(SysMenu sm) throws Exception {
        // 根据父级id 生成自己的id
        String menuId = (String) commonDao.findForObject("menuMapper.queryMenuId", sm.getPmenuId() + "__");
        sm.setMenuId(menuId);
        // 查询出父级对像
        Map<String, Object> rtnList = (Map<String, Object>) commonDao.findForObject("menuMapper.queryMenuById", sm.getPmenuId());
        if(rtnList == null){
            sm.setLev("1");
        }else {
            sm.setLev(String.valueOf(Integer.parseInt( rtnList.get("lev").toString()) + 1));
        }

        // 保存对象
        Integer i = (Integer)commonDao.save("menuMapper.saveMenu", sm);
        if(i <= 0){
            throw new Exception("保存失败");
        }

        // 保存权限对象
        SysPopedom sp = new SysPopedom();
        sp.setMenuId(sm.getMenuId());
        sp.setItemName(sm.getMenuName());
        sp.setItemType("1");
        sp.setCreateUser(sm.getCreateUser());
        sp.setCreateTime(sm.getCreateTime());

        Integer j = (Integer)commonDao.save("menuMapper.saveSysPopedom", sp);
        if(j <= 0){
            throw new Exception("生成权限项失�?");
        }
    }

    @Override
    public void updMenu(SysMenu sm) throws Exception {
        Integer i = (Integer)commonDao.update("menuMapper.updateMenu", sm);
        if(i <= 0){
            throw new Exception("修改失败");
        }
    }

    @Override
    public void delMenu(String menuId) throws Exception {
        Integer l = (Integer) commonDao.findForObject("menuMapper.queryMenuByIdLike", menuId + "%");

        if(l > 1){
            throw new Exception("此菜单下含有子菜单，请先删除子菜单！");
        }

        Integer i = (Integer) commonDao.delete("menuMapper.deleteMenu", menuId);
        if(i <= 0){
            throw new Exception("删除失败");
        }
    }
}
