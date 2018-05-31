package com.ktb.domain;

public class Order {

    private Integer id;
    private Double money;
    private String receiverInfo; // 收货地址

    // 订单与客户关联
    private Customer customer; // 描述订单属于某一个客户

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public String getReceiverInfo() {
        return receiverInfo;
    }
    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", money=" + money +
                ", receiverInfo='" + receiverInfo + '\'' +
                ", customer=" + customer +
                '}';
    }
}