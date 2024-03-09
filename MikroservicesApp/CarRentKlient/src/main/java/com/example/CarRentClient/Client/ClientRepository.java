package com.example.CarRentClient.Client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientRegistrationAndLogin, Long> {
    List<ClientRegistrationAndLogin> findAll();
}
