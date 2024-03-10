package com.example.carRent.Car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class UserController {
    private final CarService carService;


    public UserController(CarService carService) {
        this.carService = carService;

    }

    @GetMapping("/allCars")
    ResponseEntity<List<CarDto>> availableCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }


    @GetMapping("/rent/{id}")
    ResponseEntity<CarDto> rent(@PathVariable long id) {
        return ResponseEntity.ok(carService.findById(id));


    }


}
