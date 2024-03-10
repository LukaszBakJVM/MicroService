package org.example.rent.Car;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CarServices {
    private final CarMapper carMapper;
    private final WebClient webClient;
    @Value("${baseCarUrl}")
    private String baseUrl;


    public CarServices(CarMapper carMapper, WebClient.Builder webClient) {
        this.carMapper = carMapper;
        this.webClient = webClient.build();
    }


    public Mono<RentTime> rent(long id, LocalDateTime start, LocalDateTime end) {
        return webClient.patch().uri(baseUrl + "/car/{id}", id).body(BodyInserters.fromValue(new RentTime(start, end))).retrieve().bodyToMono(RentTime.class);


    }


}
