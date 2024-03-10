package org.example.rent.Rent;

import org.springframework.stereotype.Service;

@Service
public class RentMapper {
    Rent dtoToEntity(RentDto dto){
        Rent rent = new Rent();
        rent.setCarId(dto.carId());
        rent.setClientId(dto.clientId());
        return rent;
    }
    RentDto entityToDto(Rent rent){
        return new RentDto(rent.getCarId(), rent.getClientId());
    }
}
