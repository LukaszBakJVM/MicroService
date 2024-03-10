package org.example.rent.Rent;

import org.springframework.stereotype.Service;

@Service
public class RentService {
    private final RentRepository repository;
    private final RentMapper rentMapper;

    public RentService(RentRepository repository, RentMapper rentMapper) {
        this.repository = repository;
        this.rentMapper = rentMapper;
    }

}
