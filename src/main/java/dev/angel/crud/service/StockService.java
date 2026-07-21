package dev.angel.crud.service;

import dev.angel.crud.DTO.InventoryUpdateDTO;
import dev.angel.crud.entity.Vehicle;
import dev.angel.crud.entity.Stock;
import dev.angel.crud.repos.ProductRepository;
import dev.angel.crud.repos.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Get all inventory records
    public List<Stock> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // Get inventory by ID
    public Optional<Stock> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    // Create or save inventory (with product linkage)
    public Stock saveInventory(Stock stock) {
        if (stock.getProduct() == null || stock.getProduct().getId() == null) {
            throw new IllegalArgumentException("Product ID must be provided when creating inventory.");
        }

        Long productId = stock.getProduct().getId();
        Vehicle product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        stock.setProduct(product);
        return inventoryRepository.save(stock);
    }

    // Update inventory
    public Stock updateInventory(Long id, Stock stockDetails) {
        Stock stock = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));

        stock.setWarehouseLocation(stockDetails.getWarehouseLocation());
        stock.setAisle(stockDetails.getAisle());
        stock.setShelf(stockDetails.getShelf());
        stock.setQuantityAvailable(stockDetails.getQuantityAvailable());
        stock.setReserved(stockDetails.isReserved());
        stock.setCategory(stockDetails.getProduct().getCategory());

        if (stockDetails.getProduct() != null && stockDetails.getProduct().getId() != null) {
            Vehicle product = productRepository.findById(stockDetails.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + stockDetails.getProduct().getId()));
            stock.setProduct(product);
        }

        return inventoryRepository.save(stock);
    }

    // Delete inventory
    public void deleteInventory(Long id) {
        Stock stock = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));
        inventoryRepository.delete(stock);
    }

    // Update quantity only
    public Stock updateQuantity(Long id, int newQuantity) {
        Stock stock = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));
        stock.setQuantityAvailable(newQuantity);
        return inventoryRepository.save(stock);
    }

    // ✅ Bulk inventory update (e.g., receiving a shipment)
    public List<Stock> bulkUpdateInventory(List<InventoryUpdateDTO> updates) {
        List<Stock> updatedStocks = new ArrayList<>();

        for (InventoryUpdateDTO update : updates) {
            Stock stock = inventoryRepository.findByProductId(update.getProductId())
                    .orElseThrow(() -> new RuntimeException("Stock not found for product ID: " + update.getProductId()));

            int newQuantity = stock.getQuantityAvailable() + update.getQuantityToAdd();
            stock.setQuantityAvailable(newQuantity);

            updatedStocks.add(inventoryRepository.save(stock));
        }

        return updatedStocks;
    }

    public Stock addQuantityToProduct(Long productId, int quantityToAdd) {
        Stock stock = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Stock not found for product ID: " + productId));

        int newQuantity = stock.getQuantityAvailable() + quantityToAdd;
        stock.setQuantityAvailable(newQuantity);

        return inventoryRepository.save(stock);
    }

}
