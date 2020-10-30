package cn.yunhe.java.pojo;

import java.math.BigDecimal;

public class TvOrder {
    private Integer orderId;

    private String orderSn;

    private String userId;

    private String userName;

    private String userCardNumber;

    private String addTime;

    private String finishTime;

    private String paySn;

    private BigDecimal arrivedAmount;

    private BigDecimal goodsAmount;

    private BigDecimal shippingFee;

    private BigDecimal orderAmount;

    private Short orderState;

    private String orderMsg;

    private BigDecimal integralHandsel;

    private Integer servicePointId;

    private String shippingTime;

    private String deliverExplain;

    private String receiverName;

    private String receiverAddress;

    private String receiverPhone;

    private Integer receiveProvinceId;

    private Integer receiveCityId;

    private String deliveryTime;

    private Short receiptMethod;

    private Short isExperie;

    private Short payMethod;

    private Short isReturngoods;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCardNumber() {
        return userCardNumber;
    }

    public void setUserCardNumber(String userCardNumber) {
        this.userCardNumber = userCardNumber == null ? null : userCardNumber.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public String getPaySn() {
        return paySn;
    }

    public void setPaySn(String paySn) {
        this.paySn = paySn == null ? null : paySn.trim();
    }

    public BigDecimal getArrivedAmount() {
        return arrivedAmount;
    }

    public void setArrivedAmount(BigDecimal arrivedAmount) {
        this.arrivedAmount = arrivedAmount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Short getOrderState() {
        return orderState;
    }

    public void setOrderState(Short orderState) {
        this.orderState = orderState;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg == null ? null : orderMsg.trim();
    }

    public BigDecimal getIntegralHandsel() {
        return integralHandsel;
    }

    public void setIntegralHandsel(BigDecimal integralHandsel) {
        this.integralHandsel = integralHandsel;
    }

    public Integer getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(Integer servicePointId) {
        this.servicePointId = servicePointId;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime == null ? null : shippingTime.trim();
    }

    public String getDeliverExplain() {
        return deliverExplain;
    }

    public void setDeliverExplain(String deliverExplain) {
        this.deliverExplain = deliverExplain == null ? null : deliverExplain.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public Integer getReceiveProvinceId() {
        return receiveProvinceId;
    }

    public void setReceiveProvinceId(Integer receiveProvinceId) {
        this.receiveProvinceId = receiveProvinceId;
    }

    public Integer getReceiveCityId() {
        return receiveCityId;
    }

    public void setReceiveCityId(Integer receiveCityId) {
        this.receiveCityId = receiveCityId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public Short getReceiptMethod() {
        return receiptMethod;
    }

    public void setReceiptMethod(Short receiptMethod) {
        this.receiptMethod = receiptMethod;
    }

    public Short getIsExperie() {
        return isExperie;
    }

    public void setIsExperie(Short isExperie) {
        this.isExperie = isExperie;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public Short getIsReturngoods() {
        return isReturngoods;
    }

    public void setIsReturngoods(Short isReturngoods) {
        this.isReturngoods = isReturngoods;
    }
}