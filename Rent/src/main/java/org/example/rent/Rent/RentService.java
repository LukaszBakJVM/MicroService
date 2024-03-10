package org.example.rent.Rent;

import org.example.rent.Car.CarServices;
import org.example.rent.Client.ClientService;
import org.springframework.stereotype.Service;

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
    RentDto rentCar(RentDto dto){
        Rent rent = rentMapper.dtoToEntity(dto);
        Rent save = repository.save(rent);
        rentCar(save.getCarId());
        return rentMapper.entityToDto(save);


    }
    private void  rentCar(long carId){
        carServices.rent(carId).subscribe();
    }



}
