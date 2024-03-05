package com.example.CarRentClient.Client;

import org.springframework.stereotype.Service;

@Service
public class Mapper {
    ClientRegistrationAndLogin dtoToEntity(ClientDto dto){
        ClientRegistrationAndLogin client=new ClientRegistrationAndLogin();
        client.setFirstName(dto.firstName());
        client.setLastName(dto.firstName());
        client.setCreditCardNumber(dto.creditCardNumber());
        return client;

    }

    ClientDto entityToDto(ClientRegistrationAndLogin client){
        return new ClientDto(client.getFirstName(), client.getLastName(), client.getCreditCardNumber());
    }
}
