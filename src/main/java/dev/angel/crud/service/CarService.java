package dev.angel.crud.service;

import dev.angel.crud.entity.Car;
import dev.angel.crud.repos.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

//    @Autowired
//    private StockRepository stockRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setVin(carDetails.getVin());
        car.setStockNumber(carDetails.getStockNumber());
        car.setMake(carDetails.getMake());
        car.setModel(carDetails.getModel());
        car.setTrim(carDetails.getTrim());
        car.setProductionYear(carDetails.getProductionYear());
        car.setBodyType(carDetails.getBodyType());
        car.setExteriorColor(carDetails.getExteriorColor());
        car.setInteriorColor(carDetails.getInteriorColor());
        car.setFuelType(carDetails.getFuelType());
        car.setTransmission(carDetails.getTransmission());
        car.setDrivetrain(carDetails.getDrivetrain());
        car.setEngineDescription(carDetails.getEngineDescription());
        car.setMpgCity(carDetails.getMpgCity());
        car.setMpgHighway(carDetails.getMpgHighway());
        car.setCondition(carDetails.getCondition());
        car.setMileage(carDetails.getMileage());
        car.setPrice(carDetails.getPrice());
        car.setMsrp(carDetails.getMsrp());
        car.setStatus(carDetails.getStatus());
        car.setDateAcquired(carDetails.getDateAcquired());
        car.setDateSold(carDetails.getDateSold());
        car.setDescription(carDetails.getDescription());
        car.setFeatures(carDetails.getFeatures());
        car.setImageUrls(carDetails.getImageUrls());

        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));

//        Optional<Stock> stock = stockRepository.findByCarId(id);
//        stock.ifPresent(s -> {
//            s.setCar(null);
//            stockRepository.save(s);
//        });

        carRepository.delete(car);
    }
}
