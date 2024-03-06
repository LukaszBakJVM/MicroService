package com.example.CarRentClient.Car;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CarService {
    private final CarMapper carMapper;
    private final WebClient webClient;

    public CarService(CarMapper carMapper, WebClient.Builder webClient) {
        this.carMapper = carMapper;
        this.webClient = webClient.build();
    }
    Mono<List<CarDto>>allAvailableCars(){
    return     webClient.get().uri("/car/available")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(Car.class)
                .filter(Car::available)
                .map(carMapper::carToDto)
                .collectList();
    }
}
