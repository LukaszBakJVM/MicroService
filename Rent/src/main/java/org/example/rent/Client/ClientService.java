package org.example.rent.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    Mono<ClientDto> clientById(long id) {
        return webClient.get().uri(baseUrl + "/client/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Client.class).map(clientMapper::map);

    }


}
