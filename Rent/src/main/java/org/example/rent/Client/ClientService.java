package org.example.rent.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClientService {
    @Value("${baseClientUrl}")
    private String baseUrl;
    private final ClientMapper clientMapper;
    private final WebClient webClient;

    public ClientService(ClientMapper clientMapper, WebClient.Builder webClient) {
        this.clientMapper = clientMapper;
        this.webClient = webClient.baseUrl(baseUrl).build();
    }
}
