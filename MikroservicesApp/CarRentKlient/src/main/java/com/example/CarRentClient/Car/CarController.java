package com.example.CarRentClient.Car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/available")
    ResponseEntity<Mono<List<CarDto>>>allAvailable(){
        return ResponseEntity.ok(carService.allAvailableCars());
    }
}
