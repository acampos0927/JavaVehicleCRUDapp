//package dev.angel.crud.service;
//
//import dev.angel.crud.entity.Order;
//import dev.angel.crud.entity.OrderItem;
////import dev.angel.crud.entity.Vehicle;
//import dev.angel.crud.entity.Stock;
////import dev.angel.crud.repos.ProductRepository;
//import dev.angel.crud.repos.OrderRepository;
//import dev.angel.crud.repos.StockRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private StockRepository stockRepository;
//
////    @Autowired
////    private ProductRepository productRepository;
//
//    // Get all orders
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//    // Get order by ID
//    public Optional<Order> getOrderById(Long id) {
//        return orderRepository.findById(id);
//    }
//
//    // Create or save order with stock validation and total calculation
//    public Order saveOrder(Order order) {
//        BigDecimal totalAmount = BigDecimal.ZERO;
//
////        for (OrderItem item : order.getItems()) {
////            // Load full product from DB
////            Vehicle product = productRepository.findById(item.getProduct().getId())
////                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + item.getProduct().getId()));
////
////            item.setProduct(product); // Replace partial product with full one
//
//            // Check stock
////            Stock stock = (Stock) stockRepository.findByProductId(product.getId())
////                    .orElseThrow(() -> new RuntimeException("Stock not found for product: " + ((Vehicle) product).getName()));
////
////            if (stock.getQuantityAvailable() < item.getQuantity()) {
////                throw new RuntimeException("Insufficient stock for product: " + product.getClass());
//            }
//
////            // Calculate item total
////            BigDecimal itemTotal = BigDecimal.valueOf(product.getPrice())
////                    .multiply(BigDecimal.valueOf(item.getQuantity()));
////            totalAmount = totalAmount.add(itemTotal);
////        }
////
////        // Deduct stock and set order reference
////        for (OrderItem item : order.getItems()) {
////            Stock stock = (Stock) stockRepository.findByProductId(item.getProduct().getId()).get();
////            stock.setQuantityAvailable(stock.getQuantityAvailable() - item.getQuantity());
////            stockRepository.save(stock);
//
//            item.setOrder(order); // maintain bidirectional relationship
//        }
//
//        order.setTotalAmount(totalAmount.doubleValue());
//        order.setStatus("Confirmed");
//
//        return orderRepository.save(order);
//    }
//
//    // Update order
//    public Order updateOrder(Long id, Order orderDetails) {
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        order.setOrderDate(orderDetails.getOrderDate());
//        order.setTotalAmount(orderDetails.getTotalAmount());
//        order.setStatus(orderDetails.getStatus());
//        order.setItems(orderDetails.getItems());
//
//        for (OrderItem item : order.getItems()) {
//            item.setOrder(order); // maintain relationship
//        }
//
//        return orderRepository.save(order);
//    }
//
//    // Delete order
//    public void deleteOrder(Long id) {
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        orderRepository.delete(order);
//    }
//
//    // Update order status only
//    public Order updateOrderStatus(Long id, String newStatus) {
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        order.setStatus(newStatus);
//        return orderRepository.save(order);
//    }
//}
//
