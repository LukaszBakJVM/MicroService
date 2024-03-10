package org.example.rent.Car;

import org.springframework.stereotype.Service;

@Service
public class CarMapper {
    CarDto map(Car car){
        return new CarDto(car.id(),car.startRent(),car.endRent());
    }
    RentCarDto rent(Car car){
        return new RentCarDto(car.id(),car.startRent(),car.endRent());
    }
}
