package com.example.carRent.Client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class Services {

    private final Mapper mapper;
    private final WebClient webClient;


    public Services(Mapper mapper, WebClient.Builder webClient) {
        this.mapper = mapper;
        this.webClient = webClient.build();
    }

    public Mono<List<ClientDto>> findAllClient() {
        return webClient.get().uri("/client/all").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Client.class).map(mapper::mapToDto).collectList();


    }


}

