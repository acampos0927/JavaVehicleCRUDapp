package dev.angel.crud.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryUpdateDTO {

    @NotNull(message = "Car ID is Required")
    private Long carId;

    @Min(value = 1, message = "Quantity to add must be at least 1")
    private int quantityToAdd;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public int getQuantityToAdd() {
        return quantityToAdd;
    }

    public void setQuantityToAdd(int quantityToAdd) {
        this.quantityToAdd = quantityToAdd;
    }
}
