package org.example.rent.Rent;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentMapper {
    Rent dtoToEntity(RentDto dto){
        Rent rent = new Rent();
        rent.setCarId(dto.carId());
        rent.setClientId(dto.clientId());
        rent.setAmount(dto.price());
        return rent;
    }
    RentDto entityToDto(Rent rent){
        return new RentDto(rent.getCarId(), rent.getClientId(),rent.getAmount());
    }
    FindAllCars allCars(Rent rent){
        List<Long>allCars = new ArrayList<>();
        allCars.add(rent.getCarId());



        return new FindAllCars(rent.getClientId(),allCars );
    }



    }

