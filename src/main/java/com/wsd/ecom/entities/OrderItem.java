package com.wsd.ecom.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_detail_id", nullable = false)
    private OrderDetail orderDetail;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "price", nullable = false)
    private double price;

    public OrderItem(OrderDetail orderDetail, Product product, Integer quantity, double price) {
        this.orderDetail = orderDetail;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public @NotNull OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(@NotNull OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public @NotNull Product getProduct() {
        return product;
    }

    public void setProduct(@NotNull Product product) {
        this.product = product;
    }

    public @NotNull Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull Integer quantity) {
        this.quantity = quantity;
    }

    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull double price) {
        this.price = price;
    }
}
