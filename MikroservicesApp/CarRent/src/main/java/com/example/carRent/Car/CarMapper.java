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

    CarDto EntityToDto(Car car) {
        return new CarDto(car.getPrice(), car.getStartRent(), car.getEndRent(), car.getMark().getMark(), car.getMark().getModel(), car.getMark().getCapacity().getValue());
    }

    Car dtoToEntity(CarDto carDto) {
        Car car = new Car();
        car.setPrice(carDto.price());
        car.setStartRent(carDto.startRent());
        car.setEndRent(carDto.endRent());
        Mark mark = markRepository.findByMarkAndModel(carDto.mark(), carDto.model()).orElseThrow();

        car.setMark(mark);
        return car;
    }

    NewCarDto newCarDto(Car car) {
        return new NewCarDto(car.getPrice(), car.getMark().getMark(), car.getMark().getModel(), car.getMark().getCapacity().getValue());
    }

    Car newCarDtoToEntity(NewCarDto dto) {
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
        return car;


    }

    private Capacity stringToEnum(String s) {
        return Arrays.stream(Capacity.values()).filter(capacity -> capacity.getValue().equals(s)).findFirst().get();


    }
}

