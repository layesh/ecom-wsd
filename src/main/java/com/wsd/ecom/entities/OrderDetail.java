package com.wsd.ecom.entities;

import com.wsd.ecom.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne(optional = false)
    private Customer customer;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    @NotNull
    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @Column(name = "date_created")
    private Instant dateCreated;

    @Column(name = "date_updated")
    private Instant dateUpdated;

    public OrderDetail(Customer customer, List<OrderItem> orderItemList, double totalAmount, PaymentStatus paymentStatus, Instant dateCreated, Instant dateUpdated) {
        this.customer = customer;
        this.orderItemList = orderItemList;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public @NotNull Customer getCustomer() {
        return customer;
    }

    public void setCustomer(@NotNull Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @NotNull
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(@NotNull double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public @NotNull PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(@NotNull PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Instant getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Instant dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
