package cn.yunhe.java.services.sysmgr;

import cn.yunhe.java.pojo.SysMenu;
import cn.yunhe.java.util.objects.Result;

import java.util.List;
import java.util.Map;


public interface MenuService {

    /**
     * 查询所有的菜单
     * @return
     * @throws Exception
     */
    Result query(int page, int limit) throws Exception;

    /**
     * 添加菜单时下拉框内容
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> querySelect() throws Exception;

    /**
     * 新增菜单
     * @param sm
     * @throws Exception
     */
    void addMenu(SysMenu sm) throws Exception;

    /**
     * 修改菜单
     * @param sm
     * @throws Exception
     */
    void updMenu(SysMenu sm) throws Exception;

    /**
     * 删除菜单
     * @throws Exception
     */
    void delMenu(String menuId) throws Exception;
}
