package org.example.rent.Car;

import java.time.LocalDateTime;

public record CarDto(long carId, LocalDateTime startRent, LocalDateTime endRent) {
}
