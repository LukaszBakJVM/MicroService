package org.example.rent.Client;

import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    ClientDto map(Client client){
        return new ClientDto(client.id());
    }
}
