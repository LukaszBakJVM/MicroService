package com.example.CarRentClient.Car;

import java.math.BigDecimal;

public record CarDto(long carId,BigDecimal price, String mark, String model, String value) {
}
