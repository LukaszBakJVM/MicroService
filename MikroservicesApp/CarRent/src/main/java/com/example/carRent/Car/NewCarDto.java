package com.example.carRent.Car;

import java.math.BigDecimal;

public record NewCarDto(BigDecimal price, String mark, String model, String value) {
}
