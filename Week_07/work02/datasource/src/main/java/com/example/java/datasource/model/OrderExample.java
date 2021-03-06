package work02.datasource.src.main.java.com.example.java.datasource.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(String value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(String value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(String value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(String value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLike(String value) {
            addCriterion("user_id like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotLike(String value) {
            addCriterion("user_id not like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<String> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<String> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andOrder_noIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrder_noIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_noEqualTo(String value) {
            addCriterion("order_no =", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotEqualTo(String value) {
            addCriterion("order_no <>", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noGreaterThan(String value) {
            addCriterion("order_no >", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noLessThan(String value) {
            addCriterion("order_no <", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noLike(String value) {
            addCriterion("order_no like", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotLike(String value) {
            addCriterion("order_no not like", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noIn(List<String> values) {
            addCriterion("order_no in", values, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotIn(List<String> values) {
            addCriterion("order_no not in", values, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(Byte value) {
            addCriterion("order_status =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(Byte value) {
            addCriterion("order_status <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(Byte value) {
            addCriterion("order_status >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_status >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(Byte value) {
            addCriterion("order_status <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(Byte value) {
            addCriterion("order_status <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<Byte> values) {
            addCriterion("order_status in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<Byte> values) {
            addCriterion("order_status not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(Byte value1, Byte value2) {
            addCriterion("order_status between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(Byte value1, Byte value2) {
            addCriterion("order_status not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andProduct_countIsNull() {
            addCriterion("product_count is null");
            return (Criteria) this;
        }

        public Criteria andProduct_countIsNotNull() {
            addCriterion("product_count is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_countEqualTo(Integer value) {
            addCriterion("product_count =", value, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countNotEqualTo(Integer value) {
            addCriterion("product_count <>", value, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countGreaterThan(Integer value) {
            addCriterion("product_count >", value, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_count >=", value, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countLessThan(Integer value) {
            addCriterion("product_count <", value, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countLessThanOrEqualTo(Integer value) {
            addCriterion("product_count <=", value, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countIn(List<Integer> values) {
            addCriterion("product_count in", values, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countNotIn(List<Integer> values) {
            addCriterion("product_count not in", values, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countBetween(Integer value1, Integer value2) {
            addCriterion("product_count between", value1, value2, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_countNotBetween(Integer value1, Integer value2) {
            addCriterion("product_count not between", value1, value2, "product_count");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_priceEqualTo(BigDecimal value) {
            addCriterion("product_price =", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotEqualTo(BigDecimal value) {
            addCriterion("product_price <>", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceGreaterThan(BigDecimal value) {
            addCriterion("product_price >", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price >=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceLessThan(BigDecimal value) {
            addCriterion("product_price <", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price <=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIn(List<BigDecimal> values) {
            addCriterion("product_price in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotIn(List<BigDecimal> values) {
            addCriterion("product_price not in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price not between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andPay_channelIsNull() {
            addCriterion("pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andPay_channelIsNotNull() {
            addCriterion("pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPay_channelEqualTo(String value) {
            addCriterion("pay_channel =", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotEqualTo(String value) {
            addCriterion("pay_channel <>", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelGreaterThan(String value) {
            addCriterion("pay_channel >", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelGreaterThanOrEqualTo(String value) {
            addCriterion("pay_channel >=", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelLessThan(String value) {
            addCriterion("pay_channel <", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelLessThanOrEqualTo(String value) {
            addCriterion("pay_channel <=", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelLike(String value) {
            addCriterion("pay_channel like", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotLike(String value) {
            addCriterion("pay_channel not like", value, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelIn(List<String> values) {
            addCriterion("pay_channel in", values, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotIn(List<String> values) {
            addCriterion("pay_channel not in", values, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelBetween(String value1, String value2) {
            addCriterion("pay_channel between", value1, value2, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_channelNotBetween(String value1, String value2) {
            addCriterion("pay_channel not between", value1, value2, "pay_channel");
            return (Criteria) this;
        }

        public Criteria andPay_noIsNull() {
            addCriterion("pay_no is null");
            return (Criteria) this;
        }

        public Criteria andPay_noIsNotNull() {
            addCriterion("pay_no is not null");
            return (Criteria) this;
        }

        public Criteria andPay_noEqualTo(String value) {
            addCriterion("pay_no =", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noNotEqualTo(String value) {
            addCriterion("pay_no <>", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noGreaterThan(String value) {
            addCriterion("pay_no >", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noGreaterThanOrEqualTo(String value) {
            addCriterion("pay_no >=", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noLessThan(String value) {
            addCriterion("pay_no <", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noLessThanOrEqualTo(String value) {
            addCriterion("pay_no <=", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noLike(String value) {
            addCriterion("pay_no like", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noNotLike(String value) {
            addCriterion("pay_no not like", value, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noIn(List<String> values) {
            addCriterion("pay_no in", values, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noNotIn(List<String> values) {
            addCriterion("pay_no not in", values, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noBetween(String value1, String value2) {
            addCriterion("pay_no between", value1, value2, "pay_no");
            return (Criteria) this;
        }

        public Criteria andPay_noNotBetween(String value1, String value2) {
            addCriterion("pay_no not between", value1, value2, "pay_no");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "is_deleted");
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