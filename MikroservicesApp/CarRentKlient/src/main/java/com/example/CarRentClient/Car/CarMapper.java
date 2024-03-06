package com.example.CarRentClient.Car;

import org.springframework.stereotype.Service;

@Service
public class CarMapper {
    CarDto carToDto(Car car) {
        return new CarDto(car.price(), car.mark(), car.model(), car.value());
    }
}
