package cn.yunhe.java.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TvOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TvOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberIsNull() {
            addCriterion("user_card_number is null");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberIsNotNull() {
            addCriterion("user_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberEqualTo(String value) {
            addCriterion("user_card_number =", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberNotEqualTo(String value) {
            addCriterion("user_card_number <>", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberGreaterThan(String value) {
            addCriterion("user_card_number >", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("user_card_number >=", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberLessThan(String value) {
            addCriterion("user_card_number <", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberLessThanOrEqualTo(String value) {
            addCriterion("user_card_number <=", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberLike(String value) {
            addCriterion("user_card_number like", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberNotLike(String value) {
            addCriterion("user_card_number not like", value, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberIn(List<String> values) {
            addCriterion("user_card_number in", values, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberNotIn(List<String> values) {
            addCriterion("user_card_number not in", values, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberBetween(String value1, String value2) {
            addCriterion("user_card_number between", value1, value2, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserCardNumberNotBetween(String value1, String value2) {
            addCriterion("user_card_number not between", value1, value2, "userCardNumber");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(String value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(String value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(String value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(String value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(String value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(String value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLike(String value) {
            addCriterion("add_time like", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotLike(String value) {
            addCriterion("add_time not like", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<String> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<String> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(String value1, String value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(String value1, String value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(String value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(String value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(String value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(String value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLike(String value) {
            addCriterion("finish_time like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotLike(String value) {
            addCriterion("finish_time not like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<String> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<String> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(String value1, String value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(String value1, String value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andPaySnIsNull() {
            addCriterion("pay_sn is null");
            return (Criteria) this;
        }

        public Criteria andPaySnIsNotNull() {
            addCriterion("pay_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPaySnEqualTo(String value) {
            addCriterion("pay_sn =", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnNotEqualTo(String value) {
            addCriterion("pay_sn <>", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnGreaterThan(String value) {
            addCriterion("pay_sn >", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnGreaterThanOrEqualTo(String value) {
            addCriterion("pay_sn >=", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnLessThan(String value) {
            addCriterion("pay_sn <", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnLessThanOrEqualTo(String value) {
            addCriterion("pay_sn <=", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnLike(String value) {
            addCriterion("pay_sn like", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnNotLike(String value) {
            addCriterion("pay_sn not like", value, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnIn(List<String> values) {
            addCriterion("pay_sn in", values, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnNotIn(List<String> values) {
            addCriterion("pay_sn not in", values, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnBetween(String value1, String value2) {
            addCriterion("pay_sn between", value1, value2, "paySn");
            return (Criteria) this;
        }

        public Criteria andPaySnNotBetween(String value1, String value2) {
            addCriterion("pay_sn not between", value1, value2, "paySn");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountIsNull() {
            addCriterion("arrived_amount is null");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountIsNotNull() {
            addCriterion("arrived_amount is not null");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountEqualTo(BigDecimal value) {
            addCriterion("arrived_amount =", value, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountNotEqualTo(BigDecimal value) {
            addCriterion("arrived_amount <>", value, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountGreaterThan(BigDecimal value) {
            addCriterion("arrived_amount >", value, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("arrived_amount >=", value, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountLessThan(BigDecimal value) {
            addCriterion("arrived_amount <", value, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("arrived_amount <=", value, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountIn(List<BigDecimal> values) {
            addCriterion("arrived_amount in", values, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountNotIn(List<BigDecimal> values) {
            addCriterion("arrived_amount not in", values, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrived_amount between", value1, value2, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andArrivedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrived_amount not between", value1, value2, "arrivedAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIsNull() {
            addCriterion("goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIsNotNull() {
            addCriterion("goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountEqualTo(BigDecimal value) {
            addCriterion("goods_amount =", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotEqualTo(BigDecimal value) {
            addCriterion("goods_amount <>", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountGreaterThan(BigDecimal value) {
            addCriterion("goods_amount >", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_amount >=", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLessThan(BigDecimal value) {
            addCriterion("goods_amount <", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_amount <=", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIn(List<BigDecimal> values) {
            addCriterion("goods_amount in", values, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotIn(List<BigDecimal> values) {
            addCriterion("goods_amount not in", values, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_amount between", value1, value2, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_amount not between", value1, value2, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNull() {
            addCriterion("shipping_fee is null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNotNull() {
            addCriterion("shipping_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeEqualTo(BigDecimal value) {
            addCriterion("shipping_fee =", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <>", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThan(BigDecimal value) {
            addCriterion("shipping_fee >", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee >=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThan(BigDecimal value) {
            addCriterion("shipping_fee <", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIn(List<BigDecimal> values) {
            addCriterion("shipping_fee in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotIn(List<BigDecimal> values) {
            addCriterion("shipping_fee not in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee not between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Short value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Short value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Short value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Short value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Short value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Short value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Short> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Short> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Short value1, Short value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Short value1, Short value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderMsgIsNull() {
            addCriterion("order_msg is null");
            return (Criteria) this;
        }

        public Criteria andOrderMsgIsNotNull() {
            addCriterion("order_msg is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMsgEqualTo(String value) {
            addCriterion("order_msg =", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgNotEqualTo(String value) {
            addCriterion("order_msg <>", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgGreaterThan(String value) {
            addCriterion("order_msg >", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgGreaterThanOrEqualTo(String value) {
            addCriterion("order_msg >=", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgLessThan(String value) {
            addCriterion("order_msg <", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgLessThanOrEqualTo(String value) {
            addCriterion("order_msg <=", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgLike(String value) {
            addCriterion("order_msg like", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgNotLike(String value) {
            addCriterion("order_msg not like", value, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgIn(List<String> values) {
            addCriterion("order_msg in", values, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgNotIn(List<String> values) {
            addCriterion("order_msg not in", values, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgBetween(String value1, String value2) {
            addCriterion("order_msg between", value1, value2, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andOrderMsgNotBetween(String value1, String value2) {
            addCriterion("order_msg not between", value1, value2, "orderMsg");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselIsNull() {
            addCriterion("integral_handsel is null");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselIsNotNull() {
            addCriterion("integral_handsel is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselEqualTo(BigDecimal value) {
            addCriterion("integral_handsel =", value, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselNotEqualTo(BigDecimal value) {
            addCriterion("integral_handsel <>", value, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselGreaterThan(BigDecimal value) {
            addCriterion("integral_handsel >", value, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("integral_handsel >=", value, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselLessThan(BigDecimal value) {
            addCriterion("integral_handsel <", value, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselLessThanOrEqualTo(BigDecimal value) {
            addCriterion("integral_handsel <=", value, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselIn(List<BigDecimal> values) {
            addCriterion("integral_handsel in", values, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselNotIn(List<BigDecimal> values) {
            addCriterion("integral_handsel not in", values, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integral_handsel between", value1, value2, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andIntegralHandselNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integral_handsel not between", value1, value2, "integralHandsel");
            return (Criteria) this;
        }

        public Criteria andServicePointIdIsNull() {
            addCriterion("service_point_id is null");
            return (Criteria) this;
        }

        public Criteria andServicePointIdIsNotNull() {
            addCriterion("service_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andServicePointIdEqualTo(Integer value) {
            addCriterion("service_point_id =", value, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdNotEqualTo(Integer value) {
            addCriterion("service_point_id <>", value, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdGreaterThan(Integer value) {
            addCriterion("service_point_id >", value, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_point_id >=", value, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdLessThan(Integer value) {
            addCriterion("service_point_id <", value, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_point_id <=", value, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdIn(List<Integer> values) {
            addCriterion("service_point_id in", values, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdNotIn(List<Integer> values) {
            addCriterion("service_point_id not in", values, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdBetween(Integer value1, Integer value2) {
            addCriterion("service_point_id between", value1, value2, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andServicePointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_point_id not between", value1, value2, "servicePointId");
            return (Criteria) this;
        }

        public Criteria andShippingTimeIsNull() {
            addCriterion("shipping_time is null");
            return (Criteria) this;
        }

        public Criteria andShippingTimeIsNotNull() {
            addCriterion("shipping_time is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTimeEqualTo(String value) {
            addCriterion("shipping_time =", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeNotEqualTo(String value) {
            addCriterion("shipping_time <>", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeGreaterThan(String value) {
            addCriterion("shipping_time >", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_time >=", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeLessThan(String value) {
            addCriterion("shipping_time <", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeLessThanOrEqualTo(String value) {
            addCriterion("shipping_time <=", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeLike(String value) {
            addCriterion("shipping_time like", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeNotLike(String value) {
            addCriterion("shipping_time not like", value, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeIn(List<String> values) {
            addCriterion("shipping_time in", values, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeNotIn(List<String> values) {
            addCriterion("shipping_time not in", values, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeBetween(String value1, String value2) {
            addCriterion("shipping_time between", value1, value2, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andShippingTimeNotBetween(String value1, String value2) {
            addCriterion("shipping_time not between", value1, value2, "shippingTime");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainIsNull() {
            addCriterion("deliver_explain is null");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainIsNotNull() {
            addCriterion("deliver_explain is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainEqualTo(String value) {
            addCriterion("deliver_explain =", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainNotEqualTo(String value) {
            addCriterion("deliver_explain <>", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainGreaterThan(String value) {
            addCriterion("deliver_explain >", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_explain >=", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainLessThan(String value) {
            addCriterion("deliver_explain <", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainLessThanOrEqualTo(String value) {
            addCriterion("deliver_explain <=", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainLike(String value) {
            addCriterion("deliver_explain like", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainNotLike(String value) {
            addCriterion("deliver_explain not like", value, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainIn(List<String> values) {
            addCriterion("deliver_explain in", values, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainNotIn(List<String> values) {
            addCriterion("deliver_explain not in", values, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainBetween(String value1, String value2) {
            addCriterion("deliver_explain between", value1, value2, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andDeliverExplainNotBetween(String value1, String value2) {
            addCriterion("deliver_explain not between", value1, value2, "deliverExplain");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdIsNull() {
            addCriterion("receive_province_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdIsNotNull() {
            addCriterion("receive_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdEqualTo(Integer value) {
            addCriterion("receive_province_id =", value, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdNotEqualTo(Integer value) {
            addCriterion("receive_province_id <>", value, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdGreaterThan(Integer value) {
            addCriterion("receive_province_id >", value, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_province_id >=", value, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdLessThan(Integer value) {
            addCriterion("receive_province_id <", value, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_province_id <=", value, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdIn(List<Integer> values) {
            addCriterion("receive_province_id in", values, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdNotIn(List<Integer> values) {
            addCriterion("receive_province_id not in", values, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_province_id between", value1, value2, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_province_id not between", value1, value2, "receiveProvinceId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdIsNull() {
            addCriterion("receive_city_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdIsNotNull() {
            addCriterion("receive_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdEqualTo(Integer value) {
            addCriterion("receive_city_id =", value, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdNotEqualTo(Integer value) {
            addCriterion("receive_city_id <>", value, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdGreaterThan(Integer value) {
            addCriterion("receive_city_id >", value, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_city_id >=", value, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdLessThan(Integer value) {
            addCriterion("receive_city_id <", value, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_city_id <=", value, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdIn(List<Integer> values) {
            addCriterion("receive_city_id in", values, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdNotIn(List<Integer> values) {
            addCriterion("receive_city_id not in", values, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_city_id between", value1, value2, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andReceiveCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_city_id not between", value1, value2, "receiveCityId");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(String value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(String value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(String value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(String value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(String value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLike(String value) {
            addCriterion("delivery_time like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotLike(String value) {
            addCriterion("delivery_time not like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<String> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<String> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(String value1, String value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(String value1, String value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodIsNull() {
            addCriterion("receipt_method is null");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodIsNotNull() {
            addCriterion("receipt_method is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodEqualTo(Short value) {
            addCriterion("receipt_method =", value, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodNotEqualTo(Short value) {
            addCriterion("receipt_method <>", value, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodGreaterThan(Short value) {
            addCriterion("receipt_method >", value, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodGreaterThanOrEqualTo(Short value) {
            addCriterion("receipt_method >=", value, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodLessThan(Short value) {
            addCriterion("receipt_method <", value, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodLessThanOrEqualTo(Short value) {
            addCriterion("receipt_method <=", value, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodIn(List<Short> values) {
            addCriterion("receipt_method in", values, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodNotIn(List<Short> values) {
            addCriterion("receipt_method not in", values, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodBetween(Short value1, Short value2) {
            addCriterion("receipt_method between", value1, value2, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andReceiptMethodNotBetween(Short value1, Short value2) {
            addCriterion("receipt_method not between", value1, value2, "receiptMethod");
            return (Criteria) this;
        }

        public Criteria andIsExperieIsNull() {
            addCriterion("is_experie is null");
            return (Criteria) this;
        }

        public Criteria andIsExperieIsNotNull() {
            addCriterion("is_experie is not null");
            return (Criteria) this;
        }

        public Criteria andIsExperieEqualTo(Short value) {
            addCriterion("is_experie =", value, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieNotEqualTo(Short value) {
            addCriterion("is_experie <>", value, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieGreaterThan(Short value) {
            addCriterion("is_experie >", value, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieGreaterThanOrEqualTo(Short value) {
            addCriterion("is_experie >=", value, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieLessThan(Short value) {
            addCriterion("is_experie <", value, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieLessThanOrEqualTo(Short value) {
            addCriterion("is_experie <=", value, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieIn(List<Short> values) {
            addCriterion("is_experie in", values, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieNotIn(List<Short> values) {
            addCriterion("is_experie not in", values, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieBetween(Short value1, Short value2) {
            addCriterion("is_experie between", value1, value2, "isExperie");
            return (Criteria) this;
        }

        public Criteria andIsExperieNotBetween(Short value1, Short value2) {
            addCriterion("is_experie not between", value1, value2, "isExperie");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Short value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Short value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Short value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Short value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Short value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Short value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Short> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Short> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Short value1, Short value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Short value1, Short value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsIsNull() {
            addCriterion("is_returngoods is null");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsIsNotNull() {
            addCriterion("is_returngoods is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsEqualTo(Short value) {
            addCriterion("is_returngoods =", value, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsNotEqualTo(Short value) {
            addCriterion("is_returngoods <>", value, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsGreaterThan(Short value) {
            addCriterion("is_returngoods >", value, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsGreaterThanOrEqualTo(Short value) {
            addCriterion("is_returngoods >=", value, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsLessThan(Short value) {
            addCriterion("is_returngoods <", value, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsLessThanOrEqualTo(Short value) {
            addCriterion("is_returngoods <=", value, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsIn(List<Short> values) {
            addCriterion("is_returngoods in", values, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsNotIn(List<Short> values) {
            addCriterion("is_returngoods not in", values, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsBetween(Short value1, Short value2) {
            addCriterion("is_returngoods between", value1, value2, "isReturngoods");
            return (Criteria) this;
        }

        public Criteria andIsReturngoodsNotBetween(Short value1, Short value2) {
            addCriterion("is_returngoods not between", value1, value2, "isReturngoods");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}