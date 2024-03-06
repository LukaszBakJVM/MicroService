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

    public CarMapper(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    RentCarDto EntityToDto(Car car) {
        return new RentCarDto(car.getPrice(), car.getStartRent(), car.getEndRent(), car.getMark().getMark(), car.getMark().getModel(), car.getMark().getCapacity().getValue());
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

    CarDto newCarDto(Car car) {
        return new CarDto(car.getPrice(), car.getMark().getMark(), car.getMark().getModel(), car.getMark().getCapacity().getValue(), car.isAvailable());
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

