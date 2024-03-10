package org.example.rent.Car;

import java.time.LocalDateTime;

public record RentCarDto(long id, LocalDateTime startRent, LocalDateTime endRent) {
}
