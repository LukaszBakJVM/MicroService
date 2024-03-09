package org.example.rent.Car;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
public class CarController {
    private final CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }
}
