package com.example.carRent.Car;

import com.example.carRent.Car.Mark.Capacity;
import com.example.carRent.Car.Mark.Mark;
import com.example.carRent.Car.Mark.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CarMapper {
    private final MarkRepository markRepository;
    private final CarRepository carRepository;

    public CarMapper(MarkRepository markRepository, CarRepository carRepository) {
        this.markRepository = markRepository;
        this.carRepository = carRepository;
    }


    Car dtoToEntity(RentCarDto rentCarDto) {
        Car car = new Car();
        car.setPrice(rentCarDto.price());
        car.setStartRent(rentCarDto.startRent());
        car.setEndRent(rentCarDto.endRent());
        Mark mark = markRepository.findByMarkAndModel(rentCarDto.mark(), rentCarDto.model()).orElseThrow();

        car.setMark(mark);
        return car;
    }

    DtoRent rentCarDtoFromEntity(Car car) {
        return new DtoRent(car.getId(), car.getStartRent(), car.getEndRent());
    }

    Car rentCarDtoToEntity(DtoRent dto) {
        Car car = carRepository.findById(dto.id()).orElseThrow();


        car.setId(dto.id());
        car.setStartRent(dto.startRent());
        car.setEndRent(dto.endRent());
        car.setAvailable(false);
        return car;
    }

    CarDto newCarDto(Car car) {
        return new CarDto(car.getId(), car.getPrice(), car.getMark().getMark(), car.getMark().getModel(), car.getMark().getCapacity().getValue(), car.isAvailable());
    }

    Car newCarDtoToEntity(CarDto dto) {
        Car car = new Car();
        car.setPrice(dto.price());
        Optional<Mark> byMarkAndModel = markRepository.findByMarkAndModel(dto.mark(), dto.model());
        if (byMarkAndModel.isPresent()) {
            car.setMark(byMarkAndModel.get());
        } else {
            Mark mark = new Mark();
            mark.setMark(dto.mark());
            mark.setModel(dto.model());
            Capacity capacity = stringToEnum(dto.value());
            mark.setCapacity(capacity);
            Mark save = markRepository.save(mark);
            car.setMark(save);
            car.setMark(mark);
        }
        car.setAvailable(dto.available());
        return car;


    }

    private Capacity stringToEnum(String s) {
        return Arrays.stream(Capacity.values()).filter(capacity -> capacity.getValue().equals(s)).findFirst().get();


    }
}

