package org.example.rent.Car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rent")
public class CarController {
    private final CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping
    ResponseEntity<Mono<CarDto>> carById(@RequestParam long id) {
        return ResponseEntity.ok(carServices.findId(id));
    }
}
