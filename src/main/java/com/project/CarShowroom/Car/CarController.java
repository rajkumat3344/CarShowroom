package com.project.CarShowroom.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCar(){
        return carService.getCar();
    }

    @PostMapping
    public void addNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @PutMapping("{carId}")
    public void  updateCarProperties(@PathVariable("carId") Long carId,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) String engineType,
                                     @RequestParam(required = false) String color){
        carService.updateCarProperties(carId,name, model, engineType, color);
    }

    @DeleteMapping("{carId}")
    public void removeOldCarEntries(@PathVariable("carId") Long carId) {
        carService.removeOldCarEntries(carId);
    }
}
