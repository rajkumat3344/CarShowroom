package com.project.CarShowroom.Car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarRegistration {

    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository) {
        return args -> {
            Car ferrari = new Car(
                    "Ferrari",
                    "Roma",
                    "3.9 L V8",
                    "Red"
            );

            Car lamborgini = new Car(
                    "Lamborgini",
                    "Huracan",
                    "5.2 L V10",
                    "Yellow"
            );
            carRepository.saveAll(List.of(
               ferrari, lamborgini
            ));
        };
    }
}
