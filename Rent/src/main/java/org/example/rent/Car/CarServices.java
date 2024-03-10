package org.example.rent.Car;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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



    Mono<CarDto> findId(long id) {
        return webClient.get().uri(baseUrl+"/car/rent/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Car.class)
                .map(carMapper::map);


    }
}
