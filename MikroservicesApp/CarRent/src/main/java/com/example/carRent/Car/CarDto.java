package com.example.carRent.Car;

import java.math.BigDecimal;

public record CarDto(long id,BigDecimal price, String mark, String model, String value, boolean available) {
}
