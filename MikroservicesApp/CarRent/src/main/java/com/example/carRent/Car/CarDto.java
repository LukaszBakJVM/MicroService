package com.example.carRent.Car;

import java.math.BigDecimal;

public record CarDto(BigDecimal price, String mark, String model, String value, boolean available) {
}
