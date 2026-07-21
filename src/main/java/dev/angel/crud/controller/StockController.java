package dev.angel.crud.controller;

import dev.angel.crud.DTO.InventoryUpdateDTO;
import dev.angel.crud.entity.Stock;
import dev.angel.crud.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class StockController {

    @Autowired
    private StockService inventoryService;

    // GET all inventory
    @GetMapping
    public List<Stock> getInventory() {
        return inventoryService.getAllInventory();
    }

    // GET inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getInventoryById(@PathVariable Long id) {
        Optional<Stock> inventory = inventoryService.getInventoryById(id);
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new inventory
    @PostMapping
    public Stock createInventory(@RequestBody Stock stock) {
        return inventoryService.saveInventory(stock);
    }

    // PUT update inventory
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateInventory(@PathVariable Long id, @RequestBody Stock updatedStock) {
        Optional<Stock> existing = inventoryService.getInventoryById(id);
        if (existing.isPresent()) {
            return ResponseEntity.ok(inventoryService.updateInventory(id, updatedStock));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH update quantity only
    @PatchMapping("/{id}/quantity")
    public ResponseEntity<Stock> updateQuantity(@PathVariable Long id, @RequestParam int quantity) {
        try {
            Stock updated = inventoryService.updateQuantity(id, quantity);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST bulk inventory update (e.g., receiving a shipment)
    @PostMapping("/bulk-update")
    public ResponseEntity<List<Stock>> bulkUpdateInventory(@RequestBody List<InventoryUpdateDTO> updates) {
        List<Stock> updatedStocks = inventoryService.bulkUpdateInventory(updates);
        return ResponseEntity.ok(updatedStocks);
    }

    @PatchMapping("/car/{carId}/add-quantity")
    public ResponseEntity<Stock> addQuantityToCar(
            @PathVariable Long carId,
            @RequestBody InventoryUpdateDTO updateDTO) {
        try {
            Stock updated = inventoryService.addQuantityToCar(carId, updateDTO.getQuantityToAdd());
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
