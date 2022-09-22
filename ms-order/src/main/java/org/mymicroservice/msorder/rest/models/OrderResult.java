package org.mymicroservice.msorder.rest.models;

public class OrderResult {
    private String desc;
    private Long orderId;

    public String getDesc() {
        return desc;
    }

    public OrderResult setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderResult setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }
}
