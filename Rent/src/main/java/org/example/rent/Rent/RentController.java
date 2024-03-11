package org.example.rent.Rent;

import org.example.rent.Car.CarPrice;
import org.example.rent.Car.CarServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/rent")
public class RentController {
    private final RentService rentService;
    private final CarServices carServices;

    public RentController(RentService rentService, CarServices carServices) {
        this.rentService = rentService;
        this.carServices = carServices;
    }
    @PostMapping
    ResponseEntity<RentDto>rentCar(@RequestBody RentDto dto, @RequestParam LocalDateTime start ,@RequestParam LocalDateTime end){
        RentDto rentDto = rentService.rentCar(dto,start,end);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(rentDto).toUri();
        return ResponseEntity.created(uri).body(rentDto);


    }

}
