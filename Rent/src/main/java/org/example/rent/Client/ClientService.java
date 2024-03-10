package org.example.rent.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClientService {
    private final ClientMapper clientMapper;
    private final WebClient webClient;
    @Value("${baseClientUrl}")
    private String baseUrl;

    public ClientService(ClientMapper clientMapper, WebClient.Builder webClient) {
        this.clientMapper = clientMapper;
        this.webClient = webClient.build();
    }

    Mono<List<ClientDto>> allClient() {
        return webClient.get().uri(baseUrl + "/client/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(Client.class)
                .map(clientMapper::map)
                .collectList();
    }


}
