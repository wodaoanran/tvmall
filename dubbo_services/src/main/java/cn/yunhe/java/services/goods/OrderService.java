package cn.yunhe.java.services.goods;

import cn.yunhe.java.util.objects.Result;

public interface OrderService {
    /**
     * 根据查询条件查询订单信息
     * @param orderSn
     * @param userId
     * @param userName
     * @param orderState
     * @param pageNum
     * @param size
     * @return
     */
     Result queryAll(String orderSn, String userId, String userName, String orderState,
                     int pageNum, int size) throws Exception;
}
