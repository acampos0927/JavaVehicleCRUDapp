//package dev.angel.crud.controller;
//
//import dev.angel.crud.entity.Order;
//import dev.angel.crud.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//
//    private final OrderService orderService;
//
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    // GET all orders
//    @GetMapping
//    public List<Order> getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
//    // GET order by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
//        Optional<Order> order = orderService.getOrderById(id);
//        return order.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // POST create new order
//    @PostMapping
//    public ResponseEntity<?> createOrder(@RequestBody Order order) {
//        try {
//            Order createdOrder = orderService.saveOrder(order);
//            return ResponseEntity.ok(createdOrder);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    // PUT update existing order
//    @PutMapping("/{id}")
//    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
//        Optional<Order> existing = orderService.getOrderById(id);
//        if (existing.isPresent()) {
//            return ResponseEntity.ok(orderService.updateOrder(id, updatedOrder));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // DELETE order
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
//        orderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // PATCH update order status
//    @PatchMapping("/{id}/status")
//    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
//        try {
//            Order updated = orderService.updateOrderStatus(id, status);
//            return ResponseEntity.ok(updated);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
