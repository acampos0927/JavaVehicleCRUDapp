//package dev.angel.crud.entity;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private LocalDate orderDate;
//    private double totalAmount;
//    private String status;
//
//    @JsonManagedReference
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<OrderItem> items;
//
//    public Order() {}
//
//    public Order(LocalDate orderDate, double totalAmount, String status, List<OrderItem> items) {
//        this.orderDate = orderDate;
//        this.totalAmount = totalAmount;
//        this.status = status;
//        this.items = items;
//    }
//
//    // Getters and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public LocalDate getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(LocalDate orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<OrderItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<OrderItem> items) {
//        this.items = items;
//        if (items != null) {
//            for (OrderItem item : items) {
//                item.setOrder(this); // ensure bidirectional consistency
//            }
//        }
//    }
//}

