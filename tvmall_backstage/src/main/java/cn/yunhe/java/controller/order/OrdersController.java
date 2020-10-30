package cn.yunhe.java.controller.order;


import cn.yunhe.java.controller.common.BaseController;
import cn.yunhe.java.pojo.TvOrder;
import cn.yunhe.java.services.goods.OrderService;
import cn.yunhe.java.util.FileExport;
import cn.yunhe.java.util.objects.Result;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController extends BaseController {

//    @Autowired
//    private OrderService service;
    @Reference
    private OrderService service;
    /**
     * 跳转到订单列表页面
     * @return
     */
    @RequestMapping("orderList")
    public String toOrderList(){
        return "goods/order/orderList";
    }

    @ResponseBody
    @RequestMapping("list")
    public Result list(String orderSn, String userId, String userName, String orderState, int page, int limit){
        Result rs = null;
        try {
            rs = service.queryAll(orderSn, userId, userName, orderState, page, limit);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result();
    }

    /**
     * export Excel
     * @param orderSn
     * @param userId
     * @param userName
     * @param orderState
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("export")
    public void exportExcel(String orderSn, String userId, String userName, String orderState, HttpServletResponse response) {
        Result rs = null;
        try {
            rs = service.queryAll(orderSn, userId, userName, orderState, 0, 0);
            String[] topName = {"订单编号","用户id", "用户姓名"};
            List<Object[]> list = new ArrayList<>();
            for(TvOrder order : (List<TvOrder>)rs.getData()) {
                Object [] obj =new Object[topName.length];
                obj[0]=order.getOrderSn();
                obj[1]=order.getUserId();
                obj[2]=order.getUserName();

                list.add(obj);
            }
            FileExport.exportExcel(topName, list, "订单信息", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("exportPdf")
    public void exportPdf(String orderSn, String userId, String userName, String orderState, HttpServletResponse response) {
        Result rs = null;
        try {
            rs = service.queryAll(orderSn, userId, userName, orderState, 0, 0);


           List<String> titles = Arrays.asList("订单编号","用户id", "用户姓名","订单时间");//,"用户id", "用户姓名","订单时间"

           List<List> datas = new ArrayList<>();
           datas.add(titles);
          for(TvOrder order : (List<TvOrder>)rs.getData()) {
              List<String> list = new ArrayList<>();
              list.add(order.getOrderSn());
              list.add(order.getUserId());
              list.add(order.getUserName());
              list.add(order.getAddTime());

              datas.add(list);
            }

            FileExport.exportPdf(datas,"订单信息", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
