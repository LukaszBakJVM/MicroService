package com.example.carRent.Car;

import com.example.carRent.Car.Mark.Capacity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;

        this.carMapper = carMapper;
    }

    void rentCar(RentCarDto rentCarDto) {
        Car car = carMapper.dtoToEntity(rentCarDto);
        car.setAvailable(false);
        carRepository.save(car);

    }

    CarDto newCarDto(CarDto carDto) {
        Car car = carMapper.newCarDtoToEntity(carDto);

        Car save = carRepository.save(car);

        return carMapper.newCarDto(save);
    }

    List<String> enumValue() {

        return Arrays.stream(Capacity.values()).map(Capacity::getValue).collect(Collectors.toList());
    }

    void deleteById(long id) {
        carRepository.deleteById(id);
    }


    List<CarDto> findAllCars() {
        return carRepository.findAll().stream().map(carMapper::newCarDto).toList();
    }


    CarDto findById(long id) {
        Car car = carRepository.findById(id).orElseThrow();
        return carMapper.newCarDto(car);
    }

}
