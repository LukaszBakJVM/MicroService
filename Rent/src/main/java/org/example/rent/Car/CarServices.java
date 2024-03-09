package org.example.rent.Car;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CarServices {
    @Value("${baseCarUrl}")
    private String baseUrl;
    private final CarMapper carMapper;
    private final WebClient webClient;

    public CarServices(CarMapper carMapper, WebClient.Builder webClient) {
        this.carMapper = carMapper;
        this.webClient = webClient.baseUrl(baseUrl).build();
    }
    Mono<CarDto>findId(long id){
        return webClient.get().uri("/rent/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Car.class)
                .map(carMapper::map);
    }

}
