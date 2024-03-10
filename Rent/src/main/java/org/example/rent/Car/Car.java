package org.example.rent.Car;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Car(long id, BigDecimal price, String mark, String model, String value, LocalDateTime startRent,
                  LocalDateTime endRent) {
}
