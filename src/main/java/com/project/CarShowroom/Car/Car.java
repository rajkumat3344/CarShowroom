package com.project.CarShowroom.Car;

import javax.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private String name;
    private String model;
    private String engineType;
    private String color;

    public Car() {
    }

    public Car(String name, String model, String engineType, String color) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.color = color;
    }

    public Car(Long id, String name, String model, String engineType, String color) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
