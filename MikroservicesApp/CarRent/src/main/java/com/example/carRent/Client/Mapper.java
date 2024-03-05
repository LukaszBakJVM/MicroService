package com.example.carRent.Client;

import org.springframework.stereotype.Service;

@Service
public class Mapper {
    Client mapToClient(ClientDto dto){
        return new Client(dto.name(), dto.lastName(), dto.creditCardNumber());
    }

    ClientDto  mapToDto(Client client){
        return new ClientDto(client.firstName(), client.lastName(), client.creditCardNumber());
    }
}
