package com.example.CarRentClient.Client;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    ResponseEntity<ClientDto> newClient(@RequestBody ClientDto dto) {
        ClientDto clientDto = clientService.newClient(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(clientDto).toUri();
        return ResponseEntity.created(uri).body(clientDto);

    }

    @GetMapping("/all")
    ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

}
