package com.wy.shop.statemachine;

/**
 * 支付状态枚举类
 */
public enum OrderStatus {

    UN_PAY(101, "未付款"),
    CANCELLED_BY_USER(102, "用户已取消"),
    CANCELLED_BY_SYSTEM(103,"系统已取消"),
    PAYED(201,"已付款"),
    ORDER_CANCELLED(202,"订单取消"),
    REFUNDING(204,"退款中"),
    REFUNDED(203, "已退款"),
    SHIP(301, "已发货"),
    USER_RECEIVED(302, "用户已收货"),
    SYSTEM_RECEIVED(303, "系统已收货"),
    COMPLETE(401,"已完成"),
    BULK_PURCHASE_UN_PAY(801, "拼团中,未付款"),
    BULK_PURCHASE_PAYED(802, "拼团中,已付款");

    private Integer code;
    private String message;

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
