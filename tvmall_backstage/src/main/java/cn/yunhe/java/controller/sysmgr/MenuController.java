package cn.yunhe.java.controller.sysmgr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.java.controller.common.BaseController;
import cn.yunhe.java.pojo.SysMenu;
import cn.yunhe.java.services.sysmgr.MenuService;
import cn.yunhe.java.util.objects.AjaxDone;
import cn.yunhe.java.util.objects.Result;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {
	
	// Logger logger = LoggerFactory.getLogger(XTGL010Controller.class);

//    @Autowired
//    private MenuService service;
    @Reference
    private MenuService service;
    /**
     * 跳转到菜单管理页
     * @return
     */
    @RequestMapping("toMenuList")
    public String toXtgl01001(ModelMap model) throws Exception {
        // 将下拉框的数据携带到前台
        List<Map<String, Object>> list = service.querySelect();
        model.put("data", list);
        return "sysmgr/menu/menu01";
    }

    /**
     * 取出菜单数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("query")
    public Result query(HttpServletRequest request, int page, int limit){
    	Result rs = null;
        try {       
             rs = service.query(page,limit);
            return rs;
        } catch(Exception e){
            e.printStackTrace();
        }
        return new Result();
    }

    /**
     * 跳转到添加菜单页
     * @return
     */
    @RequestMapping("toXtgl01002")
    public String toXtgl01002(){

        return "sysmgr/menu/menu02";
    }

    /**
     * 跳转到图标择页面
     * @return
     */
    @RequestMapping("toMenuIcon")
    public String toMenuIcon(){

        return "sysmgr/menu/model";
    }

    /**
     * 添加菜单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("addMenu") @ResponseBody
    public AjaxDone addMenu(HttpServletRequest request, HttpServletResponse response){
        String pMenuId = request.getParameter("pmenu_id");
        String menuName = request.getParameter("menu_name");
        String rel = request.getParameter("rel");
        String url = request.getParameter("url");
        String icon = request.getParameter("icon");
        String order = request.getParameter("order");

        try {
            SysMenu sm = new SysMenu();
            sm.setPmenuId(pMenuId);
            sm.setMenuName(menuName);
            sm.setRel(rel);
            sm.setUrl(url);
            sm.setIcon(icon);
            sm.setMenuOrder(Integer.parseInt(order));
            sm.setCreateUser(getLoginObject(request).getUserName());
            sm.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

            service.addMenu(sm);
            return new AjaxDone("200","添加成功");
        } catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxDone("300","添加失败");
    }

    /**
     * 修改菜单
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("updMenu")
    public AjaxDone updMenu(HttpServletRequest request){
        String menuId = request.getParameter("menu_id");
        String menuName = request.getParameter("menu_name");
        String rel = request.getParameter("rel");
        String url = request.getParameter("url");
        String icon = request.getParameter("icon");
        String order = request.getParameter("order");

        try{
            SysMenu sm = new SysMenu();
            sm.setMenuId(menuId);
            sm.setMenuName(menuName);
            sm.setRel(rel);
            sm.setUrl(url);
            sm.setIcon(icon);
            sm.setMenuOrder(Integer.parseInt(order));
            sm.setUpdateUser(getLoginObject(request).getUserName());
            sm.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

            service.updMenu(sm);
            return new AjaxDone("200","修改成功");
        } catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxDone("300","修改失败");
    }

    /**
     * 删除菜单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("delMenu") @ResponseBody
    public AjaxDone delMenu(HttpServletRequest request, HttpServletResponse response){
        String menuId = request.getParameter("menu_id");
        try{
            service.delMenu(menuId);
            return new AjaxDone("200","删除成功");
        } catch(Exception e){
            e.printStackTrace();
            return new AjaxDone("300",e.getMessage());
        }
    }
}
