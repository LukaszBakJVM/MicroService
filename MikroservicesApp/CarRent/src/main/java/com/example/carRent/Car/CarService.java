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

    CarDto rentCar(CarDto carDto) {
        Car car = carMapper.dtoToEntity(carDto);

        carRepository.save(car);
        return carMapper.EntityToDto(car);
    }

    NewCarDto newCarDto(NewCarDto newCarDto) {
        Car car = carMapper.newCarDtoToEntity(newCarDto);

        Car save = carRepository.save(car);

        return carMapper.newCarDto(save);
    }

    List<String> enumValue() {

        return Arrays.stream(Capacity.values()).map(Capacity::getValue).collect(Collectors.toList());
    }

    void deleteById(long id) {
        carRepository.deleteById(id);
    }

    List<NewCarDto> availableCars(boolean available) {
        return carRepository.findAllByAvailable(available)
                .stream().map(carMapper::newCarDto).toList();
    }

    List<NewCarDto> findAllCars() {
        return carRepository.findAll().stream().map(carMapper::newCarDto).toList();
    }




}
