package org.example.rent.Car;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Car(long id, BigDecimal price, LocalDateTime startRent, LocalDateTime endRent) {
}
