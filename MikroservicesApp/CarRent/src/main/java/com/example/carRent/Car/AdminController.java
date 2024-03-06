package com.example.carRent.Car;

import com.example.carRent.Client.ClientDto;
import com.example.carRent.Client.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final CarService carService;
    private final Services clientService;

    public AdminController(CarService carService, Services clientService) {
        this.carService = carService;
        this.clientService = clientService;
    }

    @PostMapping("/add")
    ResponseEntity<CarDto> addNewCar(@RequestBody CarDto dto) {
        CarDto carDto = carService.newCarDto(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(carDto).toUri();
        return ResponseEntity.created(uri).body(carDto);

    }

    @GetMapping
    ResponseEntity<List<String>> capacityValues() {
        return ResponseEntity.ok(carService.enumValue());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCar(@PathVariable long id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/clients")
    ResponseEntity<Mono<List<ClientDto>>>allClient(){
        return ResponseEntity.ok(clientService.findAllClient());
    }

}
