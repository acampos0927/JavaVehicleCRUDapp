package dev.angel.crud.entity;

import dev.angel.crud.entity.enums.BodyType;
import dev.angel.crud.entity.enums.CarStatus;
import dev.angel.crud.entity.enums.Condition;
import dev.angel.crud.entity.enums.Drivetrain;
import dev.angel.crud.entity.enums.FuelType;
import dev.angel.crud.entity.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @Column(nullable = false, unique = true, length = 17)
    private String vin;

    @Column(unique = true)
    private String stockNumber;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    private String trim;

    @Column(nullable = false)
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BodyType bodyType;

    private String exteriorColor;
    private String interiorColor;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    private Drivetrain drivetrain;

    private String engineDescription;

    private Integer mpgCity;
    private Integer mpgHighway;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Condition condition = Condition.NEW;

    @Column(nullable = false)
    private int mileage;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(precision = 19, scale = 2)
    private BigDecimal msrp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarStatus status = CarStatus.AVAILABLE;

    private LocalDate dateAcquired;
    private LocalDate dateSold;

    private String description;

    @ElementCollection
    @CollectionTable(name = "car_features", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "feature")
    private Set<String> features = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "car_images", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "image_url")
    private List<String> imageUrls = new ArrayList<>();

    // Getters and Setters

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getStockNumber() { return stockNumber; }
    public void setStockNumber(String stockNumber) { this.stockNumber = stockNumber; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getTrim() { return trim; }
    public void setTrim(String trim) { this.trim = trim; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public BodyType getBodyType() { return bodyType; }
    public void setBodyType(BodyType bodyType) { this.bodyType = bodyType; }

    public String getExteriorColor() { return exteriorColor; }
    public void setExteriorColor(String exteriorColor) { this.exteriorColor = exteriorColor; }

    public String getInteriorColor() { return interiorColor; }
    public void setInteriorColor(String interiorColor) { this.interiorColor = interiorColor; }

    public FuelType getFuelType() { return fuelType; }
    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }

    public Transmission getTransmission() { return transmission; }
    public void setTransmission(Transmission transmission) { this.transmission = transmission; }

    public Drivetrain getDrivetrain() { return drivetrain; }
    public void setDrivetrain(Drivetrain drivetrain) { this.drivetrain = drivetrain; }

    public String getEngineDescription() { return engineDescription; }
    public void setEngineDescription(String engineDescription) { this.engineDescription = engineDescription; }

    public Integer getMpgCity() { return mpgCity; }
    public void setMpgCity(Integer mpgCity) { this.mpgCity = mpgCity; }

    public Integer getMpgHighway() { return mpgHighway; }
    public void setMpgHighway(Integer mpgHighway) { this.mpgHighway = mpgHighway; }

    public Condition getCondition() { return condition; }
    public void setCondition(Condition condition) { this.condition = condition; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getMsrp() { return msrp; }
    public void setMsrp(BigDecimal msrp) { this.msrp = msrp; }

    public CarStatus getStatus() { return status; }
    public void setStatus(CarStatus status) { this.status = status; }

    public LocalDate getDateAcquired() { return dateAcquired; }
    public void setDateAcquired(LocalDate dateAcquired) { this.dateAcquired = dateAcquired; }

    public LocalDate getDateSold() { return dateSold; }
    public void setDateSold(LocalDate dateSold) { this.dateSold = dateSold; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Set<String> getFeatures() { return features; }
    public void setFeatures(Set<String> features) { this.features = features; }

    public List<String> getImageUrls() { return imageUrls; }
    public void setImageUrls(List<String> imageUrls) { this.imageUrls = imageUrls; }
}
