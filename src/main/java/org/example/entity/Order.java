package org.example.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer supermarketId;
    private Date orderDate;
    private Date deliveryDate;
    private Integer year;
    private Integer month;
    private String memo;

    // Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupermarketId() {
        return supermarketId;
    }

    public void setSupermarketId(Integer supermarketId) {
        this.supermarketId = supermarketId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", supermarketId=" + supermarketId +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", year=" + year +
                ", month=" + month +
                ", memo='" + memo + '\'' +
                '}';
    }
}
