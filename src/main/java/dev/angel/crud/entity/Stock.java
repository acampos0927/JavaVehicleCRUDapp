package dev.angel.crud.entity;
import dev.angel.crud.entity.enums.BodyType;

//import dev.angel.crud.entity.enums.EnergyRating;
import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String warehouseLocation;

    @Column(nullable = false)
    private int aisle;

    @Column(nullable = false)
    private int shelf;

    @Column(nullable = false)
    private int quantityAvailable;

    @Column(name = "is_reserved")
    private boolean isReserved;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Category category = Category.ELECTRONICS;
//
//    @Enumerated(EnumType.STRING)
//    private EnergyRating  energyRating;
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "product_id", nullable = false)
//    private Vehicle product;

    public Stock() {}

    public Stock(String warehouseLocation, int aisle, int shelf, int quantityAvailable, boolean isReserved) {
        this.warehouseLocation = warehouseLocation;
        this.aisle = aisle;
        this.shelf = shelf;
        this.quantityAvailable = quantityAvailable;
        this.isReserved = isReserved;
    }

    @Override
    public String toString() {
        return "Stock {" +
                "id = " + id +
                        ", Warehouse Location=" + warehouseLocation +'\'' +
                        ", Aisle = " + aisle +
                        ", Shelf = " + shelf +
                        ", Quantity Available = " + quantityAvailable +
                        ",is Reserved = " + isReserved +
                        '}';
    }

    public boolean isInStock() {
        return quantityAvailable > 0;
    }

    public void reserve() {
        if (!isReserved && quantityAvailable > 0) {
            isReserved = true;
        }
    }

    public void releaseReservation() {
        isReserved = false;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

//    public Vehicle getProduct() {
//        return product;
//    }
//
//    public void setProduct(Vehicle product) {
//        this.product = product;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public void setEnergyRating(EnergyRating energyRating) {
//        this.energyRating = energyRating;
//    }

}
