package dev.angel.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @ManyToOne
    private Order order;

    @ManyToOne
    private Vehicle product;

    private int quantity;

    public OrderItem() {}

    public OrderItem(Order order, Vehicle product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Vehicle getProduct() {
        return product;
    }

    public void setProduct(Vehicle product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
