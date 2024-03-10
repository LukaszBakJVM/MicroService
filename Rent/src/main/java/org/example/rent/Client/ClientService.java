package org.example.rent.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClientService {
    private final ClientMapper clientMapper;
  //  private final WebClient webClient;
 //   @Value("${baseClientUrl}")
   // private String baseUrl;

    public ClientService(ClientMapper clientMapper, WebClient.Builder webClient) {
        this.clientMapper = clientMapper;
      //  this.webClient = webClient.baseUrl(baseUrl).build();
    }



}
