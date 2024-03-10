package com.example.carRent.Car;

import java.math.BigDecimal;
import java.time.LocalDateTime;

record RentCarDto(BigDecimal price, LocalDateTime startRent, LocalDateTime endRent, String mark, String model,
                  String value ,boolean available) {
}
