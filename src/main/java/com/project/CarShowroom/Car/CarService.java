package com.project.CarShowroom.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //GET
    public List<Car> getCar() {
        return carRepository.findAll();
    }

    //POST
    public void addNewCar(Car car) {
        Optional<Car> optionalCar = carRepository.findCarByModel(car.getModel());

        if (optionalCar.isPresent()){
            throw new IllegalStateException("Car already exsits in the showroom list!");
        }
        carRepository.save(car);
    }



    //PUT
    @Transactional
    public void updateCarProperties(Long carId, String name, String model, String engineType, String color) {
       Car car = carRepository.findById(carId)
               .orElseThrow(()->{
                  throw new IllegalStateException("Car with id "+carId+" doesn't exsits in showroom.");
               });
       if (name != null && name.length() > 0 && !Objects.equals(car.getName(), name)){
           car.setName(name);
       }

       if (model != null && model.length() > 0 && !Objects.equals(car.getModel(), model)){
           Optional<Car> carOptional = carRepository.findCarByModel(model);
           if (carOptional.isPresent()) {
               throw new IllegalStateException("Model already exsist!");
           }
           car.setModel(model);
       }

       if (engineType != null && engineType.length() > 0 && !Objects.equals(car.getEngineType(), engineType)){
           Optional<Car> carOptionalEngine = carRepository.findCarByEngineType(engineType);

           if (carOptionalEngine.isPresent()){
               throw new IllegalStateException("EngineType already exsist!");
           }
           car.setEngineType(engineType);
       }

       if (color != null && color.length() > 0 && !Objects.equals(car.getColor(), color)){
           car.setColor(color);
       }
    }

    //DELETE
    public void removeOldCarEntries(Long carId) {
        boolean carExsits = carRepository.existsById(carId);

        if (!carExsits){
            throw new IllegalStateException("Car with id "+carId+" doesn't present in the showroom.");
        }
        carRepository.deleteById(carId);
    }
}
