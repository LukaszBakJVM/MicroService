package com.example.CarRentClient.Client;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;
    private final Mapper mapper;

    public ClientService(ClientRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    ClientDto newClient(ClientDto clientDto) {
        ClientRegistrationAndLogin clientRegistrationAndLogin = mapper.dtoToEntity(clientDto);
        ClientRegistrationAndLogin save = repository.save(clientRegistrationAndLogin);
        return mapper.entityToDto(save);
    }

    List<ClientDto> findAllClients() {
        return repository.findAll().stream().map(mapper::entityToDto).toList();
    }

}
