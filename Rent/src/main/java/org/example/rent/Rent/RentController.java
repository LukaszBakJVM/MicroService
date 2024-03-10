package org.example.rent.Rent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/rent")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }
    @PostMapping
    ResponseEntity<RentDto>rentCar(@RequestBody RentDto dto, @RequestParam LocalDateTime start ,@RequestParam LocalDateTime end){
        RentDto rentDto = rentService.rentCar(dto,start,end);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(rentDto).toUri();
        return ResponseEntity.created(uri).body(rentDto);


    }
}
