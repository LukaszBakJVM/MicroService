package com.example.carRent.Car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class UserController {
    private final CarService carService;


    public UserController(CarService carService) {
        this.carService = carService;

    }

    @GetMapping("/available")
    ResponseEntity<List<CarDto>> availableCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/rented")
    ResponseEntity<List<CarDto>> rentedCars() {
        return ResponseEntity.ok(carService.availableCars(false));
    }

    @GetMapping ("/rent/{id}")
    ResponseEntity<Long> rent(@PathVariable long id) {
        return ResponseEntity.ok(carService.findById(id));


    }


}
