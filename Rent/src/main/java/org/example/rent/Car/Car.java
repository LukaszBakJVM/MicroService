package org.example.rent.Car;

import java.time.LocalDateTime;

public record Car(long id, LocalDateTime startRent, LocalDateTime endRent) {
}
