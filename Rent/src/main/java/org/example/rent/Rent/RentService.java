package org.example.rent.Rent;

import org.example.rent.Car.CarPrice;
import org.example.rent.Car.CarServices;
import org.example.rent.Client.ClientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

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
        BigDecimal bigDecimal = priceOfRent(start, end, dto.carId());
        dto = new RentDto(dto.carId(),dto.clientId(),bigDecimal);
        Rent rent = rentMapper.dtoToEntity(dto);


        Rent save = repository.save(rent);
        rentCar(save.getCarId(), start, end);
        return rentMapper.entityToDto(save);


    }

    private void rentCar(long carId, LocalDateTime start, LocalDateTime end) {
        carServices.rent(carId, start, end).subscribe();
    }

    private BigDecimal priceById(long id) {
        try {
            return carServices.price(id).map(CarPrice::price).toFuture().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    private BigDecimal priceOfRent(LocalDateTime start, LocalDateTime end,long id) {
        long days = Duration.between(start, end).toDays();
        BigDecimal price = priceById(id);
        return price.multiply(BigDecimal.valueOf(days));
    }
}
