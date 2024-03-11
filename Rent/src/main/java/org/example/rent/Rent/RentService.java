package org.example.rent.Rent;

import org.example.rent.Car.CarPrice;
import org.example.rent.Car.CarServices;
import org.example.rent.Client.ClientService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class RentService {
    private final RentRepository repository;
    private final RentMapper rentMapper;
    private final CarServices carServices;
    private final ClientService clientService;

    public RentService(RentRepository repository, RentMapper rentMapper, CarServices carServices, ClientService clientService) {
        this.repository = repository;
        this.rentMapper = rentMapper;
        this.carServices = carServices;
        this.clientService = clientService;
    }

    RentDto rentCar(RentDto dto, LocalDateTime start, LocalDateTime end) {
        Rent rent = rentMapper.dtoToEntity(dto);
        Rent save = repository.save(rent);
        rentCar(save.getCarId(), start, end);
        return rentMapper.entityToDto(save);


    }

    private void rentCar(long carId, LocalDateTime start, LocalDateTime end) {
        carServices.rent(carId, start, end).subscribe();
    }

    private Mono<BigDecimal> priceById(long id) {
        return carServices.price(id).map(CarPrice::price);


    }
}
