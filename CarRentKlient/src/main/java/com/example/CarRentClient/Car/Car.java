package com.example.CarRentClient.Car;

import java.math.BigDecimal;

public record Car(long id,BigDecimal price, String mark, String model, String value, boolean available) {
}
