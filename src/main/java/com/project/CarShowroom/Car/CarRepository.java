package com.project.CarShowroom.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.model=?1")
    Optional<Car> findCarByModel(String model);

    @Query("SELECT c FROM Car c WHERE c.engineType=?1")
    Optional<Car> findCarByEngineType(String engineType);

}
